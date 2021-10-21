import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import static org.junit.Assert.*;

public class EX3_UniqueRandomNumberGeneratorTest {
  @Test
  public void testGenerateUniqueRandomNumbers() {
    int desiredCount = 5;
    int min = 1;
    int max = 10;

    List<Integer> result = EX3_UniqueRandomNumberGenerator.generateUniqueRandomNumbers(desiredCount, min, max);

    assertEquals("result should contain expected number of elements", desiredCount, result.size());

    result.forEach(elem -> {
      assertTrue("should be greater than or equal to min", elem >= min);
      assertTrue("should be less than or equal to max", elem <= max);
    });

    Set<Integer> uniqueValues = new HashSet<>(result);
    assertEquals("result should not contain duplicates", result.size(), uniqueValues.size());

    List<Integer> sorted = result.stream().distinct().sorted().collect(Collectors.toList());
    assertEquals("result should be sorted", sorted, result);
  }

  // TODO: write another test with different desiredCount / min / max
}
