from django.shortcuts import render
import random
from bs4 import BeautifulSoup
import requests

# Create your views here.
# 무조건 첫째 파라미터는 request가 되어야 함
def lotto(request):

    return render(request, 'lotto.html')

def winning(request):
    # 1. 1~45까지의 숫자 중에 n개의 숫자를 랜덤 추출
    # 1-1.  1~45까지의 번호를 가진 배열을 만들기
    num_list = list(range(1,46))
    num_count = request.GET['count']
    #무조건 던지는 애는 다 스트링임(문자열로 인식)

    # 1-2. 해당 배열에서 count만큼의 숫자를 샘플링
    result = random.sample(num_list, int(num_count)) 
    result.sort()
    # 2. 로또 당첨번호 공개 사이트로 가서 지난 주 당첨번호 가져오기
    # - 몇회차인지, 언제 당첨번호인지, 1등 당첨금이 얼마인지
    url='https://dhlottery.co.kr/gameResult.do?method=byWin'
    response = requests.get(url)
    html = BeautifulSoup(response.text, 'html.parser')
    winning_numbers = html.select('div.win span')
    winning_count = 0
    winning_list = []

    for number in winning_numbers:
        # result list 변수에 number가 포함되어 있나요?
        # element가 list에 들어있는 지 확인하는 것
        winning_list.append(int(number.text))
        if int(number.text) in result:
            winning_count +=1 

    return render(request, 'winning.html', {'result':result,
                                            'winning_list':winning_list,
                                            'winning_count':winning_count})
