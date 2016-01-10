<%--
  Created by IntelliJ IDEA.
  User: Jordy
  Date: 1-11-2015
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>Playlists</h2>
<table>
  <thead>
  <th>owner</th>
  <th>name</th>
  </thead>
  <tbody>
  <c:forEach items="${all}" var="current">
    <tr>
      <td>
        <c:out value="${current.owner}"/>
      </td>
      <td>
        <a href="${pageContext.request.contextPath}/viewPlaylist?playlistid=${current.playlistId}"><c:out value="${current.name}"/></a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<a href="http://localhost:8080">Ga terug</a>
</body>
</html>
