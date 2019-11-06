#1. 요청을 보내기 위함
import requests

url = "http://webtoon.daum.net/data/pc/webtoon/list_serialized/fri"

response = requests.get(url)
#4. 응답의 내용을 출력한다. 
print(response.text)

