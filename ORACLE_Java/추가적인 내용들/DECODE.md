# DECODE 함수
## 정의
- 오라클 쿼리에서 가장 많이 사용하는 함수 중 하나임.
- 최근에는 이것 대신 CASE WHEN 구문 사용을 권장하기도 함
- if else 같은 기능을 수행(조건문임)
```ORACLE
DECODE(SEX, 'M', '남자', 'F', '여자')
```
- 이 경우 다음과 같은 의미를 가짐
```C#
if(sex == 'M')
  return '남자';
else
  return '여자';
```
