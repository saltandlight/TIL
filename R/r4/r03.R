library(kormaps2014)
library(dplyr)
library(ggplot2)
library(ggiraphExtra)



str(changeCode(korpop1))
head(changeCode(korpop1))

korpop1 <- rename(korpop1, pop=총인구_명, 
                name=행정구역별_읍면동)
str(changeCode(kormap1))

png("wc5.png", width=600, height=500)
ggChoropleth(data=korpop1,
             aes(fill=pop,
                 map_id=code,
                 tooltip=name),
             map=kormap1,
             interactive=T);
dev.off()
