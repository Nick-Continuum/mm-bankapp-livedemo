package be.continuum.bigbank.menu;

import be.continuum.bigbank.exceptions.IbanNotFoundException;
import be.continuum.bigbank.model.BankAccount;
import be.continuum.bigbank.service.LoginService;

public class LoginMenu {
    private final MenuHandler menu;
    private final LoginService loginService = new LoginService();

    public LoginMenu(MenuHandler menu) {
        this.menu = menu;
    }

    public BankAccount login() {
        while (true) {
            try {
                String authUserIban = menu.askForUserInput("What is your Iban?");
                String authUserPin = menu.askForUserInput("What is your pincode?");

                return loginService.login(authUserIban, authUserPin);
            } catch (IbanNotFoundException infe) {
                menu.showError(infe.getMessage());
            }
        }
    }
}
