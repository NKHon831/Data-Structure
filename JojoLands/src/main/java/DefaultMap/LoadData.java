/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DefaultMap;

/**
 *
 * @author Asus
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadData extends Game {
    public static ArrayList<String> rList = new ArrayList<>();
    public static ArrayList<String> sList = new ArrayList<>();
    
    public LoadData(){
        loadData();
        createResident();
        createStand();
    }
    
    
    
    public static void loadData(){     
        try {
            // Read the csv file
            Scanner inputCsv1 = new Scanner(new FileInputStream("residents.csv"));
            Scanner inputCsv2 = new Scanner(new FileInputStream("stands.csv"));

                while (inputCsv1.hasNextLine()) {
                    String line = inputCsv1.nextLine();
                    rList.add(line);
                }            
    
                while (inputCsv2.hasNextLine()) {
                    String line = inputCsv2.nextLine();                  
                    sList.add(line);
                } 
  
            inputCsv1.close();
            inputCsv2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }       
    }
    
    public void createResident(){
        for(int i=1;i<rList.size();i++){
            String hold=null;
            String[]temp=rList.get(i).split(",");
            for(int k=0;k<temp.length;k++){
                if(temp[k].equals("N/A"))
                    temp[k]="0";  
                if(k==5)
                    hold=temp[5];
            }
            
            residents.add(new Resident(temp[0],Integer.parseInt(temp[1]),temp[2],temp[3],temp[4],hold));
        }
    }
    
    public void createStand(){
        for(int i=1;i<sList.size();i++){
            String[]temp=sList.get(i).split(",");
                          
            stands.add(new Stand(temp[0],temp[1],temp[2],temp[3],temp[4],temp[5],temp[6],temp[7]));
        }
    }
    
    public ArrayList<Resident> getResidents(){
        return residents;
    }
    
    public ArrayList<Stand> getStands(){
        return stands;
    }
 
}

