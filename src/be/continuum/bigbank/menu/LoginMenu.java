package be.continuum.bigbank.menu;

import be.continuum.bigbank.BankAccountInMemoryRepository;
import be.continuum.bigbank.exceptions.IbanNotFoundException;
import be.continuum.bigbank.exceptions.IncorrectPinCodeException;
import be.continuum.bigbank.exceptions.LockedAccountException;
import be.continuum.bigbank.model.BankAccount;
import be.continuum.bigbank.service.LoginService;

import static java.lang.System.exit;

public class LoginMenu {
    private final MenuHandler menu;
    private final LoginService loginService;

    public LoginMenu(MenuHandler menu, BankAccountInMemoryRepository repo) {
        this.menu = menu;
        loginService = new LoginService(repo);
    }

    public BankAccount login() {
        while (true) {
            try {
                String authUserIban = menu.askForUserInput("What is your Iban?");
                String authUserPin = menu.askForUserInput("What is your pincode?");

                return loginService.login(authUserIban, authUserPin);
            } catch (IbanNotFoundException infe) {
                menu.showError(infe.getMessage());
            } catch (IncorrectPinCodeException ipe) {
                menu.showError(ipe.getMessage());
            } catch (LockedAccountException lae) {
                menu.showError(lae.getMessage());
            }
        }
    }

    public void logout() {
        menu.showMenuItem("Logging out...");
        menu.showMenuItem("Logged out successfully");
        exit(0);
    }
}
