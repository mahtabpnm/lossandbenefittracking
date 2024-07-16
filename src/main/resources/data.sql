--Sample Users

INSERT INTO users (id, username, password, email, first_name, last_name) VALUES
(1, 'john_doe', 'password1', 'john.doe@example.com', 'John', 'Doe'),
(2, 'jane_doe', 'password2', 'jane.doe@example.com', 'Jane', 'Doe');

INSERT INTO categories (id, name) VALUES
(1, 'Food'),
(2, 'Transport'),
(3, 'Entertainment');

INSERT INTO transactions (id, user_id, category, amount, date, is_benefit) VALUES
(1, 1, 'Food', -50.0, '2024-06-01T10:00:00', false),
(2, 1, 'Transport', -20.0, '2024-06-02T12:00:00', false),
(3, 1, 'Entertainment', 100.0, '2024-06-03T18:00:00', true),
(4, 2, 'Food', -30.0, '2024-06-01T10:00:00', false),
(5, 2, 'Transport', -10.0, '2024-06-02T12:00:00', false),
(6, 2, 'Entertainment', 200.0, '2024-06-03T18:00:00', true);