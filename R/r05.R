st <- read.csv("student2.csv",
              header=TRUE,
              encoding = "EUC-KR")
stss <- apply(st[,c(3:6)], 2 , mean)
sts <- apply(st[,c(3:6)], 1 , mean)
names(sts) <- st[,2]
sts
class(stss)
class(sts)
dfstss <- as.data.frame(stss)
colnames(dfstss) <- "average"

df2 <- dfstss[order(dfstss$average),]
df2 <- sort(dfstss$average)
df2
colMeans(st[,c(3:6)])
rowMeans(st[,c(3:6)])

