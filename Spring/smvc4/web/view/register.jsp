<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>지도 생성하기</title>
    
</head>
<style>
#map{
	width:80px;
	height:350px;
	margin:0 auto;
	padding-top: 30px;
	border: 2px solid orange;
}

</style>
<script>

$(document).ready(function(){
	$.ajax({
		url:'pdata.mc',
		success:function(){
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = { 
		        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		        level: 3 // 지도의 확대 레벨
		    };

		// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
		var map = new kakao.maps.Map(mapContainer, mapOption); 
		}
	});	
	
});
</script>
<div class="center_page">
<h1>Register Page</h1>
<!-- 지도를 표시할 div 입니다 -->
<div id="map" style="width:80%;height:350px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c086c64778b15b4da61eb12d979a9733"></script>
<script>



</script>
</div>


</html>