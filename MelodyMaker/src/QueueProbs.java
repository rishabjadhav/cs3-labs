import java.util.LinkedList;
import java.util.Queue;

public class QueueProbs {
    public QueueProbs() {

    }

    public Queue<Integer> evenFirst(Queue<Integer> nums) {
        int size = nums.size();
        Queue<Integer> returned = new LinkedList<Integer>();
        Queue<Integer> odds = new LinkedList<Integer>();

        for (int i = 0; i < size; i++) {
            int selected = nums.poll();

            if (selected % 2 != 0) {
                odds.offer(selected);
            } else {
                returned.offer(selected);
            }
        }
        for (int i = 0; i < odds.size(); i++) {
            returned.offer(odds.poll());
        }

        return returned;
    }

    public Queue<Integer> sieveOfEratosthenes(int n) {
        Queue<Integer> sieve = new LinkedList<Integer>();
        Queue<Integer> primes = new LinkedList<Integer>();

        for (int i = 2; i < n; i++) { //populates the queue with 2-n
            sieve.offer(i);
        }

        while (!sieve.isEmpty()) {
            int primeNum = sieve.poll(); //c = 2
            primes.offer(primeNum); //adds 2

            int size = sieve.size();
            for (int i = 0; i < size; i++) { //iterate through all elements of sieve to check which ones to add to primes
                int nextNum = sieve.poll();

                if (nextNum % primeNum != 0) {
                    sieve.offer(nextNum);
                }
            }
        }
        return primes;
    }
}
