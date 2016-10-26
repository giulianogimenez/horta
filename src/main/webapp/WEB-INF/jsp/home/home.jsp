<%-- 
    Document   : home
    Created on : Oct 26, 2016, 11:50:01 AM
    Author     : giuliano.gimenez
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <c:forEach var="item" items="${plantas}">
            ${item.nome}<br>
        </c:forEach>
    </body>
</html>
