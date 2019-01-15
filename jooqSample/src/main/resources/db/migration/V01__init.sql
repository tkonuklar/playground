CREATE TABLE authors (
id INT PRIMARY KEY NOT NULL,
first_name VARCHAR(50),
last_name VARCHAR(50) NOT NULL
);

CREATE TABLE books (
id INT PRIMARY KEY NOT NULL,
title VARCHAR(100)
);

CREATE TABLE authorBook (
author_id INT NOT NULL,
book_id INT NOT NULL,
PRIMARY KEY (author_id,book_id),
CONSTRAINT fk_ab_author FOREIGN KEY (author_id) REFERENCES authors (id) ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT fk_ab_books FOREIGN KEY (book_id) REFERENCES books (id)
);