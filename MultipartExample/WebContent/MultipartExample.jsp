<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Magic tool</title>
</head>
<body>
    <h1>Multipart form example</h1>
    <form action="MultipartExampleServlet" method="post" enctype="multipart/form-data">
    	<div style="padding-bottom: 2%;">
	    	Proyect name: <input type="text" name="projectName" size="20">
	    </div>
	    <div style="padding-bottom: 2%;">
	    	Git repository: <input type="text" name="gitRepository" size="20">
	    </div>
	    <div style="padding-bottom: 2%;">
	    	File: <input type="file" name="arisFile" size="50" />
	    </div>
	    <div>
	    	<input type="submit" value="GO" />
	    </div>
	</form>
</body>
</html>