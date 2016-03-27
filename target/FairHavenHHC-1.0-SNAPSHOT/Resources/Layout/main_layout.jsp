<%-- 
    Document   : main_layout
    Created on : Nov 12, 2014, 6:09:50 PM
    Author     : Sam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<c:set var="context" value="${pageContext.request.contextPath}" scope="session"/>

<html>
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="${context}/images/favicon.ico">

        <title><tiles:getAsString name="title" /></title>

        <!-- Bootstrap core CSS -->
        <link href="${context}/css/base.css" rel="stylesheet">


        <!-- Just for debugging purposes. Don't actually copy this line! -->
        <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>
    <body>
        <header class="page-header">
            <tiles:insertAttribute name="header" />
        </header>
        <main class="page-main">
            <tiles:insertAttribute name="content" />
        </main>
        <footer class="page-footer">
            <tiles:insertAttribute name="footer" />
        </footer>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type='text/css'/>

        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="${context}/scripts/materialize.min.js"></script>
        <script type="text/javascript" src="${context}/scripts/main.js"></script>
        <script type="text/javascript" src="${context}/scripts/jquery-mask-plugin-min.js"></script>
        <script type="text/javascript" src="${context}/scripts/input-mask.js"></script>

    </body>
</html>