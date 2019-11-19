# Day8

- 어제 했던 것들

  - Naver api 사용해보기
    - 외부 사이트에 Request를 보낼 때, Post 방식으로 요청하는 방법을 알았음.
    - Request Body 에 단순히 파라미터명과 파라미터 값으로 이루어진 쌍이 아니라 json 형식으로 파라미터를 보내는 방법
  - ORM 기초
    - Create, Read를 Django Shell에서 실행시켜보기
    - ORM(Object Realationship Mapping)이 무엇인지? 왜 사용해야 하는지?

- 오늘 해야할 것들

  - 기본 게시판 만들기

    - URL 분리하기 

      - urls.py에 우리가 접속할 모든 주소를 명시했는데, CRUD 를 하다보면 만들어야 할 페이지가 점점 많아서 구분하기가 어려워지기 때문에 각 역할을 하는 App마다 `urls.py`파일을 생성할 예정

    - 공용으로 사용할 수 있는(공유할 수 있는) HTML 파일 만들기

      - 반복되는 HTML 구조를 계속해서 새로 만들지 말고 공통되는 부분은 하나의 파일로 묶어서 반복해서 사용하도록 함. 

    - CRUD 계속

      C- new, create
      R- index show
      U- update
      D- destroy

    - `python manage.py makemigrations`:  구조를 잡아주는 내용이 있음. 

    - `python manage.py migrate`: 동작시키는 것

- 외주받는 사이트

  - 프리랜서
    크몽
    위시캣

- Trello는 기본적인 기능만 제공함: 보드 내의 카드를 다른 채널의 보드와 공유 불가

  ​														  기능들이 한정되어 있음, 데이터베이스 관리 어려움

  ​															Attlassian 

- Jira Software; 규모가 큰 기업에서 많이 씀

- Notion:  여기는 나만의 게시판이라 괜찮음 

  ​			   혼자도 무료로 사용 가능

  ​			   학교 계정 살아있으면 사용해보기 

- 포트폴리오 제출 방법: 깃허브 페이지

- GET 방식으로 해서 만들어보기