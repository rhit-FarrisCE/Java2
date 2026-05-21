package Exercize_8.Problem_1;
import java.math.BigInteger;
import java.util.Date;


// The implementation of CheckCollatz.check() will be extremely slow
// if we try very large values for n.
// It is actually easy to share the computation on multiple threads,
// by spawning as many threads as cores and running the checks
// for an interval [lower, upper] on 1 core.
//
public class CheckCollatzMT {

  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Usage:");
      System.out.println("java CheckCollatzMT n num_threads");
      System.out.println("where positive integers i: 1<= i <= n will be checked");
      System.out.println("and num_threads is the number of threads to use");
      System.exit(1);
    }

    // Spawn num_threads,
    // each of them will verify the conjecture for i in [lower, upper]
    // where lower and upper are determined such that each thread has
    // approximately the same amount of work to perform.
    //
    long start_time = new Date().getTime();
    BigInteger n = new BigInteger(args[0]);
    int num_threads = Integer.parseInt(args[1]);
    int nPerThread = n.intValue() / num_threads;

    Thread[] threads = new Thread[num_threads];

    for (int i = 0; i < num_threads; i++) {
      final int lower = i * nPerThread + 1;
      final int upper = (i == num_threads - 1) ? n.intValue() : (i + 1) * nPerThread;

      threads[i] = new Thread(new Runnable() {
        public void run() {
            for (int j = lower; j <= upper; j++) {
                if (!Collatz.checkCollatz(new BigInteger(String.valueOf(j)))) {
                    System.out.println("The conjecture is not valid");
                    System.exit(1);
                }
            }
        }
      });
      threads[i].start();
    }
    for (Thread t : threads) {
      try {
        t.join();
      } catch (InterruptedException e) {
        System.err.println("Thread interrupted");
        System.exit(1);
      }
    }
    long end_time = new Date().getTime();
    System.out.println("Ellapsed time: " + (end_time-start_time) + "ms");
    System.out.println("The conjecture seems valid up to n="+args[0]);
  }
}
