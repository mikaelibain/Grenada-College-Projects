/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeview;


/* @author josiahc2016 */
public class Linklist {
    public String bookName;
    public int millionsSold;
    
    public Linklist next;
    
    public Linklist(String bookName, int millionsSold){
    
        this.bookName = bookName;
        this.millionsSold = millionsSold;
    }
    
    public void display(){
    
        System.out.println(bookName + ": " + millionsSold + ",000,000") ;
    }
    
    public String toString(){
    
        return bookName;
    }
    
    public static void main(String[] args) {
        
        Linklist1 theLinkedList = new Linklist1();
        
        theLinkedList.insertFirstLink("Bread",500);
        theLinkedList.insertFirstLink("Cake",200);
        theLinkedList.insertFirstLink("Pizza",150);
        theLinkedList.insertFirstLink("Puff Pastry",100);
        //find something in linked list
        System.out.println(theLinkedList.find("Bread").bookName + " Was found " +" - This is a seacrh");
        
    }
    
}

class Linklist1{

    public Linklist firstLink;
    
    Linklist1(){
    
        firstLink = null;
    }
    
    public boolean isEmpty(){
        
        return(firstLink == null);
        
    }
    public void insertFirstLink(String bookName, int millionsSold){

    Linklist newLink = new Linklist(bookName, millionsSold);
    
    newLink.next = firstLink;
    
    firstLink = newLink;
    
    }
    
    public void display(){
        
        Linklist theLink = firstLink;
        
        while(theLink != null){
            
            theLink.display();
        
            System.out.println("Next Link: " + theLink.next);
            
            theLink = theLink.next;
            
            System.out.println();
        }
    }
        public Linklist find(String bookName){
            
            Linklist theLink = firstLink;
            
            if(!isEmpty()){
                
                while(theLink.bookName != bookName){
                    
                    if(theLink.next == null){
                        
                        return null;
                } else {
                        
                        theLink = theLink.next;
                    }
            }
        } else {
                
            System.out.println("Empty LinkedList");
                
            }
            
            return theLink;  
    } 
        
    public Linklist removeLink(String bookName){
        
        Linklist currentLink = firstLink;
        Linklist previousLink = firstLink;
        
        while(currentLink.bookName != bookName){
            
            if(currentLink.next == null){
                
                return null;
            } else {
                previousLink = currentLink;
                
                currentLink = currentLink.next;
            }
        }
         if(currentLink == firstLink){
             
             firstLink = firstLink.next;
             
         }else {
             
             previousLink.next = currentLink.next;
         }
          return currentLink;
    }    
}
