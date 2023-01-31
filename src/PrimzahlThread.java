import java.util.*;

/**
 * this is the documentation of the class PrimzahlThread
 * to get the primaZahlen using implements Runnable
 * @author Yolla Hanna
 * @version 1.1
 * @see "C:\Users\Akademie\IdeaProjects\PrimaZahlen"
 */
public class PrimzahlThread implements Runnable {
    /**
     *
     */
    private final int from;
    private final int to;
    public TreeMap<Integer,Integer> list = new TreeMap<>() {
    };
    private int counter = 0;
    private int cou = 0;

    public PrimzahlThread(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public int getCounter() {
        return counter;
    }

    public int getCou() {
        return cou;
    }

    public boolean isPrime(int x) {
        if (x == 1) {
            return false;
        }
        int top = (int) Math.sqrt(x);
        for (int i = 2; i <= top; i++)
            if (x % i == 0)
                return false;
        return true;

    }
    int lastPrime = -1;
    @Override
    public void run() {
        int i;
        for (i = from; i < to; i++) {

            if (isPrime(i)) {
                counter++;
                if (i - lastPrime == 2) {
                    cou++;
                    list.put(lastPrime,i);
                    // list.add(i);
                }
                lastPrime = i;
            }
             // System.out.println(list);
            // System.out.println(counter);
        }
    }
}