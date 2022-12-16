import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class EX3_UniqueRandomNumberGenerator {
	// Instructions:
	// Given a desired count and a range of desired values defined by minimum /
	// maximum integers (inclusive),
	// generate a list of unique random numbers within the specified range and of
	// the desired count.
	// The list should be sorted in ascending order.

	public static void main(String[] args) {
		List<Integer> result = generateUniqueRandomNumbers(5, 200, 300);
		System.out.println(result.toString());
	}

	public static List<Integer> generateUniqueRandomNumbers(int desiredCount, int minInclusive, int maxInclusive) {
		// YOUR CODE HERE
		List<Integer> result = new Random().ints(desiredCount, minInclusive, maxInclusive).boxed().distinct().sorted()
				.collect(Collectors.toList());
		return result;
	}
}
