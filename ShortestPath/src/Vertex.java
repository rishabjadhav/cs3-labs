import java.util.List;

public class Vertex implements Comparable<Vertex> {
    private int x;
    private int y;
    public int id;

    public List<Integer> edges; //the list of edges (connections) for this node
    private boolean visited = false;
    public double distance = Double.POSITIVE_INFINITY;

    public Vertex() {}

    public Vertex(int ID, int x, int y) {
        this.id = ID;
        this.x = x;
        this.y = y;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }
    public double distanceFrom(Vertex v) {
        return Math.sqrt(Math.pow(v.x - this.x, 2) + Math.pow(v.y - this.y, 2));
    }

    @Override
    public String toString() {
        return "Vertex #" + id + " at (" + this.x + ", " + this.y + ") // Visited? : " + this.visited;
    }

    public int compareTo(Vertex v) {
        //IF THIS NODE HAS A GREATER DISTANCE, IT RETURNS 1
        //OTHERWISE, IT RETURNS -1
        if (v.distance == this.distance) {
            return 0;
        } else if (v.distance > this.distance) {
            return -1;
        } else {
            return 1;
        }
    }

    public boolean beenVisited() {
        return visited;
    }
}
