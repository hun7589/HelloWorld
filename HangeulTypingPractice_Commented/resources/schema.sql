
CREATE DATABASE IF NOT EXISTS typing_db;
USE typing_db;

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS texts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    level ENUM('초급', '중급', '고급'),
    language VARCHAR(20),
    content TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS results (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    text_id INT,
    speed DOUBLE,
    accuracy DOUBLE,
    played_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (text_id) REFERENCES texts(id)
);
