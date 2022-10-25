import java.util.*;

public class Disk implements Comparable<Disk>
{
    private int[] contents; //holds content of disk
    private int vacantSpace;
    private final int diskID;

    public Disk(int diskID) {
        //for empty disk
        this.diskID = diskID;
        this.vacantSpace = 1000000;
    }


    public Disk(int diskID, int remainSpace) {
        this.diskID = diskID;
        int totalNum = 0;

        for (int i = 0; i < this.contents.length; i++) {
            totalNum += contents[i];
        }
        this.vacantSpace = 1000000 - totalNum;
    }

    public void add (int file) {
        this.contents = Arrays.copyOf(contents, contents.length + 1);
        this.contents[contents.length - 1] = file;
        int totalNum = 0;

        for(int i = 0; i < this.contents.length; i++)
        {
            totalNum += contents[i];
        }
        this.vacantSpace = 1000000 - totalNum;
    }

    @Override
    public int compareTo(Disk disk) {
        return Integer.compare(disk.getVacantSpace(), this.vacantSpace);
    }
    @Override
    public String toString() {
        return Arrays.toString(this.contents);
    }
    public int getVacantSpace() {
        return this.vacantSpace;
    }
    public int getDiskID() {
        return this.diskID;
    }
}