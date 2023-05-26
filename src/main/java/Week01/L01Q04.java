/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week01;

/**
 *
 * @author Asus
 */
public class L01Q04 {
    public static void main(String[] args) {
        Account1 acc=new Account1("George",1122,1000);
        
        acc.deposit(30);
        acc.deposit(40);
        acc.deposit(50);
        acc.withdraw(5);
        acc.withdraw(4);
        acc.withdraw(2);
        System.out.println(acc.getName());
        System.out.println(acc.getMonthlyInterest());
        System.out.println(acc.getBalance());
        System.out.println(acc.getTransactions());
        
    }
}
