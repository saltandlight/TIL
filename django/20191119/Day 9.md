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

관리자에 대해서 먼저 진행 

