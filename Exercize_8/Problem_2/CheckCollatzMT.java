package Exercize_8.Problem_2;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class CheckCollatzMT {
    private static final AtomicInteger passCount = new AtomicInteger(0);
    private static final AtomicInteger failCount = new AtomicInteger(0);
    private static final AtomicLong totalSteps = new AtomicLong(0);

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java CheckCollatzMT <n> <numThreads>");
            System.out.println("  n: BigInteger upper limit (1 to n will be tested)");
            System.out.println("  numThreads: number of threads to use");
            System.exit(1);
        }

        BigInteger n;
        int numThreads;

        try {
            n = new BigInteger(args[0]);
            numThreads = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("Invalid input: " + e.getMessage());
            System.exit(1);
            return;
        }

        if (numThreads <= 0) {
            System.err.println("Number of threads must be positive");
            System.exit(1);
        }

        long startTime = System.currentTimeMillis();

        // Create array to hold thread references
        Thread[] threads = new Thread[numThreads];
        
        // Divide work evenly across threads
        BigInteger itemsPerThread = n.divide(BigInteger.valueOf(numThreads));

        // Create and start separate threads
        for (int i = 0; i < numThreads; i++) {
            BigInteger start = itemsPerThread.multiply(BigInteger.valueOf(i)).add(BigInteger.ONE);
            BigInteger end;

            if (i == numThreads - 1) {
                // Last thread gets the remainder
                end = n;
            } else {
                end = itemsPerThread.multiply(BigInteger.valueOf(i + 1));
            }

            CollatzWorker worker = new CollatzWorker(start, end, i);
            threads[i] = new Thread(worker, "CollatzThread-" + i);
            threads[i].start();
        }

        // Wait for all threads to complete
        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.err.println("Thread interrupted: " + e.getMessage());
            }
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        // Display results
        System.out.println("========== Collatz Conjecture Multi-Threaded Test ==========");
        System.out.println("Range: 1 to " + n);
        System.out.println("Number of threads: " + numThreads);
        System.out.println("Passed: " + passCount.get());
        System.out.println("Failed: " + failCount.get());
        System.out.println("Total steps: " + totalSteps.get());
        System.out.println("Elapsed time: " + elapsedTime + " ms");
        System.out.println("============================================================");
    }

    /**
     * Worker class that tests Collatz conjecture for a range of numbers
     */
    static class CollatzWorker implements Runnable {
        private BigInteger start;
        private BigInteger end;
        private int threadId;

        public CollatzWorker(BigInteger start, BigInteger end, int threadId) {
            this.start = start;
            this.end = end;
            this.threadId = threadId;
        }

        @Override
        public void run() {
            System.out.println("Thread " + threadId + " started: processing " + start + " to " + end);
            for (BigInteger num = start; num.compareTo(end) <= 0; num = num.add(BigInteger.ONE)) {
                long steps = testCollatz(num);
                if (steps >= 0) {
                    passCount.incrementAndGet();
                    totalSteps.addAndGet(steps);
                } else {
                    failCount.incrementAndGet();
                }
            }
            System.out.println("Thread " + threadId + " completed!");
        }

        /**
         * Test the Collatz conjecture for a given number
         * Returns the number of steps if it reaches 1 (passes)
         * Returns -1 if it doesn't reach 1 (fails)
         */
        private long testCollatz(BigInteger n) {
            long steps = 0;
            BigInteger current = n;

            while (!current.equals(BigInteger.ONE)) {
                if (current.signum() <= 0) {
                    return -1; // Invalid number
                }

                steps++;
                if (steps > 10000000) {
                    // Safety limit to prevent infinite loops
                    return -1;
                }

                // If even: n = n / 2
                if (current.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                    current = current.divide(BigInteger.TWO);
                }
                // If odd: n = 3n + 1
                else {
                    current = current.multiply(BigInteger.valueOf(3)).add(BigInteger.ONE);
                }
            }

            return steps;
        }
    }
}
