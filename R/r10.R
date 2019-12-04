d1 <- c(10,20,30,40,NA)
# NA 좀 삭제해라 
print(sum(d1, na.rm=TRUE))
d1 <- c(10,20,30,40,NULL)
# NULL: 데이터 없는 걸로 치자 
print(sum(d1))

f1 <- function(a){
  return (100+a);
  #괄호를 항상 닫아줘야 함.
}
result <- f1(200.11)
print(result)

f1 <- function(...){
  args <- list(...)
  for(i in args){
    print(i)
  }
}

f1(c(1,2,3,4,5,6,7,8,9,10))
f1(c(1:100))

# 짝수의 값들만 합을 구해서 리턴하기 
f2 <- function(args){
  sum =0;
  for(i in args){
    print(i)
    if(i %% 2 == 0){
      sum = sum+i;
    }
  }
  return (sum);
}


f2(c(100:1000))

f3 <- function(...){
  args <- list(...)
  sum <- 0
  for(i in (...)){
    if(i %% 2 == 0){
      sum = sum+i;
    }
  }
  return (sum);
}

f3(c(100:1000))




