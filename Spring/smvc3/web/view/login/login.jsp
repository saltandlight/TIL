<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="center_page">
<h1>Login Page</h1>
<form action="loginimpl.mc" method="POST">
<table>
<tr><td>ID</td><td><input type="text" name="id"></td></tr>
<tr><td>PWD<td><input type="password" name="pwd"></td></tr>
<tr><td colspan="2"><input type="submit" name="LOGIN"></td></tr>
</table>
</form>



</div>