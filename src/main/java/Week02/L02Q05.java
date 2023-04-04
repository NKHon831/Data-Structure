/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week02;

/**
 *
 * @author Asus
 */
public class L02Q05 {
    public static void main(String[] args) {
        Integer[]intArray={1,2,3};
        String[]strArray={"red","green","blue"};
        Circle[] circle={new Circle(3),new Circle(2.9),new Circle(5.9)};
        
        System.out.println(max(intArray));
        System.out.println(max(strArray));
        System.out.println(max(circle));

    }
    
    
    public static <E extends Comparable<E>>E max(E[] list){
            E max=list[0];
            for(E array:list){
                if(array.compareTo(max)>0){
                    max=array;
                }
            }
            return max;
    }
}
