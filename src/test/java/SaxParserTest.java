import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class SaxParserTest {
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
        assertEquals("""
                        /file-776194140.xml
                        /dir-880176375/file-1073842118.java
                        /dir-880176375/dir-2145307015/file-1498940214.xhtml
                        """
                , outContent.toString());
    }

    @Test
    public void regexSearch() {
        String[] args = {"-f", "src/test/resources/test-file1.xml", "-S", ".*?[a-z]{4}-\\d+\\.[a-z]+"};
        Main.main(args);
        assertEquals("""
                        /file-776194140.xml
                        /dir-880176375/file-1073842118.java
                        /dir-880176375/dir-2145307015/file-1498940214.xhtml
                        """
                , outContent.toString());
    }

    @Test
    public void exactSearch() {
        String[] args = {"-f", "src/test/resources/test-file1.xml", "-s", "file-776194140.xml"};
        Main.main(args);
        assertEquals("/file-776194140.xml\n", outContent.toString());
    }

    @Test
    public void maskSearch() {
        String[] args = {"-f", "src/test/resources/test-file1.xml", "-s", "`.xml`"};
        Main.main(args);
        assertEquals("/file-776194140.xml\n", outContent.toString());
    }
}
