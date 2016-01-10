<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>Tracks</h2>
<table>
  <thead>
  <th>performer</th>
  <th>title</th>
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
    </tr>
  </c:forEach>
  </tbody>
</table>
<a href="${pageContext.request.contextPath}/addTrack?playlistid=<%= request.getParameter("playlistid") %>">Voeg track toe</a>
<a href="${pageContext.request.contextPath}/viewPlaylist">Ga terug</a>
</body>
</html>
