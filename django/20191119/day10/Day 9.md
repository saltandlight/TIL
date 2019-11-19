# Day9

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

| 역할   | Request Method | End-point             | Views(Function) |
| ------ | -------------- | --------------------- | --------------- |
| Create | GET            | /articles/new         | new             |
| Create | POST           | /articles/create      | create          |
| Read   | GET            | /articles/<id>        | show            |
| Read   | GET            | /articles/            | index           |
| Update | GET            | /articles/<id>/edit   | edit            |
| Update | POST           | /articles/<id>/       | update          |
| Delete | POST(DELETE)   | /articles/<id>/delete | delete          |

- GET-> 조회

- POST -> DB에 반영

  created_at.strftime("%Y-%m-%d")

관리자에 대해서 먼저 진행 

