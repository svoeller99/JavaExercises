import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EX2_IndicesSumming {
  //Instructions:
  //  Given an array of integers, return a list of strings containing the indexes of two numbers that add up to the
  //  provided target, one pair of indices per string. You may not use the same
  //  index twice.  A sample array is provided, but code should perform for any array of any
  //  number of integers.
  public static Set<Indices> findIndicesMatchingTargetSum(int[] inputArray, int targetSum) {
    //YOUR CODE HERE Set<Indices> indicesSet = (Set<Indices>) 
	 Set<Indices> result = IntStream.range(0, inputArray.length).boxed()
								      	 .flatMap(i1 -> IntStream.range(i1, inputArray.length)
								         .filter(i2 -> i1!=i2 && inputArray[i1] + inputArray[i2] == targetSum)
								         .mapToObj(i2 -> new EX2_IndicesSumming.Indices(i1, i2)))
								         .collect(Collectors.toSet());
	 return result;
  }
  
  public static void main(String[] args) {
	  Set<Indices> result = findIndicesMatchingTargetSum(new int[]{4,6,1,4,2,1,6,5,3,6},10);
	  System.out.println(result.toString());
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
}
