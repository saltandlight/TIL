# WITH 구문

## 기능:

- FROM 절에서 어떤 조건을 가진 테이블 불러올 때, 그 조건을 가진 테이블 자체에 이름을 붙임 -> 별도의 테이블로 인식하게 함
- 쿼리를 뷰처럼 재사용 가능
- 오라클 9이상에서 지원함

```ORACLE
WITH GENESIS AS
(
 SELECT *
 FROM CARS
 WHERE CATE = 'GENESIS'
)
SELECT * 
FROM GENESIS;
```

## 장점

- 서브쿼리 반복 시, WITH 구문 사용하는 게 가독성 좋음
- 성능적으로도 GOOD GOOD
- WITH 문에 다중 쿼리 사용 시 위력이 파워 업!

```ORACLE
WITH GENESIS AS
(
 SELECT *
 FROM CAR_A
 WHERE CATE = 'GENESIS'
),
SONATA AS
(
  SELECT * 
  FROM CAR_B
  WHERE CATE = 'SONATA'
),
TOTAL AS
(
   SELECT c1.NAME,
   		  c2.PRICE,
   FROM GENESIS c1,
        SONATA  c2
   WHERE c1.PRCICE = c2.PRICE
)
SELECT * 
FROM TOTAL
WHERE ROWNUM <= 100;
```

- 이런 식으로 계속 추가가 가능!

## 단점

- SELECT 할 때는 보기 좋지만, INSERT, UPDATE, DELETE 처럼 직접 데이터 변경 있는 구문에  WITH 구문 **사용가능** BUT!!!, WITH 구문이 통채로 들어가야 해서 비효율적임
- 직접 데이터 변경할 때는 사용하지 않는 편이 좋음

##### 참고 사이트

- https://epdl-studio.tistory.com/35
- https://zzznara2.tistory.com/71

