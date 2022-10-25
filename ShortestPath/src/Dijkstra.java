import java.util.*;

public class Dijkstra {
    private Graph g;


    public Dijkstra(Graph g) {
        this.g = g;
    }

    public static void main(String[]args) {
        Dijkstra dijkstra = new Dijkstra(new Graph("input6.txt"));
    }

    public double distance (int source, int destination) {
        dijkstra(source, destination);
        return g.adjList[source].distanceFrom(g.adjList[destination]);
    }

    private void dijkstra(int source, int destination) {
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.add(g.adjList[source]); //push the source in a min priority queue

        while (!pq.isEmpty()) {

            Vertex current = pq.poll(); //pop the vertex
            current.setVisited(true);

            for (Integer i : current.edges) {
                Vertex adjacent = g.adjList[i];
                if (adjacent.beenVisited()) {
                    Double d = distance(current.id, adjacent.id);
                    d += current.distance; //update adjacent's distance
                    if (d < adjacent.distance) { //if shorter link is found
                        pq.remove(adjacent);
                        adjacent.distance = d; //update distance and requeue with update
                        pq.add(adjacent);
                    }
                }
            }
        }
    }
}
