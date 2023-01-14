CREATE DATABASE Dice;

USE Dice;

DROP TABLE user;
CREATE TABLE user
(
    id BIGINT(20) PRIMARY KEY auto_increment,
    username varchar(64) UNIQUE
);

DROP TABLE dice_history;
CREATE TABLE dice_history
(
    left_username VARCHAR(64),
    left_sum INT,
    right_username VARCHAR(64),
    right_sum INT,
    winner VARCHAR(64),
    time datetime DEFAULT NOW()
);

DELETE FROM dice_history where left_sum <> 100; -- 删除全表。这条语句中的条件无意义，只是为了让解释器认为语句安全
DELETE FROM user where id <> -1; -- 删除全表。这条语句中的条件无意义，只是为了让解释器认为语句安全
INSERT INTO user VALUES
(null, 'admin'),
(null, 'user');
commit;
