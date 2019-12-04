data <- data.frame(
  "lee"=c(90,86,81,95),
  "kim"=c(91,85,82,94),
  "hong"=c(92,84,83,93),
  "kang"=c(93,83,84,92),
  "han"=c(94,82,85,91),
  "goo"=c(95,81,86,90)
)
print(data)

data2 <- c(sum(data[,1]),sum(data[,2]),sum(data[,3]),sum(data[,4]),sum(data[,5]), sum(data[,6]))
data3 <-c(mean(data[,1]),mean(data[,2]),mean(data[,3]),mean(data[,4]),mean(data[,5]), mean(data[,6]))
data<- rbind(data,data2)
data <- rbind(data, data3)
data

data$sum <- c(sum(data[1,]),sum(data[2,]),sum(data[3,]),sum(data[4,]),sum(data[5,]), sum(data[6,]))
data$avg <-c(mean(as.numeric(data[1,c(1:6)])),mean(as.numeric(data[2,c(1:6)])),mean(as.numeric(data[3,c(1:6)])),mean(as.numeric(data[4,c(1:6)])),mean(as.numeric(data[5,c(1:6)])), mean(as.numeric(data[6,c(1:6)])))
rownames(data) <- c("1", "2", "3", "4","sum","avg")
data
# sum average를 열에 추가
# sum average를 행에도 추가

data2 <- data[data$lee >= 90,]
data2
# 학생별 평균 점수가 87점 이상인 사람만 출력
data3 <- data[data[6,c(1:6)] >= 87, ]
data3


