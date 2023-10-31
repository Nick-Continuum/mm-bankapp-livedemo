package be.continuum.bigbank.menu;

import be.continuum.bigbank.model.BankAccount;

import java.util.Scanner;

public class MenuHandler {
    public static final Scanner KEYBOARD = new Scanner(System.in);
    public static final String EURO_SIGN = "\u20ac";

    public void showMenuItem(String message) {
        System.out.println(message);
    }
    public void showMenuTitle(String message) {
        showMenuItem("+++++      +++++++       ++++++");
        System.out.printf("+ %s +\n", message);
        showMenuItem("+++++      +++++++       ++++++");
    }

    public void showSubMenuTitle(String title) {
        System.out.printf("----- %s -----\n", title);
    }

    public void showMenuBlock(String... blockItems) {
        // Validate length for the separator
        int longestWord = 0;
        for (String blockItem : blockItems) {
            if (blockItem.length() > longestWord) longestWord = blockItem.length();
        }

        String separator = "-".repeat(longestWord);

        // Print the message
        showMenuItem(separator);
        for (String blockItem : blockItems) {
            showMenuItem(blockItem);
        }
        showMenuItem(separator);
    }

    public void showError(String message) {
        String separator = "-".repeat(message.length()+13);
        showMenuItem(separator);
        System.out.printf("----- Error: %s\n", message);
        showMenuItem(separator);
    }

    public String askForUserInput(String message) {
        System.out.printf("%s ", message);
        return KEYBOARD.next();
    }

    public void showUserInfo(BankAccount user) {
        showMenuBlock(
                "Welcome: " + user.getFullName(),
                String.format("Your balance: %s %.2f", EURO_SIGN, user.getBalance())
        );
    }

}
