package be.continuum.bigbank.model;

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

    public Transaction[] getOutgoingTransactions() {
        return outgoingTransactions;
    }

    void setOutgoingTransactions(Transaction[] outgoingTransactions) {
        this.outgoingTransactions = outgoingTransactions;
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
