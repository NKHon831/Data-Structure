/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week02;

/**
 *
 * @author Asus
 */
public class MyGeneric <T>{
    private T e;
    
    public MyGeneric(){
        
    }
    
    public MyGeneric(T e){
        this.e=e;
    }
    
    public void setE(T e){
        this.e=e;
        
    }
    
    public T getE(){
        return e;
    } 
    
}
