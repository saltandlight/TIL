<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="center_page">
<h1>User List</h1>
<c:forEach var="u" items="${userlist }" >
 <h3>
 <a href="userdetail.mc?id=${u.id }">${u.id }</a>
 ${u.name }
 </h3>
</c:forEach>
</div>