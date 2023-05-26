/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week01;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Asus
 */
public class L01Q02 {
    public static void main(String[] args) {
        int text=3;
        String [] fileName={"text1.txt","text2.txt","text3.txt","text4.txt"};
        String [] split={",",", ","; ","\\d+"};
        
        display(fileName[text],split[text]);
    }
    
    public static void display(String fileName,String split){
        ArrayList<String> line=new ArrayList<>();
        int numOfChar=0;
        try{
            Scanner sc=new Scanner(new FileInputStream(fileName));
            while(sc.hasNextLine()){
                line.add(sc.nextLine());
            }
            sc.close();
            
            
        }catch (IOException e){
            System.out.println("Error");
        }
        String[][] table=new String[line.size()][]; 
        
        for(int i=0;i<line.size();i++){
            String [] hold=line.get(i).split(split);
            numOfChar+=hold.length;
            table[i]=new String[hold.length+1];
            table[i][0]=line.get(i);
            for(int j=0;j<hold.length;j++){
                table[i][j+1]=hold[j];
                System.out.print(table[i][j+1]+" ");
            }
            System.out.println("");
        }
        
        System.out.println("Total character : "+numOfChar);
    }
}
