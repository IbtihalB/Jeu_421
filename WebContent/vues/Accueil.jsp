<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<img src="/getImage.action?imageId=${id_of_the_image}"/>

<p>in the  mapped to /getImage.action:
get the ID of the image from the request parameters
String imageId = request.getParameter("imageId");
byte[] imageData = getImageFromDatabase(imageId);
response.setContentType("image/");
response.getOutputStream().write(imageData);</p>
<% String variable=(String)request.getAttribute("personne");%>
<%= variable%>	         

</body>
</html>