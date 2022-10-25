/*
    c
    n m l
    a b
    c d
    e f
    h
    i

    c represents how many cases exist in the file
    n represents how many dominos are in this case, numbered 1-n
    m represents how many knock down relationships there are, or lines after the first line
    l represents how many dominos are knocked down by hand, or remaining lines

    if a is knocked down, b will also be knocked down
    if c is knocked down, d will also be knocked down

    h and i are assumed to be knocked down

    m + l = how many lines are in the case
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ChildsPlay {
    static Scanner reader = null;

    private static class Graph {
        private HashMap<Integer, HashSet<Integer>> dominoMap = new HashMap<>();
        private HashSet<Integer> tippedSet = new HashSet<>();
        private int tippedDominos;


        public Graph() {

        }

        public void setTipped(int dom) {
            if (tippedSet.contains(dom)) {
                return; //prevents setting repeat tipped dominos
            } else {
                tippedSet.add(dom);
                HashSet<Integer> adjacentDominos = dominoMap.get(dom);
                if (dominoMap.get(dom) != null) {
                    for (int domino : adjacentDominos) {
                        setTipped(domino);
                    }
                }
                tippedDominos = tippedSet.size();
            }
        }

        public void setTipLink(int domCause, int domEffect) {
            //System.out.println("setting link between " + domCause + " and " + domEffect);
            if (!dominoMap.containsKey(domCause)) {
                HashSet<Integer> tempSetCause = new HashSet<>();
                tempSetCause.add(domEffect);
                dominoMap.put(domCause, tempSetCause);
            } else {
                dominoMap.get(domCause).add(domEffect);
            }
        }

        public int getTipped() {
            return tippedDominos;
        }
    }

    public static void main(String[] args) {
        try {
            reader = new Scanner(new File("play.dat"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        int cases = reader.nextInt();
        //System.out.println("cases : " + cases);

        for (int i = 0; i < cases; i++) {
            int dominosTotal = reader.nextInt(); //unused
            //System.out.println("number of dominos : " + numDominos);
            int knockLinks = reader.nextInt();
            //System.out.println("knock relationships : " + knockRelation);
            int knocked = reader.nextInt();
            //System.out.println("knocked by hand : " + tipped);


            Graph graph = new Graph();
            for (int j = 0; j < knockLinks; j++) {
                int domCause = reader.nextInt();
                int domEffect = reader.nextInt();
                //System.out.println("if " + domCause + " is knocked down, " + domEffect + " will also be knocked down");
                graph.setTipLink(domCause, domEffect);
            }

            for (int k = 0; k < knocked; k++) {
                int tippedDomino = reader.nextInt();
                //System.out.println("tipped : " + tippedDomino);
                graph.setTipped(tippedDomino);
            }
            System.out.println(graph.getTipped());
        }
    }
}

