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
        for(int i=0;i<tempArray.length;i++){
            newBag.add(tempArray[i]);
        }
        tempArray=bag2.toArray();
        for(int i=0;i<tempArray.length;i++){
            newBag.add(tempArray[i]);
        }
        return newBag;
        
    }
    
    @Override
    public BagInterface<T> intersection(BagInterface<T> bag2){
        BagInterface<T>newBag=new ArrayBag<>();
        T[] tempArray1=this.toArray();//this object toArray()
        loop:
        for(int i=0;i<tempArray1.length;i++){
            for(int a=i-1;a>=0;a--){
             if(bag[i]==bag[a])
                 continue loop;
            }
            if(bag2.contains(bag[i])){
                int freq1=this.getFrequencyOf(bag[i]);
                int freq2=bag2.getFrequencyOf(bag[i]);
                for(int j=0;j<Math.abs(freq1-freq2);j++){
                    newBag.add(bag[i]);
                }
            }
        }           
        return newBag;
    }
    
    @Override
    public BagInterface<T> difference(BagInterface<T> bag2){
        BagInterface<T>newBag=new ArrayBag<>();
        T[]array1=this.toArray();
        T[]array2=bag2.toArray();
        for(int i=0;i<this.getCurrentSize();i++){
            for(int j=0;j<bag2.getCurrentSize();j++){
                if(array1[i]==array2[j]){
                    array1[i]=null;
                    array2[j]=null;
                    break;
                }
            }
        }
        for(int i=0;i<array1.length;i++){
            if(array1[i]!=null)
                newBag.add(array1[i]);
        }

        return newBag;      
    }
    
    
}
