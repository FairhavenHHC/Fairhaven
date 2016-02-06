<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="navbar-fixed ">
    <nav>
        <div class="nav-wrapper ">
            <div>
                <!--<a href="index.htm" class="brand-logo center text-capitalize">Fairhaven HHC</a>-->
                <a href="#" data-activates="mobile-menu" class="button-collapse"><i class="material-icons">menu</i></a>
                <ul id="nav-mobile" class="hide-on-med-and-down left">
                    <li><a href="index.htm" class="text-capitalize bolden">Home</a></li>
                    <li><a href="services.htm" class="text-capitalize">Services</a></li>  
                    <li><a href="news.htm" class="text-capitalize">News</a></li>
                    <li><a href="locations.htm" class="text-capitalize">Locations</a></li>
                    <li><a href="about.htm" class="text-capitalize">About</a></li>
                </ul>
                <!--<ul  class="right">
                    <li><a class="dropdown-button text-capitalize" href="#!" data-activates="dropdown1">Admin <i class="material-icons right">arrow_drop_down</i></a></li>
                </ul>-->
                <ul class="right">
                    <li>
                        <c:choose>
                            <c:when test="${not empty pageContext.request.userPrincipal}">  
                                <a href="logout.htm" class="text-capitalize"><strong>Logout</strong></a>
                            </c:when>
                            <c:otherwise>
                                <a href="admin.htm" class="text-capitalize"><strong>Member login</strong></a>
                            </c:otherwise>
                        </c:choose>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
