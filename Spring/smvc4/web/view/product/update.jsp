<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="center_page">
<h1>Proudct Update Page</h1>
<form action="proudctupdateimpl.mc" method="POST">
<table>
<tr><td>ID</td><td><input readonly="readonly" type="text" name="id" value="${p.id }"></td></tr>
<tr><td>PWD<td><input type="password" name="pwd"></td></tr>
<tr><td>NAME<td><input type="text" name="name"></td></tr>
<tr><td colspan="2"><input type="submit" name="UPDATE"></td></tr>
</table>
</form>



</div>