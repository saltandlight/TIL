#1. 요청을 보내기 위한 requests 모듈을 import한다
import requests
#2. url의 주소를 저장한다.
url2 = "https://ticket.melon.com/common/ajax/offer"
url="https://ticket.melon.com/offer/ajax/offerList.json?offerPosType=MAIN_B_CO_3"
#3. 요청을 보내고 응답을 변수에 저장한다.
headers = {
  'User-Agent': 'Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.87 Mobile Safari/537.36'
}
response=requests.get(url)
#4. 변수에 저장된 내용을 출력한다.
print(response.text)
