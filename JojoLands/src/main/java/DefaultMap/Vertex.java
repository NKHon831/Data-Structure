/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DefaultMap;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Asus
 */
public class Vertex<T extends Comparable<T>, N extends Comparable <N>> extends Game{   
    Scanner sc=new Scanner(System.in);
    ArrayList<OptionClass>option=new ArrayList<>();
    T vertexInfo;
    int indeg;
    int outdeg;
    Vertex<T,N> nextVertex;
    Edge<T,N> firstEdge;
    
    public Vertex() {
        this(null, null);
    }
	
    public Vertex(T vInfo, Vertex<T,N> next) {
        vertexInfo = vInfo;       
        indeg=0;
        outdeg=0;
        nextVertex = next;
        firstEdge = null;
        basicOption();
    }
  
    public void printInfo(){
        System.out.println("Current Location: "+vertexInfo);
        //iterate through all options and print them out
        for(int i=1;i<=option.size();i++){
            System.out.print("["+i+"]"+option.get(i-1)); 
            if(option.get(i-1).description!=null)
                System.out.println(" ("+option.get(i-1).description+")");
            else
                System.out.println("");
            
            //Print all the subOption if there are
            if(option.get(i-1).hasSubOption()){
                option.get(i-1).printSubOption();
            }
        }

    }
   
    public String nextMove(String input){
        System.out.println(String.valueOf('=').repeat(100));
        int temp=Character.getNumericValue(input.charAt(0))-1;
        return String.valueOf(option.get(temp).option);
    }
   
    public void basicOption(){
        option.add(new OptionClass("Move to: "));
        if(vertexInfo.compareTo((T)"Town Hall")!=0)
            option.add(new OptionClass("Back to Town Hall"));
        else{
            option.add(new OptionClass("Advance to Next Day"));
            option.add(new OptionClass("Save Game"));
            option.add(new OptionClass("Exit"));
        }
        
    }
    
    public void addOption(String newOption,String description){
        option.add(option.size()-1,new OptionClass(newOption,description));
    }
    
    public void removeOption(){
        OptionClass back=null;
        OptionClass forward=null;
        for(OptionClass i: option){
            if(i.option.equals("Back"))
                back=i;
            if(i.option.equals("Forward"))
                forward=i;          
        }
        option.remove(back);
        option.remove(forward);
    }
    
    public void viewWaitingOrderProcessingList(){
        
    }
    
    public void viewMenu(){
        
    }
    
}