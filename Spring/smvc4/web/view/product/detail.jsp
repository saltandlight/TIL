<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<style>
img{
	width:180px;
	height:200px;
	
}

</style>

<div class="center_page">
<h1>Product Detail Page</h1>
<h5><img src="img/${productdetail.imgname }" ></h5>
<h5>name: ${productdetail.name }</h5>
<h5>price: ${productdetail.price }</h5>
<h5>regdate: ${productdetail.regdate }</h5>

<a href="productdelete.mc?id=${productdetail.id }">DELETE</a>
<a href="productupdate.mc?id=${productdetail.id }">UPDATE</a>

</div>


