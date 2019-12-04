sort(mpg[mpg$manufacturer=="audi", "hwy"],decreasng=FALSE, na.last=NA)
mpg[mpg$manufacturer=="audi",]

audi <- mpg[mpg$manufacturer=="audi", ]
a <- audi[order(audi$hwy, decreasing=T),]
a2 <- head(a, 5)
a2

head(mpg %>% filter(manufacturer=="audi") %>% arrange(desc(hwy)),5)