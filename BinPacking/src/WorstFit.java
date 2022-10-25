import java.io.File;
import java.util.*;

public class WorstFit {
    private static Queue<Disk> discQueue = new PriorityQueue<Disk>();
    private static int discID;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("File?"); //prompt for filename
        File file = new File(console.nextLine().trim()); //create file object
        Scanner fileReader = null; //define file reading scanner

        try {
            fileReader = new Scanner(file); //create filereader
            double sum = 0;
            ArrayList<Integer> allFiles = new ArrayList<>();
            while (fileReader.hasNextInt()) {
                int readNum = fileReader.nextInt();
                allFiles.add(readNum);
                sum += readNum;
                Collections.sort(allFiles, Collections.reverseOrder());
                for (int i = 0; i < allFiles.size(); i++) {
                    worstFit(100);
                }
            }
        }

        catch (Exception exception) {
            System.out.println("404 : File Not Found");
        }
    }

    private static void worstFit(int totalFiles) {
        if (discQueue.size() == 0) {
            discQueue.add(new Disk(discID, totalFiles));
            discID++;
        } else if (discQueue.peek().getVacantSpace() < totalFiles) {
            Disk temp = discQueue.poll();
            worstFit(totalFiles);
            discQueue.add(temp);
        } else {
            discQueue.peek().add(totalFiles);
            discQueue.add(discQueue.poll());
        } }
}