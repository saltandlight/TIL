head(iris)
iris
irisr <- apply(iris[,c(1:4)],1, mean)
irisr2 <- colMeans(iris[,c(1:4)])
irisr2

siris <- sapply(iris[,c(1:4)], mean)
class(siris)
siris

tapply(iris$Sepal.Length, iris$Species, mean)
