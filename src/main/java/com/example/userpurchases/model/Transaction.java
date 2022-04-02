package com.example.userpurchases.model;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private long id;

    private String name;

    private String lastName;

    private String month;

    private int transactions;

    private double rewardsPoints;

    public Transaction() {
    }

    public Transaction(long id, String name, String lastName, int transactions, double rewardsPoints) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.transactions = transactions;
        this.rewardsPoints = rewardsPoints;
    }

    public Transaction(long id, String name, String lastName, String month, int transactions, double rewardsPoints) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.month = month;
        this.transactions = transactions;
        this.rewardsPoints = rewardsPoints;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        month = month;
    }

    public int getTransactions() {
        return transactions;
    }

    public void setTransactions(int transactions) {
        this.transactions = transactions;
    }

    public double getRewardsPoints() {
        return rewardsPoints;
    }

    public void setRewardsPoints(double rewardsPoints) {
        this.rewardsPoints = rewardsPoints;
    }
}
