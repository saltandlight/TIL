#1. 요청을 보내기 위함
import requests
import json

url = "http://webtoon.daum.net/data/pc/webtoon/list_serialized/fri"

response = requests.get(url)

data=response.json()

print(data)
print(type(data))