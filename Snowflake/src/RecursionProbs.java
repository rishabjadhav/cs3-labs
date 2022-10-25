import java.util.Stack;

public class RecursionProbs {

    public double sumReciprocal(int n) {
        if (n > 1) {
            return (double) 1/n + sumReciprocal(n - 1);
        } else {
            return 1;
        }

    }

    public int productOfEvens(int n) {
        if (n > 1) {
            return n * 2 * productOfEvens(n - 1);
        } else {
            return 2;
        }
    }

    public String conversion(int num, int base) {
        String s = "";
        if (num >= base) {
            s = s + num % base;
            return conversion((int) Math.floor(num / base), base) + s;
        } else {
            s = s + num;
            return s;
        }
    }

    public int matchingDigits(int a, int b) {
        if ((a == 0) || (b == 0)) {
            return 0;
        }

        if (a % 10 == b % 10) {
            a /= 10;
            b /= 10;
            return 1 + matchingDigits(a, b);
        }
        else {
            a /= 10;
            b /= 10;
            return matchingDigits(a, b);
        }
    }

    public void doubleUp(Stack<Integer> nums) {
        Stack<Integer> numsTwo = (Stack<Integer>) nums.clone();

        while (numsTwo.size() != nums.size() * 2) {
            numsTwo.push(nums.pop());
            numsTwo.push(numsTwo.peek());
            doubleUp(nums);
        }
        System.out.println(numsTwo);
    }

    public void printThis (int n) {
        String str = "";
        int asterick = 0;
        if (n % 2 == 0) {
            asterick = 2;
        } else {
            asterick = 1;
        }

        int walls = (n - asterick) / 2;
        int wallstwo = walls;
        while (walls > 0) {
            str += "<";
            walls--;
        }
        while (asterick > 0) {
            str += "*";
            asterick--;
        }
        while (wallstwo > 0) {
            str += ">";
            wallstwo--;
        }
        System.out.println(str);
    }

    public void printNums2 (int n) {
        String str = "";
        int ones = 0;
        if (n % 2 == 0) {
            ones = 2;
        } else {
            ones = 1;
        }

        int walls = (n - ones) / 2 + 1;
        int i = 2;
        int wallstwo = walls;
        while (walls > 1) {
            str += walls + " ";
            walls--;
        }
        while (ones > 0) {
            str += "1 ";
            ones--;
        }
        while (i <= wallstwo) {
            str += i + " ";
            i++;
        }
        System.out.println(str);
    }
}
