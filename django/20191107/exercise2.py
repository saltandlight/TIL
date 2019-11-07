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