# xml-folder-struct-parser
Program parses xml file with folder structure and saves it in File class


# Usage examples

## output all files
$ java -jar assembly.jar -f test-files.xml

## output files with name file-1498940214.xhtml
$ java -jar assignment.jar -f test-files.xml -s file-1498940214.xhtml

## output all files with java extention
$ java -jar assignment.jar -f test-files.xml -s ‘.java’

## find all files by regular expression
$ java -jar assignment.jar -f test-files.xml -S .*?[a-z]{4}-\d+\.[a-z]+
