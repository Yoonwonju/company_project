SELECT TITLE_NO, TITLE_NAME FROM TITLE;
SELECT MAX(TITLE_NO)+1 FROM TITLE;
INSERT INTO TITLE(TITLE_NO, TITLE_NAME) VALUES (6, '계약직');
UPDATE TITLE SET TITLE_NAME = '정규직' WHERE TITLE_NO = 6;
DELETE FROM TITLE WHERE TITLE_NO=6;

SELECT DEPT_NO,DEPT_NAME,FLOOR FROM DEPARTMENT;