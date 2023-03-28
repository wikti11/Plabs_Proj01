import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class DictionaryTest{

    final static Logger logger = Logger.getLogger(Dictionary.class);

    @Before
    public void setUp() {
        logger.info("Starting setup for FindingWords.");
    }

    @Test
    public void checkingDictionaryLanguage() {
        String language = "foo";
        String[] words = {"A", "B", "C"};
        Dictionary dictionary = new Dictionary(words, language);
        assertSame("foo", dictionary.getLanguage());
    }

    @Test
    public void checkingDictionaryWords() {
        String language = "foo";
        String[] words = {"A", "B", "C"};
        Dictionary dictionary = new Dictionary(words, language);
        String[] falseResult = {"J"};
        assertFalse(Arrays.equals(falseResult, dictionary.getWords()));
    }

}