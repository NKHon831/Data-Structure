/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week05;

/**
 *
 * @author Asus
 */
public class MyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    int size=0;
    
    
    public MyLinkedList(){
        
    }
    
    public void addFirst(E e){
        Node<E>newNode=new Node<>(e);
        newNode.next=head;
        head=newNode;
        size++;
        if(tail==null)
            tail=head;

    }
    
    public void addLast(E e){
        if(tail==null){
            head=new Node<>(e);
            tail=head;
        }
        else{
         Node<E>newNode=new Node<>(e);
         tail.next=newNode;
         tail=newNode;
        }
        size++;
    }
    
    
    public void add(int index, E e){
        if(index==0) 
            addFirst(e);
        else if(index>=size)
            addLast(e);
        else {
            Node<E> current=new Node<>(e);
            for(int i=1;i<index;i++){//stop before requested index
                current=current.next;
            }
            Node<E>temp=current.next;
            current.next=new Node<>(e);
            current.next.next=temp;
            size++;
        }
    }
    
    
    public E removeFirst(){
        if(size==0)
            return null;
        else{
            Node<E> temp=head;
            head=head.next;
            size--;
            if(head==null)
                tail=null;
            return temp.element;
        }                 
        
    }    
    
    public E removeLast(){
        if(size==0)
            return null;
        else if(size==1)
            return removeFirst(); 
        else{
            Node<E> temp=tail;
            Node<E>current=head;
            for(int i=0;i<size-2;i++){
                current=current.next;
            }
            tail=current;
            tail.next=null;
            size--;
            return temp.element;
        }
    }
    
    public E remove(int index){
        if(index<0||index>=size)
            return null;
        else if(index==0)
            return removeFirst();
        else if(index==size-1)
            return removeLast();
        else {
            Node<E>current=head;
            for(int i=1;i<index;i++){
                current=current.next;
            }
            Node<E>temp=current.next;
            current.next=temp.next;
            size--;
            return temp.element;
        }
    }
        
    public boolean contains(E e){
        Node<E>current=head;
        for(int i=0;i<size;i++){
            if(current.element==e)
                return true;
            current=current.next;
        }
        return false;
    }
    
    public E get(int index){
        Node<E>current=head;
        for(int i=0;i<index;i++){
            current=current.next;
        }
        return current.element;
    }
    
    public E getFirst(){
        return get(0);
    }
    
    public E getLast(){
        return get(size-1);
    }
    
    public int indexOf(E e){
        Node<E> current=head;
        for(int i=0;i<size;i++){
            if(current.element==e)
                return i;
            current=current.next;
        }
        return -1;
    }
    
    public int lastIndexOf(E e){
        int index=-1;
        Node<E>current=head;
        for(int i=0;i<size;i++){
            if(current.element==e)
                index=i;  
            current=current.next;
        }
        return index;
    }
    
    public E set(int index,E e){
        Node<E>current=head;
        for(int i=0;i<index;i++){
            current=current.next;
        }
        E temp=current.element;
        current.element=e;
        return temp;
    }
    
    public void clear(){
        for(int i=0;i<size;i++){
            removeFirst();
        }
    }
    
    public void print(){
        Node<E> current=head;
        for(int i=0;i<size;i++){
            System.out.print(current.element+" ");
            current=current.next;
        }
    }
    
    public void reverse(){
        for(int i=size-1;i>=0;i--){
            Node<E>current=head;
            for(int j=0;j<i;j++){
                current=current.next;
            }
            System.out.print(current.element+" ");
        }
    } 
    
    public int getSize(){
        return size;
    }
    
    public E getMiddleValue(){
        int index=(size-1)/2;
        return get(index);
    }
}
