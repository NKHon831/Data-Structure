/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week02;

/**
 *
 * @author Asus
 */
public class StorePairGeneric<T extends Comparable<T>> implements Comparable<StorePairGeneric<T>>{
    
    private T first;
    private T second;
    
    public StorePairGeneric(T first,T second){
        this.first=first;
        this.second=second;
        
    }
    
    public T getFirst(){
        return first;
    }
    
    public T getSecond(){
        return second;
    }
    
    public void setPair(T first,T second){
        this.first=first;
        this.second=second;
    }
    
    @Override
    public String toString(){
        return "first ="+first.toString()+" second = "+second.toString();
    }
    

    
    public boolean equals(StorePairGeneric<T> o){
        return this.first.equals(o.first);
    }
            


   
    @Override
   public int compareTo(StorePairGeneric<T> o){
       return this.first.compareTo(o.first);
   }
       
   
}
