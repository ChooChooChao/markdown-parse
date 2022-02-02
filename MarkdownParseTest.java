import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.junit.*;


public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLinks() throws IOException {
        ArrayList<String> expected = new ArrayList<String>(); 
        expected.add("https://something.com");
        expected.add("some-page.html");

        Path fileName = Path.of("test-file-own.md");
	    String contents = Files.readString(fileName);
        assertEquals(expected, MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksTwo() throws IOException {
        ArrayList<String> expected = new ArrayList<String>(); 
        expected.add("https://something.com/(randomstuff");
        expected.add("some-page.html[what-if-brackets]");

        Path fileName = Path.of("break_code.md");
	    String contents = Files.readString(fileName);
        assertEquals(expected, MarkdownParse.getLinks(contents));
    }
    
    @Test
    public void getLinksThree() throws IOException {
        ArrayList<String> expected = new ArrayList<String>(); 

        Path fileName = Path.of("noLinks.md");
	    String contents = Files.readString(fileName);
        assertEquals(expected, MarkdownParse.getLinks(contents));
    }

    @Test
    public void test1() throws IOException {
        ArrayList<String> expected = new ArrayList<String>(); 
        expected.add("https://something.com");
        expected.add("some-page.html");

        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);
        assertEquals(expected, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testFile3() throws IOException {
        ArrayList<String> expected = new ArrayList<String>(); 

        Path fileName = Path.of("test-file3.md");
	    String contents = Files.readString(fileName);
        assertEquals(expected, MarkdownParse.getLinks(contents));
    }
}
