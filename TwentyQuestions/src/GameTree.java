import java.io.*;
import java.util.Scanner;

public class GameTree {
	private BTNode root;
	private BTNode thisNode;

	private Scanner reader;
	private String fileName;
	private File file;


	private class BTNode {
		private String data;
		private BTNode left;
		private BTNode right;

		public BTNode (String data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	public GameTree() {

	}

	public GameTree(String fileName) {
		this.fileName = fileName;
		this.file = new File(fileName);
		try {
			reader = new Scanner(file);
		} catch (FileNotFoundException e) {}

		root = questionIdentifier();
		thisNode = root;
	}

	public void add(String question, String answer) {
		String data = thisNode.data;
		thisNode.data = question;
		thisNode.left = new BTNode(answer);
		thisNode.right = new BTNode(data);
	}



	private BTNode questionIdentifier() {
		String line = reader.nextLine();

		if (line.charAt(line.length() - 1) == '?') { //if the last character of the line is a question mark, denoting a question
			BTNode node = new BTNode(line);

			node.left = questionIdentifier(); //recursively create nodes for all questions
			node.right = questionIdentifier();
			return node;
		}

		return new BTNode(line);
	}

	public boolean foundAnswer() {
		if (thisNode != null) {
			if (thisNode.data.charAt(thisNode.data.length() - 1) == '?') {
				return true;
			}
		}
		return false;
	}


	public String getCurrent() {
		if (thisNode == null) {
			return null;
		}
		return thisNode.data;
	}

public void playerSelected(Choice question) {
	if (question == Choice.No) {
		thisNode = thisNode.right;
	} else {
		thisNode = thisNode.left;
		}
	}

	public void reStart() {
		thisNode = root;
	}

	@Override
	public String toString() {
		return traverse(root, "");
	}

	private String traverse(BTNode node, String str) {
		if (node == null)
			return "";
		else {
			return traverse(node.right, str + "-") + str + node.data + '\n' +
					traverse(node.left, str + "-");
		}
	}

	public void saveGame() {
		PrintWriter printWriter;
		try {
			if (reader == null) {
				throw new FileNotFoundException("404 : File Not Found");
			}
			printWriter = new PrintWriter(this.file);
		}

		catch (FileNotFoundException e) {
			return;
		}
		saveGameHelper(printWriter, root);
		printWriter.close();
	}
	private void saveGameHelper(PrintWriter printWriter, BTNode node) {
		if (node != null) {
			printWriter.println(node.data);
			saveGameHelper(printWriter, node.left);
			saveGameHelper(printWriter, node.right);
		}
	}
}