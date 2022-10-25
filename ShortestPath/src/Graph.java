import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Graph {
    private int vertices;
    private int edges;
    public Vertex[] adjList;

    public Graph(String fileName) {
        File file = new File(fileName);
        try {
            Scanner reader = new Scanner(file);
            this.vertices = reader.nextInt();
            adjList = new Vertex[vertices];
            this.edges = reader.nextInt();

            for (int i = 0; i < this.vertices; i++) {
                Vertex v = new Vertex(reader.nextInt(), reader.nextInt(), reader.nextInt());
                adjList[i] = v;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public double distance (int from, int to) {
        return adjList[from].distanceFrom(adjList[to]);
    }

    @Override
    public String toString() {
        String graph = "";

        for (int i = 0; i < adjList.length; i++) {
            graph += adjList[i] + " ";
        }
        return graph;
    }

    public static void main (String[]args) {
        Graph g = new Graph("input6.txt");
        System.out.println(g);

    }

}
