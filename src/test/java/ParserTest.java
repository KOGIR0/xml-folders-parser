import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParserTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void fullSearch() {
        String[] args = {"-f", "src/test/resources/test-file1.xml"};
        Main.main(args);

        List<String> expectedOutput = List.of("/file-776194140.xml",
                "/dir-880176375/file-1073842118.java",
                "/dir-880176375/dir-2145307015/file-1498940214.xhtml"
        );
        List<String> actualOutput = outContent.toString().lines().toList();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void regexSearch() {
        String[] args = {"-f", "src/test/resources/test-file1.xml", "-S", ".*?[a-z]{4}-\\d+\\.[a-z]+"};
        Main.main(args);

        List<String> expectedOutput = List.of("/file-776194140.xml",
                "/dir-880176375/file-1073842118.java",
                "/dir-880176375/dir-2145307015/file-1498940214.xhtml"
        );
        List<String> actualOutput = outContent.toString().lines().toList();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void exactSearch() {
        String[] args = {"-f", "src/test/resources/test-file1.xml", "-s", "file-1498940214.xhtml"};
        Main.main(args);

        List<String> expectedOutput = List.of("/dir-880176375/dir-2145307015/file-1498940214.xhtml");
        List<String> actualOutput = outContent.toString().lines().toList();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void maskSearch() {
        String[] args = {"-f", "src/test/resources/test-file1.xml", "-s", "`*.java`"};
        Main.main(args);

        List<String> expectedOutput = List.of("/dir-880176375/file-1073842118.java");
        List<String> actualOutput = outContent.toString().lines().toList();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void noFileFoundSearch() {
        String[] args = {"-f", "src/test/resources/test-file1.xml", "-s", "file-107384218.java"};
        Main.main(args);

        String expectedOutput = "";
        String actualOutput = outContent.toString();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void noArgs() {
        String[] args = {};
        Main.main(args);

        assertTrue(outContent.toString().contains("Missing required option: f"));
    }

    @Test
    public void wrongArg() {
        String[] args = {"-F", "src/test/resources/test-file1.xml", "-O", "file-776194140.xml"};
        Main.main(args);

        assertTrue(outContent.toString().contains("Unrecognized option"));
    }
}
