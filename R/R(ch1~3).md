# R을 이용한 데이터 처리 & 분석 실무

## 1장. R 프로그래밍을 위한 환경 준비하기

### 01. 왜 R인가

- R은 데이터 분석을 위한 도구로 많은 인기를 끌고 있었음

- R은 다양한 패키지의 집합임.

- 범용적인 API들의 집합, 특별한 것들은 외부 라이브러리들을 이용함.

- R패키지도 상당히 많은 패키지로 구성됨.

  -> 하루에도 많은 패키지들이 탄생...

  -> 어렵...

- 통계를 기반으로 한 데이터 분석에 근거함.

- cran이라는 곳을 통해서 다운로드 받을 수 있음.

- R이 인기를 끌었던 이유: 자바와 연동되기 떄문에 (큰 특징 중 하나)

  ​                                        매우 훌륭한 패키지들이 많이 나옴(상당히 많은 

  ​                                        대학에서 R에 대해 publish했음.)

- 파이썬은 주로 고속 연산, 시각화, 기계학습, 분석 알고리즘 등 통계적 데이터에는 약함. 그러나...! 파이썬도 통계 라이브러리를 상당히 많이 제공 중임.

### 02. R 설치

- R 설치:

  <https://cran.r-project.org/bin/windows/base/>

- rstudio 설치:

  <https://www.rstudio.com/products/rstudio/download/#download>

- File-> new Project -> name: r1, subdir: C:/rstudio

- console: 결과를 보는 영역

``` r
a <- 100;
b <- 200;
c <- a+b;
print(c)
```

- Run: 실제로 라인단위로 인터프리팅 시키는 것
- Source: 파일 전체를 실행시키는 것.

### 06. 배치 실행

```r
> source('C:/rstudio/r1/r01.R')
[1] 300
```

이 디렉터리의 이 파일을 실행하겠다는 뜻.

## 2장. 데이터 타입

#### 01. 변수

- 알파벳, _, .로 구성되며 -은 사용 불가

- 첫 글자는 알파벳 또는 .로 시작해야 함.

  ```r
  a
  b
  a1
  b2
  .x
  ```

  ```R
  > .2 <- 100;
  Error in 0.2 <- 100 : invalid (do_set) left-hand side to assignment
  ```

- 변수값 할당

  - <-, <<- , = 연산자를 사용
  - =는 명령의 최상위 수준에서만 사용 가능
  - <-나 <<- 는 바꿔서도 사용 가능함.

  ```R
  a <- c(1:10)
  //1~10 까지의 수(수열)
  b <- mean(a);
  print(a)
  ```

### 02. 함수 호출 시 인자 지정

- R의 함수 인자는 위치 또는 이름으로 지정 가능함.

  ```R
  foo(a, b, c=1, d=2)
  ```

**스칼라**

- 하나의 숫자를 의미함.

**숫자**

**NA(Not Available)**

- 결측치 

- 연산 시 다 빼야 함.(제외시켜야 함.)

  -> How to?

  - is.na로 비교함

**NULL**

- NULL 객체를 뜻함.
- 변수를 초기화하지 않았을 때 사용함.
- undefined 임.
- NULL: 10명 중 한명은 시험 안 봐도 되는~
- NA: 10명이 시험 보는데 한 명이 안 온 경우

**문자열**

- ""와 ''를 같이 사용함.

**진리값**

TRUE, FALSE 이런 식으로 대문자로 씀

### 03. 팩터

- 범주형 데이터임. 대중소의 레벨을 표현하는 기준(남, 여 이런 식)

```R
sex <- factor("m", c("m","f"))
# factor 변수 sex는 m아니면 f밖에 가질 수가 없다.
```

- R은 숫자 아니면 스트링이므로 "" 사용에 유의할 것

``` R
> data <- factor("m", c("m", "f"));
> print(data)
[1] m
Levels: m f
> print(levels(data)[1])
[1] "m"
> print(levels(data)[2])
[1] "f"
```

### 04. 벡터

- 배열의 개념, 한 가지 스칼라 타입의 데이털글 저장 가능
- 숫자만 저장하는 배열, 문자열만 저장하는 배열이 벡터에 해당함

```R
> a <- c(1,3,5);
> b <- c(1:5)
> c <- c(1, 3, c(4:6))
> a
[1] 1 3 5
> b
[1] 1 2 3 4 5
> c
[1] 1 3 4 5 6
> score <- c(100, 90, 80)
> names(score) <- c("lee", "kim", "han")
#벡터의 컬럼 지정
> print(score)
lee kim han 
100  90  80 
```

```R
v1 <- c(1:10)
print(v1[-1])
# 1번 아이를 제외하고 출력해주세요~
score <- c(100, 90, 80)
names(score) <- c("lee", "kim", "han")
print(score["lee"])
# lee의 점수를 가져와서 출력해주세요~
v1 <- c(10:20)
print(v1[5:8])
# 몇 번째부터 몇 번째까지 출력해주세요~
> print(length(v1))
[1] 11
# 얘를 더 많이 씀.
> print(NROW(v1))
[1] 11
```

**두 개 이상일 때는 무조건 c를 써라~~**

제일 중요한 것은 벡터임.

**벡터 연산**

- identical: 객체가 같은지 판단
- union: 합집합을 구함
- intersect: 교집합을 구함
- setequal: x와 y가 같은 집합인지 판단

**연속된 숫자로 구성된 벡터**

```R
seq(
from, 
to,
by)

seq_along(
 along.with
  # 이 인자 길이만큼 시퀀스를 생성함.
)
```

**반복된 값을 저장한 벡터**

```R
rep(
  x,
  times,
  each
)


> a <- c(1,10)
> b <- seq(1, 10, 2)
> c <- rep(1, times=5)
> print(a)
[1]  1 10
> print(b)
[1] 1 3 5 7 9
> print(c)
[1] 1 1 1 1 1
```

### 05. 리스트

- key, value를 의미함.

```R
a <- list(s1=c(80,90,70,88), s2=c(90, 100, 80, 30))
#s1이 key, 뒤의 값이 value
print(mean(a$s1))
print(mean(a$s2))
print(mean(c(mean(a$s1), mean(a$s2))))
```

**리스트 데이터 접근**

### 06. 행렬

- 행과 로우의 수가 지정된 구조

```R
data <- c(1:9)
ma <- matrix(data, nrow=3, byrow=TRUE)
ma
# nrow는 몇 행인지
# byrow는 row기준인지 나타냄
## r3의 평균과 c3의평균 구하라 
ma2 <- ma[c(2:3) ,c(2:3)]
ma2

print(mean(ma2[2,]))
print(mean(ma2[,2]))
print(mean(ma2))

```

**행렬 연산**

- A+x: 행렬 A의 모든 값에 스칼라 x를 더함.
- A+B: 행렬 A와 행렬 B의 합을 구함.
- A %*% B: 행렬 A와 행렬 B의 곱을 구함.

### 07. 배열

- 배열은 다차원 데이터

### 08. 데이터 프레임(제일 중요)

- 현실에서는 데이터 프레임이 많이 쓰임

- 다양한 타입이 들어감. 

- 엑셀과 같은 모습

- R에서 가장 많이 사용하는 데이터 타입

  ```R
  > df1 <- data.frame(x=c(1:5), y=c(5:9), z=c(11:15))
  > df1
    x y  z
  1 1 5 11
  2 2 6 12
  3 3 7 13
  4 4 8 14
  5 5 9 15
  > print(df1)
    x y  z
  1 1 5 11
  2 2 6 12
  3 3 7 13
  4 4 8 14
  5 5 9 15
  > print(df1$x)
  [1] 1 2 3 4 5
  > print(df1$y)
  [1] 5 6 7 8 9
  > print(df1[1,])
    x y  z
  1 1 5 11
  > print(df1[2,])
    x y  z
  2 2 6 12
  > print(df1$x)
  [1] 1 2 3 4 5
  > print(df1$x[3])
  [1] 3
  > print(df1[3,1])
  [1] 3
  > print(df1["x"])
    x
  1 1
  2 2
  3 3
  4 4
  5 5
  > print(df1[,2])
  [1] 5 6 7 8 9
  > # cutting 2,2 ~ 5,3
  > df2=df1[c(2:5),c(2:3)]
  > df2
    y  z
  2 6 12
  3 7 13
  4 8 14
  5 9 15
  # 학생별 평균, 전체 평균 출력하시오.
  each1 <- c(mean(df1$lee), mean(df1$kim),mean(df1$han),mean(df1$jun), mean(df1$goo))
  each2 <- c(sum(df1[1,]), sum(df1[2,]), sum(df1[3,]),
             sum(df1[4,]))
  each2

  print(mean(df1[,1]))
  print(mean(df1[,2]))
  print(mean(df1[,3]))
  print(mean(df1[,4]))
  print(mean(df1[,5]))
  print(mean(each1))

  > df1 <- data.frame(
  +   "lee" = c(90,99,89,87),
  +   "kim" = c(91,98,81,86),
  +   "han" = c(92,97,82,85),
  +   "jun" = c(93,96,83,84),
  +   "goo" = c(94,95,84,83),
  +   "grade"=c("A","B","A","A")
  + )
  > str(df1)
  # 어떤 타입이 어떤 식으로 들어가 있는 지 보고 싶을 때 사용
  'data.frame':	4 obs. of  6 variables:
   $ lee  : num  90 99 89 87
   $ kim  : num  91 98 81 86
   $ han  : num  92 97 82 85
   $ jun  : num  93 96 83 84
   $ goo  : num  94 95 84 83
   $ grade: Factor w/ 2 levels "A","B": 1 2 1 1
  ```

  - 데이터 프레임에 스트링을 넣으면 팩터 형태로 들어감.

  ```R
  df1$lee <- c(0,0,0,0)
  # 데이터 프레임 열 변경
  df1$hong <- c(100,100,100,100)
  # 데이터 프레임에 새로운 열 추가
  # 데이터 프레임에서 4열 삭제
  df2 <- df1[,-4]
  print(df2)
  ```

  - 데이터 프레임 접근

    - d[m, n, drop=TRUE]:

      데이터 프레임 d의 m행 n컬럼에 저장된 데이터

  - 유틸리티 함수

### 09. 타입 판별

- 데이터 타입 판별 함수

  | 함수               | 의미                      |
  | ---------------- | ----------------------- |
  | class(x)         | 객체 x의 클래스               |
  | str(x)           | 객체 x의 내부 구조             |
  | is.factor(x)     | 주어진 객체 x가 팩터인가          |
  | is.numeric(x)    | 주어진 객체 x가 숫자를 저장한 벡터인가  |
  | is.character(x)  | 주어진 객체 x가 문자열을 저장한 벡터인가 |
  | is.matrix(x)     | 주어진 객체 x가 행렬인가          |
  | is.array(x)      | 주어진 객체 x가 배열인가          |
  | is.data.frame(x) | 주어진 객체 x가 데이터 프레임인가     |

### 10. 타입 변환

| 함수               | 의미                        |
| ---------------- | ------------------------- |
| as.factor(x)     | 주어진 객체 x를 팩터로 변환          |
| as.numeric(x)    | 주어진 객체 x를 숫자를 저장한 벡터로 변환  |
| as.character(x)  | 주어진 객체 x를 문자열을 저장한 벡터로 변환 |
| as.matrix(x)     | 주어진 객체 x를 행렬로 변환          |
| as.array(x)      | 주어진 객체 x를 배열로 변환          |
| as.data.frame(x) | 주어진 객체 x를 데이터 프레임으로 변환    |

### 3장. R 프로그래밍

#### 01. R의 특징

- 1. 데이터를 다루는 방식이 조금 다름
- 2. NA를 조심...!(연산 시 몽땅 NA될 수 있음), NULL도 조심...!
- 3. 객체 불변성

#### 02. 흐름 제어

- if

  연속적인 벡터 데이터 

  ```R
  ifelse(x %% 2 == 0, "even", "odd")
  ```

- 반복문

  | 문법                                 | 의미                                       |
  | ---------------------------------- | ---------------------------------------- |
  | `for (i in data) {  i를 사용한 문장}`    | data에 들어 있는 각각의 값을 변수 i에 할당하면서 각각에 대해 블록 안의 문장을 수행한다. |
  | `while (cond) {  조건이 참일 때 수행할 문장}` | 조건 cond가 참일 때 블록 안의 문장을 수행한다.            |
  | `repeat {  반복해서 수행할 문장}`           | 블록 안의 문장을 반복해서 수행한다. repeat은 다른 언어의 do-while에 해당한다. |

  - for문은 데이터 값을 하나하나 출력할 때 사용함.
  - while loop: 시작, 조건, 증감 

#### 03. 연산

NA가 들어갔는지? 중요함.

| 연산자와 함수                | 의미                                       |
| ---------------------- | ---------------------------------------- |
| +, -, *, /             | 사칙 연산                                    |
| n %% m                 | n을 m으로 나눈 나머지                            |
| n %/% m                | n을 m으로 나눈 몫                              |
| n^m                    | n의 m승                                    |
| exp(n)                 | e의 n승                                    |
| log(x, base=exp(1))    | logbase(x). 만약 base가 지정되지 않으면 loge(x)를 계산 |
| log2(x), log10(x)      | 각각 log2(x), log10(x)를 계산                 |
| sin(x), cos(x), tan(x) | 삼각 함수                                    |

- 벡터 연산

```R
> d[d$x %% 2 == 0, ]
  x y
2 2 b
4 4 d


> data2 <- data[data$lee >= 90,]
> data2
    lee kim hong kang han goo  sum   avg
1    90  91   92   93  94  95  555  92.5
4    95  94   93   92  91  90  555  92.5
sum 352 352  352  352 352 352 2112 352.0
```

**NA 처리**

```R
d1 <- c(10,20,30,40,NA)
# NA 좀 삭제해라 
print(sum(d1, na.rm=TRUE))
```

| 함수                      | 의미                                       |
| ----------------------- | ---------------------------------------- |
| na.fail(object, ...)    | object에 NA가 포함되어 있으면 실패한다.               |
| na.omit(object, ...)    | object에 NA가 포함되어 있으면 이를 제외한다.            |
| na.exclude(object, ...) | object에 NA가 포함되어 있으면 이를 제외한다는 점에서 na.omit과 동일하다. 그러나 naresid, napredict를 사용하는 함수에서 NA로 제외한 행을 결과에 다시 추가한다는 점이 다르다. |
| na.pass(object, ...)    | object에 NA가 포함되어 있더라도 통과시킨다.             |

na.omit이나 na.exclude 하면 행이 제외되기 때문에 na.rm을 사용함.

```R
> d1 <- c(10,20,30,40,NULL)
> # NA 좀 삭제해라 
> print(sum(d1))
[1] 100
```

NA와 다르게 계산이 된다.

```R
f1 <- function(a){
  return (100+a);
  #괄호를 항상 닫아줘야 함.
}
result <- f1(200.11)
print(result)
```

**중첩 함수**

- 함수 안에 또 다른 함수를 정의하여 사용함.

### 05. 스코프

```R
n<- 100
f1 <- function(){
  n<-1
  return (n)
}

print(f1())
```

- 밖의 n과 안의 n은 다른 아이~~

```R
n<- 100
f1 <- function(){
  n<<-1
  # 전역변수 1로 바꿈
  return (n)
}

print(f1())

print(n)
```

```R
list=ls()
# 여태까지 사용한 변수들 list에 담음
print(list)
# list 다 프린트
rm(list=ls())
# list도 지우고 여태까지 사용했던 변수들도 다 지움.
```

### 06. 값에 의한 전달

```R
> f <- function(df2) {
+ df2$a <- c(1, 2, 3)
+ }
> df <- data.frame(a=c(4, 5, 6))
> f(df)
> df
a
1 4
2 5
3 6
# call by value -> 실제 df값은 변동 없음.
> f <- function(df) {
+ df$a <- c(1, 2, 3)
+ return(df)
+ }
> df <- data.frame(a=c(4, 5, 6))
> df <- f(df)  # df의 값을 덮어쓴다.
> df
a
1 1
2 2
3 3
# return 하면 실제적인 값이 바뀜..!
```

- 자바랑 R 연동 시 자바가 R의 함수 호출
- -> R 사용하지 않고 hive에서 분석해서 처리하면 안 되나?
- hive에서 그룹함수 사용 시 늦어짐(맵리듀스 돌아가는 속도...)
- 빅데이터의 경우 다름
- 데이터의 양이 많으면 맵리듀스 안 쓰고 가져오면 빠름
- 저장된 데이터를 가져와서 R에서 처리 가능
- R을 사용하는 이유: 통계 패키지를 사용하려고 