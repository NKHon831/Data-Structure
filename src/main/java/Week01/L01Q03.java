/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week01;


/**
 *
 * @author Asus
 */
public class L01Q03 {
    public static void main(String[] args){
        Account acc1=new Account(1122,20000);
        
        acc1.withdraw(2500);
        acc1.deposit(3000);
        
        System.out.println("Balance : "+acc1.getBalance());
        System.out.println("Monthly interest : "+acc1.getMonthlyInterest());
        System.out.println("Date created : "+acc1.getDateCreated());
        
    }
}
