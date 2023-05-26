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
    int dayNumber=0;
    String day;
    
    public Game(){
    }
    
    
    public void newDay(){
       dayNumber++;
       day=days[(dayNumber-1)%7];
        
    }
    
}
