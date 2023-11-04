<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <form:form modelAttribute="u" action="register" method="post">
   <form:label path="name">Name</form:label>
   <form:input path="name"/>
   <form:label path="phone">Phone</form:label>
   <form:input path="phone"/>
   <form:label path="email">Email</form:label>
   <form:input path="email"/>
   <form:label path="age">Age</form:label>
   <form:input path="age"/>
   <form:label path="password">Password</form:label>
   <form:input path="password"/>
   <form:button>Register</form:button>
   </form:form>
</body>
</html>