# Synchronizing a printing queue using a semaphore

![Java](https://img.shields.io/badge/Java-8%2B-orange?logo=openjdk)

This Java program demonstrates how a semaphore controls access to a shared printer. It creates print job threads, each representing a job and requesting access to the printer. A job holds the semaphore while printing is simulated for one second, then releases it so another waiting job can proceed. The printing queue is controlled by an instance of the [`Semaphore`](https://docs.oracle.com/en/java/javase/26/docs/api/java.base/java/util/concurrent/Semaphore.html) class available in the [`java.util.concurrent` package](https://docs.oracle.com/en/java/javase/26/docs/api/java.base/java/util/concurrent/package-summary.html).

The semaphore starts with one permit, allowing one job into the printing section at a time, and other threads wait until the current job releases the permit. The semaphore does not guarantee which waiting thread goes next, so the print order can vary between runs.

This project is part of the **Concurrent Programming** module at the [Federal University of Rio Grande do Norte (UFRN)](https://www.ufrn.br), Natal, Brazil.

## Repository Structure

```
printingqueue-semaphore 
├─── doc                     # Directory with HTML pages resulting from the generated Javadoc
└─── src                     # Directory with source code files
     └─── Job.java           # Implementation of a printing job as a thread
     └─── Main.java          # Main class
     └─── PrintingQueue.java # Simulation of a shared printing queue controlled by a semaphore
```

## Prerequisites

- Java Development Kit (JDK) 8 or newer
- A terminal or IDE

The program uses Java's standard library, so it requires no additional dependencies. 

## Contributing

Contributions are welcome! Fork this repository and submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
