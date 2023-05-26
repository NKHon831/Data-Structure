/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week05;

/**
 *
 * @author Asus
 */
public class TestLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Character> linkedList=new MyLinkedList<>();
        linkedList.addLast('a');
        linkedList.addLast('b');
        linkedList.addLast('c');
        linkedList.addLast('d');
        linkedList.addLast('e');
        
        System.out.println("Element in the linked list :");
        linkedList.print();
        System.out.println("\nElement in the linked list in reverse order:");
        linkedList.reverse();
        
        System.out.println("\nNumber of elements in the linked list : "+linkedList.size);
        System.out.println("First element: "+linkedList.getFirst());
        System.out.println("Last element: "+linkedList.getLast());       
        System.out.println("Element that is removed from the list :"+linkedList.remove(2));
        System.out.println("Index of 'b':"+linkedList.indexOf('b'));
        System.out.println("Index of 'd':"+linkedList.indexOf('d'));
        if(linkedList.contains('c'))
            System.out.println("The list contains 'c'");
        else
            System.out.println("The list does not contain 'c'");     
        
        linkedList.set(0,'j');
        linkedList.set(1,'a');
        linkedList.set(2,'v');
        linkedList.set(3,'a');
        System.out.println("Element in the linked list :");
        linkedList.print();  
        System.out.println("\nNumber of elements in the linked list : "+linkedList.size);
        
        System.out.println("Middle value :"+linkedList.getMiddleValue());
        
    }
}
