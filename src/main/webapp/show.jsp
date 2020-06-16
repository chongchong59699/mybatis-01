<%--
  Created by IntelliJ IDEA.
  User: 59699
  Date: 2020/6/15
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px" cellspaceing="0px" cellpadding="10px"
style="margin: auto;">
    <tr>
        <td>id</td>
        <td>username</td>
        <td>password</td>
        <td>phone</td>
        <td>mail</td>
    </tr>
<c:forEach items="${pageInfo.list}" var="list">
    <tr>
        <td>${list.id}</td>
        <td>${list.username}</td>
        <td>${list.password}</td>
        <td>${list.phone}</td>
        <td>${list.mail}</td>
    </tr>
</c:forEach>
    <tr>
        <td colspan="5" align="center">
            <c:forEach items="${pageInfo.navigatepageNums}" var="num">
                <a href="${pageContext.request.contextPath}/showUserByPageServlet?pageNum=${num}">${num}</a>
            </c:forEach>
        </td>
    </tr>
</table>
</body>
</html>
