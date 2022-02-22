import java.util.ArrayList;
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
  public static List<String> findWords(String[][] board, List<String> wordsToFind) {
    List<String> outputList = new ArrayList<>();
    for(String word :wordsToFind){
      char[] charArray = word.toCharArray();
      int k=0;
      for(int i = 0 ; i < board.length;i++){
        for(int j = 0 ; j < board[i].length;j++) {
              if(board[i][j].toCharArray()[0] ==( charArray[k])){
                  if(checkRight(board,charArray[k+1],i,j)){

                  } else if(checkLeft(board,charArray[k+1],i,j)){

                  }else if(checkUp(board,charArray[k+1],i,j)){

                  }else if(checkDown(board,charArray[k+1],i,j)){

                  }
              }
        }
      }
    }

    return outputList;
  }

  private static boolean checkDown(final String[][] board, final char c, final int i, final int j) {
    if( j+1 < board[i].length) {
      if(board[i][j+1].toCharArray()[0] ==(c)){
       return true;
      }
    }
    return false;
  }
  private static boolean checkUp(final String[][] board, final char c, final int i, final int j) {
    if( j+1 < board[i].length) {
      if(board[i][j+1].toCharArray()[0] ==(c)){
        return true;
      }
    }
    return false;
  }
  private static boolean checkLeft(final String[][] board, final char c, final int i, final int j) {
    if( j+1 < board[i].length) {
      if(board[i][j+1].toCharArray()[0] ==(c)){
        return true;
      }
    }
    return false;
  }
  private static boolean checkRight(final String[][] board, final char c, final int i, final int j) {
    if( j+1 < board[i].length) {
      if(board[i][j+1].toCharArray()[0] ==(c)){
        return true;
      }
    }
    return false;
  }
}
