library(ggplot2)
mpgta <- table(mpg$class)
cc <- as.data.frame(mpgta)
cc
colnames(cc) <- c("CLASS", "CNT")
cc

ggplot(data=cc, aes(x=reorder(CLASS,CNT), y=CNT))+
  geom_col()


ggplot(data=mpg, aes(x=class))+
  geom_bar()
