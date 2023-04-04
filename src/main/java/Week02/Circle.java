/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week02;

/**
 *
 * @author Asus
 */
public class Circle implements Comparable<Circle>{
    
    private double radius;
    
    public Circle(double radius){
        this.radius=radius;
    }
    
    public void setRadius(double radius){
        this.radius=radius;
    }
    
    public double getRadius(){
        return radius;
    }

    @Override
    public int compareTo(Circle o) {
        if(this.radius > o.radius){
            return 1;
        }
        else if(this.radius<o.radius){
            return -1;
        }
        else
            return 0;
    }
    
    public String toString(){
        return Double.toString(radius);
    }

 
    
    
    
}
