CREATE TABLE TEST_BOARD (
	BNO NUMBER(10),
	TITLE VARCHAR2(2000) NOT NULL,
	CONTENT VARCHAR2(2000) NOT NULL,
	WRTIER VARCHAR2(100) NOT NULL,
	REGDATE DATE DEFAULT SYSDATE,
	CONSTRAINT PK_TEST_BOARD PRIMARY KEY(BNO)
);

