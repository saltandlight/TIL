library(ggplot2)
economics

qplot(economics$unemploy, economics$pce)
ggplot(data=economics, aes(x=unemploy, y=pce))+geom_point()
re <- cor.test(economics$unemploy, economics$pce)
if(re$p.value <0.05){
  result = lm(economics$pce~economics$unemploy)
  class(result$coefficients)
}else{
  print("아닙니다")
}




