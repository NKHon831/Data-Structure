/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DefaultMap;

/**
 *
 * @author Asus
 */
public class Game {
    String []days={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    int dayNumber=0;
    String day;
    
    public Game(){
    }
    
    
    public void newDay(){
       dayNumber++;
       day=days[(dayNumber-1)%7];
        
    }
}
