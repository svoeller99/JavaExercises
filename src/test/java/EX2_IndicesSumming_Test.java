import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EX2_IndicesSumming_Test {
  @Test
  public void testFindIndicesMatchingTargetSum() {
    final int[] inputArray = {1, 5, 2, 0, 4, 11, 9, 6, 12, 7};
    final int targetValue = 9;

    Set<String> expected = new HashSet<>(Arrays.asList(
        "1, 4",
        "2, 9",
        "3, 6"
    ));
    assertEquals(expected, EX2_IndicesSumming.findIndicesMatchingTargetSum(inputArray, targetValue));
  }
}
