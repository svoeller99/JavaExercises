import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EX1_DuplicatesFinder {
  //Instructions:
  //  Given an array of integers, return all numbers appearing more than once as a sorted list of integers.
  //  Only include duplicate numbers one time. A sample input array
  //  is provided, but your code should perform for an array of any number of integers.
  public static List<Integer> findDuplicates(int[] inputArray) {
    //YOUR CODE HERE
	  List<Integer> duplicatedNumbersList = Arrays.stream(inputArray).boxed()
			  									  .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
			  									  .entrySet().stream().filter(i->i.getValue()>1).map(Map.Entry::getKey)
			  									  .collect(Collectors.toList());
	  return duplicatedNumbersList;
  }
  
  public static void main(String[] args) {
	  List<Integer> duplicatedNumbersList = findDuplicates(new int[]{4,6,1,4,2,1,6,5,3,6});
	  System.out.println(duplicatedNumbersList);
  }
}
