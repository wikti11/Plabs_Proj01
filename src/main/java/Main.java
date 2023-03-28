import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    Logger log = Logger.getLogger("name");

    public static void main(String [] args) throws IOException {
        Scanner userInput = new Scanner(System.in);
        String userChose = "";
        int amountOfFinding = 0;

        System.out.print("This is a simple dictionary. \n'find' - finds a word in dictionary\n'add' - adds new dictionary\n'exit' - exits program\n");
        while (!userChose.equals("exit")) {
            System.out.print("-> ");
            userChose = userInput.nextLine();
            switch (userChose) {
                case "find" -> {
                    amountOfFinding++;
                    FindingWords.settingUp(amountOfFinding);
                }
                case "add" -> CreateDictionary.creator();
                case "exit" -> System.out.print("Exiting...\n");
                default -> System.out.print("Unknown command\n");
            }
        }
    }

}