from django.shortcuts import render
import requests
from bs4 import BeautifulSoup

# Create your views here.
def opgg(request):
    # 소환사명을 입력할 입력창을 만든다.
    return render(request, 'opgg.html')


def result(request):
    # 실제 op.gg를 크롤링해서 입력된 소환사에 대한   
    name=request.GET['nickname']
    url=f'https://www.op.gg/summoner/userName={name}'
    response=requests.get(url)
    html = BeautifulSoup(response.text, 'html.parser')
    if html.select_one('span.WinLose .wins') is None:
        result = {
            'msg':'소환사가 없거나 언랭입니다.'
        }
    else:
        result={
            'name':name,
            # 값이 없다? 소환사가 없거나 unlang입니다.라는 결과를 뽑아줌
            'win':html.select_one('span.WinLose .wins').text,
            'lose':html.select_one('span.WinLose .losses').text,
            'ratio':html.select_one('span.WinLose .winratio').text
        }

    # 전적 정보를 가져온다.
    return render(request, 'opgg/result.html', result) 