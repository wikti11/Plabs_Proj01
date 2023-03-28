import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateDictionary {

    public static void creator(){
        try {
            Scanner userInput = new Scanner(System.in);
            System.out.println("This is a dumb program which means it will OVERWRITE already existing files.");

            System.out.print("Language: ");
            String languageByUser = userInput.nextLine();

            System.out.print("Amount of words: ");
            int amountOfWords = userInput.nextInt();

            if (amountOfWords == (int)amountOfWords) {
                userInput.nextLine();
                String[] words = new String[amountOfWords];

                IntStream.range(0, words.length).forEach(i -> {
                    System.out.print("Word #" + (i + 1) + ": ");
                    words[i] = userInput.nextLine();
                });

//            for (int i = 0; i < amountOfWords; i++){
//                System.out.print("Word #"+(i+1)+": ");
//                words[i] = userInput.nextLine();
//            }

                CreateDictionary.dictionaryCreator(words, languageByUser);
            }
            else{
                System.out.println("Amount of words must be integer.");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void dictionaryCreator(String[] words, String languageByUser) throws IOException{
        String suffix = ".json";
        Dictionary dictionary = new Dictionary(words, languageByUser);
        ObjectMapper json = new ObjectMapper();
        json.writeValue(Paths.get(languageByUser+suffix).toFile(), dictionary);
        System.out.print("File created. Restart to use it with 'find' command."+"\n");
    }
}

