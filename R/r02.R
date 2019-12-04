useravg<- function(){
  user <- read.csv("user.csv", 
                   stringsAsFactors = FALSE,
                   header=FALSE,
                   encoding="EUC-KR")
  str(user)
  user$V5 <- as.integer(user$V5)
  user2<- data.frame(mean(user$V3), mean(user$V4, na.rm=TRUE), mean(user$V5, na.rm=TRUE))
  colnames(user2) <- c("age", "weight", "height")
  user2
  write.csv(
    user2,
    file="useravg.csv",
    row.names=FALSE,
    fileEncoding="UTF-8"
  )
  return (user2)
}


useravg()


