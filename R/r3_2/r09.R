# class별 hwy 연비 평균을 그래프로 그려보기
library(ggplot2)
mpg2 <- aggregate(data=mpg, hwy~class, mean)
mpg2

ggplot(data=mpg2, aes(x=class, y=hwy))+
  ylim(0, 40)+
  geom_col()

head(economics)
str(economics)
tail(economics)

ggplot(data=economics, aes(x=date, y=unemploy))+geom_line()
ggplot(data=economics, aes(x=date, y=psavert))+geom_line()

library(foreign)
library(dplyr)
library(ggplot2)
library(readxl)

raw_welfare <- read.spss(file="Koweps_hpc10_2015_beta1.sav",
                         to.data.frame=T)
head(raw_welfare)


