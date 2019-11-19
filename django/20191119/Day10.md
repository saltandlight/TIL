# Day10

- `pip install pylint`
- `pip install pyling-django`
- `django-admin startproject crudtest`
- `cd crudtest`
- `python manage.py startapp articles`
- url name space 설정하기 
- RESTFUL 한 API 설계하기 
- Django Admin 설정하기 
- created_at, updated_at 필드 설정하기 
  - DateTimeField 

### URL namespace

- 각각의 url에 별명을 지어줘서 html 파일에서 사용하는 링크를 추가적으로 바꾸지 않고urls.py에서만 수정하면 html 파일에서도 링크 수정이 반영되도록 함. 

### RESTful api

| 역할   | Request Method                                               | End-point             | Views(Function) | 기존 역할    |
| ------ | ------------------------------------------------------------ | --------------------- | --------------- | ------------ |
| Create | GET                                                          | /articles/new         | new             | 새 글 form   |
| Create | POST                                                         | /articles/new         | new             | 새 글 작성   |
| Read   | GET                                                          | /articles/<id>        | show            | 글 하나 보기 |
| Read   | GET                                                          | /articles/            | index           | 전체 리스트  |
| Update | GET                                                          | /articles/<id>/edit   | edit            | 수정 form    |
| Update | POST                                                         | /articles/<id>/       | edit            | 수정 반영    |
| Delete | POST(DELETE) -> GET방식 사용함 (왜냐하면 a태그는 GET 방식으로만 요청 가능해서임.) | /articles/<id>/delete | delete          | 삭제         |

- GET-> 조회

- POST -> DB에 반영

  created_at.strftime("%Y-%m-%d")
  
- 관리자에 대해서 먼저 진행 

- DB에 실제로 어떤 데이터가 반영이 되는 것은 POST라는 것을 주로 사용함.

- POST 같은 경우는 실제 DB에 데이터를 변경할 수 있도록 약속해놓은 부분

- POST 로 하면 csrf_token을 활용하게 됨(우리의 어플리케이션과 맞지 않으면 csrf_token 에러라고 뜸)

- 요청을 파라미터로 넘겨주게 되면 할 수 있음

- csrf_token이라는 것은 기초적인 방법으로 다른 사이트에서 우리 사이트로 위조해서 보내는 것을 방지하는 가장 기본적인 내용

- method에 따라서 같은 메서드를 실행하게 되는데 실행할 떄 request method가 POST냐 GET이냐에 따라 다른 것을 불러옴
