<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="center_page">
<h1>User Add Page</h1>
<form enctype="multipart/form-data" action="productaddimpl.mc" method="POST">
<table>
<tr><td>NAME<td><input type="text" name="name"></td></tr>
<tr><td>PRICE</td><td><input type="text" name="price"></td></tr>
<tr><td>IMG<td><input type="file" name="mf"></td></tr>

<tr><td colspan="2"><input type="submit" name="REGISTER"></td></tr>
</table>
</form>



</div>