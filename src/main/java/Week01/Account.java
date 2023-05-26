/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week01;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
/**
 *
 * @author Asus
 */
public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;
    LocalDate currentDate=LocalDate.now();
    Date date = Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    SimpleDateFormat format1=new SimpleDateFormat("dd-MM-yyyy");
    
    public Account(){
        this.id=0;
        this.balance=0;
    }
    
    public Account(int id ,double balance) {
        this.id=id;
        this.balance=balance;
        this.annualInterestRate=4.5;
        this.dateCreated=date;
        
        
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
    
    public String getDateCreated(){
        return format1.format(dateCreated);
    }
    
    public double getMonthlyInterestRate(){
        return annualInterestRate/12;
    }
    
    public double getMonthlyInterest(){
        return ((annualInterestRate/12)/100)*balance;
    }
    
    public void withdraw(double amount){
        balance-=amount;
    }
    
    public void deposit(double amount){
        balance+=amount;
    }
}
