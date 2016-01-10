<%--
  Created by IntelliJ IDEA.
  User: Jordy
  Date: 1-11-2015
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>
<form method="GET" action="${pageContext.request.contextPath}/addPlaylist">
  Playlist naam: <input type="text" size="50" name="name">
  <input type="submit" value="Toevoegen">
</form>
</body>
</html>
