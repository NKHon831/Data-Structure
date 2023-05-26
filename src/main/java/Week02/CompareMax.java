/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week02;

/**
 *
 * @author Asus
 */
public class CompareMax {
    public static void main(String[] args) {     
        
        System.out.println(CompareMax.maximum("NKH","CBP","TCL"));
        System.out.println(CompareMax.maximum(100,99,47));
        
    }
    
    
    public static <E extends Comparable<E>> E maximum(E obj1,E obj2,E obj3){
        if(obj1.compareTo(obj2)>0 &&obj1.compareTo(obj3)>0){
            return obj1;
        }
        else if(obj2.compareTo(obj1)>0 &&obj2.compareTo(obj3)>0){
            return obj2;
        }
        else if(obj3.compareTo(obj1)>0 &&obj3.compareTo(obj2)>0){
            return obj3;
        }
        else
            return null;
    }
}
