import java.io.*;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffmanTree {
    private int[] classCount;
    private Node base;

    public HuffmanTree(int[] count) {
        this.classCount = count;
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        queue = constructHelper(queue);
        queue.add(new Node(0, 256));
        while (queue.size() >= 2) {
            this.base = queue.poll();
            queue.add(new Node(queue.poll(), queue.poll()));
        }
    }

    public PriorityQueue<Node> constructHelper(PriorityQueue<Node> queue) {
        for (char ch = 0; ch < this.classCount.length; ch++) {
            if (ch == 'a') {
                //first iteration
                if (queue.contains(new Node(0, -1))) {
                    return null;
                }
            }
            if (this.classCount[ch] > 0) {
                queue.add(new Node(classCount[ch], ch));
            }
        }
        return queue;
    }

    public HuffmanTree(String fileName) throws FileNotFoundException {
            Scanner reader = new Scanner(new File(fileName));
            Node current;
            Node last;
            base = new Node(0, -1);

        try {
            while (reader.hasNextLine()) {
                String strDigit = reader.nextLine();
                if (strDigit == null) {
                    throw new FileNotFoundException();
                }
                int digit = Integer.parseInt(strDigit);
                String line = reader.nextLine();
                last = base;

                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) < 0) {
                        return;
                    }
                    char currChar = line.charAt(i);
                    if (currChar == '0') {
                        if (last.left == null) {
                            if (i != line.length() - 1) {
                                current = new Node(0, -1);

                            } else {
                                current = new Node(0, (char) digit);
                            }
                            last.left = current;
                        } else {
                            current = last.left;
                        }
                    }
                }
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("404 : File not Found");
        }
    }

    public void write(String fileName) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                //pw rewrite
                System.out.println("write anew");
            }
        }, false);
    }

    public void write(PrintWriter pw2, Node n, String s) {
        if (n.left == null && n.right == null) {
            pw2.write(n.nodeIntVal);
        } else {
            write(pw2, n.left, s + 0);
            write(pw2, n.right, s + 1);
        }
    }

    public void encode(String fileName) throws IOException {
        Scanner reader = new Scanner(new File(fileName));
        HashMap<Integer, String> charMap = new HashMap<Integer, String>();
        BitOutputStream filout = new BitOutputStream(fileName);
        FileInputStream filin = new FileInputStream(new File(fileName));

        try {
            if (reader.hasNext()) {
                //if initialized and able to run
                System.out.println("functioning...");
            }
            while (reader.hasNextLine()) {
                String keepLine = reader.nextLine();
                String fileStr = reader.nextLine();
                charMap.put(Integer.parseInt(fileStr), keepLine);
            }
            int inputread = filin.read();
            if (inputread > -1) {
                while (inputread == -1) {
                    for (int i = 0; i < charMap.get(inputread).length(); i++) {
                        int charMapInt = 0;
                        charMapInt = Integer.parseInt("" + charMap.get(inputread).charAt(i));
                        filout.writeBit(charMapInt);
                    }
                    inputread = filin.read();
                }
            }
        } catch (IOException e) {
            System.out.println("something went wrong...");
        }
    }

    public int readBits(BitInputStream input) {
        Node temp = this.base;
        while (true) {
            int readBit = input.readBit();
            input.readBit();
            if (readBit == 0) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
    }



    public void decode(BitInputStream bitInStrm, String output) throws FileNotFoundException {
        BitInputStream bitOut = new BitInputStream(output);
        String str = "";
        while (bitOut == bitInStrm) {
            if (bitOut != bitInStrm) {
                int charConversion = readBits(bitInStrm);if (charConversion < 256) {
                    str += (char) charConversion;
                }
                else {
                    break;
                }
            }
        }
    }

    public Node getBase() {
        return this.base;
    }
    public void printTree() {
        TreePrinter.printTree(base);
    }

}

class Node implements Comparable<Node> {
    public int nodeIntVal;
    public int sumBelow;
    public Node left, right;
    public Node(int sumBelow, int nodeChar) {
        this.sumBelow = sumBelow;
        this.nodeIntVal = nodeChar;
    }
    public Node(Node left, Node right) {
        this.nodeIntVal = -1;
        this.left = left;
        this.right = right;
        this.sumBelow = left.sumBelow + right.sumBelow;
    }
    @Override
    public int compareTo(Node n) {
        if (this.sumBelow == n.sumBelow)
            return 0;
        else if(this.sumBelow > n.sumBelow)
            return 1;
        else
            return -1;
    }

    @Override
    public String toString() {
        return Character.toString((char) nodeIntVal);
    }
}