import java.util.Stack;

public class Runner {
    public static void main(String[]args) {
        RecursionProbs r = new RecursionProbs();
        System.out.println(r.sumReciprocal(10));
        System.out.println(r.productOfEvens(4));
        System.out.println(r.conversion(1453, 8));
        System.out.println(r.matchingDigits(298892, 7892));
        //Stack<Integer> s = new Stack<>();
        //s.push(1);s.push(2);s.push(3);s.push(4);s.push(5);
        //r.doubleUp(s);
        r.printThis(8);
        r.printNums2(8);
    }


}
