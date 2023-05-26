/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DefaultMap;

/**
 *
 * @author Asus
 */
public final class CreateMap {
    Graph<String,Integer> defaultMap=new Graph<>();
    String[]locationName={
       "Town Hall",
       "Polnareff Land",
        "Cafe Deux Magots",
        "Savage Garden",
        "Joestar Mansion",
        "Jade Garden",
        "Morioh Grand Hotel",
        "San Giorgio Maggiore",
        "Trattoria Trussardi",
        "Libeccio",
        "Vineyard",
        "DIO's Mansion",
        "Angelo Rock",
        "Green Dolphin Street Prison"};
    
    String[][] nameList={
        {"Town Hall","Cafe Deux Magots","Jade Garden","Morioh Grand Hotel"},
        {"Cafe Deux Magots","Town Hall","Polnareff Land","Savage Garden","Jade Garden"},
        {"Polnareff Land","Cafe Deux Magots","Savage Garden"},    
        {"Savage Garden","Cafe Deux Magots","Polnareff Land","Joestar Mansion","Vineyard"},     
        {"Jade Garden","Town Hall","Cafe Deux Magots","Joestar Mansion","San Giorgio Maggiore","Morioh Grand Hotel"},
        {"Joestar Mansion","Jade Garden","Savage Garden","Vineyard","Libeccio"},
        {"Vineyard","Savage Garden","Joestar Mansion","Libeccio","DIO's Mansion"},
        {"San Giorgio Maggiore","Jade Garden","Trattoria Trussardi","Libeccio"},
        {"Morioh Grand Hotel","Town Hall","Jade Garden","Trattoria Trussardi"},
        {"Trattoria Trussardi","Morioh Grand Hotel","San Giorgio Maggiore","Green Dolphin Street Prison"},
        {"Green Dolphin Street Prison","Trattoria Trussardi","Libeccio","Angelo Rock"},
        {"Angelo Rock","Green Dolphin Street Prison","DIO's Mansion"},
        {"DIO's Mansion","Libeccio","Vineyard","Angelo Rock"},
        {"Libeccio","San Giorgio Maggiore","Joestar Mansion","Vineyard","DIO's Mansion","Green Dolphin Street Prison"},
                        };
    Integer[][]weighList={
        {4,5,5},
        {4,4,4,3},
        {4,6},
        {4,6,4,8},
        {5,3,2,2,3},
        {4,2,3,6},
        {8,3,3,6},
        {2,3,4},
        {5,3,6},
        {3,6,6},
        {6,2,3},
        {2,3},
        {3,3,2},
        {6,6,4,3,2},
                            };
    
    
    public CreateMap(){
        createLocation();
        createEdge();
        defaultMap.move();
        
    }
    
    public void createLocation(){
        for(String i :locationName)
            defaultMap.addVertex(i);        
    }
    
    public void createEdge(){
        for(int r=0;r<nameList.length;r++){
            for(int c=1;c<nameList[r].length;c++){
                 defaultMap.addEdge(nameList[r][0],nameList[r][c] ,weighList[r][c-1]);
            }
        }
    }
    
    public void printMap(){
        defaultMap.printEdges();
    }
    
}

