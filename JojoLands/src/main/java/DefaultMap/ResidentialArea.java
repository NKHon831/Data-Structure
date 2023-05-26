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
public class ResidentialArea <T extends Comparable<T>, N extends Comparable <N>>extends Vertex{
    ArrayList<Resident> resident=new ArrayList<>();
    
    
    public ResidentialArea(){
        super();
        addCommonOption();
    }
    
    public ResidentialArea(T vInfo, Vertex<T,N> next){
        super(vInfo,next);
        addCommonOption();
    }
    
    public void addCommonOption(){
        option.add(option.size()-1,new OptionClass("View Resident Information"));
    }
    
    
    
    
}
