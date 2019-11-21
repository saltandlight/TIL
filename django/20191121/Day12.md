# Day12

form 태그 -> 파일을 저장할 수 있는 모델 

- 이미지 업로드

- ```python
  urlpattenrs += 
  static(settings.MEDIA_URL, 
         document_root=settings.MEDIA_ROOT)
  ```

- d

  - 모델 하나에 직접 입력

  - models.py에 있는 model에는 

  - 기존 데이터가 있는데 새로운 칼럼 추가하면 안 됨

  - blank = true //null 대신에 빈 스트링으로 채우겠다는 뜻

  - image url 

  - 기존에 있던 거 날리면 새 칼럼에는 새로운 것이 들어있기 때문에 다시 돌리면 괜찮음.

    

