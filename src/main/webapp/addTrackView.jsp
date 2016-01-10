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
