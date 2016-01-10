<%--
  Created by IntelliJ IDEA.
  User: Jordy
  Date: 1-11-2015
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<table>
  <thead>
  <th>performer</th>
  <th>title</th>
  <th>voeg toe</th>
  </thead>
  <tbody>
  <c:forEach items="${all}" var="current">
    <tr>
      <td>
        <c:out value="${current.performer}"/>
      </td>
      <td>
        <c:out value="${current.title}"/>
      </td>
      <td>
        <a href="${pageContext.request.contextPath}/addTrack?playlistid=<%= request.getParameter("playlistid") %>&trackid=${current.trackId}" >Voeg toe aan playlist</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
