<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/4
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${empdata}<br>
    ${empdata.totalRows}<br>
    ${empdata.totalPages}<br>

    <c:forEach items="${empdata.empList}" var="emp">
        ${emp.empno}-${emp.ename}-${emp.job}-${emp.sal}-${emp.hiredate}<br>
    </c:forEach>

</body>
</html>
