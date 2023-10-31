package be.continuum.bigbank.menu;

import be.continuum.bigbank.service.LoginService;

import static be.continuum.bigbank.menu.MenuHandler.KEYBOARD;

public class BankMainMenu {
    public void run() {
        MenuHandler menu = new MenuHandler();
        menu.showMenuTitle("Welcome to the Big Bank App");

        String authUserIban = menu.askForUserInput("What is your Iban?");
        String authUserPin = menu.askForUserInput("What is your pincode?");

        LoginService loginService = new LoginService();
        loginService.login(authUserIban, authUserPin);
    }
}
