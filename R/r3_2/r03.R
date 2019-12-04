library(readxl)
library(dplyr)
st <- read_excel("st.xlsx")
st <- rename(st, MA=MATH)
st$AVG <- rowMeans(st[,c(3:5)])

#st$LEVEL <- ifelse(st$AVG >= 90, "PASS","FAIL")
#qplot(st$LEVEL)

#level을 그룹핑 해서 평균 구하기 -> aggregate 사용!
#aggregate(data=st,AVG~LEVEL ,mean)

st$grade <- ifelse(st$AVG >= 90, "A",
                   ifelse(st$AVG >= 80, "B",
                          ifelse(st$AVG >= 70, "C","F")))
st
qplot(st$grade)
ta <- table(st$grade)
class(ta)
as.data.frame(ta)


