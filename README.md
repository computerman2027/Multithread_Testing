
# PrimeFinderBenchmark

PrimeFinderBenchmark is a Java-based multithreaded program that benchmarks the optimal number of threads for finding all prime numbers within a specified range. This tool helps in understanding the best number of threads to utilize for maximizing performance on a given system when working with CPU-intensive tasks.

## Features

- Calculates all prime numbers up to a user-defined range.
- Benchmarks different thread counts to determine the optimal number of threads for the task.
- Utilizes multithreading to improve performance by dividing the range into segments for each thread.
- Automatically detects the available cores and tests up to double that amount for optimal thread count.

## Requirements

- **Java 8** or above.
- **Maven** (optional, if you want to manage dependencies or create a runnable JAR file).

## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/computerman2027/Multithread_Testing.git
   cd PrimeFinderBenchmark
   ```

2. Compile the Java program:
   ```bash
   javac PrimeFinderBenchmark.java
   ```

3. Run the program:
   ```bash
   java PrimeFinderBenchmark
   ```

## Usage

When you run the program, you will be prompted to enter a range for finding prime numbers. The program will then test multiple thread counts to determine the optimal configuration for your system.

### Example Run

```plaintext
Enter range: 90000000
Available Cores: 16
Threads: 1, Time Taken: 17561 ms
Threads: 2, Time Taken: 12676 ms
...
Threads: 30, Time Taken: 2391 ms
Optimal number of threads: 30
Time taken with optimal threads: 2391 ms
```

### Explanation of Output

- **Available Cores**: Shows the number of logical processors available on your system.
- **Threads**: The number of threads used for the calculation.
- **Time Taken**: The time (in milliseconds) taken to find all prime numbers up to the specified range with the given number of threads.
- **Optimal number of threads**: The number of threads that yielded the shortest execution time.
- **Time taken with optimal threads**: The execution time with the optimal thread count.

## Code Overview

- `main` method: Prompts the user for the range and benchmarks each thread count to find the optimal setting.
- `findPrimesWithThreads`: Divides the range into segments, assigns each segment to a thread, and calculates primes within that segment.
- `isPrime`: Helper function that checks if a number is prime, optimized for efficiency.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contributions

Contributions are welcome! Feel free to open issues or submit pull requests for improvements or new features.

---

Happy Coding!
