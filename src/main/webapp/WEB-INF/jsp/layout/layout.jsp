<%-- 
    Document   : layout
    Created on : Oct 26, 2016, 11:38:52 AM
    Author     : giuliano.gimenez
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="d" uri="http://www.opensymphony.com/sitemesh/decorator" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Horta em Casa</title>
        <link rel="stylesheet" type="text/css" href="<c:url value='/ext/jquery-ui/jquery-ui-1.10.3.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/ext/bootstrap/css/bootstrap.min.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/ext/font-awesome-4.5.0/css/font-awesome.min.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/padrao.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/layout/layout.css'/>">
        
        <script type="text/javascript" src="<c:url value='/ext/jquery/jquery-2.1.4.min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/ext/jquery-ui/jquery-ui-1.10.3.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/ext/validate/jquery.validate.min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/ext/gritter/jquery.gritter.min.js'/>"></script>
    </head>
    <body>
        <div class="top">
            Horta em Casa
        </div>
        <div class="content">
            <d:body />
        </div>
    </body>
</html>
