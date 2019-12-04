n<- 100
f1 <- function(){
  m <-1
  return (m)
}

print(f1())

print(n)

list=ls()
print(list)
rm(list=ls())
print(list)


f1 <- function(){
  
  result <- c(10,20,30,40,50)
  return (result)
}