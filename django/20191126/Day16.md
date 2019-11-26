# Day 16

jquery를 쓰는 가장 큰 이유

- css 셀렉터를 쓰는 것이 굉장히 간편해짐

```javascript
$('#submitComment').click(function(){
    
});


//위의 아이보다 이 형태에 익숙해지는 것이 좋음
$('#submitCommet').on('click', function(){
    var input = $('#commentForm').val();
    
})
```

- JS, jQuery

  - 요소를 찾아서
  - 요소에 이벤트가 발생하는 것을 포착해서(EventListener)
  - 이벤트가 발생했을 때 어떤 로직을 실행할 지 결정(Event Handler)

- Ajax(Asynchronous javascript & Xml)

  - 비동기 자바스크립트 & XML

  - 실행은 다른 친구에게 맡겨놓고 그것이 완료되었다는 알림(CallBack)을 받아서 사용함

  - Callback(반드시등록을 해야함)

  - ```html
    <script>
    $(function(){
      $.ajax({
          url: '어느 주소로 요청을 보낼 지',
          method: '어떤 request method로 보낼지',
          date:{//얘 자체가 하나의 객체임
              key: '어떤 형태로 보낼지'
          },
          success: function(data){
              '요청이 성공적으로 완료되었을 때'
          },
          error:function(data){
             '요청이 정상적으로 완료되지 않았을 때' 
          }
      })  
    })
    </script>
    ```

  - 댓글 수정

    - 댓글 수정 버튼을 누른다.
    - 원래의 댓글 내용이 입력창에 들어간다.
    - 확인버튼을 누르면 수정한 내용이 반영됨.
      - 방법1- 확인 버튼에 속성을 추가해서 제출할 때, 해당 속성의 유무를 파악해 서로 다른 로직을 탈 수 있도록 함.
      - 방법2-수정할 때 Ajax로 제출하는 url 부분을 변수(HTML 속성)로 만들어서 처리

    

- Auth(User)

  - gem install devise
  - rails g devise:install

프로미스 기반 

**tip**

- 500에러는 개발자 책임
- 에러 해결하는 방법을 하나씩 알아가다보면 해결방식을 채택할 수 있고, 통찰이 생김

**이벤트 발생**

1. JS에 HTML 요소를 추가한 다음 Ajax로 서버에 요청을 보내서 실제 DB에 반영
2. Ajax로 서버에 요청을 보내 실제 DB에 반영된 후에는 JS로 실제 HTML 요소 추가(지금은 이걸 선택)

결과물 보내드리ㅣㄱ(해커톤)

sqlite 파일이랑 migrations 파일 밑에 숫자 밑에 있는 애들만 지우기 



submit -> 댓글 등록

JS(JQ), PYTHON 

$ajax({

   url: 

  method: 

  data: {

​		success: function(){

​         },

​	    error: function(){

​         }

​    }

})

ㅐㄴ가 정확한 위치로 요청을 보냈냐 

url에서 어떤 로직으로 도는지

그 쪽에서 요구하는 데이터의 형태가 어떻게 되는지

어떤어떤 이름으로 프론트에 있는 내용을 보내야 하는지



그 쪽에서 우리에게 날려준 data라는 아이

json으로 response를 보내주는 것

어떤 작동을 하는 지 이해하기



코드를 기계적으로 이해하지 말기

```참고사항
board_id는 댓글의 id였음.
등록을 할 때, 
아무데나 갖다 붙이는 게 아니라
article에 댓글을 갖다 붙여야 함

그래야 글을 여러 개 썼을 떄
code에서 데이터라는 속성을 사용하는 방법
data라는 속성의method라는 이름에 무언가를 넣을 수 있음.

뭘 모르는지 알고 있어야 함
어떤 질문으로 검색을 했는지 보여줘야 함


내일 좋아요랑 유저를 함 
오늘은 진도보다는 한 거 바탕으로 응용하여 
원래 댓글 기능 있어야 할 곳에 달아보기

12/12까지 종합프로젝트 진행함


ncs에도 업로드하기

워드로 

minified된 jquery 불러오기


댓글만 하자ㅑ 

입력창 

form 자체에 클래스 쥼
수정 ㅂ튼 누르면

내가 현재 누른 애 여ㅛㅍ에 있눈 애 찾아야 함(this이용)
data-comment라는 내용에 댓글을 그냥 넣는 경우도 있음

문제를 해결하려고 할 때 어떤 것을 찾아야 하는지


걍 article을 다 바구는 게 나을 것 같음

있는 기능인지 


기한은 내일 오전까지 

```

