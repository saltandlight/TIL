import random

#딕셔너리 선언
student_phone_number = {
    "김민지":"010-1234-1234"
}

#print(student_phone_number["김민지"])
#print(student_phone_number.get("김민지"))

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

#print(lunch_menu["20층 식당"]["B코스"])
#print(lunch_menu.get("20층 식당").get("B코스"))

lunch_menu["경성불백"] = {
#새로운 키 값과 value들을 넣어주기
    "한식메뉴":"석쇠불고기",
    "특식메뉴":"돈까스"
}

'''
print(lunch_menu)
lunch_menu["양자강"]="짜장면"
print(lunch_menu)


print(lunch_menu.keys())
print(lunch_menu.values())
print(lunch_menu.items())
'''

#순회하는 박스 뭉치들은 B로 감
#key는 lunch_menu.keys()의 값을 하나씩 담아가며 순회함

'''
for key in lunch_menu.keys():
    print(key)


for value in lunch_menu.values():
    print(value) 

for key, value in lunch_menu.items():
    print(key)
    print(value)
 '''

#여러 개 중에 한개 뽑는 것
print(random.choice(list(lunch_menu.keys())))
#여러 개 중에 여러 개 뽑는데 뒤에 지정한 숫자만큼 뽑는다.
print(random.sample(list(lunch_menu.keys()),2))

'''
if 조건1:
    #괄호는 필요없다!
    조건 1의 실행문
elif 조건2:
    조건 2의 실행문
else:
    나머지 실행문
'''


