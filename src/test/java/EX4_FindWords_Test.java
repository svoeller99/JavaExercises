import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

public class EX4_FindWords_Test {
  @Test
  public void testFindWords() {
    String[][] board =  {
        {"o","a","a","n"},
        {"e","t","a","e"},
        {"i","h","k","r"},
        {"i","f","l","v"}
    };
    List<String> words = Arrays.asList("oath","pea","eat","rain");
    List<String> expectedWordsFound = Arrays.asList("eat", "oath");

    List<String> result = EX4_FindWords.findWords(board, words);
    assertEquals("Resulting found words should match expected", expectedWordsFound, result);
  }
}
