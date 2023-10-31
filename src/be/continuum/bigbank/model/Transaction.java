package be.continuum.bigbank.model;

import java.time.LocalDateTime;

public class Transaction {
    private BankAccount sender;
    private BankAccount receiver;
    private double amount;
    private LocalDateTime timestamp;
    private String description;

    public Transaction(BankAccount sender, BankAccount receiver, double amount, LocalDateTime timestamp, String description) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.timestamp = timestamp;
        this.description = description;
    }

    public Transaction(BankAccount sender, BankAccount receiver, double amount, LocalDateTime timestamp) {
        this(sender, receiver, amount, timestamp, "");
    }

    public Transaction(BankAccount sender, BankAccount receiver, double amount) {
        this(sender, receiver, amount, LocalDateTime.now());
    }

    public Transaction(BankAccount sender, BankAccount receiver, double amount, String description) {
        this(sender, receiver, amount, LocalDateTime.now(), description);
    }

    public BankAccount getSender() {
        return sender;
    }

    void setSender(BankAccount sender) {
        this.sender = sender;
    }

    public BankAccount getReceiver() {
        return receiver;
    }

    void setReceiver(BankAccount receiver) {
        this.receiver = receiver;
    }

    public double getAmount() {
        return amount;
    }

    void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "sender=" + sender +
                ", receiver=" + receiver +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                ", description='" + description + '\'' +
                '}';
    }
}
