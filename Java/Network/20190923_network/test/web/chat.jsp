<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<meta charset="EUC-KR">
<title>Insert title here</title>
<script>


function sendMsg(msg){
	alert(msg);
	$.ajax({
		url:'chat',
		data:{"msg":msg},
		success:function(data){
			$('#msg').val('');
		}
	});
}
function bt(){
	var msg = $('#msg').val();
	alert(msg);
	sendMsg(msg);
};
</script>
</head>
<body>
<h1>Chat Web Client</h1>


<input id="msg" type="text" name="msg">
<input id="bt" onclick="bt();" type="button" value="CHAT">



</body>
</html>