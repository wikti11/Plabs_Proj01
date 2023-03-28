import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.*;

public class FindingWords {

    public static void settingUp(int amountOfSearches){
        Scanner userInput = new Scanner(System.in);
        System.out.print("Word: ");
        String wordByUser = userInput.nextLine();
        finder(amountOfSearches, wordByUser);
    }

    public static void finder(int amountOfSearches, String wordByUser) {
        String suffix = ".json";
        ObjectMapper mapper = new ObjectMapper();
        int tmp = 0;
        int totalAmount = 0;

        File f = new File("C:\\Users\\wikto\\Desktop\\Useless\\pliki\\studia\\3sem\\Pracownia programowania\\Project_Prog_Labs");
        File[] matchingFiles = f.listFiles((dir, name) -> name.endsWith(suffix));
        amountOfSearches++;
        assert matchingFiles != null;

//        for (File matchingFile : matchingFiles){
//            try {
//                Map<String, List<String>> map1 = mapper.readValue(matchingFile, Map.class);
//            }
//            catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }


        for (File matchingFile : matchingFiles) {

            try {
                Map<String, List<String>> mapFromJson = mapper.readValue(matchingFile, Map.class);


                for (Map.Entry<String, List<String>> entry : mapFromJson.entrySet()) {
                    if (entry.getKey().equals("words")) {
                        totalAmount = totalAmount+entry.getValue().size();
                        for (int i = 0; i < entry.getValue().size(); i++) {
                            if (entry.getValue().get(i).equals(wordByUser)) {
                                for (Map.Entry<String, List<String>> entry2 : mapFromJson.entrySet()) {
                                    if (entry2.getKey().equals("language")) {
                                        System.out.print(entry2.getValue() + "\n");
                                        Statistics.savingStatistics(amountOfSearches, String.valueOf(entry2.getValue()));
                                    }
                                }
                            } else {
                                tmp++;
                            }
                        }
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (tmp == totalAmount){
            System.out.print("Given word doesn't exist in any dictionary." + "\n");
        }

    }
}