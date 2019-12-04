library(sqldf)
iris
head(iris)
str(iris)
result <- sqldf('select Species,avg("Sepal.Length"), 
                avg("Sepal.Width") 
                from iris group by Species')
result

tt <-  read.csv("titanic.csv",
                header=TRUE,
                stringsAsFactors = TRUE,
                na.strings = "NA")
str(tt)
head(tt)

result <- sqldf('select pclass, avg(survived) from tt group by pclass')
result

result <- sqldf('select pclass, sex, avg(survived) from tt
                group by pclass, sex
                having avg(survived)<0.5')
class(result)
result













