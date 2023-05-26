/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DefaultMap;

import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class OptionClass <T>{
    T option;
    T description;
    ArrayList<OptionClass>subOption=new ArrayList<>();
    
    public OptionClass(T o){
        option=o;
    }
    
    public OptionClass(T a , T b){
        option=a;
        description=b;
    }
    
    public void addSubOption(T o){
        OptionClass newOption=new OptionClass(o);
        subOption.add(0,newOption);
    }
    
    public boolean hasSubOption(){
        if(subOption.isEmpty())
            return false;
        else 
            return true;
    }
    
    public void printSubOption(){
        if(hasSubOption()){
            System.out.print("  ");
            for(int i=0;i<subOption.size();i++){
                System.out.print("  ["+(char)(i+65)+"]"+subOption.get(i));
            }
            System.out.println("");
        }
    }
    
    @Override
    public String toString(){
          return String.valueOf(option);
    }
    
}
