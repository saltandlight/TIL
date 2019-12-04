st <- read.csv("student2.csv",
               header=TRUE,
               stringsAsFactors = FALSE,
               na.strings = "NA",
               encoding = "EUC-KR")
st[st$KO >= 90, ]
st[st$KO >= 90 & st$SI >= 80 , c("KO","SI")]

# 값이 이상함... 추후 수정
st$AVG <- st[,mean(c(3:6))]
st$CLASS <- c(1,1,1,2,2,2,3,3)

# 묶음: class, 평균을 구할 대상:AVG, data: st
aggregate(data=st[st$KO>=90,],AVG~CLASS,mean)
