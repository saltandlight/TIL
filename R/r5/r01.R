library(ggplot2)
library(dplyr)
mpg1 <- as.data.frame(ggplot2::mpg)
head(mpg1)

#mpg1[mpg1$class %in% c("compact", "suv"),c("class","cty")]
aggregate(data=mpg, cty~class, mean)
mpg_diff <- mpg[mpg$class %in% c("compact","suv"),c("class","cty")]
table(mpg_diff$class)

t.test(data=mpg_diff, cty~class, var.equal=T)

table(mpg$fl)
mpg_diff2 <- as.data.frame(mpg[mpg$fl %in% c("r","p"),c("fl", "cty")])
table(mpg_diff2$fl)

t.test(data=mpg_diff2, cty ~ fl, var.equal=T)
str(mpg)
mpg$drv

# 고속연비: hwy ,  오토차량&수동차량: trans
mpg_diff3 <- mpg[,c("trans","hwy")]
table(mpg_diff3$trans)
aggregate(data=mpg_diff3,hwy ~ trans,mean)
t.test(data=mpg_diff3, hwy~trans, var.equal=T)

str(mpg)

#substr 쓰는 방법도 있음.
mpg_diff3$way <- ifelse(mpg_diff3$trans %in% c("manual(m5)","manual(m6)"), "M", "A")
str(mpg_diff3)

mpg_diff4 <- mpg_diff3[,c("way", "hwy")]
#mpg_diff4 <- as.data.frame(mpg_diff3[,c("way", "hwy")])
aggregate(data=mpg_diff4,hwy ~ way,mean)
t.test(data=mpg_diff4, hwy ~ way, var.equals=T)
















