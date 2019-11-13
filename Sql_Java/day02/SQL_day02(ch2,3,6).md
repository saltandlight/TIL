1. RDBMS

2. DDL

   1. CREATE

   CREATE TABLE T_USER(

   ID VARCHAR2(10),

   PWD VARCHAR2(10),

   NAME VARCHAR2(20)

   );

   1. DROP

   DROP TABLE T_USER;

   ALTER

3. DML

   1)SELECT

   SELECT 구조

   Alias AS

   WHERE AND OR NOT

   Operation

   ORDER BY

   FUNCTION

   2)INSERT

   INSERT INTO T_USER () VALUES ()

   1. DELETE

   DELETE FROM T_USER

   DELETE FROM T_USER WHERE ID='id01'

   1. UPDATE

   UPDATE T_USER SET PWD='111', NAME='공말숙'

   UPDATE T_USER SET PWD='111', NAME='공말숙' WHERE ID='id03'

시험은 ANSI 표준으로 공부해야 함.

DDL을 작성하기 위해서는 데이터 모델링을 먼저 해야 함.

# 2. 검색의 기본

## 2-1. SELECT문의 기본

검색하는 것-> SELECT문

검색할 때는 선택하려는 열에 대한 조건을 추가 가능.

현업에서는 거의 오라클, mariaDB는 스타트업 기업들이 많이 사용

-tip

KING과 같은 임원은 Employee가 아님

salesman에게는 commission줄 수 있음.

근데 다른 아이들은 안 주니까 NULL임.

결측치 걸러내기

EMP가 DEPT의 dname, loc를 가질 경우 loc가 바뀐다면 관리자는 노가다를 해야 함...

-> DEPT를 따로 만들어서 참조하게 함.

Foreign Key: 다른 테이블의 PK를 참조하고 있는 것.(남의 키)

EMP와 DEPT와 같은 구조=relational DBMS(ex.Oracle)

테이블을 쪼갤수록 프로그래밍 복잡...

-> 이런 것을 고려할 줄 아는, 개발을 잘 하는 DBA가 좋음.

- 모든 열을 출력한다.

  ```
  SELECT * FROM EMP;
  ```

  별표는 모든 열을 의미함.

- 열에 별명을 부여하자(대단히 중요!!!!!!!!!) ALIASING ; ALIAS 부여

```
SELECT ENAME, SAL, SAL*12 AS ASAL , DEPTNO AS DNO
FROM EMP;
```

 연봉을 출력하고 싶고, 프로그래밍할 때 편하게 하고 싶을 때 이런 식으로 ALIAS 사용!!

 중간에 스페이스바를 넣고 싶다면 이런 식으로 하기

```
SELECT ENAME, SAL, SAL*12 AS "ANN SAL" , 
DEPTNO AS DNO
FROM EMP;
```

DATE 에는 년,월,일, 초까지 다 들어있음.

||을 사용하면 한 컬럼에 합쳐지는데 숫자와 문자를 합칠 경우 문자가 된다.

```
SELECT ENAME || ' ' || SAL AS ENAMEANDJOB
FROM EMP;
```

- 결과에서 중복 행을 제거

```
SELECT 
DISTINCT (JOB)
FROM EMP;
```

그러나 다른 컬럼도 같이 쓰면 DISTINCT 기능이 잘 발현되지 않음.(의미 없음)

```
SELECT 
DISTINCT (JOB), ENAME
FROM EMP;
```

- WHERE 구를 사용한 행 선택

```
SELECT * 
FROM EMP
WHERE JOB = 'MANAGER';
```

- 주석 작성법

  - 1행 주석: '--' 뒤에 표시함

  - 2행 주석: '/*와 */ 사이에 표시함

    ```
    SELECT * FROM EMP
    --where statement.
    /*
    Multi Comments ..
    */
    WHERE JOB = 'MANAGER'
    AND ENAME LIKE 'C%';
    ```

# 2-2. 산술 연산자와 비교 연산자

- 산술 연산자(+,-,*,/)

  ```
  SELECT ENAME, SAL,SAL+COMM
  FROM EMP;
  
  SELECT ENAME, SAL,(SAL*12*0.87) + (NVL(COMM,0)*12*0.88) AS "ANN SAL"
  FROM EMP;
  
  /*NVL은 NULL을 특정 숫자로 바꿔주는 함수(꼭 기억!!!!)*/
  
  SELECT ENAME, SAL,(SAL*12*0.87) + (NVL(COMM,0)*12*0.88) AS ANSAL
  FROM EMP
  WHERE (SAL*12*0.87) + (NVL(COMM,0)*12*0.88) <> 30000;
  -- 같지 않다의 연산자; <>
  -- 비교할 때는 ALIAS를 사용할 수 없음!!
  ```

# 2-3. 논리 연산자

- AND 연산자와 OR 연산자

```
SELECT * FROM EMP
WHERE COMM IS NOT NULL;

SELECT * FROM EMP
WHERE SAL < 2000
AND DEPTNO = 30
OR ENAME LIKE '%E%';

앞의 것부터 순차적으로 진행함!
OR 연산자를 쓸 때 내가 원하는 조건이 아닐 수 있으므로 조심해서 써야 한다.
OR 연산자보다 AND 연산자가 우선순위가 높다.
AND 연산자는 같이 움직인다.

SELECT * FROM EMP
WHERE JOB='CLERK' OR
DEPTNO=10 AND DEPTNO=20
```

- 괄호를 사용하면 강해진다.

  ```
  SELECT * FROM EMP
  WHERE JOB='CLERK'
  AND (DEPTNO=10 OR DEPTNO = 20)
  
  SELECT * FROM EMP
  WHERE JOB='CLERK'
  AND NOT (DEPTNO=10 OR DEPTNO = 20)
  --deptno가 10, 20 인 애들이 나오지 않음.
  ```

- NULL을 포함한 진리값

  IS NULL과 IS NOT NULL을 사용함.

## 3-4. 검색결과를 재정렬한다.

ORDER BY

column 기준으로 정렬함.

```
SELECT ENAME, SAL FROM EMP
WHERE SAL > 1000
AND DEPTNO = 20
ORDER BY SAL DESC;

SELECT ENAME, SAL FROM EMP
WHERE SAL > 1000
AND DEPTNO = 20
ORDER BY 2 DESC;

SELECT ENAME, SAL FROM EMP
WHERE SAL > 1000
AND DEPTNO = 20
ORDER BY ENAME;

SELECT ENAME, SAL, SAL*12 FROM EMP
WHERE SAL > 1000
AND DEPTNO = 20
ORDER BY 3 ASC;
--3번째 컬럼을 기준으로 정렬함(작은-> 큰)

SELECT ENAME, SAL, SAL*12 AS ASAL 
FROM EMP
WHERE SAL > 1000
AND DEPTNO = 20
ORDER BY ASAL ASC;
-- 정렬할 떄는 ALIAS를 사용해도 됨!!
-- 정렬 시 ORER BY 뒤에 있는 칼럼이 많으면 의미가 없음.
-- 되도록이면 ALIAS 나 명칭을 이용해서 사용할 것(숫자는 프로그래밍 시에 방해됨.)

SELECT * FROM EMP
WHERE COMM IS NOT NULL
ORDER BY COMM DESC;
-- null이 보통 이렇게 처리 안 하는 경우 위에 뜸.
-- 이 문장은 널이 아닌 애들 위주로 정렬한 것.
```

- 열 번호를 사용해서는 안 된다.

  필요하면 써라~ 그러나 ~~~ 되도록이면 ALIAS 써서 해라.

# 6. 함수, 술어, CASE 식

## 6-1. 다양한 함수

- 함수 종류
  - 산술함수
  - 문자열함수
  - 날짜함수
  - 변환함수
  - 집약함수
- 산술 함수
  - +(덧셈)
  - -(뺄샘)
  - *(곱셈)
  - /(나눗셈)

```
SELECT ENAME, SAL, MOD(SAL,3) FROM EMP;
SELECT ENAME, SAL, ROUND(SAL/7,3) AS BONUS FROM EMP;
--함수가 각각의 행에 적용이 된다.(단일행 함수)
```

- 문자열 함수

  - || : 연결함수(column을 연결함.)

    SQL server와 mysql에서는 사용할 수 없다.

  - REPLACE(ename, substr(ename, 1, 3), 'AAA'): ename의 1~3까지의 값을 AAA로 바꿔라

  - SUBSTR(ename, 1, 3) : ename의 1~3인덱스까지 출력

  ```
  SELECT LOWER(ENAME) || ' ' || JOB AS EJOB FROM EMP;
  
  SELECT ENAME, SUBSTR(ENAME, 1 , 3),
  REPLACE(ENAME, SUBSTR(ENAME, 1 , 3), 'AAA' )
  FROM EMP;
  ```

  - UPPER: 대문자화
  - LOWER:소문자화
  - LENGTH:문자열 길이

  ```
  SELECT ENAME, SUBSTR(ENAME, 2 , 3),
  REPLACE(ENAME, SUBSTR(ENAME, 2, LENGTH(ENAME)), LOWER(SUBSTR(ENAME, 2, LENGTH(ENAME))) )
  FROM EMP;
  
  SELECT ENAME, LENGTH(ENAME) FROM EMP;
  
  SELECT ENAME, SUBSTR(ENAME, 2 , 3),
  REPLACE(ENAME, SUBSTR(ENAME, 2, LENGTH(ENAME)), LOWER(SUBSTR(ENAME, 2, LENGTH(ENAME))) )
  FROM EMP;
  
  SELECT NAME, LENGTH(NAME) FROM T_USER;
  
  DESC T_USER;
  
  INSERT INTO T_USER VALUES('id79', 'pwd78', 'aaaaaaaaaaaaaaaaaaaa');
  
  -- 가 가 3자리를 차지함.(바이트)...그러나 막상 출력시키면 1로 표시됨.
  
  
  SELECT ENAME, SUBSTR(SAL,1,2)*10 FROM EMP;
  -- 스트링처럼 나와도 곱하기 할 때 먹힌다!(자동연산이 가능함) 그러나 SUBSTR안에 ename과 같은 알파벳이 들어가면 안 됨.
  
  SELECT ENAME, SAL FROM EMP
  WHERE DEPTNO IN (20,30,10);
  ```

- 날짜 함수

  TO_CHAR와 DATE함수를 자주 묶어서 쓴다.

  원하는 캐릭터로 바꿀 수 있음!!

- TO_CHAR: 날짜를 내가 원하는 String으로 바꿀 때 사용한다.

```
SELECT ENAME, TO_CHAR(CURRENT_TIMESTAMP,'YYYY:MM:DD:HH:MM:SS'),
TO_CHAR(HIREDATE, 'YYYY:MM:DD'), SYSDATE,
SYSDATE-HIREDATE
FROM EMP

DATE 객체는 연산이 됨!


SELECT ENAME, TO_CHAR(CURRENT_TIMESTAMP,'YYYY:MM:DD:HH:MM:SS'),
TO_CHAR(HIREDATE, 'YYYY:MM:DD'), SYSDATE,
SYSDATE-HIREDATE,
TO_DATE(TO_CHAR(HIREDATE, 'YYYY/MM'), 'YYYY/MM')
FROM EMP;

INSERT INTO T_PRODUCT VALUES
('id100', 'pants', 10000, TO_DATE('2010/10/11', 'YYYY/MM/DD'));
```

- 변환함수
  - NVL(comm,o) : comm이 null인 값을 0으로 바꿔줌!

## 6-2. 술어

- MONTHS_BETWEEN(SYSDATE, HIREDATE)

  :두 날짜 사이에 몇 개월이 지났는지 알려줌!!

## 6-3. CASE 식

등급이라는 것을 만들 때 사용하는 것이 case 문

```
SELECT ENAME,
CASE WHEN JOB='PRESIDENT'
     THEN '왕'
     WHEN JOB='MANAGER'
     THEN '관리자'
     ELSE '직원'
END
FROM EMP;

SELECT ENAME,SAL,
CASE WHEN SAL >= 5000
     THEN '왕'
     WHEN SAL >=3000
     THEN '관리자'
     ELSE '직원'
END AS GRADE 
FROM EMP;
```

ELSE가 중요함!

오라클에서는 DECODE를 많이 쓴다. 그렇지만 CASE식은 표준!!

CASE~END가 하나의 column