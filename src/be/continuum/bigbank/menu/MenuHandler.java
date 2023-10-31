package be.continuum.bigbank.menu;

import java.util.Scanner;

public class MenuHandler {
    public static final Scanner KEYBOARD = new Scanner(System.in);

    public void showMenuTitle(String message) {
        System.out.println("+++++      +++++++       ++++++");
        System.out.printf("+ %s +\n", message);
        System.out.println("+++++      +++++++       ++++++");
    }

    public String askForUserInput(String message) {
        System.out.printf("%s ", message);
        return KEYBOARD.next();
    }

    public int askForUserInputAsInteger(String message) {
        return Integer.parseInt(askForUserInput(message));
    }

}
