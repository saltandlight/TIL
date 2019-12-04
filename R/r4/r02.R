wc3 <- function(){
  library(XML);  
  library(KoNLP);
  library(wordcloud);
  library(RColorBrewer);
  library(rvest);
  html1 <- htmlTreeParse(
    "http://hanatour.com",
    useInternalNodes = TRUE,
    trim=TRUE,
    encoding = "EUC-KR"
  );
  txt1 <- xpathSApply(html1,"//p",xmlValue);
  html2 <- htmlTreeParse(
    "http://modetour.com",
    useInternalNodes = TRUE,
    trim=TRUE,
    encoding = "UTF-8"
  );
  
  txt2 <- xpathSApply(html2,"//p",xmlValue);
  
  html3 <- htmlTreeParse(
    "http://www.tourcabin.com",
    useInternalNodes = TRUE,
    trim=TRUE,
    encoding = "UTF-8"
  );
  txt3 <- xpathSApply(html3,"//p",xmlValue);
  
  txt1 <- iconv(txt1,"UTF-8","EUC-KR");
  txt2 <- iconv(txt2,"UTF-8","EUC-KR");
  txt3 <- iconv(txt3,"UTF-8","EUC-KR");
  
  txt <- union(txt1,txt2);
  txt <- union(txt,txt3);
  nouns <- extractNoun(txt)
  
  c <- unlist(nouns);
  c <- as.character(c)
  
  numtxt <- Filter(function(x){ nchar(x) >=2 },c);
  numtxt <- gsub("[0-9]","",numtxt);
  numtxt <- gsub("[A-Z]","",numtxt);
  numtxt <- gsub("[a-z]","",numtxt);
  numtxt <- gsub("\\W","",numtxt);
  # 임시 저장
  write(unlist(numtxt),"text_temp.txt");
  # 테이블 형태로 읽어들이기
  numtable <- read.table("text_temp.txt");
  wcount <- table(numtable);
  # 테이블로 읽어들인 후 100번째까지 sort
  wcount <- head(sort(wcount,decreasing = T),100);
  
  palate <- brewer.pal(9,"Set1");
  jpeg("wc4.jpeg", width=600, height=500, quality=100)
  wordcloud(names(wcount),
            freq=wcount,
            scale=c(5,0,5),
            rot.per=0.35,
            min.freq=1,
            random.order=F,
            random.color=T,
            colors=palate
  );
  dev.off()
}

wc3()
