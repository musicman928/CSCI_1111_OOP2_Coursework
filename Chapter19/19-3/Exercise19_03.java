/*
Author: 
Date: 

Description: 
 */
import java.util.ArrayList;

public class Exercise19_03 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(14);
    list.add(24);
    list.add(14);
    list.add(42);
    list.add(25);
    
    ArrayList<Integer> newList = removeDuplicates(list);
    
    System.out.print(newList);
  }

  private static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
    ArrayList<E> out = (ArrayList<E>) list.clone();
    boolean duped = false;

    for (int i = 0; i < out.size(); i++) {
      if (duped) {
        i--;
        out.remove(i);
        duped = false;
      }

      for (int j = i + 1; j < out.size(); j++) {
        if (out.get(i).equals(out.get(j))) {
          out.remove(j);
          j--;
          duped = true;
        }
      }
    }

    return out;
  }
}