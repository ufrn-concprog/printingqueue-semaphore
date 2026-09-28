# Synchronizing a printing queue using a semaphore

![Python](https://img.shields.io/badge/Python-3-green?logo=python)
![Build](https://img.shields.io/badge/build-manual-lightgrey)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

This Python program demonstrates how a semaphore controls access to a shared printer. It creates print job threads, each representing a job and requesting access to the printer. A job holds the semaphore while printing is simulated for one second, then releases it so another waiting job can proceed.

The semaphore starts with a count of one, allowing one job into the printing section at a time. Other threads wait until the current job releases it. The semaphore does not guarantee which waiting thread goes next, so the print order can vary between runs.

This project is part of the **Concurrent Programming** module at the [Federal University of Rio Grande do Norte (UFRN)](https://www.ufrn.br), Natal, Brazil.

## 📂 Repository Structure

```text
.
├── job.py             # Definition of the Job class
├── printingqueue.py   # Definition of the PrintingQueue class
├── main.py            # Main program
└── README.md
```

## 🚀 Getting Started

### ✅ Prerequisites

- Python 3
- A terminal or IDE

The program uses only Python's standard library, so no additional packages are required.

### ▶️ Running

From the project root, run:

```bash
python3 main.py
```

The program reports each job as it is sent to the printer and when printing completes. After all threads have joined, it prints `All printing jobs are finished`. The interleaving and order of job messages may differ between runs.

## 🤝 Contributing

Contributions are welcome! Fork this repository and submit a pull request 🚀

## 📜 License

This project is licensed under the [MIT License](LICENSE).
