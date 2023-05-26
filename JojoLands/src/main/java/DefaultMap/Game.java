/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DefaultMap;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Asus  
 */
public class Game {
    final String []days={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};  
    final ArrayList<String>restaurant=new ArrayList<>(
            Arrays.asList("Cafe Deux Magots","Savage Garden","Jade Garden","Trattoria Trussardi","Libeccio"));
    final ArrayList<String>residentialArea=new ArrayList<>(
            Arrays.asList("Polnareff Land","Morioh Grand Hotel","Joestar Mansion","Vineyard","San Giorgio Maggiore",
                    "DIO's Mansion","Green Dolphin","Angelo Rock"));
    int dayNumber=0;
    String day;
    
    public ArrayList<Resident> residents=new ArrayList<>();
    public ArrayList<Stand> stands=new ArrayList<>();
    
    public Game(){
        
    }
    
    
    public void newDay(){
       dayNumber++;
       day=days[(dayNumber-1)%7];
        
    }
    
    
}
