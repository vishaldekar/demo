package com.app.RestDemo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="bank_account")
public class BankAccount {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy="uuid2")
    private  String id ;

    @Column(name = "account_number")
    private String accountNumber ;

    @Column(name = "currency")
    private String currency;

    @Column(name = "balance")
    private  String balance ;


    public BankAccount(){

    }

    public BankAccount(String accountNumber, String currency, String balance) {
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }



    @Override
    public String toString() {
        return "BankAccount{" +
                "id='" + id + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", currency=" + currency +
                ", balance=" + balance +
                '}';
    }
}
