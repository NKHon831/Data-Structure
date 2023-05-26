/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DefaultMap;

/**
 *
 * @author Asus
 */
import java.util.ArrayList;
import java.util.Scanner;
public class Graph<T extends Comparable<T>, N extends Comparable <N>> extends Game{
   Scanner sc=new Scanner(System.in);
   Vertex<T,N> head;
   int size;
   Vertex<T,N> previousLocation;
   Vertex<T,N> currentLocation;
   Vertex<T,N> nextLocation;
   ArrayList<Vertex<T,N>>list1=new ArrayList<>();//store backward route history
   ArrayList<Vertex<T,N>>list2=new ArrayList<>();//store forward route history
   
	
   public Graph()	{
      head=null;
      size=0;
   }
   
   public void clear() {   
      head=null;
   }

   public int getSize()   {
      return this.size;
   }
   
   public int getIndeg(T v)  {
      if (hasVertex(v)==true)	{
         Vertex<T,N> temp = head;
         while (temp!=null) {
            if ( temp.vertexInfo.compareTo( v ) == 0 )
               return temp.indeg;
            temp=temp.nextVertex;
         }
      }
      return -1;
   }
         
   public int getOutdeg(T v)  {
      if (hasVertex(v)==true)	{
         Vertex<T,N> temp = head;
         while (temp!=null) {
            if ( temp.vertexInfo.compareTo( v ) == 0 )
               return temp.outdeg;
            temp=temp.nextVertex;
         }
      }
      return -1;
   }

   public boolean hasVertex(T v)	{
      if (head==null)
         return false;
      Vertex<T,N> temp = head;
      while (temp!=null)	{
         if ( temp.vertexInfo.compareTo( v ) == 0 )
            return true;
         temp=temp.nextVertex;
      }
      return false;
   }

   public boolean addVertex(T v)	{
      if (hasVertex(v)==false)	{
         Vertex<T,N> temp=head;
         Vertex<T,N>newVertex=null;
         if(restaurant.contains((String)v))
             newVertex=new Restaurant<>(v,null);// create restaurant
         else if(residentialArea.contains((String)v))
             newVertex = new ResidentialArea<>(v, null);// create residential area
         else
             newVertex=new Vertex<>(v,null);//create Town Hall;
         if (head==null)   
            head=newVertex;
         else {
            Vertex<T,N> previous=head;;
            while (temp!=null)  {
               previous=temp;
               temp=temp.nextVertex;
            }
            previous.nextVertex=newVertex;
         }
         size++;
         return true;
      }
      else
         return false;
   }
   
   public int getIndex(T v) {
      Vertex<T,N> temp = head;
      int pos=0;
      while (temp!=null)	{
         if ( temp.vertexInfo.compareTo( v ) == 0 )
            return pos;
         temp=temp.nextVertex;
         pos+=1;
      }
      return -1;
   }
   
   public ArrayList<T> getAllVertexObjects() {
      ArrayList<T> list = new ArrayList<>();
      Vertex<T,N> temp = head;
      while (temp!=null)	{
         list.add(temp.vertexInfo);
         temp=temp.nextVertex;
      }
      return list;
   }

   public ArrayList<Vertex<T,N>> getAllVertices() {
      ArrayList<Vertex<T,N>> list = new ArrayList<>();
      Vertex<T,N> temp = head;
      while (temp!=null)	{
         list.add(temp);
         temp=temp.nextVertex;
      }
      return list;
   }
   
   public T getVertex(int pos) {
      if (pos>size-1 || pos<0) 
         return null;
      Vertex<T,N> temp = head;
      for (int i=0; i<pos; i++)
         temp=temp.nextVertex;
      return temp.vertexInfo;
   }
   
   //addEgde(source,destination,1)or addEgde(source,destination,null)
   public boolean addEdge(T source, T destination,N w)   {
      if(hasEdge(source,destination))
          return false;
      Vertex<T,N> sourceVertex = head;
      while (sourceVertex!=null)	{
         if ( sourceVertex.vertexInfo.compareTo( source ) == 0 )   {
            // Reached source vertex, look for destination now
            Vertex<T,N> destinationVertex = head;
            while (destinationVertex!=null)	{
               if ( destinationVertex.vertexInfo.compareTo( destination ) == 0 )   {
                   sourceVertex.option.get(0).addSubOption(destination);
                  // Reached destination vertex, add edge here
                  Edge<T,N> currentEdge = sourceVertex.firstEdge;
                  Edge<T,N> newEdge = new Edge<>(destinationVertex,w, currentEdge);
                  sourceVertex.firstEdge=newEdge;
                  sourceVertex.outdeg++;
                  destinationVertex.indeg++;
                  return true;
               }
               destinationVertex=destinationVertex.nextVertex;
            }
         }
         sourceVertex=sourceVertex.nextVertex;
      }
      return false;
   }
   
      public boolean addUndirectedEdge(T source, T destination,N w)   {
          if(addEdge(source,destination,w))
              if(addEdge(destination,source,w))
                  return true;
          
          return false;
   }
   
   public boolean hasEdge(T source, T destination) {
      if (head==null)
         return false;
      if (!hasVertex(source) || !hasVertex(destination)) 
         return false;
      Vertex<T,N> sourceVertex = head;
      while (sourceVertex!=null)	{
         if ( sourceVertex.vertexInfo.compareTo( source ) == 0 )   {
            // Reached source vertex, look for destination now 
            Edge<T,N> currentEdge = sourceVertex.firstEdge;
            while (currentEdge != null) {
               if (currentEdge.toVertex.vertexInfo.compareTo(destination)==0) 
               // destination vertex found 
                  return true;
               currentEdge=currentEdge.nextEdge;
            }
         }
         sourceVertex=sourceVertex.nextVertex;
      }
      return false;
   }
   
   public N getEdgeWeight(T source, T destination) {
      N notFound=null;
      if (head==null)
         return notFound;
      if (!hasVertex(source) || !hasVertex(destination)) 
         return notFound;
      Vertex<T,N> sourceVertex = head;
      while (sourceVertex!=null)	{
         if ( sourceVertex.vertexInfo.compareTo( source ) == 0 )   {
            // Reached source vertex, look for destination now 
            Edge<T,N> currentEdge = sourceVertex.firstEdge;
            while (currentEdge != null) {
               if (currentEdge.toVertex.vertexInfo.compareTo(destination)==0) 
               // destination vertex found 
                  return currentEdge.weight;
               currentEdge=currentEdge.nextEdge;
            }
         }
         sourceVertex=sourceVertex.nextVertex;
      }
      return notFound;
   }
   
   public ArrayList<T> getNeighbours (T v)  {
      if (!hasVertex(v))
         return null;
      ArrayList<T> list = new ArrayList();
      Vertex<T,N> temp = head;
      while (temp!=null)	{
         if ( temp.vertexInfo.compareTo( v ) == 0 )   {
            // Reached vertex, look for destination now
            Edge<T,N> currentEdge = temp.firstEdge;
            while (currentEdge != null) {
               list.add(currentEdge.toVertex.vertexInfo);
               currentEdge=currentEdge.nextEdge;
            }
         }
         temp=temp.nextVertex;
      }
      return list;   
   }
   
   public void printEdges()   {
      Vertex<T,N> temp=head;
      while (temp!=null) {
         System.out.print("# " + temp.vertexInfo + " : " );
         Edge<T,N> currentEdge = temp.firstEdge;
         while (currentEdge != null) {
            System.out.print("[" + temp.vertexInfo + "," + currentEdge.toVertex.vertexInfo +"("+currentEdge.weight+")"+"] " );
            currentEdge=currentEdge.nextEdge;
         }
         System.out.println();
         temp=temp.nextVertex;
      }  
   }
   
   public boolean removeEdge(T source,T destination){
       if(!hasEdge(source,destination))
           return false;
       else{
           Vertex<T,N> currentVertex=head;
           while(currentVertex!=null){
               if(currentVertex.vertexInfo.compareTo(source)==0){
                   Edge<T,N>previousEdge=null;
                   Edge<T,N>currentEdge=currentVertex.firstEdge;
                   while(currentEdge.toVertex.vertexInfo.compareTo(destination)!=0){
                          previousEdge=currentEdge;
                          currentEdge=currentEdge.nextEdge;
                   }
                   if(previousEdge==null)
                       currentVertex.firstEdge=currentEdge.nextEdge;
                   else{
                       previousEdge.nextEdge=currentEdge.nextEdge;
                   }
                   currentEdge.toVertex.indeg--;
                   currentVertex.outdeg--;
                   return true;
                   
               }
               currentVertex=currentVertex.nextVertex;
           }
           return false;
       }
   }
   
   public void move(){
       startNewDay();
       currentLocation=head;
       while(currentLocation!=null){
           if(previousLocation!=null)
               currentLocation.addOption("Back",(String) previousLocation.vertexInfo);
           if(nextLocation!=null)
               currentLocation.addOption("Forward",(String) nextLocation.vertexInfo);
          
           //Show current Location and  select option
           currentLocation.printInfo();
           System.out.println("\nSelect: ");
           String a=sc.next();
           String userInput=currentLocation.nextMove(a);
           currentLocation.removeOption();
           if(userInput.equals("Move to: "))
               explore(a);
                
           else if(userInput.equals("Back to Town Hall"))
               backTownHallDirectly();
                   
           else if(userInput.equals("Back"))
               backward();
           
           else if(userInput.equals("Forward"))
               forward();
           
           else if(userInput.equals("Advance to Next Day"))
               startNewDay();
           
           else if(userInput.equals("Exit"))
               break;
           
           else if(userInput.equals("View Waiting List and Order Processing List"))
               viewList();
           
           else if(userInput.equals("View Menu"))
               viewMenu();
           
       }
       list1.clear();//not sure have to clear route history anot
   }
   
   public void explore(String a){
        list2.clear();//clear forward history when player choose explore new location
        nextLocation=null;
        list1.add(currentLocation);
        previousLocation=currentLocation;
        int temp=(int)a.charAt(1)-65;
        Edge<T,N>hold=currentLocation.firstEdge;
        for(int i=0;i<temp;i++){
            hold=hold.nextEdge;
        }
        currentLocation=hold.toVertex;
   }
   
   public void backward(){
       list2.add(currentLocation);
       nextLocation=list2.get(list2.size()-1);
       currentLocation=list1.remove(list1.size()-1);
       if(list1.isEmpty())
           previousLocation=null;
       else
           previousLocation=list1.get(list1.size()-1);
   }
   
   public void backTownHallDirectly(){
        list2.clear();//clear forward history when player choose explore new location
        nextLocation=null;
        list1.add(currentLocation);
        previousLocation=currentLocation;
        currentLocation=head;
   }
   
   public void forward(){
       list1.add(currentLocation);
       previousLocation=list1.get(list1.size()-1);
       currentLocation=list2.remove(list2.size()-1);
       if(list2.isEmpty())
           nextLocation=null;
       else
         nextLocation=list2.get(list2.size()-1);
   }
   
   public void viewList(){
       currentLocation.viewWaitingOrderProcessingList();
   }
   
   public void viewMenu(){
       currentLocation.viewMenu();
   }
   
    public void reset(){
       currentLocation=head;
       nextLocation=null;
       previousLocation=null;
       list1.clear();
       list2.clear();    
   }
   
   public void startNewDay(){
       newDay();
       reset();
       System.out.println("It's Day "+dayNumber+" ("+day+") of our journey in JOJOLands!");
   }
   
   
   
}