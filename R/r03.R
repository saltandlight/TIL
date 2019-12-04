v1 <- c(1:10)
save(v1, file="v1.dat")
rm(list=ls())
# 값을 잠시 save 했다가 load함 
load("v1.dat")

x <- data.frame(id=c(1, 2), 
                name=c("a", "b"), 
                stringsAsFactors=F)
x$age <- c(20,30)
x

y <- rbind(x, c(1,"c",40))
y <- cbind(y,level=c(1,2,3), add=c(3,2,1), rate=c(1,2,3))
y
