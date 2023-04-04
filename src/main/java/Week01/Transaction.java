/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week01;

import java.time.LocalDateTime;

/**
 *
 * @author Asus
 */

public class Transaction {
    LocalDateTime currentDate=LocalDateTime.now();
    private char type;
    private double amount;
    private double balance;
    private String description;
    private LocalDateTime date;
    
    
    public Transaction(char type,double amount,double balance,String description){
        this.type=type;
        this.amount=amount;
        this.balance=balance;
        this.description=description;
        date=LocalDateTime.now();
        
    }

    public LocalDateTime getCurrentDate() {
        return currentDate;
    }

    public char getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setCurrentDate(LocalDateTime currentDate) {
        this.currentDate = currentDate;
    }

    public void setType(char type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    } 
    
    public String toString(){
        return "\nType: "+type+
               "\nAmount: "+amount+
               "\nBalance: "+balance+
               "\nDescription: "+description;
    }
    
}
