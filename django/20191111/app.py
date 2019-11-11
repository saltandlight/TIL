from flask import Flask, request, render_template, redirect, url_for
import requests
import json

app = Flask(__name__)

@app.route('/naver')
def fake_naver():
    return render_template('naver.html')

@app.route('/naver/search')
def fake_naver_search():
    # 검색 로직
    query = request.args.get('query')

    return render_template('search.html', q=query)

@app.route('/login')
def login_form():
    # 아이디 입력창, 패스워드 입력창, 로그인 버튼
    return render_template('login.html')


#GET 방식만 받겠다. 다른 걸로 하려면 추가적으로 설정을 해라 
@app.route('/login/submit', methods=['POST'])
def login():
    # 아이디를 조회하고, 해당 row의 비밀번호가 일치하는지 확인
    # 로그인 로직
    
    #return render_template('success.html')
    return redirect(url_for('main'))

@app.route('/main')
def main():
    return '로그인에 성공하셨습니다. 메인페이지입니다.'

# 1. 전체 요일 적혀있는 페이지
@app.route('/')
def index():
    days = {
        '월요일':'mon',
        '화요일':'tue',
        '수요일':'wed',
        '목요일':'thu',
        '금요일':'fri',
        '토요일':'sat',
        '일요일':'sun',
    }

# 2. 각 요일에 대한 데이터 요청하는 곳
    # @app.route('/<day>')
    # def day_webtoon_list(day):
    #     url = f'http://webtoon.daum.net/data/pc/webtoon/list_serialized/{day}?'
    #     response = requests.get(url)
    #     data=response.get(url).get("data")
    #     webtoon_list=[]
    #     for toon in data:
    #         webtoon_title=toon["title"]
    #         webtoon_nickname=toon["nickname"]
    #         webtoon_introduction=toon["introduction"]
    #         webtoon_artists=[]
    #     for ar in toon["cartoon"]["artists"]:
    #         webtoon_artists.append(ar["name"])
    #         webtoon_data[webtoon_title]=[webtoon_nickname, webtoon_introduction, ",".join(webtoon_artists)]
    #     return response.json()
    # return render_Template('day_webtoon_list.html', days=days)
# 3. 각 웹툰에 대한 세부 데이터 요청하는 곳(받는 곳과 동의어)

@app.route('/toon/<nickname>')
def webtoon_info(nickname):
    url=f'http://webtoon.daum.net/webtoon/view/{nickname}'
    return requests.get(url).json()

