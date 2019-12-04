library(KoNLP)
library(dplyr)
library(stringr)

txt <- readLines("hiphop.txt")
head(txt)
txt <- str_replace_all(txt, "\\W", " ")
nouns <- extractNoun(txt)
cnt <- table(unlist(nouns))
# nouns는 list이므로 unlist해서 table로 바꿔줌
df_cnt <- as.data.frame(cnt, stringsAsFactors=F)
# vector로 바꿔서 받겠다.
colnames(df_cnt) <- c("word", "freq")
# column 이름을 바꿔주기
head(df_cnt)
str(df_cnt)
df_word <- filter(df_cnt, nchar(word) >= 2)
df_word

top_20 <- df_word %>% 
  arrange(desc(freq)) %>% 
  head(20)
top_20

library(wordcloud)
library(RColorBrewer)

pal <- brewer.pal(8, "Dark2")

set.seed(1234)
png("wordcloud_hiphop.png", width=600, height=500)

wordcloud(words=df_word$word,
          freq=df_word$freq,
          min.freq=2,
          max.words=200,
          random.order=F,
          rot.per=.1,
          scale=c(4,0.3),
          colors=pal)
dev.off()

## 10-2. 국정원 트윗 텍스트 마이닝
twitter <- read.csv("twitter.csv",
                    header=T,
                    stringsAsFactors = F,
                    fileEncoding="UTF-8")
View(twitter)

# 변수명 수정
twitter <- rename(twitter, 
                  no=번호,
                  id=계정이름,
                  date=작성일,
                  tw=내용)
head(twitter$tw)

# 특수문자 제거
twitter$tw <- str_replace_all(twitter$tw, "\\W", " ")
head(twitter$tw)

#트윗에서 명사 추출
nouns <- extractNoun(twitter$tw)

#추출한 명사 list를 문자열 벡터로 변환, 빈도표
nouns
wordcount <- table(unlist(nouns))
head(wordcount)

#데이터 프레임으로 변환
df_word <- as.data.frame(wordcount, stringsAsFactors = F)
str(df_word)
# 변수명 수정
df_word <- rename(df_word,
                  word=Var1,
                  freq=Freq)
head(df_word)

# 두 글자 이상 단어만 추출
df_word <- filter(df_word, nchar(word)>=2)

# 상위 20개 추출
top20<- df_word %>% 
  arrange(desc(freq)) %>% 
  head(20)
top20

# 단어 빈도 막대 그래프 만들기
library(ggplot2)
order <- arrange(top20, freq)$word

png("plot1.png", width=600, height=500)
ggplot(data=top20, aes(x=word, y=freq))+
  ylim(0, 2500)+
  geom_col()+
  coord_flip()+
  scale_x_discrete(limit = order)+
  geom_text(aes(label=freq), hjust=-0.3)

dev.off()

pal <- brewer.pal(8,"Dark2")
set.seed(1234)

png("plot2.png", width=600, height=500)
wordcloud(words=df_word$word,
          freq=df_word$freq,
          min.freq=10,
          max.words=200,
          random.order=F,
          rot.per=.1,
          scale=c(6,0.2),
          colors=pal)
dev.off()

















