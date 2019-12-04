setting_1 <-function(){
  install.packages("readxl")
  install.packages("ggplot2")
  install.packages("dplyr")
  install.packages("plotly")
  install.packages("htmlwidgets")
  
  remove.packages(c("ggplot2", "data.table"))
  install.packages('Rcpp', dependencies = TRUE)
  library(Rcpp)
}

##common source
library(readxl)
library(ggplot2)
library(dplyr)
library(htmlwidgets)

sagyo2 <-read.csv("fin_data1.csv",
                  stringsAsFactors=F)
car2 <- read.csv("fin_data2.csv",
                 stringsAsFactors=F)
total <- left_join(car2, sagyo2, by="gu")
total <- total[order(total$jagayong, decreasing=T),]
str(total)
#setting_2 <- function(){
#  library(readxl)
#  library(ggplot2)
#  library(dplyr)
#  library(htmlwidgets)
  
#  sagyo2 <-read.csv("fin_data1.csv",
#                    stringsAsFactors=F)
#  car2 <- read.csv("fin_data2.csv",
#                   stringsAsFactors=F)
#  total <- left_join(car2, sagyo2, by="gu")
#  total <- total[order(total$jagayong, decreasing=T),]
#}

data_fee_car <- function(){
  
  return (total[,c("jagayong","sa_fee")])
  
}

data_qual_car <- function(){
  
  return (total[,c("jagayong","sa_qual")])
  
}


car_sa_qual_inter <- function(){
  library(plotly)
  p <- ggplot(data=total, aes(x=jagayong, y=sa_qual))+
    labs(x="Cars", y="Quality of Private Education")+ 
    geom_point(aes(colour=sa_qual))+
    scale_color_continuous(name="Quality of Private Education",
                          low="purple", high="orange")
  pp<- ggplotly(p)
  return (pp)
  #saveWidget(pp, file="inter_car_safee.html")
}


car_sa_fee <- function(){
  png(filename=x, width=600, height=500);
  print(ggplot(data=total, aes(x=jagayong, y=sa_fee))+
          labs(x="Cars", y="Fee of Private Education")+ 
          geom_point(aes(colour=sa_fee))+
          scale_color_continuous(name="Fee of Private Education",
                                 low="blue", high="purple"));
  dev.off();
}

cortest_qual <- function(){
  cor.test(total$jagayong, total$sa_qual)
}

cortest_fee <- function(){
  cor.test(total$jagayong, total$sa_fee)
}

rhive <- function(){
  library(RJDBC);
  library(DBI);
  library(rJava);
  hive_lib <- 'c:\\java_hive_lib';
  .jinit();
  .jaddClassPath(dir(hive_lib,full.names = T));
  .jclassPath();
  
  drv=JDBC(driverClass='org.apache.hive.jdbc.HiveDriver',
           'hive-jdbc-1.0.1.jar');
  conn=dbConnect(drv,"jdbc:hive2://70.12.114.216:10000",
                 "root","111111");
  
  cars=dbGetQuery(conn,"select * from cars");
  sagyouk = dbGetQuery(conn,"select * from sagyouk");
  
  dbDisconnect(conn);
  cars
  View(cars)
  sagyouk
  return (user);
}

