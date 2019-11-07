## Day2

- 파이썬 딕셔너리 
  - 딕셔너리?
  - 애를 왜 쓰는지?
  - 얘를 어떻게 활용할지?
  - JSON 과 비교했을 때 어떤 차이가 있는지?
  - 딕셔너리 활용 문제 
- 어제 사용했떤 다음 웹툰 코드 사용해서 원하는 정보 뽑아내기
- 자유롭게 원하는 사이트에서 데이터를 뽑아내보기
- 함수 활용하기 
- 플라스크 기본

### 값을 저장

- 변수

  - a="하하"

- 배열

  - 값(박스)을 붙여서 쭉 나열
  - 0 1 2 3
  - 파이썬에서는 타입이 달라도 상관없음

- 딕셔너리

  - 같은 이름의 값을 2번 담지 못함
  - Key: 정보를 불러올 수 있는 마법의 장치
  - Value: 담겨있는 정보
  - Key와 Value가 한 쌍으로 이루어진 것이 딕셔너리
  - 어떤 언어에서는 해쉬라고 함 
  - HashMap 
  - 중복되는 게 있으면 마지막 key값만 기억함. 
  - key값은 고유해야 함. (트리를 그리는 구조인데 이 구조 때문에 Key값은 고유해야 함)

- ```python
  #딕셔너리 선언
  student_phone_number = {
      "김민지":"010-1234-1234"
  }
  
  print(student_phone_number["김민지"])
  print(student_phone_number.get("김민지"))
  
  lunch_menu = {
      "20층 식당":{
          "A코스":"돈까스",
          "B코스":"순대국"
      },
      "양자강":{
          "점심메뉴":"탕짬면",
          "특선메뉴":"군만두"
      },
      "대동집":{
          "밥안주":"비빔면",
          "술안주":"오돌뼈"
      },
      "경성불백":{
  
      }
  }
  
  print(lunch_menu["20층 식당"]["B코스"])
  print(lunch_menu.get("20층 식당").get("B코스"))
  
  lunch_menu["경성불백"] = {
  #새로운 키 값과 value들을 넣어주기
      "한식메뉴":"석쇠불고기",
      "특식메뉴":"돈까스"
  }
  
  print(lunch_menu)
  lunch_menu["양자강"]="짜장면"
  print(lunch_menu)
  
  
  print(lunch_menu.keys())
  print(lunch_menu.values())
  print(lunch_menu.items())
  
  #순회하는 박스 뭉치들은 B로 감
  #key는 lunch_menu.keys()의 값을 하나씩 담아가며 순회함
  
  for key in lunch_menu.keys():
      print(key)
  
  for value in lunch_menu.values():
      print(value) 
   
  for key, value in lunch_menu.items():
      print(key)
      print(value)
  ```

- 파이썬에서는 들여쓰기 자체가 하나의 문법임.

- 반복문, 조건문, 함수 만들 때, scope 지켜서 만들어야 함 

### 덕타이핑(Duck Typing)

- 새 한 마리가 있는데 꽥꽥 하고 울고 뒤뚱뒤뚱거리며 걸으면 오리라고 규정함. 
- 말을 할 수 있고 걸어다닐 수 있으면 사람으로 규정함.
- 반복문을 쓸 수 있는 메소드 => 반복문 쓸 수 있음.

### Quiz

```python
'''python 연습문제'''
#1. 평균을 구하시오
scores={
    "수학":90,
    "영어":87,
    "한국지리":92
}

sum=0
avg=0

for a in scores.values():
    sum+=a

avg=sum/3
print(round(avg,1))
# 배열의 길이를 구하는 함수는 len(배열)
#2. 각 학생의 평균 점수와 반 평균을 구하세요
scores={
    "a학생":{
        "수학":80,
        "국어":90,
        "음악":100
    },
    "b학생":{
        "수학":90,
        "국어":90,
        "음악":68
    }
}

sum_a=0
sum_b=0
sum_tot=0
avg_a=0
avg_b=0
tot_avg=0

for a in scores["a학생"].values():
    sum_a+=a

avg_a=sum_a/3

for b in scores["b학생"].values():
    sum_b+=b

avg_b=sum_b/3

print(round(avg_a,1))
print(round(avg_b,1))

sum_tot=sum_a+sum_b
tot_avg=sum_tot/6

print(round(tot_avg,1))

#3.다음 웹툰의 금요일 웹툰 전체의 리스트 중에서 각 웹툰의 제목, 설명, 작가 이름, 장르만 골라 새로운 dictionary를 만들고 이 dictionary  담고 있는 list를 만드세요 

#3-1. 금요일 뿐만 아니라 월요일부터 일요일까지의 웹툰 데이터를 파싱하여 각각 dictionary로 만드세요 

```

### 조건문

```python
if 조건1:
    조건 1의 실행문
elif 조건2:
    조건 2의 실행문
else:
    나머지 실행문
```

- indent 지켜서 코딩해야 함

### 함수

```python
def 함수명(파라미터):
    실행문
```

