library(readxl)
library(dplyr)
st <- read_excel("st.xlsx")
st <- as.data.frame(st)
#st2<-st[st$CLASS <= 2,c("CLASS","ENG")]
#aggregate(data=st2, ENG~CLASS, mean)
#st %>% filter(MATH>=90)
#st[st$CLASS %in% c(2,3) & st$MATH>=90,]
str(st)
st %>% mutate(sum=MATH+ENG+SCI, 
              avg=(MATH+ENG+SCI)/3)


st$SUM <- rowSums(st[,c(3:5)])
st$AVG <- rowMeans(st[,c(3:5)])

st$SUM <- apply(st[,c(3:5)],1, sum)
st$AVG <- apply(st[,c(3:5)],1, mean)

aggregate(data=st, AVG~CLASS, mean)
aggregate(data=st, SUM~CLASS, sum)
