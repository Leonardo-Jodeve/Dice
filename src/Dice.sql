CREATE DATABASE Dice;

USE Dice;

CREATE TABLE user
(
    id BIGINT(20) PRIMARY KEY auto_increment,
    username varchar(64) UNIQUE
);


CREATE TABLE dice_history
(
    left_username VARCHAR(64),
    left_sum INT,
    right_username VARCHAR(64),
    right_sum INT,
    winner VARCHAR(64),
    time datetime DEFAULT NOW()
);

INSERT INTO user VALUES
(null, 'admin'),
(null, 'user');
commit;
