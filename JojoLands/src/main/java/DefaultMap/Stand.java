/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DefaultMap;

/**
 *
 * @author Asus
 */
public class Stand {
    private String stand;
    private String standUser;
    private String power;
    private String speed;
    private String range;
    private String stamina;
    private String precision;
    private String developmentPotential;
    
    
    public Stand(String a,String b,String c,String d,String e,String f,String g,String h){
        stand=a;
        standUser=b;
        power=c;
        speed=d;
        range=e;
        stamina=f;
        precision=g;
        developmentPotential=h;
              
    }
    
    
    public String toString(){
        return  String.format("|%-25s|%-25s|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s|",stand,standUser,power,speed,range,stamina,precision,developmentPotential);
    }
}
