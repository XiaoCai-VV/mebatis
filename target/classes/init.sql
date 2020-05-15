CREATE TABLE blog(
 bid BIGINT NOT NULL AUTO_INCREMENT,
 name VARCHAR(50),
 author_id BIGINT,
 PRIMARY KEY(bid)
);

INSERT INTO blog(NAME, author_id) VALUES('测试文章标题', 2);
