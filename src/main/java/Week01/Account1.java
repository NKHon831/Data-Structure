/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week01;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class Account1 {

    private String name;
    private int id;
    private double balance;
    private double annualInterestRate;
    private LocalDate dateCreated;
    LocalDate currentDate=LocalDate.now();
    private ArrayList<Transaction> transactions=new ArrayList<>();
    
    public Account1(String name,int id ,double balance){
        this.name=name;
        this.id=id;
        this.balance=balance;
        this.annualInterestRate=1.5;
        this.dateCreated=currentDate;
        
        
    }
    
    public int getId(){
        return id;
    }
    
    public double getBalance(){
        return balance;
    }
    
    public double getAnnualInterestRate(){
        return annualInterestRate;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public void setBalance(double balance){
        this.balance=balance;
    }
    
    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate=annualInterestRate;
    }
    
    public LocalDate getDateCreated(){
        return dateCreated;
    }
    
    public double getMonthlyInterestRate(){
        return annualInterestRate/12;
    }
    
    public double getMonthlyInterest(){
        return ((annualInterestRate/12)/100)*balance;
    }
    
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }


    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
    
    public void withdraw(double amount){
        String description="Withdraw "+amount;
        balance-=amount;
        transactions.add(new Transaction('W',amount,balance,description));
        
        
    }
    
    public void deposit(double amount){
        String description="Deposit "+amount;
        balance+=amount;
        transactions.add(new Transaction('D',amount,balance,description));
    }
}