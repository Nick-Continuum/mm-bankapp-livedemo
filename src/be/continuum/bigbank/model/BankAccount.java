package be.continuum.bigbank.model;

import java.util.Arrays;

public class BankAccount {
    private static final int LOG_IN_ATTEMPTS = 3;
    private String iban;
    private String pin;
    private String fullName;
    private double balance;
    private int locked;
    private Transaction[] incomingTransactions;
    private Transaction[] outgoingTransactions;

    BankAccount() {
    }

    public BankAccount(String iban, String pin, String fullName, double balance, Transaction[] incomingTransactions, Transaction[] outgoingTransactions) {
        this.iban = iban;
        this.pin = pin;
        this.fullName = fullName;
        this.balance = balance;
        this.incomingTransactions = incomingTransactions;
        this.outgoingTransactions = outgoingTransactions;
        this.accountUnlocked();
    }

    public String getIban() {
        return iban;
    }

    void setIban(String iban) {
        this.iban = iban;
    }

    public String getPin() {
        return pin;
    }

    void setPin(String pin) {
        this.pin = pin;
    }

    public String getFullName() {
        return fullName;
    }

    void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getBalance() {
        return balance;
    }

    void setBalance(double balance) {
        this.balance = balance;
    }

    public Transaction[] getIncomingTransactions() {
        return incomingTransactions;
    }

    void setIncomingTransactions(Transaction[] incomingTransactions) {
        this.incomingTransactions = incomingTransactions;
    }

    public void addIncomingTransaction(Transaction transaction) {
        incomingTransactions = Arrays.copyOf(incomingTransactions, incomingTransactions.length + 1);
        incomingTransactions[incomingTransactions.length - 1] = transaction;
    }

    public Transaction[] getOutgoingTransactions() {
        return outgoingTransactions;
    }

    void setOutgoingTransactions(Transaction[] outgoingTransactions) {
        this.outgoingTransactions = outgoingTransactions;
    }

    public void addOutgoingTransaction(Transaction transaction) {
        this.outgoingTransactions = Arrays.copyOf(this.outgoingTransactions, this.outgoingTransactions.length + 1);
        this.outgoingTransactions[this.outgoingTransactions.length - 1] = transaction;
    }

    public void deposit(double amount) {
        isAmountValid(amount);
        balance += amount;
    }

    public void withdraw(double amount) {
        isAmountValid(amount);
        hasSufficientFunds(amount);
        balance -= amount;
    }

    private void isAmountValid(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Provided amount is negative or zero");
    }

    private void hasSufficientFunds(double amount) {
        if (balance > amount) throw new IllegalArgumentException("Not enough balance available for withdrawal");
    }

    public void accountUnlocked() {
        locked = LOG_IN_ATTEMPTS;
    }

    public void failedPinAttempt() {
        locked--;
    }

    public boolean isLocked() {
        return locked <= 0;
    }

    public int getAttemptsRemaining() {
        return locked;
    }
}
