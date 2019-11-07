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