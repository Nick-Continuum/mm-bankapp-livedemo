package be.continuum.bigbank.menu;

import be.continuum.bigbank.model.BankAccount;

import static be.continuum.bigbank.menu.MenuHandler.EURO_SIGN;

public class BalanceMenu {
    private final BankAccount user;
    private final MenuHandler menu;

    public BalanceMenu(BankAccount user, MenuHandler menu) {
        this.user = user;
        this.menu = menu;
    }

    public void showMenu() {
        menu.showSubMenuTitle("Balance");
        menu.showMenuItem(String.format(
                "Your balance: %s %.2f",
                EURO_SIGN,
                user.getBalance()
        ));
    }
}
