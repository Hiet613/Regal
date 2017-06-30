<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
<title>Welcome２</title>
</head>
<body>
    <h1>管轄を選択してください</h1>
    <form:form modelAttribute="testForm" >
<%--         ID:<form:input path="id" />



		<form:select  path="id" items="${address}" var="address" itemValue="id" >
		<c:out value="${address.name}"></c:out>

		</form:select>
		 <input type="submit" />

        <c:forEach items="${address}" var="address">
            <p><c:out value="${address.id}"></c:out>:<c:out value="${address.address}"></c:out>
            </p>
        </c:forEach>
 --%>
	 <form:select path="id">
		 <form:options items="${selectAddress}" />
	 </form:select>
	 <input type="submit" />

    </form:form>

</body>
</html>