import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Instructions:
//    Word Search - Given a 2D board and a list of words from the dictionary, find all words in the board.
//    Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
//    horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
//
//    Contrary to how a traditional word search works, letters in a word can alternate between horizontal/vertical.
//    However, diagonals are not allowed.
//
//    The resulting list of found words should be sorted alphabetically.
//
//    Example:
//
//    Input:
//    board = [
//            ['o','a','a','n'],
//            ['e','t','a','e'],
//            ['i','h','k','r'],
//            ['i','f','l','v']
//            ]
//    words = ["oath","pea","eat","rain"]
//
//    Output: ["eat","oath"]
public class EX4_FindWords {
	
  public static void main(String[] args) {
	  char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
	  List<String> wordsToFind = List.of("oath","pea","eat","rain");
	  List<String> result = findWords(board,wordsToFind);
	  result.sort(Comparator.naturalOrder());
      System.out.println(result);
  }
	
  public static List<String> findWords(char[][] board, List<String> wordsToFind) {
	  ArrayList<String> result = new ArrayList<String>();
	  int row = board.length;
	  int column = board[0].length;
	  for (String word : wordsToFind) {
		  boolean flag = false;
		  for (int i = 0; i < row; i++) {
			  for (int j = 0; j < column; j++) {
				  char[][] newBoard = new char[row][column];
				  for (int x = 0; x < row; x++) {
					  for (int y = 0; y < column; y++) {
						  newBoard[x][y] = board[x][y];
					  }
				  }
				  
				  if (dfs(newBoard, word, i, j, 0)) {
				  flag = true;
				  }
			  }
		  }
		  if (flag) {
		  result.add(word);
		  }
	  }
	  return result;
  }
  
  public static boolean dfs(char[][] board, String word, int i, int j, int k) {
	  int row = board.length;
	  int column = board[0].length;
	  if (i < 0 || j < 0 || i >= row || j >= column || k > word.length() - 1) {
		  return false;
	  }
	  if (board[i][j] == word.charAt(k)) {
		  char temp = board[i][j];
		  board[i][j] = '#';
		  if (k == word.length() - 1) {
			  return true;
		  } else if (dfs(board, word, i - 1, j, k + 1)
		  || dfs(board, word, i + 1, j, k + 1)
		  || dfs(board, word, i, j - 1, k + 1)
		  || dfs(board, word, i, j + 1, k + 1)) {
			  board[i][j] = temp;
			  return true;
		  }
	  } else {
		  return false;
	  }
	  	return false;
  }
}
