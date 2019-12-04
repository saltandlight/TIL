#install.packages("RJDBC")
#install.packages("DBI")
#install.packages("rJava")
dd <- function(x,y){
  z <- x+y;
  return (z);
}

df <- function(){
  year <- c(2010,2011,2012,2013,2014);
  qt <- c(980,890,789,765,879);
  result <- data.frame(YEAR=year, QT=qt);
  return (result)
}

db <- function(){
  library(RJDBC);
  library(DBI);
  library(rJava);
  
  drv=JDBC(driverClass="oracle.jdbc.driver.OracleDriver",classPath="c:\\ojdbc6_g.jar");
  conn=dbConnect(drv,"jdbc:oracle:thin:@127.0.0.1:1521:XE","db","db");
  
  tuser<- dbGetQuery(conn, "select * from t_user")
  class(tuser)
  dbDisconnect(conn);
  
  return (tuser);
}

str(db())

