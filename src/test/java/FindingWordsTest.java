import org.apache.log4j.Logger;
import org.junit.*;
import org.junit.contrib.java.lang.system.SystemOutRule;
import static org.junit.Assert.*;
import java.io.IOException;

public class FindingWordsTest{
    final static Logger logger = Logger.getLogger(FindingWords.class);

    @Before
    public void setUp(){
        logger.info("Starting setup for FindingWords.");
    }

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void quickOutputTest() {
        System.out.print("sample text");
        assertEquals("sample text", systemOutRule.getLog());
    }

    @Test
    public void englishTest() throws IOException {
        FindingWords.finder(2,"about");
        assertEquals("English"+"\n", systemOutRule.getLog());
    }

    @Test
    public void polishTest() throws IOException {
        FindingWords.finder(1,"abażur");
        assertEquals("Polish"+"\n", systemOutRule.getLog());
    }

    @Test
    public void bothTest() throws IOException {
        FindingWords.finder(2,"abandon");
        assertEquals("English"+"\n"+"Polish"+"\n", systemOutRule.getLog());
    }

    @Test
    public void noLanguageTest() throws IOException {
        FindingWords.finder(2,"random word");
        assertEquals("Given word doesn't exist in any dictionary."+"\n", systemOutRule.getLog());
    }

}