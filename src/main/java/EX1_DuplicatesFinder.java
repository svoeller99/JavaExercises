import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EX1_DuplicatesFinder {
	// Instructions:
	// Given an array of integers, return all numbers appearing more than once as a
	// sorted list of integers.
	// Only include duplicate numbers one time. A sample input array
	// is provided, but your code should perform for an array of any number of
	// integers.
	public static List<Integer> findDuplicates(int[] inputArray) {
		// YOUR CODE HERE
		List<Integer> duplicateNumber = Arrays.stream(inputArray).boxed().filter(n -> !elementSet.add(n))
				.collect(Collectors.toSet()).parallelStream().collect(Collectors.toList());
		return duplicateNumber;
	}

	public static void main(String[] args) {
		List<Integer> duplicateNumberList = findDuplicates(new int[] { 3, 5, 6, 7, 3, 1, 7 });
		System.out.println(duplicateNumberList);
	}
}
