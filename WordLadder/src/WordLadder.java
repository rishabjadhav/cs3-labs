import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordLadder {

    Queue<Stack<String>> queue;
    Set<String> dict;
    String startWord;
    String finalWord;
    ArrayList<String> usedWords;

    public void process() {
        try {
            File input = new File("input.txt");
            Scanner inputScanner = new Scanner(input);
            dict = readDict();

            Long startTime = System.currentTimeMillis();
            while (inputScanner.hasNextLine()) {
                usedWords = new ArrayList<String>();
                queue = new LinkedList<>();

                startWord = inputScanner.next().toUpperCase(); //get the starting word
                finalWord = inputScanner.next().toUpperCase(); //get the final word

                //dict = readDict(startWord);

                //System.out.println("Finding ladder for // " + startWord + " and " + finalWord);

                if (startWord.equals(finalWord)) {
                    System.out.print("Found a ladder! >>>");
                    System.out.println(" [" + startWord + "]");
                    continue;
                }
                if (startWord.length() != finalWord.length()) {
                    System.out.println("No ladder between " + startWord + " and " + finalWord);
                    continue;
                }
                if (!dict.contains(startWord)) {
                    System.out.println("No ladder between " + startWord + " and " + finalWord);
                    continue;
                }
                if (smartFindWords(finalWord).isEmpty()) {
                    System.out.println("No ladder between " + startWord + " and " + finalWord);
                    continue;
                }

                usedWords = new ArrayList<String>();
                usedWords.add(startWord);

                ArrayList<String> list = smartFindWords(startWord);
                //ArrayList<String> list = findWords(startWord);

                for (int i = 0; i < list.size(); i++) {
                    Stack<String> s = new Stack<>();
                    s.push(startWord);
                    s.push(list.get(i));
                    queue.offer(s);
                    //System.out.println(s);
                }
                iterateQueue();
            }
            inputScanner.close();
            System.out.println("Total time taken : [" + (System.currentTimeMillis() - startTime) + " ms]");
        }

        catch (FileNotFoundException e) {
            System.out.println("Error 404 : File Not Found");
            e.printStackTrace();
        }

    }

    public Set<String> readDict() {
        Set<String> set = new HashSet<String>();

        try {
            File dictionary = new File("dictionary.txt");
            Scanner dictScanner = new Scanner(dictionary);
            while (dictScanner.hasNext()) {
                String word = dictScanner.next();
                set.add(word);
            }

            dictScanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error 404 : File Not Found");
            e.printStackTrace();
        }
        return set;
    }
    public Set<String> readDict(String str) {
        Set<String> set = new HashSet<String>();

        try {
            File dictionary = new File("dictionary.txt");
            Scanner dictScanner = new Scanner(dictionary);
            while (dictScanner.hasNext()) {
                String word = dictScanner.next();
                if (str.length() == word.length()) {
                    set.add(word);
                }
            }

            dictScanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error 404 : File Not Found");
            e.printStackTrace();
        }
        return set;
    }


    public ArrayList<String> findWords(String word) {

        ArrayList<String> list = new ArrayList<String>();

        for (String dictWord : dict) {
            if (dictWord.length() != word.length()) {
                continue;
            }
            else {
                boolean allowed = true;

                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) != dictWord.charAt(i)) {
                        if (!allowed) {
                            break;
                        } else {
                            allowed = false;
                        }
                    }
                    if ((i == word.length() - 1) && (!allowed)) {
                        if (!usedWords.contains(dictWord)) {
                            list.add(dictWord);
                        }
                    }
                }
            }
        }
        usedWords.addAll(list);
        return list;
    }

    public ArrayList<String> smartFindWords(String word) {
        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < word.length(); i++) {
            for (char ch = 'A'; ch <= 'Z'; ch++) {
                char[] wordArray = word.toCharArray();
                wordArray[i] = ch;
                String newWord = new String(wordArray);

                if (dict.contains(newWord)) {
                    if (!usedWords.contains(newWord)) {
                        if (!word.equals(newWord)) {
                            list.add(newWord);
                        }
                    }
                }
            }
        }
        usedWords.addAll(list);
        return list;
    }

    public boolean iterateQueue() {
        int size = queue.size();

        while (true) {
            Stack<String> s = queue.poll();

            if (hasFinalWord(s)) {
                return true;
            }

            ArrayList<String> list = smartFindWords(s.peek());
            //ArrayList<String> list = findWords(s.peek());

            for (int j = 0; j < list.size(); j++) {
                Stack<String> n = (Stack<String>) s.clone();
                n.push(list.get(j));
                queue.offer(n);
                //System.out.println(n);
                if (hasFinalWord(n)) {
                    return true;
                }
            }
            size = queue.size();
            if (size == 0) {
                System.out.println("No ladder found between " + startWord + " and " + finalWord);
                return false;
            }
        }
    }

    public boolean hasFinalWord(Stack s) {
        if (s.peek().equals(finalWord)) {
            System.out.println("Found a ladder! >>> " + s);
            return true;
        }
        return false;
    }
}
