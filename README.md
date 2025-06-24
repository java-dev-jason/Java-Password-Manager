# 🔐 Java Password Manager

A secure, console-based password manager written in Java.  
It uses **MySQL** to store encrypted passwords, **SHA-256** for login authentication, and **AES-256 encryption** to protect stored data.

---

## ✨ Features

- 🔑 Set and verify a master password (hashed with SHA-256)
- 🧠 Store passwords encrypted with AES-256
- 📄 View stored passwords (after decryption)
- ➕ Add and delete password entries
- 🗂 Passwords stored in MySQL
- 🔒 Encryption key saved locally (for learning/demo purposes)

---

## 📦 Technologies

- Java 17+
- MySQL
- SHA-256 (`MessageDigest`)
- AES-256 (`javax.crypto`)
- JDBC for MySQL interaction

---

## 🔐 Notes on Security

- This project encrypts all stored passwords using AES-256.
- The encryption key is saved in a local text file (src/Key.txt) for demo purposes.
- The login password is hashed using SHA-256 and stored in the database.
- ⚠️ This is not production-ready. For real applications:
   - Never store the key locally in plain text
   - Use key management systems
   - Use environment variables for credentials

---

## 🙋‍♂️ About

Built by Jason Belzek as a learning project to explore encryption, Java security, and database interaction.
Feel free to fork it, improve it, or use it as inspiration for your own security-based projects!

---

## 🚀 Getting Started

1. Clone the repository
2. Set up a MySQL database named `passmanager`
   - Table `login` (column: `password`)
   - Table `passwords` (columns: `idPassword`, `password`)
3. Set your MySQL credentials inside the `MYSQL` class
4. Compile and run:

```bash
javac Main.java
java Main
