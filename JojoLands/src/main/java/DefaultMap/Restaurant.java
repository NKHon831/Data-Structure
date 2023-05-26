/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DefaultMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Asus
 */
public  class Restaurant<T extends Comparable<T>, N extends Comparable <N>> extends Vertex{ 
    //store waiting list
    LinkedList<Resident> list=new LinkedList<>();
    
    //store order processing list
    Queue<Resident> queue=new LinkedList<>();
    
    //for the use of Savage Garden
    public static Stack<Resident> stack1=new Stack<>();
    public static Stack<Resident> stack2=new Stack<>();
    
    
    public Restaurant(){
        super();
        option.add(new OptionClass("View Menu"));
        option.add(new OptionClass("View Waiting List and Order Processing List"));
        option.add(new OptionClass("View Sales Information"));
        option.add(new OptionClass("Milagro Man"));
        processingList((String)vertexInfo);
    }
    
    public Restaurant(T v , Vertex<T,N> w){
        super(v,w);
        option.add(new OptionClass("View Menu"));
        option.add(new OptionClass("View Waiting List and Order Processing List"));
        option.add(new OptionClass("View Sales Information"));
        option.add(new OptionClass("Milagro Man"));
    }
    
    //Add the customer into a waiting list
    public void queueToWaitingList(Resident customer){
        list.addLast(customer);
    }
    
    //sort the waiting list into processing order list

    public void processingList(String restaurant){
        switch(restaurant){
            case "Jade Garden"->JadeGarden();
            case "Cafe Deux Magots"->CafeDeuxMagots();
            case "Libeccio"->Libeccio();
            case "Savage Garden"->SavageGarden();
            case "Trattoria Trussardi"->TrattoriaTrussardi();
            default->System.out.println("Error");
        }
    }
    
    //display the waiting list
    public void displayWaitingList(){
        System.out.println("Waiting List");
        printLine(102);
        System.out.printf("|%-3s|%-30s|%-5s|%-8s|%-50s|\n","No","Name","Age","Gender","Order");
        printLine(102);
        for(int i=0;i<list.size();i++){
            System.out.printf("|%-3d|",i+1);
            System.out.println(list.get(i));
        }
        printLine(102);
    }

    public void displayProcessingList(){
        Queue<Resident> temp=new LinkedList<>(queue);
        System.out.println("Order Processing List");
        printLine(102);
        System.out.printf("|%-3s|%-30s|%-5s|%-8s|%-50s|\n","No","Name","Age","Gender","Order");
        printLine(102);
        for(int i=0;i<list.size();i++){
            System.out.printf("|%-3d|",i+1);
            System.out.println(temp.poll());
        }
        printLine(102);
    
    }
    
    @Override
    public void viewWaitingOrderProcessingList(){
        System.out.println(vertexInfo+"\n");
        displayWaitingList();
        displayProcessingList();
    }
    
    @Override
    public void viewMenu(){
        System.out.println(vertexInfo+"\n");
        System.out.printf("+%-40s+%-10s+\n",String.valueOf('-').repeat(40),String.valueOf('-').repeat(10));
        System.out.printf("|%-40s|%-10s|\n","Food","Price");
        System.out.printf("+%-40s+%-10s+\n",String.valueOf('-').repeat(40),String.valueOf('-').repeat(10));
        String[][]menu=menu();
        for(int i=0;i<menu.length;i++){
                System.out.printf("|%-40s|%-10s|\n",menu[i][0],menu[i][1]);
        }
        System.out.printf("+%-40s+%-10s+\n",String.valueOf('-').repeat(40),String.valueOf('-').repeat(10));
       
    }
    
    public  void printLine(int length){
        for(int i=0;i<length;i++){
            if(i==0||i==4||i==35||i==41||i==50||i==101)
                System.out.print("+");
            else
               System.out.print("-");
        }
        System.out.println("");
    }
    
    public void JadeGarden() {
        LinkedList<Resident>temp=new LinkedList<>(list);
        while(!temp.isEmpty()){
            queue.add(temp.removeFirst());
            if(!temp.isEmpty())
            queue.add(temp.removeLast());
        }
    }
    
    public void CafeDeuxMagots() {
        ArrayList<Resident> unknownAge=new ArrayList<>();
        LinkedList<Resident> listSortByAge=new LinkedList<>(list);
        for(int i=0;i<listSortByAge.size();i++)
            if(listSortByAge.get(i).getAge()==null)
                unknownAge.add(listSortByAge.remove(i));
        
        Collections.sort(listSortByAge,new AgeComparator());
            
        while(!listSortByAge.isEmpty()){
            queue.add(listSortByAge.removeFirst());
            if(!listSortByAge.isEmpty())
                queue.add(listSortByAge.removeLast());
        }
        queue.addAll(unknownAge);  
    }
    
    public void Libeccio(){
        LinkedList<Resident> wList=new LinkedList<>(list);
        ArrayList<Resident> removeCustomer=new ArrayList<>();
        Stack<Resident>stack=new Stack<>();
        
        while(!wList.isEmpty()){
            for(int i=0;i<wList.size();i++)
                if(dayNumber%(i+1)==0)
                    removeCustomer.add(wList.get(i));
            for(Resident i:removeCustomer){
                stack.push(i);
                wList.remove(i);
            }       
        }    
        while(!stack.isEmpty())
            queue.add(stack.pop());
    }
        
    public void SavageGarden(){
        LinkedList<Resident> temp=new LinkedList<>(list);
        while(!temp.isEmpty())
            stack1.push(temp.removeLast());
        
        Resident current=stack1.peek();
        loop:{
        while(!stack1.isEmpty()||!stack2.isEmpty()){
            for(int i=0;i<dayNumber-1;i++){
                if(!stack1.isEmpty())
                    if(current==stack1.peek())
                        current=slideOver(stack1,stack2);                
                    else
                        current=slideOver(stack2,stack1);
                else 
                    current=slideOver(stack2,stack1);
                 
            }
            
            if(stack1.contains(current)){
                queue.add(stack1.pop());
                if(stack1.isEmpty())
                    if(stack2.isEmpty())
                        break loop;
                    else
                        current=stack2.peek();           
                else
                    current=stack1.peek();
            }
            else{
                queue.add(stack2.pop());
                if(stack2.isEmpty())
                    if(stack1.isEmpty())
                        break loop;
                    else
                        current=stack1.peek();           
                else
                    current=stack2.peek();
            }
        }
        }
    }
    
    public Resident slideOver(Stack<Resident> stack1,Stack<Resident> stack2){
        stack2.add(stack1.pop());
        return replaceCurrent(stack1,stack2);
                    
    }
    
    public Resident replaceCurrent(Stack<Resident> stack1,Stack<Resident> stack2){
        if(stack1.isEmpty())
            return stack2.peek();
        else 
            return stack1.peek();
    }
        
    public void TrattoriaTrussardi(){
        ArrayList<Resident>unknownAge=new ArrayList<>();
        LinkedList<Resident> maleList=new LinkedList<>(list);
        LinkedList<Resident> femaleList=new LinkedList<>();
        
        for(int i=0;i<maleList.size();i++){
            if(maleList.get(i).getAge()==null)
                unknownAge.add(maleList.remove(i));
            else if(maleList.get(i).getGender().equals("Female"))
                femaleList.add(maleList.remove(i));
        }
        Collections.sort(maleList,new AgeComparator());
        Collections.sort(femaleList,new AgeComparator());
        
        while(!maleList.isEmpty()||!femaleList.isEmpty()){
            if(!maleList.isEmpty())
                queue.add(maleList.removeLast());
            if(!femaleList.isEmpty())
                queue.add(femaleList.removeFirst());
            if(!maleList.isEmpty())
                queue.add(maleList.removeFirst());
            if(!femaleList.isEmpty())
                queue.add(femaleList.removeLast());       
        }
        queue.addAll(unknownAge);//didnt sort the unknown age by gender   
    }
    
    public String[][] menu(){
        String[][] menuJD={
            {"Braised Chicken in Black Bean Sauce","($15.00)"},
            {"Braised Goose Web with Vermicelli","($21.00)"},
            {"Deep-fried Hiroshima Oysters","($17.00)"},
            {"Poached Tofu with Dried Shrimps","($12.00)"},
            {"Scrambled Egg White with Milk","($10.00)"},
            };
        
        String[][] menuCafe={
            {"Sampling Matured Cheese Platter","($23.00)"},
            {"Spring Lobster Salad","($35.00)"},
            {"Spring Organic Omelette","($23.00)"},
            {"Truffle-flavoured Poultry Supreme","($34.00)"},
            {"White Asparagus","($26.00)"},
            };
        
        String[][] menuTT={
            {"Caprese Salad","($10.00)"},
            {"Creme caramel","($6.50)"},
            {"Lamb Chops with Apple Sauce","($25.00)"},
            {"Spaghetti alla Puttanesca","($15.00)"},
            };

        String[][] menuLibeccio={
            {"Formaggio","($12.50)"},
            {"Ghiaccio","($1.01)"},
            {"Melone","($5.20)"},
            {"Prosciutto and Pesci","($20.23)"},
            {"Riscotto","$(13.14)"},
            {"Zucchero","($0.60)"},
            };  

        String[][] menuSG={
            {"Abbacchio's Tea","($1.00)"},
            {"DIO's Bread","($36.14)"},
            {"Giorno's Donuts","($6.66)"},
            {"Joseph's Tequila","($35.00)"},
            {"Kakyoin's Cherry","($3.50)"},
            {"Kakyoin's Porridge","($4.44)"},
            };          
        
        if(vertexInfo.equals("Jade Garden"))
            return menuJD;
        else if(vertexInfo.equals("Cafe Deux Magots"))
            return menuCafe;
        else if(vertexInfo.equals("Trattoria Trussardi"))
            return menuCafe;
        else if(vertexInfo.equals("Libeccio"))
            return menuCafe;
        else if(vertexInfo.equals("Savage Garden"))
            return menuCafe;
        return null;
    } 
       
}

class AgeComparator implements Comparator<Resident>{
    
    @Override
    public int compare(Resident resident1,Resident resident2){
        if(resident1.getAge()>resident2.getAge())
            return -1;
        else if(resident1.getAge()<resident2.getAge())
            return 1;
        else
            return 0;
    }
}




