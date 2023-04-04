/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week02;

/**
 *
 * @author Asus
 */
public class L02Q04 {
    public static void main(String[] args) {
        Integer []intArray={5,3,7,1,4,9,8,2};
        String[] strArray={"red","blue","orange","tan"};
               
        System.out.println(minmax(intArray));
        System.out.println(minmax(strArray));
        
    }
    
    public static <E extends Comparable<E>>String minmax(E[] array){
        E min,max;
        min=array[0];
        max=array[0];
        for (E array1 : array) {
            if (array1.compareTo(max) > 0) {
                max = array1;
            }
            if (array1.compareTo(min) < 0) {
                min = array1;
            }
        }
        return "Min = "+min+" Max = "+max;
    }
}
