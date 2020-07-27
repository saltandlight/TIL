# 분석함수
## 분석함수
```SQL
   SELECT
    분석함수 OVER[[PARTITION BY 칼럼] [ORDER BY 칼럼] [WINDOWING 절]]
   FROM 테이블
```
- 서브쿼리보다 훨씬 간편하고 좋다
- 분석함수 뒤에 ANALYTIC CLUASE(OVER 절) 활용해서 행 그룹의 정의를 지정
- 각 그룹당 결과값을 반복하여 출력함
-  행 그룹은 칼럼에 대한 행
- 행 그룹의 범위(WINDOW)를 PARTITION BY, ORDER BY, WINDOWING으로 조절이 가능

## Partition By
- 뒤에 오는 컬럼마다 Group By 해서 그 기준대로 파티션을 주는 명령어
- 실행 순서
  `FROM-WHERE-GROUP BY-HAVING-SELECT-ORDER BY-OVER`
- 가장 마지막에 실행됨