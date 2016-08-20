/** 
 Mergesort.  
 COMP1406/1006 - Fall 2013
 Assignment 9 - Problem 4


 <p>
 A class implements the algorithm mergesort for linked lists.
*/


public class Merge{
  
  //attributes
  
  private static LinkedList merged = new LinkedList();
  private static LinkedList nullList = new LinkedList();
  //int count = 0;
 
  public static LinkedListABS merge (LinkedListABS firs, LinkedListABS secon){
    // purpose : to merge together two lists of strings (each that are sorted alphabetically)
    // input : two lists 
    // output : a "new" list that is sorted alphabteically and contains all the elements in the two input lists
    //          the new list should have all new nodes in it
   
    // Note: you must use recursion for this problem
    
    LinkedList first = (LinkedList) firs;
    LinkedList second = (LinkedList) secon;
    
    if (first == null || second == null){
      if (first == null && second == null){
        LinkedListABS nullList2 = (LinkedListABS) nullList;
        return nullList2;
      }
      else if (first == null && second != null){
        return second;
      }
      else{
        return first;
      }
    }
    
    else{
      if (first.size() == 0 || second.size() == 0){
      if(first.size() == 0 && second.size() == 0){
        LinkedListABS cat = merged;
        LinkedList merged = new LinkedList();
        return cat;
      }
      else if (first.size() == 0 && second.size() != 0){
        merged.insert(second.remove(), merged.size());
        return merge(first, second);
      }
      else{
        merged.insert(first.remove(), merged.size());
        return merge(first, second);
      }
    }
    else{
      /*System.out.println(first.isEmpty());
      System.out.println(second.isEmpty());
      System.out.println(first.getHead().getData());
      System.out.println(second.getHead().getData());*/
     
      if ((first.getHead().getData()).compareToIgnoreCase(second.getHead().getData()) <= 0){
        merged.insert(first.remove(), merged.size());
        return merge(first, second);
      }
      else{
        merged.insert(second.remove(), merged.size());         
        return merge (first, second);
      }
    }
  }
  }
 
  
  public static LinkedListABS[] split(LinkedListABS list){
    // purpose : to split the input list into two (almost) equally sized lists
    // input : a list of strings 
    // output : an array of two "new" lists a list. The first list corresponds to first half of the 
    //          input list and the second list corresponds to the second half of the input list 
    //          The output lists should have all new nodes in it
    // example: list = {s0,s1,s2,s3,s4,s5}
    //          split(list) -> [{s0,s1,s2}, {s3,s4,s5}]
    //          list = {s0,s1,s2,s3,s4,s5,s6}
    //          split(list) -> [{s0,s1,s2,s3}, {s4,s5,6}]
    // when list has even length the list is split exactly in half size()/2 strings in each
    // when list has odd length, then the first list has size()/2+1 strings and the second has size()/2 
    //                                                   (using integer division)
    
    //LinkedList split1 = new LinkedList();
    //LinkedList split2 = new LinkedList();
    
    LinkedListABS [] splitedList = new LinkedListABS[2];
    LinkedListABS b;
    LinkedListABS c;
    
    if (list.size() != 0){
      if (list.size()%2 == 0){
        int a = list.size()/2;
        b = CopyLinkedList.copy(list, 0, a);
        c = CopyLinkedList.copy(list, a, list.size());
        
        splitedList[0] = b;
        splitedList[1] = c;
      }
      else{
        int a = list.size()/2;
        b = CopyLinkedList.copy(list, 0, a + 1);
        c = CopyLinkedList.copy(list, a + 1, list.size());
        
        splitedList[0] = b;
        splitedList[1] = c;
      }
      return splitedList;
    }
    
    else{
      return splitedList;
    }
  }
  
  
  public static LinkedListABS sort(LinkedListABS list){
    // puspose : sorts the link of Strings (alphabteically) using mergesort
    // input : a list of Strings
    // output : a "new" list of the same Strings but sorted alphabetically
    //          (the input list must be left unchanged. the new list must have all new nodes in it)
    
    //LinkedList [] listArray = new LinkedList [list.size()];
    
    /*if (split(list).[0].size() == 1){
      listArray.[0] = split(list).[0];
    }
    else{
      list
      
    }*/
    
    /*if (list!= null){
      
      //if number of items in list is even number
      if (list.size()%2 == 0){
        int a = list.size()/2;
        LinkedListABS b = split(list);
        
        for (int i = 0; i<a; i=i+1){
          for(int j = 0; j<b.length(); j=j+1){
          LinkedListABS split(b[j]);
          
          
      LinkedListABS [] a = split(list);
      LinkedListABS [] b = split(a[0]);
      }
      
      else{
        int a = (list.size()/2) + 1;
      
    
    if(list.size() = 1){
    }
    else{
      a = split(list);
    }*/
    
    return null;    
  }
    
  //main function used for testing
  /*public static void main(String [] args){
    
    LinkedList first = new LinkedList();
    LinkedList second = new LinkedList();
    first.insert("d", 0);
    second.insert("b", 1);
    second.insert("c", 2);
    first.insert("a", 3);
    first.insert("e", 4);
    second.insert("hello", 0);
    second.insert("sorry", 1);
    second.insert("morning", 2);
    second.insert("afternoon", 3);
    second.insert("evening", 4);
    
    System.out.println(first.getHead().getData());
    System.out.println(second);
    
    LinkedListABS one = (LinkedListABS) first;
    LinkedListABS two = (LinkedListABS) second;
    
    //LinkedListABS [] splitList = split(one);
    //LinkedListABS [] splitList = split(two);
    
    //LinkedListABS two = (LinkedListABS) second;
    //System.out.println(first.size());
    LinkedListABS newList = merge (one, two);
    LinkedList newerList = (LinkedList) newList;
    System.out.println(newerList);
    //LinkedListABS [] splitList = split(newList);
    //LinkedListABS split1 = splitList[0];
    //LinkedListABS split2 = splitList[1];
    //LinkedList splitone = (LinkedList) split1;
    //LinkedList splittwo = (LinkedList) split2;
    //System.out.println(splitone);
    //System.out.println(splittwo);
    
  }*/
  
}
