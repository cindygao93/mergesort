/** 
 LinkedList Class.  
 COMP1406/1006 - Fall 2013
 Assignment 9 - Problem 1

 <p>
 A class that creates a linked list and methods which can operate on the linked list.
*/

public class LinkedList extends LinkedListABS{
  
  //attributes
  private Node head;
  private Node end;
  private int size;
  private Node tempElement; //tracks the list
  private String removed;
  
  //getter for head
  public Node getHead(){
    return head;
  }
  
  /* checks if list is empty or not 
   * return true if the list is empty and false otherwise*/
  public boolean isEmpty(){
    if (head == null){
      return true;
    }
    else{
      return false;
    }
  }
  
  /* returns the number os Strings in the list */
  public int size(){
    return size;
  }
  
  /* insterts a String s into position pos of the current list 
   * if pos < 0 it inserts to the front of the list
   * if pos > size() it inserts to the end of the list
   * returns the actual position that s is added to */
  public int insert(String s, int pos){
    
    //if the node is added to the beginning
    Node b = new Node(s, head);
    if (size == 0){
      this. head = b;
      this. end = b;
      size = size + 1;
      return 0;
    }
    else if (pos<=0){
      this. head = b;
      size = size + 1;
      return 0;
    }
    
    //if node is added to the end
    else if (pos>=size){
      Node n = new Node(s, null);
      tempElement = head;
      end.setNext(n);
      end = n;
      
      size = size + 1;
      return size - 1;
    }
   
    //if node is added to middle (anywhere not the ends)
    else{
      tempElement = head;
      Node n = new Node(s);
      for (int i=0; i<=pos; i=i+1){
        if (i == pos-1){
          Node a = tempElement.getNode();
          tempElement.setNext(n);
          n.setNext(a);
        }
        tempElement = tempElement.getNode();
      }
      size = size + 1;
      return pos;
    }
  }
  
   /* removes and returns the String in position pos
   * or if pos is not in the range 0..size()-1, returns null and does not modify the list */
  public String remove(int pos){
    if (pos<0 || pos>size-1){
      return null;
    }
    else if (pos == 0){
      tempElement = head.getNode();
      String removed = head.getData();
      head.setNext(null);
      head = tempElement;
      size = size - 1;
      
      return removed;
    }
    
    else if (pos == size-1){
      tempElement = head;
      while (tempElement.getNode() != end){
        tempElement = tempElement.getNode();
      }
      tempElement.setNext(null);
      String removed = end.getData();
      end = tempElement;
      size = size - 1;
      return removed;
    }
    
    //int is not position of either ends
    else{
      tempElement = head;
      for (int i=0; i<pos; i=i+1){
        tempElement = tempElement.getNode();
        if (i == pos - 1){
          removed = tempElement.getData();
        }
      }
      tempElement = head;
      for (int i=0; i<pos; i=i+1){
        tempElement = tempElement.getNode();
        if (i== pos-2){
          tempElement.setNext(tempElement.getNode().getNode());
        }
      }
      size = size - 1;
      return removed;
    }
  }
  
  /* removes and returns the String in the front of the list 
   * or returns null if the list is empty */
  public String remove(){
    
    if (size == 0){
      return null;
    }
    else{
      String removed = head.getData();
      tempElement = head.getNode();
      head.setNext(null);
      head = tempElement;
      size = size - 1;
      return removed;
    }
  }
  
  /* returns the String at position pos in the list 
   * or returns null if pos is not in the range 0..size()-1 
   * The list is never modified */  
  public String look(int pos){
    int count = 0;
    if (pos<0 || pos>size-1){
      return null;
    }
    else{
      tempElement = head;
      while (count != pos){
        tempElement = tempElement.getNode();
        count = count + 1;
      }
      return tempElement.getData();
    }
  }
  
    /* returns a String representation of the list.  
   * The returned String consists of all the Strings in the list, in order,
   * with a "|" (pipe) between each String. 
   * For example, if list = "cat" -> "dog" -> "eel" then the String representation
   * would be "cat|dog|eel"
   * No extra spaces are added */
  @Override
  public String toString(){
    if (size == 0){
      return "";
    }
    else{
      
      String aString = "";
      tempElement = head;
      for (int i=0; i<size; i=i+1){
        aString = aString + "|" + tempElement.getData();
        tempElement = tempElement.getNode();
      }
      return aString;
    }
  }
  
  //empty contructor for LinkedList class
  public LinkedList(){
    head = null;
    size = 0;
    end = null;
    tempElement = head;
  }
  
  //main commented out that can be used for testing
  /*public static void main (String [] args){

    LinkedList list = new LinkedList();
    System.out.println(list.insert("a", 0));
    System.out.println(list.insert("b", 1));
    System.out.println(list.insert("c", 2));
    System.out.println(list.insert("d", 3));
    System.out.println(list.insert("e", 4));
    System.out.println(list.look(3));
    System.out.println(list.toString());
    System.out.println(list.remove(2));
    System.out.println(list.toString());
    System.out.println(list.remove());
    System.out.println(list.toString());
    System.out.println(list.size());
    System.out.println(list.insert("cat", 1));
    System.out.println(list.toString());
    System.out.println(list.insert("cat", 50));
    System.out.println(list.insert("cat", -1));
    System.out.println(list.toString());
  }*/
}
