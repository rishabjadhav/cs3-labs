import java.util.LinkedList;

public class Tour
{
	private Node head;

	/** create an empty tour */
	public Tour()
	{
		head = null;
	}
	
	/** create a four-point tour, for debugging */
	public Tour(Point a, Point b, Point c, Point d)
	{
		head = new Node(a, new Node(b, new Node(c, new Node(d))));
		head.next.next.next.next = head;

	}
	
	/** print tour (one point per line) to std output */
	public void show()
	{
		Node n = head.next;
		while (!n.equals(head)) {
			System.out.println(n.p.toString());
		}
		System.out.println(head.p.toString());
	}
	
	/** draw the tour using StdDraw */
	public void draw()
	{
		Node n = head.next;
		while (!n.equals(head)) {
			n.p.draw();
			n.p.drawTo(n.next.p);
		}
		head.p.draw();
		head.p.drawTo(n.next.p);
	}
	
	/** return number of nodes in the tour */
	public int size()
	{
		Node n = head.next;
		int i = 0;
		while (!n.equals(head)) {
			i++;
			n = n.next;
		}

		return i + 1;
	}
	
	/** return the total distance "traveled", from start to all nodes and back to start */
	public double distance()
	{
		Node n = head.next;
		double distance = 0.0;
		while (!n.equals(head)) {
			distance += n.p.distanceTo(n.next.p);
		}
		distance += head.p.distanceTo(head.next.p);
		
		return distance;
	}
	
	/** insert p using nearest neighbor heuristic */
    public void insertNearest(Point p) 
    {
        Node node = new Node();
		Node near = new Node();
		double distance = 0;
		double nearest = 0;

		while (node.next != head) {
			distance = head.p.distanceTo(node.next.p);
			if (distance < nearest) {
				nearest = distance;
				near = node;
			}
		}
		Node temp = new Node();
		temp.next = node.next;
		node.next = near;
		near.next = temp;
    }

	/** insert p using smallest increase heuristic */
    public void insertSmallest(Point p) 
    {
    	Node temp = new Node();
		double distance = 0.1;
		double nearest = 0;

		while (temp.next != head) {




			if (distance < nearest) {
				nearest = distance;
			}
		}
    }

	private class Node {
		Point p;
		Node next;

		public Node() {

		}

		public Node(Point p, Node next) {
			this.p = p;
			this.next = next;
		}
		public Node (Point p) {
			this.p = p;
		}

		public boolean equals(Node n){
			if (this.p.x() == n.p.x()) {
				if (this.p.y() == n.p.y()){
					return true;
				}
			}
			return false;
		}
	}
}