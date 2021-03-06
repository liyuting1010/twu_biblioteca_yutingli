DROP TABLE IF EXISTS books;

CREATE TABLE IF NOT EXISTS books
(
  id     SERIAL PRIMARY KEY,
  name   VARCHAR(250) NOT NULL,
  author VARCHAR(250),
  publication_year INTEGER,
  count  INTEGER NOT NULL CHECK ( count >= 0 )
);

INSERT INTO books(name, author, publication_year, count)
VALUES
('Glimpses of World History', 'Jawaharlal Nehru', 1992, 4),
('Prison Diary', 'Jay Prakash Narayan', 1897, 1),
('Why Socialism', 'Jayaprakash Narayan', 2000, 0);

DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users
(
  id       SERIAL PRIMARY KEY,
  username VARCHAR(250) UNIQUE NOT NULL,
  password VARCHAR(250)
);

INSERT INTO users(username, password)
VALUES ('Yuting1', 'password1'),
       ('Yuting2', 'password2'),
       ('Yuting3', 'password3');


DROP TABLE IF EXISTS borrow_records;

CREATE TABLE IF NOT EXISTS borrow_records
(
  id          SERIAL PRIMARY KEY,
  uid         INTEGER NOT NULL,
  bid         INTEGER NOT NULL,
  borrow_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  return_date TIMESTAMP
);

INSERT INTO borrow_records(uid, bid, borrow_date, return_date)
VALUES (2, 1, now(), NULL),
       (3, 2, '2020-01-26 18:00:00', now()),
       (2, 2, '2020-01-16 07:43:00', NULL);
