
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Scooby {
    public static void main(String[] args) {
        Scanner scanner = null;
        File file = new File("Scooby.dat");
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int sets = scanner.nextInt();
        //System.out.println("number of sets : " + sets);
        scanner.nextLine();

        for (int i = 0; i < sets; i++) {
            Graph graph = new Graph();
            String[] rooms = scanner.nextLine().split(" ");
            String link = scanner.nextLine();
            //System.out.println(rooms);
            for (String room : rooms) {
                //System.out.println(room);
                if (!graph.linkedRooms.containsKey(room.charAt(0))) {
                    graph.linkedRooms.put(room.charAt(0), new LinkedList<>());
                }

                graph.linkedRooms.get(room.charAt(0)).add(room.charAt(1));


                if (!graph.linkedRooms.containsKey(room.charAt(1))) {
                    graph.linkedRooms.put(room.charAt(1), new LinkedList<>());
                }

                graph.linkedRooms.get(room.charAt(1)).add(room.charAt(0));
            }

            boolean foundPath = graph.isLink(graph.linkedRooms, new HashSet<>(), link.charAt(0), link.charAt(1));
            if (foundPath) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }


    public static class Graph {
        public HashMap<Character, LinkedList<Character>> linkedRooms = new HashMap<>();

        public Graph() {}


        static boolean isLink(HashMap<Character, LinkedList<Character>> allRooms, HashSet<Character> alrSearched, char start, char finish) {
            if (start == finish) {
                return true;
            }
            if (alrSearched.contains(start)) {
                return false;
            }
            alrSearched.add(start);
            boolean found = false;
            if (allRooms.get(start) == null) {
                return false;
            }
            for (Character character : allRooms.get(start)) {
                if (isLink(allRooms, alrSearched, character, finish)) {
                    found = true;
                    break;
                }
            }
            return found;
        }
    }
}