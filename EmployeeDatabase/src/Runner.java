
import java.io.*;
import java.util.*;

public class Runner {
    public static void main(String[]args) {
        EmployeeDatabase ed = new EmployeeDatabase(50000);

        try {
            File file = new File("Large Data Set.txt");
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                int ID = fileReader.nextInt();
                String fullName = fileReader.next() + " " + fileReader.next();
                Employee emp = new Employee(fullName);
                ed.put(ID, emp);
            }
            fileReader.close();
        }

        catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}