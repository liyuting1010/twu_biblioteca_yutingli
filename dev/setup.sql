CREATE TABLE books
(
  id     SERIAL PRIMARY KEY,
  name   VARCHAR(250) NOT NULL,
  author VARCHAR(250),
  count  INTEGER NOT NULL CHECK ( count >= 0 )
);

INSERT INTO books(name, author, count)
VALUES
('Glimpses of World History', 'Jawaharlal Nehru', 4),
('Prison Diary', 'Jay Prakash Narayan', 1),
('Why Socialism', 'Jayaprakash Narayan', 0);
