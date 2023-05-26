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
    private String residentialArea;
    private String parent1;
    private String parent2;
    

    public Resident(String name, Integer age, String gender, String residentialArea, String parent1,String parent2) {
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.residentialArea=residentialArea;
        this.parent1=parent1;
        this.parent2=parent2;
    }   
   
    public Integer getAge(){
        return age;
    }
    
    public String getGender(){
        return gender;
    }
    
    @Override
    public String toString(){
        return String.format("|%-30s|%-5s|%-10s|%-30s|%-20s|%-20s|",name,age,gender,residentialArea,parent1,parent2);
    }
}