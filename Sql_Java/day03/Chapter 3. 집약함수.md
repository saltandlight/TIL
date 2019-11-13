# Chapter 3. 집약함수

## 3-1. 테이블을 집약해서 검색한다.

테이블을 집합함수를 통해서 grouping함.

```
복수의 행을 하나로 모음!
-> 결과도 1개로 나옴.
```

- NULL을 제외하고 행 수를 계산한다.

  ```
  SELECT COUNT(COMM) AS CNT FROM EMP;
   결과가 4가 나옴!
  SELECT ROUND(AVG(NVL(COMM,0)),2) AS CNT FROM EMP;
  ```

  - COUNT(*)는 널이 있건 없건 관계 없다.

  ```
  SELECT MIN(SAL), MAX(SAL), SUM(SAL), ROUND( AVG(SAL),0) FROM EMP;
  ```

  - 날짜의 최댓값, 최솟값은 가능함.(연산은 안 된다.)

  ```
  SELECT MIN(HIREDATE) FROM EMP;
  ```

## 3-2. 테이블을 그룹으로 나눈다.

- GROUP BY 구

  항상 GROUP BY는 집약함수와 같이 쓴다.

```
SELECT JOB, SUM(SAL) FROM EMP
GROUP BY JOB;

SELECT JOB, SUM(SAL), MIN(SAL) FROM EMP
GROUP BY JOB;

SELECT DEPTNO, JOB, SUM(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO;

/*그룹함수 쓸 때는 조건을 HAVING 절에 쓴다. WHERE절에 쓰지 않음-- 기본 원칙*/
SELECT DEPTNO, JOB, SUM(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
HAVING DEPTNO IN (10,20)
ORDER BY DEPTNO;

SELECT DEPTNO, JOB, SUM(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
HAVING DEPTNO IN (10,20) AND JOB LIKE '%E%'
ORDER BY DEPTNO;

SELECT JOB, ROUND(AVG(SAL),2) 
FROM EMP
GROUP BY JOB
--우리 회사의 job별 sal의 평균을 구함.

SELECT JOB, ROUND(AVG(SAL),2) 
FROM EMP
WHERE DEPTNO IN(10, 30)
GROUP BY JOB


SELECT JOB, ROUND(AVG(SAL),2) 
FROM EMP
GROUP BY JOB
HAVING DEPTNO IN(10, 30)
--안 됨<- HAVING절 안에서는 GROUP BY  뒤이 아이를 써줘야 해서!!!!!!!
-- WHERE은 저런 용도로 써야 함!!!

SELECT DEPTNO, JOB, AVG(SAL)
FROM EMP
WHERE ENAME LIKE '%A%'
GROUP BY DEPTNO, JOB
HAVING DEPTNO IN (20,30) AND AVG(SAL) >= 2000
ORDER BY DEPTNO;
 
```

그룹핑 -> 그룹함수

그룹함수와 GROUP BY는 같이 쓰인다.(꼭!!!)

- GROUP BY 절에 별명을 쓰면 안 됨!(계산식도 한 번 더 써야 함!!!!)
- HAVING 절

 GROUP BY 에 있는 컬럼에 조건을 줄 때 !!!!

- WHERE 절에는 그룹함수가 올 수 없음.

- SELECT 문 실행 순서

  FROM -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY

# 5. 복잡한 질의

## 1. 뷰

테이블과 동일한 것.

실제 데이터를 저장하지는 않지만 복잡한 sql문을 매번 호출하는 것이 귀찮기 때문에 sql문의 결과를 뷰로 저장해서 사용하고 싶을 때 호출한다. 뷰는 데이터를 실질적으로 저장하지 않으므로 데이터가 갑자기 변동된다거나 하는 일은 없다.

```
CREATE VIEW EMPSALVIEW(ENAME, ANNSAL)
AS
SELECT ENAME, (SAL*12+ NVL(COMM, 0)*12) FROM EMP;
```

## 2. 서브쿼리

```
CREATE TABLE ITEM (
  ID VARCHAR2(10),
  NAME VARCHAR2(20),
  CATE NUMBER(10)
);

CREATE TABLE CATEGORY(
  NO NUMBER(10),
  NAME VARCHAR2(20)
);
ALTER TABLE ITEM ADD PRIMARY KEY(ID);
ALTER TABLE CATEGORY ADD PRIMARY KEY(NO);

INSERT INTO CATEGORY VALUES(100, '의류');
INSERT INTO CATEGORY VALUES(200, '잡화');
INSERT INTO CATEGORY VALUES(300, '소품');

ALTER TABLE ITEM ADD FOREIGN KEY (CATE)
REFERENCES CATEGORY (NO)

SELECT DEPTNO FROM DEPT
WHERE LOC = 'DALLAS'

SELECT EANME FROM EMP
WHERE DEPTNO = 20
--이 두 문장을 하나로 작성하는 것을 서브쿼리라고 함.

SELECT ENAME FROM EMP
WHERE DEPTNO =
(SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS')
```

서브쿼리는 테이블 간의 relation이 존재해야 함!!!

### 스칼라 서브쿼리

한 가지의 값을 가지고 동작을 시킨다.

단일 값임.

select, group by , having, order by 구 등 모든 곳에 쓸 수 있다.

- where절에 스칼라 서브쿼리를 씀.

```
SELECT ENAME FROM EMP
WHERE DEPTNO <
(SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS')

--SAL의 평균보다 많이 받는 사람들의 
--이름과 SAL을 출력하시오

SELECT ENAME, SAL 
FROM EMP
WHERE SAL > 
(SELECT AVG(SAL) FROM EMP )

SELECT ENAME, SAL 
FROM EMP
WHERE SAL > 
(SELECT AVG(SAL) FROM EMP )
AND (DEPTNO IN 
(SELECT DEPTNO FROM DEPT WHERE LOC IN ('DALLAS', 'CHICAGO'))
)

SELECT ENAME, SAL, (SELECT AVG(SAL) FROM EMP) 
FROM EMP
--한 로우 찍힐 떄마다 서브쿼리가 찍힌다면 이런 식으로는 가능하다!!! 와우!!


/*부서별 월급의 평균을 구하고자 한다.
이 중 전체 평균보다 높은 부서만 출력한다.
단,New York 부서만 제외한다.*/

SELECT DEPTNO, AVG(SAL) FROM EMP
GROUP BY DEPTNO
HAVING DEPTNO NOT IN (SELECT DEPTNO FROM DEPT WHERE LOC IN ('NEW YORK'))
AND AVG(SAL) > (SELECT AVG(SAL) FROM EMP)

--where 절의 IN에는 여러 개가 나와도 된다.
```

## 3. 상관 서브쿼리

```
SELECT DEPTNO, ENAME, SAL
FROM EMP e1
WHERE SAL >=
(SELECT MAX(SAL) 
FROM EMP e2
WHERE e1.DEPTNO=e2.DEPTNO
GROUP BY DEPTNO
)

/*부서별 월급을 가장 많이 받는 사람의
deptno, ename, sal을 조회하시오
부서명 accounting은 제외하시오.*/ 

SELECT DEPTNO, ENAME, SAL
FROM EMP e1
WHERE SAL >=
(SELECT MAX(SAL) 
FROM EMP e2
WHERE e1.DEPTNO=e2.DEPTNO
AND DEPTNO NOT IN 
  (SELECT DEPTNO FROM DEPT WHERE DNAME = 'ACCOUNTING')
GROUP BY DEPTNO
)

--오라클에서는 AS자를 뺴고 그냥 FROM에서 테이블 ALIAS를 시켜버린다...!!
--서브쿼리를 사용할 경우에는 IN을 서브쿼리 앞에 쓴다.

/*SCOTT이 소속된 부서 사람들의 
매니저들의 EMPNO, ENAME, DEPTNO를 조회하시오.*/
SELECT EMPNO, ENAME, DEPTNO 
FROM EMP e1
WHERE e1.EMPNO IN 
(SELECT MGR 
FROM EMP e2 
WHERE DEPTNO =(SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT')
AND e1.EMPNO=e2.MGR);
```

## 조인

```
/*EMP를 조회한다.
EMPNO, ENAME, DNAME, LOC조회*/

SELECT e.EMPNO, e.ENAME, d.DNAME, d.LOC
FROM EMP e, DEPT d
WHERE e.DEPTNO=d.DEPTNO

-- 조건을 걸 수 있는 것은 foreign key 와 primary key임~!!(조건을 거는 게 원칙)

SELECT d.LOC, ROUND(AVG(e.SAL),2) 
FROM EMP e, DEPT d
WHERE d.DEPTNO=e.DEPTNO
GROUP BY d.LOC

SELECT d.LOC, e.DEPTNO, e.ENAME, e.SAL 
FROM EMP e, DEPT d
WHERE e.DEPTNO= d.DEPTNO
AND d.LOC NOT IN ('DALLAS')
AND SAL > (
SELECT AVG(SAL) FROM EMP e2, DEPT d2 
WHERE e2.DEPTNO = d2.DEPTNO 
AND d.LOC=d2.LOC
GROUP BY d2.LOC)
--내가 속한 지역의 월급의 평균 -> 보다 많이 받는 나는 누구냐?
```