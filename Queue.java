/** 
 Queue Class.  
 COMP1406/1006 - Fall 2013
 Assignment 9 - Problem 3

Name: Cindy Gao
Student Number: 100861300
Date: November 25, 2013

 <p>
 A class creates queues and methods which can operate on the queues.
*/

public class Queue extends QueueABS{
  
  //attributes
  private int size;
  private Node head;
  private Node end;
  private Node tempElement;
  private String aString ="";
  
  
  /* checks if the queue is empty or not
   * returns true if the queue is empty, returns false otherwise */
  /* this method should not use recursion or iteration */
  public boolean isEmpty(){
    if (size == 0){
      return true;
    }
    else{
      return false;
    }
  }
  
  /* returns the number of Strings in the queue */
  /* this method should not use recursion or iteration */
  public int size(){
    return size;
  }
  
  /* adds a String to the back of the queue */
  /* this method should not use recursion or iteration */
  public void enqueue(String s){
    if (size == 0){
      head = new Node (s, null);
      end = head;
      tempElement = head;
      size = size + 1;
    }
    else{
      Node b = new Node (s, null);;
      end.setNext(b);
      end = b;
      tempElement = head;
      head = tempElement;
      size = size + 1;
    }
  }
  
  /* removes and returns the String at the front of the queue (using FIFO property)  
   * or returns null if the queue is empty */
  /* this method should not use recursion or iteration */
  public String dequeue(){
    if (size == 0){
      return null;
    }
    else{
      String removed = head.getData();
      tempElement = head.getNode();
      head.setNext(null);
      head = tempElement;
      tempElement = head;
      size = size - 1;
      return removed;
    }
  }
  
  /* returns the String at the front of the queue (or null if the queue is emoty)
   * this method does not modify the queue*/
  /* this method should not use recursion or iteration */
  public String peek(){
    if (size == 0){
      return null;
    }
    else{
      return head.getData();
    }
  }
  
  /* returns a String representation of the queue 
   * the returned string consists of all the Strings in the queueu, in the order from front 
   * of the queue to the back of the queue, with a "#" (number sign) character between each String */
  @Override
  public String toString(){
    String aString = "";
      tempElement = head;
      for (int i=0; i<size; i=i+1){
        aString = aString + tempElement.getData() +"#";
        tempElement = tempElement.getNode();
      }
    return aString;
  }
      
  @Override
  public int compareTo(QueueABS other){
    if(this.size()>other.size()){
      return 1;
    }
    else if (this.size<other.size()){
      return -1;
    }
    else{
      String first = this.head.getData().toLowerCase();
      String second = other.peek().toLowerCase();
      
      if (first.compareTo(second) > 0){
        return 1;
      }
      else if (first.compareTo(second) < 0){
        return -1;
      }
      else{
        return 0;
      }
    }
  }
  
  public Queue(){
    size = 0;
    head = null;
  }
  
  //main method used for testing
  /*public static void main (String [] args){
    Queue a = new Queue();
    a.enqueue("hello");
    a.enqueue("sorry");
    a.enqueue("morning");
    a.enqueue("afternoon");
    a.enqueue("evening");
    //System.out.println(a.size());
    System.out.println(a.toString());
    //System.out.println(a.peek());
    //System.out.println(a.dequeue());
    //System.out.println(a.toString());
    Queue b = new Queue();
    b.enqueue("morning");
    b.enqueue("sorry");
    b.enqueue("morning");
    b.enqueue("afternoon");
    b.enqueue("evening");
    System.out.println(a.compareTo(b));
  }*/
}