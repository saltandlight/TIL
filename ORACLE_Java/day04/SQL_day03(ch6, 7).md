# 상관쿼리와 JOIN 문제들

```
--내가 속한 각 부서별 월급 평균 이상으로 받는 직원들을 조회하시오.
부서<- 나의
SELECT ENAME,  SAL 
FROM EMP e1
WHERE SAL >= 
(SELECT AVG(SAL) FROM EMP e2 
WHERE e1.DEPTNO = e2.DEPTNO
GROUP BY DEPTNO)

-- 내가 속한 각 부서별 월급 가장 많이 받는 직원들을 조회하시오.

SELECT DEPTNO, ENAME,  SAL 
FROM EMP e1
WHERE SAL >= 
(SELECT MAX(SAL) FROM EMP e2 
WHERE e1.DEPTNO = e2.DEPTNO
GROUP BY DEPTNO)

--내가 속한 각 부서별 월급을 가장 많이 받는
직원들을 조회하시오 단 부서명과 지역을 출력하시오.

SELECT d1.DEPTNO, e1.ENAME, e1.SAL, d1.LOC
FROM EMP e1, DEPT d1
WHERE e1.DEPTNO = d1.DEPTNO
AND SAL >= 
(SELECT MAX(SAL) 
FROM EMP e2 
WHERE e2.DEPTNO=e1.DEPTNO 
GROUP BY e2.DEPTNO)
```

## 6-2. 술어

- EXISTS

  IN이나 NOT IN을 가지고도 충분히 확인할 수 있다.

  존재하나? 안 하나? 확인하는 기능

  상관쿼리를 반드시 써야 함.

```
-- DALLAS 에 있는 직원의 정보를 조회하시오.

SELECT  d1.DEPTNO, e1.ENAME, e1.SAL, d1.LOC
FROM EMP e1, DEPT d1
WHERE d1.LOC='DALLAS' AND e1.DEPTNO = d1.DEPTNO

-- EXISTS 뒤의 문장이 TRUE 일 떄만 수행됨!!!
SELECT d1.DEPTNO, e1.ENAME, e1.SAL, d1.LOC
FROM EMP e1, DEPT d1
WHERE e1.DEPTNO = d1.DEPTNO AND 
EXISTS
(SELECT d2.DEPTNO FROM DEPT d2, EMP e2
WHERE d2.DEPTNO = e2.DEPTNO 
AND LOC = 'DALLAS'
AND e1.DEPTNO = e2.DEPTNO );


-- JONES 가 속한 JOB의 직원을 조회하시오.
SELECT ENAME, JOB
FROM EMP e1
WHERE e1.JOB IN
(SELECT e2.JOB FROM EMP e2 WHERE ENAME='JONES' )


-- JONES 가 속한 JOB의 직원을 조회하시오.
SELECT ENAME, JOB
FROM EMP e1
WHERE e1.JOB IN
(SELECT e2.JOB FROM EMP e2 WHERE ENAME='JONES' )

SELECT ENAME, JOB
FROM EMP e1
WHERE EXISTS
(SELECT e2.JOB FROM EMP e2 
WHERE ENAME='JONES'
AND e1.JOB=e2.JOB )


--JONES 가 속한 JOB의 직원을 조회하시오.
--단 직원의 부서명과 지역을 출력하시오

SELECT d.DEPTNO, e.JOB, e.ENAME, d.LOC
FROM EMP e, DEPT d
WHERE e.DEPTNO = d.DEPTNO 
AND JOB IN (
SELECT JOB FROM EMP e2 WHERE ENAME = 'JONES')
```

# 7. 집합 연산
- **중요한 점: 컬럼 개수와 타입이 일치해야 함!**
## 7-1 테이블 덧셈과 뺄셈

- 테이블 덧셈----UNION

```
--MANAGER와 SALES 직원들의 이름과 JOB을 조회하시오.

SELECT ENAME, JOB FROM EMP
WHERE JOB = 'MANAGER'
UNION
SELECT ENAME, JOB FROM EMP
WHERE JOB = 'SALESMAN'

SELECT ENAME, JOB FROM EMP
WHERE JOB = 'MANAGER'
UNION
SELECT ENAME, TO_CHAR(HIREDATE, 'YYYY.MM.DD') FROM EMP
WHERE JOB = 'SALESMAN'
ORDER BY JOB
```

- ALL- 중복까지 다 나오게함.
- INTERSECT- 교집합
- EXCEPT- 뺴는 것, 여집합

## 7-2. 결합(테이블을 열 지향으로 연결한다.)

- Inner Join

```
-- 오라클 표준
SELECT e.ENAME, d.LOC FROM
EMP e, DEPT d
WHERE e.DEPTNO = d.DEPTNO

-- sql 표준
SELECT e.ENAME, d.LOC 
FROM EMP e INNER JOIN DEPT d
ON (e.DEPTNO = d.DEPTNO)

SELECT e.ENAME, d.LOC FROM
EMP e, DEPT d
WHERE e.DEPTNO = d.DEPTNO
AND e.JOB = 'MANAGER'
AND d.LOC LIKE '%CHICA%'


SELECT e.ENAME, d.LOC 
FROM EMP e INNER JOIN DEPT d
ON (e.DEPTNO = d.DEPTNO)
WHERE  e.JOB = 'MANAGER'
AND d.LOC LIKE '%CHICA%'

-- VIEW
CREATE VIEW T_EMP(ENO, ENM, SAL, DNO)
AS (
  SELECT EMPNO, ENAME, SAL, DEPTNO
  FROM EMP
)

CREATE VIEW T_DEPT(DNO, DNM, LOC)
AS (
   SELECT DEPTNO, DNAME, LOC FROM DEPT 
)

--T_SAL 직원 ENO, ASAL(연봉)

CREATE VIEW T_SAL (ENO, ASAL)
AS (
 SELECT EMPNO, (SAL*12)+(NVL(COMM,0)*12) FROM EMP
)

-- 직원 정보를 조회하시오. 
--ENO, ENM, SAL, ASAL, DNM, LOC

SELECT e.ENO, e.ENM, e.SAL, s.ASAL, d.DNM, d.LOC
FROM T_EMP e, T_DEPT d, T_SAL s
WHERE e.DNO = d.DNO AND s.ENO = e.ENO

SELECT e.ENO, e.ENM, e.SAL, s.ASAL, d.DNM, d.LOC
FROM T_EMP e INNER JOIN T_DEPT d ON (e.DNO = d.DNO)
INNER JOIN T_SAL s ON(s.ENO = e.ENO)

-- 직원 정보를 조회하시오. 
-- ENO, ENM, SAL, ASAL, DNM, LOC
-- JONES 부서원만 조회하시오.

SELECT e.ENO, e.ENM, e.SAL, s.ASAL, d.DNM, d.LOC
FROM T_EMP e, T_DEPT d, T_SAL s
WHERE e.DNO = d.DNO AND s.ENO = e.ENO
AND e.DNO IN (
SELECT DNO FROM T_EMP WHERE ENM = 'JONES')


-- 직원 정보를 조회하시오. 
-- ENO, ENM, SAL, ASAL, DNM, LOC
-- 부서별 연봉의 평균보다 많이 받는 직원 조회

SELECT e2.ENO, e2.ENM, e2.SAL, s2.ASAL, d2.DNM, d2.LOC
FROM T_EMP e2, T_SAL s2, T_DEPT d2
WHERE e2.DNO = d2.DNO
AND e2.ENO = s2.ENO
AND s2.ASAL > (
SELECT AVG(s1.ASAL) 
FROM T_EMP e1, T_SAL s1
WHERE  s1.ENO = e1.ENO
AND e2.DNO = e1.DNO
GROUP BY (e1.DNO)
)


SELECT e.ENAME, d.LOC FROM
EMP e INNER JOIN DEPT d
USING (DEPTNO)
--조인 시 USING이 더 편함!!

-- 직원의 정보를 출력하시오.
-- EMPNO, ENAME, MNAME(매니저의 이름) 을 출력하시오.
-- SELF-JOIN

SELECT e1.EMPNO AS EMPNO , 
       e1.ENAME AS ENAME,  
       e2. ENAME AS MNAME
FROM EMP e1, EMP e2
WHERE e1.MGR = e2.EMPNO
```

- Outer Join

```
SELECT e.ENAME, e.JOB, d.DNAME, d.LOC
FROM EMP e, DEPT d
WHERE e.DEPTNO = d.DEPTNO
-- 의 경우 부서가 없는 사원이 출력되지 않는다.

SELECT e.ENAME, e.JOB, d.DNAME, d.LOC
FROM EMP e, DEPT d
WHERE e.DEPTNO = d.DEPTNO(+)
--deptno가 없는 모든 emp가 출력됨
--+가 없는 쪽 기준

SELECT e.ENAME, e.JOB, d.DNAME, d.LOC
FROM EMP e LEFT OUTER JOIN DEPT d USING(DEPTNO)
-- EMP를 기준으로 하므로 EMP에 대한 모든 게 다 나옴

SELECT e.ENAME, e.JOB, d.DNAME, d.LOC
FROM EMP e RIGHT OUTER JOIN DEPT d USING(DEPTNO)

SELECT e.ENAME, e.JOB, d.DNAME, d.LOC
FROM EMP e FULL OUTER JOIN DEPT d USING(DEPTNO)
```

# 8. SQL 고급 처리

## 8-1. 윈도우 함수

### 윈도우 전용 함수 종류

```
--월급이 적은 순서대로 정렬해라.
SELECT ENAME, SAL,
RANK() OVER (ORDER BY SAL DESC) AS RANKING 
FROM EMP;

SELECT ENAME, SAL,
RANK() OVER (ORDER BY SAL DESC) AS RANKING,
DENSE_RANK() OVER (ORDER BY SAL DESC) AS D_RANKING,
ROW_NUMBER() OVER (ORDER BY SAL DESC) AS ROW_NUM
FROM EMP
ORDER BY SAL DESC;

SELECT ENAME, SAL,
ROW_NUMBER() OVER (ORDER BY SAL  DESC) AS ROW_NUM
FROM EMP;

SELECT ENAME, SAL, ROW_NUM FROM (
  SELECT ENAME, SAL, 
  ROW_NUMBER() OVER (ORDER BY SAL  DESC) AS ROW_NUM
  FROM EMP
)
WHERE ROW_NUM <= 5

SELECT ENAME, SAL, RANK, 
(SELECT COUNT(*) FROM EMP) AS TOTAL
 FROM (
  SELECT ENAME, SAL, 
  RANK() OVER (ORDER BY SAL  DESC) AS RANK
  FROM EMP
)
WHERE RANK <= 5

SELECT ENAME, SAL, RANK, 
(SELECT COUNT(*) FROM EMP) AS TOTAL,
(SELECT ROUND(AVG(SAL),0) FROM EMP) AS MEAN
 FROM (
  SELECT ENAME, SAL, 
  RANK() OVER (ORDER BY SAL  DESC) AS RANK
  FROM EMP
)
WHERE RANK <= 5

--total이라는 컬럼만들고
--total 몇 명 중에 1등이다.
--위에서 볼 수 있듯이 컬럼 자리에도 서브쿼리를 사용 가능함.
--서브쿼리는 필요할 때마다 어디에든 쓸 수 있어야 함. 

SELECT JOB, AVG(SAL), SUM(SAL) FROM EMP
GROUP BY ROLLUP(JOB);
--각 그룹에 대한 연산결과도 꺼내고, 총 합해서 처리하는 연산결과도 꺼내려고 할 때 쓴다.
--ROLLUP: 아주 간단한 집계를 할 수 있는 그러한 아이임.
```
