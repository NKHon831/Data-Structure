/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week02;

/**
 *
 * @author Asus
 */
public class L02Q01 {
    public static void main(String[] args) {
        MyGeneric<String> strObj=new MyGeneric<>();
        MyGeneric<Integer> intObj=new MyGeneric<>();
        
        strObj.setE("This is a String");
        intObj.setE(6);
        
        System.out.println(strObj.getE());
        System.out.println(intObj.getE());
        
    }
}
