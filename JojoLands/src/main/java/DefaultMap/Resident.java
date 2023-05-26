/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DefaultMap;

/**
 *
 * @author Asus
 */
public class Resident {
    private String name;
    private Integer age;
    private String gender;
    private String order;
    
    
    public Resident(String name,Integer age,String gender,String order){
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.order=order;
    }
    
    public Resident(String name,Integer age,String order){
        this(name,age,null,order);
    }
    
    public Resident(String name,String gender,String order){
        this(name,null,gender,order);
    }
    
    public Resident(String name,String order){
        this(name,null,null,order);
    }
    
    public Integer getAge(){
        return age;
    }
    
    public String getGender(){
        return gender;
    }
    
    @Override
    public String toString(){
        return String.format("%-30s|%-5d|%-8s|%-50s|",name,age,gender,order);
    }
    
}
