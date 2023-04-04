/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week02;

/**
 *
 * @author Asus
 */
public class L02Q03 {
    public static void main(String[] args) {
            
        StorePairGeneric<Integer> pair1=new StorePairGeneric<>(6,4);
        StorePairGeneric<Integer> pair2=new StorePairGeneric<>(2,2);
        StorePairGeneric<Integer> pair3=new StorePairGeneric<>(6,3);
        
        System.out.println(pair1.equals(pair3));
        System.out.println(pair1.compareTo(pair2));
     
    }
}
