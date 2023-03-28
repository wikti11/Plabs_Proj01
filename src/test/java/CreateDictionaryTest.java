import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import java.io.IOException;

public class CreateDictionaryTest{

    final static Logger logger = Logger.getLogger(CreateDictionary.class);
    String[] words = {"A","B","C"};
    String language = "foo";

    @Before
    public void setUp(){
        logger.info("Starting setup for FindingWords.");
    }

    @Mock
    private ObjectMapper objectMapper;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void quickOutputTest() {
        System.out.print("sample text");
        assertEquals("sample text", systemOutRule.getLog());
    }

    @Test
    public void consoleConfirmationTest() throws IOException{
        CreateDictionary.dictionaryCreator(words,language);
        assertEquals("File created. Restart to use it with 'find' command."+"\n",systemOutRule.getLog());
    }

}