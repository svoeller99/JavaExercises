import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EX1_DuplicatesFinder_Test {
  @Test
  public void testFindDuplicates() {
    int[] input = { 1, 5, 3, 2, 6, 8, 9, 10, 1, 5, 8, 9, 3, 10, 45, 32, 16, 14, 3, 5, 9 };
    List<Integer> result = EX1_DuplicatesFinder.findDuplicates(input);
    assertEquals(Arrays.asList(1, 3, 5, 8, 9, 10), result);
  }
}
