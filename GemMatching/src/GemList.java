import java.util.ArrayList;

public class GemList
{
	Node head;
	private class Node {
		private Gem gem;
		private Node next;
		Node(Gem gem){
			this.gem = gem;next = null;
		}
		@Override
		public String toString() {
			return gem.toString();
		}
	}

	private int size;
	private MyLinkedList<Node> list;

	public GemList() {
		head = null;
		size = 0;
		list = new MyLinkedList<Node>();
	}

	public int size() {
		int count = 0;
		if (head != null) {
			Node temp = head;
			count++;
			while (temp.next != null) {
				count++;
				temp = temp.next;
			}
		}
		return count;
	}

	public void draw(double y) {
		for (int i = 0; i < size; i++) {
			list.get(i).gem.draw(0, y);
		}
	}

	public String toString() {
		String returned = "[";
		Node current = head;

		while (current != null)
		{
			returned += current.gem.getType();
			if (current.next != null) {
				returned += " > ";
			}
			current = current.next;
		}

		return returned + "]";
	}

	public void insertBefore(Gem gem, int index) {
		 if (index > size()) {
			 if (head == null) {
				 head = new Node(gem);
			 }

			 else {
				 Node temp = head;

				 while(temp.next != null) {
						 temp = temp.next;
				 }

				 temp.next = new Node(gem);
				 temp.next.next = null;
			 }
		 }

		 else if(index == 0) {
			 Node temp = head;
			 head = new Node(gem);
			 head.next = temp;
		 }

		 else
		 {
			 Node temp = head;
			 int i = 0;

			 while (i != index - 1) {
				 temp = temp.next;i++;
			 }

			 Node temp2 = temp.next;
			 temp.next = new Node(gem);
			 temp.next.next = temp2;
		 }
	}

	public int score() {
		if (head == null) {
			return 0;
		}

		int score = 0;
		int streakScore = 0;
		int multiplier = 0;

		Node currentNode = head;
		GemType streakType = head.gem.getType();
		while (currentNode != null) {
			if (currentNode.gem.getType() == streakType) {
				multiplier++;
				streakScore += currentNode.gem.getPoints();
				currentNode = currentNode.next;
			} else {
				score += multiplier * streakScore;
				multiplier = 1;
				streakScore = currentNode.gem.getPoints();
				streakType = currentNode.gem.getType();
				currentNode = currentNode.next;
			}
		}
		score += multiplier * streakScore;
		return score;
	}

	//

	public static void main(String [] args)
	{
		GemList list = new GemList();
		System.out.println(list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.9);

		list.insertBefore(new Gem(GemType.BLUE, 10), 0);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.8);

		list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.7);

		list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.6);

		list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.5);

		list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.4);

		list.insertBefore(new Gem(GemType.GREEN, 50), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.3);
	}	
}
