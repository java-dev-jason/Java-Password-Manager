# 🔐 Java Password Manager

A simple console-based password manager built in Java using MySQL.

This project features:
- A login system (with hashed passwords)
- Add / view / delete stored passwords
- MySQL database for data persistence

---

## ⚙️ Technologies Used

- Java 17+
- MySQL (local DB)
- SHA-256 hashing (login)
- JDBC for database communication

---

## 🚀 Features

- 🔒 Login with password (stored securely via SHA-256)
- ➕ Add new passwords
- 👀 View all saved passwords with IDs
- ❌ Delete passwords by ID

⚠️ **Note:** Passwords are currently stored in plain text in the database. AES encryption is planned for a future version.

---

## 📦 How to Run

1. Set up a local MySQL database named `passmanager`  
2. Add two tables:

```sql
CREATE TABLE login (
    idLogin INT AUTO_INCREMENT PRIMARY KEY,
    password VARCHAR(255)
);

CREATE TABLE passwords (
    idPassword INT AUTO_INCREMENT PRIMARY KEY,
    password VARCHAR(255)
);
