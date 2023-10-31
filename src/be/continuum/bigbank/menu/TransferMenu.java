package be.continuum.bigbank.menu;

import be.continuum.bigbank.BankAccountInMemoryRepository;
import be.continuum.bigbank.model.BankAccount;
import be.continuum.bigbank.service.BankService;

public class TransferMenu {
    private final BankService bankService;
    private final BankAccount user;
    private final MenuHandler menu;

    public TransferMenu(BankAccount user, MenuHandler menu, BankService service) {
        this.user = user;
        this.menu = menu;
        this.bankService = service;
    }

    public void showMenu() {

    }
}
