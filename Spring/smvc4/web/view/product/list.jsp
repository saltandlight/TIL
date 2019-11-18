<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
.center_page > img{
	width: 80px;
	height: 80px;
}

</style>


<div class="center_page">
<h1>Product List</h1>
<c:forEach var="p" items="${plist }">
<h5><a href="productdetail.mc?id=${p.id }"><img src="img/${p.imgname }" width="80px" height="100px"> ${p.name } ${p.price }</a></h5>
</c:forEach>
</div>
