import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EX2_IndicesSumming {
  //Instructions:
  //  Given an array of integers, return a list of strings containing the indexes of two numbers that add up to the
  //  provided target, one pair of indices per string. You may not use the same
  //  index twice.  A sample array is provided, but code should perform for any array of any
  //  number of integers.
  public static Set<String> findIndicesMatchingTargetSum(final int[] inputArray, int targetSum) {
    Set<String> outputSet = new HashSet<>();
    Map<Integer,Integer> map = new HashMap<>();

    for(int i=0;i<inputArray.length;i++){
      map.put(inputArray[i],i );
    }

    for(int i=0;i<inputArray.length;i++){
      if(map.containsKey(targetSum - inputArray[i])){
        outputSet.add(i+", "+map.get(targetSum - inputArray[i]));
        map.remove(inputArray[i]);
      }
    }

    return outputSet;
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
              .collect(Collectors.joining(", "));
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
