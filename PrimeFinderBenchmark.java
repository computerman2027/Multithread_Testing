import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class PrimeFinderBenchmark {
    // private static final int RANGE = 90000000;  // Large range for benchmarking
    static int RANGE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter range : ");
        RANGE=sc.nextInt();

        int availableCores = Runtime.getRuntime().availableProcessors();

        int optimalThreads = availableCores;
        long optimalTime = Long.MAX_VALUE;

        System.out.println("Available Cores: " + availableCores);

        // Test with different thread counts
        for (int threads = 1; threads <= availableCores * 2; threads++) {
            long timeTaken = findPrimesWithThreads(threads);

            System.out.println("Threads: " + threads + ", Time Taken: " + timeTaken + " ms");

            if (timeTaken < optimalTime) {
                optimalTime = timeTaken;
                optimalThreads = threads;
            }
        }

        System.out.println("Optimal number of threads: " + optimalThreads);
        System.out.println("Time taken with optimal threads: " + optimalTime + " ms");
    }

    private static long findPrimesWithThreads(int numberOfThreads) {
        List<Integer> primeNumbers = new ArrayList<>();
        int segmentSize = RANGE / numberOfThreads;

        List<Thread> threads = new ArrayList<>();
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < numberOfThreads; i++) {
            int start = i * segmentSize + 1;
            int end = (i == numberOfThreads - 1) ? RANGE : (i + 1) * segmentSize;

            Thread thread = new Thread(() -> {
                for (int number = start; number <= end; number++) {
                    if (isPrime(number)) {
                        synchronized (primeNumbers) {
                            primeNumbers.add(number);
                        }
                    }
                }
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number == 2 || number == 3) return true;
        if (number % 2 == 0 || number % 3 == 0) return false;
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) return false;
        }
        return true;
    }
}
