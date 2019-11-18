<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<div class="center_page">
<h1>User Detail Page</h1>


<h5>${userdetail.id }</h5>
<h5>${userdetail.pwd }</h5>
<h5>${userdetail.name }</h5>
<a href="userdelete.mc?id=${userdetail.id }">DELETE</a>
<a href="userupdate.mc?id=${userdetail.id }">UPDATE</a>

</div>


