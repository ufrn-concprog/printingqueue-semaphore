# Synchronizing a printing queue using a semaphore

![Java](https://img.shields.io/badge/Java-8%2B-orange?logo=openjdk)

This Java program demonstrates how a semaphore controls access to a shared printer. It creates print job threads, each representing a job and requesting access to the printer. A job holds the semaphore while printing is simulated for one second, then releases it so another waiting job can proceed.

The semaphore starts with one permit, allowing one job into the printing section at a time. Other threads wait until the current job releases the permit. The semaphore does not guarantee which waiting thread goes next, so the print order can vary between runs.

This project is part of the **Concurrent Programming** module at the [Federal University of Rio Grande do Norte (UFRN)](https://www.ufrn.br), Natal, Brazil.

## Repository Structure

```text
.
├── Job.java             # Representation of a print job
├── PrintingQueue.java   # Shared printing queue controlled by a semaphore
├── Main.java            # Main program
└── README.md
```

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or newer
- A terminal or IDE

The program uses Java's standard library, so no additional dependencies are required.

### Compilation

From the project root, compile the source files:

```bash
javac Job.java PrintingQueue.java Main.java
```

This creates the corresponding `.class` files in the project directory.

### Running

```bash
java Main
```

The program reports each job as it is sent to the printer and when printing completes. After all threads have joined, it prints `All printing jobs are finished`. The interleaving and order of job messages may differ between runs.

## Contributing

Contributions are welcome! Fork this repository and submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
