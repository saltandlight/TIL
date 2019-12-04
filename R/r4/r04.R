install.packages("plotly")
library(plotly)

library(ggplot2)
str(mpg)
p <- ggplot(data=mpg, aes(x=displ, y=hwy, col=drv))+geom_point()
jpeg("wc5.jpeg", width=600, height=500, quality=100)
ggplotly(p)
dev.off()

str(diamonds)
p <- ggplot(data=diamonds, aes(x=cut, fill=clarity))+
  geom_bar(position="dodge")
ggplotly(p)

install.packages("dygraphs")
library(dygraphs)

economics <- ggplot2::economics
head(economics)
# 시계열 그래프를 만들 때는 시간 순서 속성을 지니는
# xts 타입으로 데이터가 되어 있어야 함.
library(xts)
eco <- xts(economics$unemploy, order.by=economics$date)
head(eco)

dygraph(eco)
dygraph(eco) %>% dyRangeSelector()

eco_a <- xts(economics$psavert, order.by=economics$date)
eco_b <- xts(economics$unemploy/1000, order.by= economics$date)

eco2 <- cbind(eco_a, eco_b)
colnames(eco2) <- c("psavert", "unemploy")
head(eco2)

dygraph(eco2) %>% dyRangeSelector()

