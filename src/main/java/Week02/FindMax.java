/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week02;

/**
 *
 * @author Asus
 */
public class FindMax {
    public static class Circle implements Comparable<Circle>{
    
    private Double radius;
    
    public Circle(Double radius){
        this.radius=radius;
    }
    
    public void setRadius(Double radius){
        this.radius=radius;
    }
    
    public Double getRadius(){
        return radius;
    }

    @Override
    public int compareTo(Circle o) {
        return this.radius.compareTo(o.radius);
    }
    
    public String toString(){
        return Double.toString(radius);
    }
  }
    
    public static void main(String[] args) {
        Integer[]intArray={1,2,3};
        String[]strArray={"red","green","blue"};
        Circle[] circle={new Circle(3.0),new Circle(2.9),new Circle(5.9)};
        
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


