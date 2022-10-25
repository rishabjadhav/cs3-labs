import java.util.Arrays;
import java.util.List;

public class RecursionProbs {
    public static void main(String[]args) {
        RecursionProbs r = new RecursionProbs();

        System.out.println();
        r.printBinary(4);
        System.out.println();
        r.climbStairs(4);
        System.out.println();
        r.campsite(2, 1);
        System.out.println();
        System.out.println(r.getMax(Arrays.asList(7, 30, 8, 22, 6, 1, 14), 19));


    }

    ////////////////////////////////////////////////////////////////////////

    public void printBinary(int digits) {
        System.out.print("printBinary(" + digits + ") >>> ");
        printBinaryHelper(digits, "");
    }

    public void printBinaryHelper(int digits, String soFar) {
        if (soFar.length() == digits) {
            System.out.print(soFar + " ");
        }
        else {
            printBinaryHelper(digits, soFar + 0);
            printBinaryHelper(digits, soFar + 1);
        }
        return;
    }

    public void climbStairs(int steps) {
        System.out.println();
        System.out.println("climbStairs(" + steps + ")");
        climbStairsHelper(steps, "");
    }

    public void climbStairsHelper(int steps, String str) {
        if (steps <= 0) {
            System.out.println(str.substring(0, str.length() - 2));
        }
        else {
            climbStairsHelper(steps - 1, str + "1, ");
            if (steps > 1) {
                climbStairsHelper(steps - 2, str + "2, ");
            }
        }
        return;
    }

    public void campsite (int x, int y) {
        System.out.println();
        System.out.println("campsite(" + x + ", " + y + ")");
        campsiteHelper(x, y, 0, 0, "");
    }

    public void campsiteHelper(int x, int y, int myX, int myY, String str) {
        if ((x == myX) && (y == myY)) {
            System.out.println(str.substring(0, str.length() - 2));
        }
        else {
            if (myX < x) {
                campsiteHelper(x, y, myX + 1, myY, str + "E, ");
            }
            if (myY < y) {
                campsiteHelper(x, y, myX, myY + 1, str + "N, ");
            }

            if ((myX < x) && (myY < y)) {
                campsiteHelper(x, y, myX + 1, myY + 1, str + "NE, ");
            }
        }
    }

    public int getMax(List<Integer> nums, int limit) {
        return getMax(nums,limit,0,0);
    }

    public int getMax(List<Integer> nums, int limit, int increment, int sum) {
        if (sum > limit) {
            return 0;
        }

        if (increment >= nums.size()) {
            return sum;
        }

        int addedSum = getMax(nums, limit,  increment+1, sum + nums.get(increment));
        int originalSum = getMax(nums, limit, increment+1, sum);

        return addedSum>originalSum?addedSum:originalSum;
    }


}
