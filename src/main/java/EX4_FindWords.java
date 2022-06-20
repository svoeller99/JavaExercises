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
		// YOUR CODE HERE
		return null;
	}

	static final String wordsToFind[] = { "oath", "pea", "eat", "rain" };
	static final int n = wordsToFind.length;
	static final int M = 3, N = 3;

	static boolean isWordFound(String str) {
		for (int i = 0; i < n; i++)
			if (str.equals(wordsToFind[i]))
				return true;
		return false;
	}

	static void findWordsUtil(char board[][], boolean wordsToFind[][], int i, int j, String str) {
        wordsToFind[i][j] = true;
		str = str + board[i][j];

		if (isWordFound(str))
			System.out.println(str);

		for (int row = i - 1; row <= i + 1 && row < M; row++)
			for (int col = j - 1; col <= j + 1 && col < N; col++)
				if (row >= 0 && col >= 0 && !wordsToFind[row][col])
					findWordsUtil(board, wordsToFind, row, col, str);

		str = "" + str.charAt(str.length() - 1);
		wordsToFind[i][j] = false;
	}

	static void findWords(char board[][]) {
		boolean wordsToFind[][] = new boolean[M][N];
		String str = "";
		for (int i = 0; i < M; i++)
			for (int j = 0; j < N; j++)
				findWordsUtil(board, wordsToFind, i, j, str);
	}

	public static void main(String args[]) {
		char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		System.out.println("2D Board-words of dictionary are present");
		findWords(board);
	}
}
