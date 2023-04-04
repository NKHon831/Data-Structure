/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class ReadMyLetter_22004741 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String text="";        
        boolean append;
        System.out.println("Append(true/false) : ");
        append=sc.nextBoolean();
        
        if(!append){
            text=read();
            write(text);
        }
        
        if(append){
            write(append());
        }
        
    }
    
    
    public static String read(){
        String text="";
        try{
            Scanner sc=new Scanner(new FileInputStream("NGKHAIHON_22004741.txt"));        
            while(sc.hasNextLine()){
                //System.out.print(sc.nextLine());
                //System.out.println("");
                text+=sc.nextLine();

            }
        sc.close();
            
            
            
        }catch (IOException e){
            System.out.println("Input File Error");
        }
        return text;
    }
    
    public static void write(String text){
        try{
            PrintWriter write=new PrintWriter(new FileOutputStream("output.txt",true));
            
            write.print(text);
            write.close();
            
        }catch (IOException e ){
            System.out.println("Output File Error");
        }
        
        
    }
    
    public static String append(){
        String text="";
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter text that you want to add : ");
        text=sc.nextLine();
        return text;
        
    }
}
