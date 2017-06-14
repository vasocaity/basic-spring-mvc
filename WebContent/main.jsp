<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>พยากรณ์อุณหภูมิของแต่ละจังหวัด</h1>
	<form action="ForecastController">
		<select name="prov">
			<%
				ArrayList<String> list = (ArrayList<String>) request.getAttribute("plist");
				for (int i = 0; i < list.size(); i++) {
					String p = list.get(i);
					out.println("<option value='" + p + "'>" + p + "</option>");
				}
				if(request.getParameter("prov") != null){
					out.println("<option value='" + request.getParameter("prov") + "' selected>" + request.getParameter("prov") + "</option>");
				}
			%>
		</select> <input type="submit" value="Submit">
	</form>
	<%
		if (request.getParameter("prov") != null) {
			String provice = (String) request.getAttribute("province");
			out.print("<br>จังหวัด" + provice+"<br>");
			ArrayList<Integer> tlist = (ArrayList<Integer>) request.getAttribute("tlist");
			for (int i = 0; i < tlist.size(); i++) {
				int t = tlist.get(i);
				out.println("Day " + (i + 1) + ":  " + t + "<br>");
			}
		}
	%>
</body>
</html>