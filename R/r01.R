head(iris)
str(iris)
str(Titanic)
Titanic
head(Titanic)

user <- read.csv("user.csv",
                 header=FALSE,
                 stringsAsFactors=TRUE,
                 na.strings = "NA",
                 encoding="EUC-KR")
colnames(user) <- c("ID","NAME","AGE","WEIGHT","HEIGHT")
user$NAME <- as.character(user$NAME)
str(user)

write.csv(
  user,
  file="user2.csv",
  row.names=FALSE,
  fileEncoding="UTF-8"
)
