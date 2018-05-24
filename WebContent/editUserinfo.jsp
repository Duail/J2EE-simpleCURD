<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Userinfo</title>
</head>
<body>
<h2>Edit Userinfo</h2>
<form action="updateUserinfo">
<table border=1, width=50%>
<tr>
<td>Id</td>
<td><input type="text" readonly="readonly" name="id" value="${userinfo.id}"></td>
</tr>
<tr>
<td>Name</td>
<td><input type="text" name="name" value="${userinfo.name}"></td>
<tr>
<td>Email</td>
<td><input type="text" name="email" value="${userinfo.email}"></td>
</tr>
<tr>
<td>Telephone</td>
<td><input type="text" name="telephone" value="${userinfo.telephone}"></td>
</tr>
<tr>
<td colspan="6" align="center"><input type="submit" value="OK"></td>
</tr>
</table>
</form>
</body>
</html>