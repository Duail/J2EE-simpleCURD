<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list userinfo</title>
<script type="text/javascript">
function beSure() {
	if (confirm("确认删除？")) {
		return true;
	}
	return false;
}
</script>
</head>
<body>
<h1>Demo First111</h1>
<form action="addUserinfo">
<table border=0, width=50%>
<tr>
<th>Add:</th>
<th><input type="text" name="name" value="name"></th>
<th><input type="text" name="email" value="email"></th>
<th><input type="text" name="telephone" value="telephone"></th>
<th><input type="submit" value="add"></th>
</tr>
</table>
</form>
<br />
<table border=1, width=100%>
<tr>
<th>Id</th>
<th>Name</th>
<th>Email</th>
<th>Telephone</th>
<th>Update</th>
<th>Delete</th>
</tr>
<c:forEach items="${userinfos}" var="userinfo">
<tr>
<td>${userinfo.id}</td>
<td>${userinfo.name}</td>
<td>${userinfo.email}</td>
<td>${userinfo.telephone}</td>
<td><a href="editUserinfo?id=${userinfo.id}">update</a></td>
<td><a href="deleteUserinfo?id=${userinfo.id}" onclick="return beSure()">delete</a></td>
</tr>
</c:forEach>
<tr>
<td colspan="6" align="center">
<a href="?start=0">[first]</a>
<b>&emsp;</b>
<a href="?start=${pre}">[pre]</a>
<b>&emsp;</b>
<a href="?start=${next}">[next]</a>
<b>&emsp;</b>
<a href="?start=${last}">[last]</a>
</td>
</tr>
</table>
</body>
</html>