import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class EX3_UniqueRandomNumberGenerator {
  //Instructions:
  //  Given a desired count and a range of desired values defined by minimum / maximum integers (inclusive),
  //  generate a list of unique random numbers within the specified range and of the desired count.
  //  The list should be sorted in ascending order.
  public static List<Integer> generateUniqueRandomNumbers(int desiredCount, int minInclusive, int maxInclusive) {
    List<Integer> outputList = new ArrayList<>();

    Random random = new Random();

    outputList = random.ints(minInclusive,maxInclusive).distinct().limit(desiredCount).boxed().collect(Collectors.toList());

    Collections.sort(outputList);

    return outputList;
  }
}
