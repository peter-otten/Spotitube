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
<form method="GET" action="${pageContext.request.contextPath}/addTrack">
    Track: <input type="text" size="50" name="zoekterm">
    <input type="hidden" name="playlistid" value="<%= request.getParameter("playlistid") %>" />
  <input type="submit" value="zoeken">
  </form>
</body>
</html>
