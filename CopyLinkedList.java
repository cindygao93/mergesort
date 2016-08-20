/** 
 CopyLinkedList Program.  
 COMP1406/1006 - Fall 2013
 Assignment 9 - Problem 2

 <p>
 A program that given an input of a LinkedListABS object will deep copy all or a portion of the list.
*/


public class CopyLinkedList{

  public static LinkedListABS copy(LinkedListABS list, int start, int end){
    // purpose : makes a copy of a consecutrive section of a linked list
    // input : a list of strings, two integer with start < end
    //         assume that     0 <= start < size()
    //                     start <  end   < size() + 1 
    // output : a "new" list consisting of the same strings that are found
    //          in the input list from positions start to end - 1.
    //          or, retyurn null if start/end are not valid (violating the assumed ranges above)
    // example: list = {s0,s1,s2,s3,s4,s5,s6,s7}
    //          copy(list, 2, 5) -> {s2,s3,s4}
    
    /*for (int i=end; start<=end; i=i-1){
      new Node(list.remove(i));
      
    }*/

    LinkedList copiedList = new LinkedList();
    
    int i = start;
    int j = end;
    for (i=start; i<end; i=i+1){
      copiedList.insert(list.look(i), i);
    }
    
    LinkedListABS copied = (LinkedListABS)copiedList;
    return copied;
  }
  
  
  //main commented out that can be used for testing
  /*public static void main(String [] args){
    LinkedList list = new LinkedList();
    System.out.println(list.insert("a", 0));
    System.out.println(list.insert("b", 1));
    System.out.println(list.insert("c", 2));
    System.out.println(list.insert("d", 3));
    System.out.println(list.insert("e", 4));
    LinkedListABS cast = (LinkedListABS)list;
    LinkedListABS copied = (LinkedList) copy(cast, 1, 5);
    System.out.println(copied);
    
  }*/
}

