import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // create an executor
        ExecutorService executor = Executors.newSingleThreadExecutor();

        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            // submit tasks to your executor
            PrimeLogger prime = new PrimeLogger(num);
            if (num != 0){
                prime.run();
             } else {break;}
            }
        executor.shutdown();
}
}

class PrimeLogger implements Runnable {
    private final int num;

    public PrimeLogger(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        // print num if it is prime
        //int num = 29;
        boolean flag = false;
        for (int i = 2; i <= num / 2; ++i) {
            // condition for nonprime number
            if (num % i == 0) {
                flag = true;
                break;
            }
        }

        if (!flag)
            System.out.println(num + " is a prime number.");
        else
            System.out.println(num + " is not a prime number.");
    }
    }
