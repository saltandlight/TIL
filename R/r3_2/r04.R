#123page prob1
library(ggplot2)
mid1 <- as.data.frame(midwest)
str(mid1)

# prob2
mid2 <- rename(mid1, total=poptotal, asian=popasian)
str(mid2)

# prob3
mid2$asianperc <- (mid2$asian/mid2$total)*100
hist(mid2$asianperc)

# prob4
mid2$asiandensity <- ifelse(mid2$asianperc > mean(mid2$asianperc),"large","small")
mid2$asiandensity

# prob5
table(mid2$asiandensity)
qplot(mid2$asiandensity)
