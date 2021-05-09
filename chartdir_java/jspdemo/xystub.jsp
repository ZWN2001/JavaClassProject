<!DOCTYPE html>
<html>
<head>
    <title>Simple Clickable XY Chart Handler</title>
</head>
<body style="margin:5px 0px 0px 5px">
<div style="font:bold 18pt verdana;">
    Simple Clickable XY Chart Handler
</div>
<hr style="border:solid 1px #000080" />
<div style="font-size:10pt verdana; margin-bottom:20px">
    <a href="viewsource.jsp?file=<%=request.getServletPath()%>">View Source Code</a>
</div>
<div style="font:10pt verdana;">
<b>You have clicked on the following chart element :</b><br />
<ul>
    <li>Data Set : <%=request.getParameter("dataSetName")%></li>
    <li>X Position : <%=request.getParameter("x")%></li>
    <li>X Label : <%=request.getParameter("xLabel")%></li>
    <li>Data Value : <%=request.getParameter("value")%></li>
</ul>
</div>
</body>
</html>
