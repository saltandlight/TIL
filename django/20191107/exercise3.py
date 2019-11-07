#1. 요청을 보내기 위함
import requests
import json

day=["mon", "tue","wed","thu","fri","sat","sun"]
daily_toon_data = {}
cart=[]

#3.다음 웹툰의 금요일 웹툰 전체의 리스트 중에서 각 웹툰의 제목, 설명, 작가 이름, 장르만 골라 
#새로운 dictionary를 만들고 이 dictionary  담고 있는 list를 만드세요 



for d in day:
    url = f'http://webtoon.daum.net/data/pc/webtoon/list_serialized/{d}'
    data=request_json_data_from_url(url)
    daily_toon_data[day]=parse_daum_webtoon_data(data)
print(daily_toon_data)    



def request_json_data_from_url(url):
    response = requests.get(url)
    data=response.json()
    return data

def parse_daum_webtoon_data(data):
    toons = []
    #print(url)
    for toon in webtoon_data:
        # 제목의 key는 title
        title = toon["title"]

    # 설명의 key는 introduction
        desc = toon["introduction"]

    # 장르의 위치는 'cartoon' 안에 'genre'라는 리스트 안에 'name'이라는 키 
        genres=[]
        for g in toon["cartoon"]["genres"]:
            genres.append(g["name"])
   
        artists=[]
        for artist in toon["cartoon"]["artists"]:
            artists.append(artist["name"])
    
    # 썸네일 이미지의 위치 
        img_url=toon["pcThumbnailImage"]["url"]

       tmp={
           title:{
               "desc":desc,
               "writer":artists,
               "img_url":img_url
           }
        }
        toons.append(tmp)
    return toons
