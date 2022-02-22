import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EX1_DuplicatesFinder {
  //Instructions:
  //  Given an array of integers, return all numbers appearing more than once as a sorted list of integers.
  //  Only include duplicate numbers one time. A sample input array
  //  is provided, but your code should perform for an array of any number of integers.
  public static List<Integer> findDuplicates(int[] inputArray) {
    List<Integer> outputList = new ArrayList<>();
    Map<Integer,Integer> map = new HashMap<>();

    for(int number : inputArray){
      map.put(number, map.get(number)==null? 1 : map.get(number)+1 );
    }
    for(Integer number : map.keySet()){
      if(map.get(number) > 1){
        outputList.add(number);
      }
    }

    return outputList;
  }
}
