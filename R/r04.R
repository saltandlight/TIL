student <- read.csv("student2.csv",
                    header=TRUE,
                    encoding = "EUC-KR")
str(student)
student
View(student)
class(student[1,c(3:6)])

avg <- c(mean(as.numeric(student[1,c(3:6)])),
         mean(as.numeric(student[2,c(3:6)])),
         mean(as.numeric(student[3,c(3:6)])),
         mean(as.numeric(student[4,c(3:6)])),
         mean(as.numeric(student[5,c(3:6)])),
         mean(as.numeric(student[6,c(3:6)])),
         mean(as.numeric(student[7,c(3:6)])),
         mean(as.numeric(student[8,c(3:6)])))
student$AVGDATA <- avg
student
newst <- student[,c(2,7)]
newst

newst2 <- student[,c(3:6)]
newst2<-rbind(newst2,c(mean(newst2$KO),mean(newst2$EN),mean(newst2$MA),mean(newst2$SI)))
newst2 
newst3<-as.data.frame(
  mean(newst2$KO),
  mean(newst2$EN),
  mean(newst2$MA),
  mean(newst2$SI))
newst3


