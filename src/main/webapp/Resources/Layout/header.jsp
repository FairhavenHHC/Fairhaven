<%-- 
    Document   : header
    Created on : Nov 12, 2014, 6:09:59 PM
    Author     : Sam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="navbar-fixed ">
    <ul id="dropdown1" class="dropdown-content">
        <c:choose>
            <c:when test="${!null}">
                <li>
                    <a href="admin.htm"><i class="fa fa-user fa-fw"></i>  </a>
                </li>
            </c:when>
            <c:otherwise>
                <li>
                    <a href="logout.htm">Logout</a>
                </li>
            </c:otherwise>
        </c:choose>
    </ul>
    <nav>
        <div class="nav-wrapper ">
            <div class="container">
                <!--<a href="index.htm" class="brand-logo medium">Fairhaven HHC</a>-->
                <a href="#" data-activates="mobile-menu" class="button-collapse"><i class="material-icons">menu</i></a>
                <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li><a href="index.htm" class="text-capitalize">Home</a></li>
                    <li><a href="services.htm" class="text-capitalize">Services</a></li>  
                    <li><a href="news.htm" class="text-capitalize">News</a></li>
                    <li><a href="locations.htm" class="text-capitalize">Locations</a></li>
                    <li><a href="about.htm" class="text-capitalize">About</a></li>
                    <li><a class="dropdown-button text-capitalize" href="#!" data-activates="dropdown1">Your health<i class="material-icons right">arrow_drop_down</i></a></li>
                </ul>  
            </div>
        </div>
    </nav>
</div>
