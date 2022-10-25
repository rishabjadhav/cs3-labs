
import java.util.*;

public class PrimePath {

    public static void main (String[]args) {
//        Scanner console = new Scanner(System.in);
//        System.out.println("Enter initial");
//        String initialInteger = console.nextLine();
//        System.out.println("Enter final");
//        String finalInteger = console.nextLine();

        String initialInteger = "1033";
        String finalInteger = "8279";


        Queue<Node> tbVisited = new LinkedList<>();
        tbVisited.add(new Node(initialInteger));
        HashSet<String> alrSearched = new HashSet<>();
        int steps = 0;

        while (!tbVisited.isEmpty()) {

            Node current = tbVisited.poll();
            System.out.println(current);
            alrSearched.add(current.num);

            if (current.num.equals(finalInteger)) {
                System.out.println(steps + "solved !");
            }

            char[] charArray = current.num.toCharArray();

            for (int i = 3; i >= 0; i--) { //iterates number of digits (usually 4)
                for (int k = 0; k <= 9; k++) { //iterates 1-9
                    char tempChar = charArray[i]; //takes i digit of current node to save
                    charArray[i] = Integer.toString(k).charAt(0); //replaces i digit of current node with j
                    String newPrime = new String(charArray); //declares new prime with replaced current
                    System.out.print(newPrime);

                    if (isPrime(Integer.parseInt(newPrime)) && !alrSearched.contains(newPrime)) {
                        steps++; //plus one number of steps
                        System.out.println(" IS PRIME");
                        tbVisited.add(new Node(newPrime)); //add this prime to be visited
                        alrSearched.add(current.num); //indicate this prime has already been searched
                        i = -1; //break from loop
                        break;
                    } else {
                        charArray[i] = tempChar;
                    }
                    System.out.println();
                }
            }
        }

    }

    public static boolean isPrime(int i) {
        for (int j = 2; j < i; j++)
            if (i % j == 0)
                return false;

        return true;
    }

    //GRAPH AND NODE CLASSES

    public static class Graph {
        public HashSet<String> primeList = new HashSet<>();

        public Graph() {

        }
    }
    public static class Node {
        public String num;

        public Node(String num) {
            this.num = num;
        }

        public boolean equals(Node n) {
            if (this.num == n.num) {
                return true;
            }
            return false;
        }
    }

}
