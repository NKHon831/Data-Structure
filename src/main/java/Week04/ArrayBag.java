/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week04;

/**
 *
 * @author Asus
 */
public  class ArrayBag<T> implements BagInterface<T>{

    private final int Default_Capacity=25;
    private T[]bag=(T[])new Object[Default_Capacity];
    private int numberOfEntries;
    
    @Override
    public int getCurrentSize() {
         return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        if(numberOfEntries==0)
            return true;
        else
            return false;
    }

    @Override
    public boolean add(T newEntry) {
         if(numberOfEntries<Default_Capacity){
             numberOfEntries++;
             bag[numberOfEntries-1]=newEntry;
             return true;
         }
         else 
             return false;
         
    }

    @Override
    public T remove() {
         bag[0]=bag[numberOfEntries-1];
         bag[numberOfEntries-1]=null;
         numberOfEntries--;
         return bag[0];
    }

    @Override
    public boolean remove(T anEntry) {
        for(int i=0;i<numberOfEntries;i++){
            if(bag[i]==anEntry){
                bag[i]=bag[numberOfEntries-1];
                bag[numberOfEntries-1]=null;
                numberOfEntries--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for(int i=0;i<numberOfEntries;i++){
            if(!isEmpty()){
                remove(bag[numberOfEntries-1]);
            }
        }
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int frequency=0;
        if(!isEmpty()){
            for(T i:bag){
                if(i==anEntry){
                    frequency++;
                }
            }
        }
        return frequency;
    }

    @Override
    public boolean contains(T anEntry) {
        if(!isEmpty()){
            for(T i : bag){
                if(i==anEntry){
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override
    public T[] toArray() {
        T[] newArray=(T[])new Object[numberOfEntries];
        
        for(int i=0;i<numberOfEntries;i++){
            newArray[i]=bag[i];
        }
        return newArray;
    }

    
    @Override
    public BagInterface<T> union(BagInterface<T> bag2){
        BagInterface<T> newBag=new ArrayBag();
        T[] tempArray=toArray();
        for (T tempArray1 : tempArray) {
            newBag.add(tempArray1);
        }
        tempArray=bag2.toArray();
        for (T tempArray1 : tempArray) {
            newBag.add(tempArray1);
        }
        return newBag;
        
    }
    
    @Override
    public BagInterface<T> intersection(BagInterface<T> bag2){
        BagInterface<T>newBag=new ArrayBag<>();
        T[] tempArray1=this.toArray();//this object toArray()
        for(int i=0;i<tempArray1.length;i++){
             if(newBag.contains(bag[i]))
                 continue ;       
            if(bag2.contains(bag[i])){
                int freq1=this.getFrequencyOf(bag[i]);
                int freq2=bag2.getFrequencyOf(bag[i]);
                for(int j=0;j<Math.min(freq1,freq2);j++){
                    newBag.add(bag[i]);
                }
            }
        }           
        return newBag;
    }
    
    @Override
    public BagInterface<T> difference(BagInterface<T> bag2){
        BagInterface<T> newBag=new ArrayBag<>();
        T[]temp1=toArray();
        T[]temp2=bag2.toArray();
        for(T i:temp1){
            newBag.add(i);
        }
        for(T i:temp2){
            if(newBag.contains(i))
                newBag.remove(i);
        }
        return newBag;      
    }   
}
