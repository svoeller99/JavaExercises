import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.robin.nike.EX2_IndicesSumming;
import com.robin.nike.EX2_IndicesSumming.Indices;

public class EX2_IndicesSumming {
  //Instructions:
  //  Given an array of integers, return a list of strings containing the indexes of two numbers that add up to the
  //  provided target, one pair of indices per string. You may not use the same
  //  index twice.  A sample array is provided, but code should perform for any array of any
  //  number of integers.
  public static Set<String> findIndicesMatchingTargetSum(final int[] inputArray, int targetSum) {
    //YOUR CODE HERE
	  Set<Indices> result = IntStream.range(0, inputArray.length).boxed()
		      	 .flatMap(n1 -> IntStream.range(n1, inputArray.length)
		         .filter(n2 -> n1!=n2 && inputArray[n1] + inputArray[n2] == targetSum)
		         .mapToObj(n2 -> new EX2_IndicesSumming.Indices(n1, n2)))
		         .collect(Collectors.toSet());
    return result;
  }

  // Optional: feel free to use this class to aid in solving the challenge. It provides the following:
  //   * Implementations of equals/hashCode that will aid in identifying duplicate pairs of indices.
  //   * A toString implementation that will produce the desired comma-delimited format expected by the test.
  static class Indices {
    private final List<Integer> indicesList;

    Indices(int a, int b) {
      this.indicesList = Stream.of(a, b).sorted().collect(Collectors.toList());
    }

    @Override
    public String toString() {
      return indicesList.stream()
              .map(Objects::toString)
              .collect(Collectors.joining(", ", "(", ")"));
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Indices indices = (Indices) o;
      return Objects.equals(indicesList, indices.indicesList);
    }

    @Override
    public int hashCode() {
      return Objects.hash(indicesList);
    }
  }
  

  public static void main(String[] args) {
	  Set<Indices> result = findIndicesMatchingTargetSum(new int[]{1, 5, 2, 0, 4, 11, 9, 6, 12, 7},9);
	  System.out.println(result.toString());
  }

}
