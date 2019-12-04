# 150page Q1
library(ggplot2)
mpg1<- mpg
mpg2 <-aggregate(data=mpg1,cty~class, mean)

# Q2
mpg2[order(mpg2$cty, decreasing=T), ]

# Q3
mpg3 <- aggregate(data=mpg1,hwy~manufacturer,mean)
head(mpg3, 3)

# Q4
mpg4 <- mpg1 %>% 
        filter(class=="compact") %>% 
        group_by(manufacturer) %>% 
        summarise(n=n()) %>% 
        arrange(desc(n))

mpg4
mpg4 <- mpg1[mpg1$class=="compact",]
#mpg4[order(mpg4 decreasing=T), ]
mpg5 <- as.data.frame(table(mpg4$manufacturer))
mpg5
mpg5[order(mpg5$Freq, decreasing=T),]

table(mpg)
mpg
table(mpg$class)
