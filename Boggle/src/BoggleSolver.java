import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class BoggleSolver
{
	private HashSet<String> dict;
	// Initializes the data structure using the given array of strings as the dictionary.
	// (You can assume each word in the dictionary contains only the uppercase letters A - Z.)
	public BoggleSolver(String dictionaryFileName)
	{
		dict = new HashSet<String>();

		File file = new File(dictionaryFileName);
		Scanner scanner = new Scanner("dictionary");
		try {
			scanner = new Scanner(file);
			while(scanner.hasNext()) {
				dict.add(scanner.next());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Dictionary File Not Found");
			e.printStackTrace();
		}
	}

	// Returns the set of all valid words in the given Boggle board, as an Iterable object
	public Iterable<String> getAllValidWords(BoggleBoard board)
	{
		HashSet<String> words = new HashSet<>();

		for (int row = 0; row < board.rows(); row++) {
			for (int col = 0; col < board.cols(); col++) {
				getAllValidWords(board, words, "", row, col, new int[board.rows()][board.cols()]);
			}
		}

		System.out.println(words);
		return words;
	}
	public void getAllValidWords(BoggleBoard board, HashSet<String> words, String wordBuilder, int row, int col, int[][] traversed){
		if (row < 0 || row >= board.rows() || col < 0 || col >= board.cols()) {
			return;
		}

		if (traversed[row][col] == 1) {
			return;
		}

		String word = "";
		if (board.getLetter(row, col) == 'Q') {
			word = wordBuilder + board.getLetter(row, col) + 'U';
		}
		else {
			word = wordBuilder + board.getLetter(row, col);
		}
		if (dict.contains(word.toUpperCase()) && word.length() > 2) {
			words.add(word);
		}

		traversed[row][col] = 1;

		getAllValidWords(board, words, word, row + 1, col, traversed);
		getAllValidWords(board, words, word, row - 1, col, traversed);
		getAllValidWords(board, words, word, row, col + 1, traversed);
		getAllValidWords(board, words, word, row, col - 1, traversed);

		getAllValidWords(board, words, word, row - 1, col - 1, traversed);
		getAllValidWords(board, words, word, row - 1, col + 1, traversed);
		getAllValidWords(board, words, word, row + 1, col - 1, traversed);
		getAllValidWords(board, words, word, row + 1, col + 1, traversed);

		traversed[row][col] = 0;

	}

	// Returns the score of the given word if it is in the dictionary, zero otherwise.
	// (You can assume the word contains only the uppercase letters A - Z.)
	public int scoreOf(String word)
	{
		if (dict.contains(word) == false) {
			return 0;
		}

		if (word.length() <= 2) {
			return 0;
		}
		if (word.length() >= 3 && word.length() <= 4) {
			return 1;
		}
		if (word.length() == 5) {
			return 2;
		}
		if (word.length() == 6) {
			return 3;
		}
		if (word.length() == 7) {
			return 5;
		}
		if (word.length() >= 8) {
			return 11;
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println("WORKING");

		final String PATH   = "./data/";
		BoggleBoard  board  = new BoggleBoard(PATH + "board-q.txt");
		BoggleSolver solver = new BoggleSolver(PATH + "dictionary-algs4.txt");

		int totalPoints = 0;

		for (String s : solver.getAllValidWords(board)) {
			System.out.println(s + ", points = " + solver.scoreOf(s));
			totalPoints += solver.scoreOf(s);
		}

		System.out.println("Score = " + totalPoints); //should print 84

		new BoggleGame(4, 4);
	}

}
