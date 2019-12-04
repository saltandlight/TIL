h <- c(100,110,120,130,140,150,160,170,180,190)
w <- c(20,25,30,35,40,50,55,65,76,85)
mdata <- data.frame("H"=h, "W"=w)
str(mdata)

re <- cor.test(mdata$H, mdata$W)
if(re$p.value < 0.05){
  result <- lm(mdata$H~ mdata$W)
  print(result$coefficients)
}else{
  print("No data...")
}

