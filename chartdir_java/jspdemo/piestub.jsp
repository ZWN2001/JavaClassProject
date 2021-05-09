<!DOCTYPE html>
<html>
<head>
    <title>Simple Clickable Pie Chart Handler</title>
</head>
<body style="margin:5px 0px 0px 5px">
<div style="font:bold 18pt verdana;">
    Simple Clickable Pie Chart Handler
</div>
<hr style="border:solid 1px #000080" />
<div style="font:10pt verdana; margin-bottom:20px">
    <a href="viewsource.jsp?file=<%=request.getServletPath()%>">View Source Code</a>
</div>
<div style="font:10pt verdana;">
<b>You have clicked on the following sector :</b><br />
<ul>
    <li>Sector Number : <%=request.getParameter("sector")%></li>
    <li>Sector Name : <%=request.getParameter("label")%></li>
    <li>Sector Value : <%=request.getParameter("value")%></li>
    <li>Sector Percentage : <%=request.getParameter("percent")%>%</li>
</ul>
</div>
</body>
</html>
