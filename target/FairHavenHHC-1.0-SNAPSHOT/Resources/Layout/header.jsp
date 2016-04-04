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
                <ul id="nav-mobile" class="hide-on-med-and-down right">
                    <li><a href="${context}/index.htm" class="text-capitalize bolden">Home</a></li>
                    <li><a href="${context}/services/" class="text-capitalize">Services</a></li>
                    <li><a class='dropdown-button text-capitalize' href='#' data-constrainwidth="false" data-activates='about_dropdown'>About <i class="fa fa-chevron-down"></i></a></li>
                </ul>

                <!-- Dropdown Structure -->
                <ul id='about_dropdown' class='dropdown-content' >
                    <li><a href="${context}/about/">Our story</a></li>
                    <li><a href="${context}/locations/">Locations</a></li>
                    <li class="divider"></li>
                    <li><a href="${context}/about/careers/">Join our team</a></li>
                </ul>

                <ul class="side-nav" id="mobile-menu">
                    <li><a href="${context}/index.htm" class="text-capitalize">Home</a></li>
                    <li><a href="${context}/services/" class="text-capitalize">Services</a></li>
                    <li class="no-padding">
                        <ul class="collapsible collapsible-accordion">
                            <li>
                                <a class="collapsible-header">About <i class="fa fa-chevron-right"></i></a>
                                <div class="collapsible-body">
                                    <ul>
                                        <li><a href="${context}/about/">Our story</a></li>
                                        <li><a href="${context}/locations/">Locations</a></li>
                                        <li class="divider"></li>
                                        <li><a href="${context}/about/careers/">Join our team</a></li>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
                <!--<ul class="right">
                    <li>
                <c:choose>
                    <c:when test="${not empty pageContext.request.userPrincipal}">
                        <a href="${context}/logout.htm" class="text-capitalize"><strong>Logout</strong></a>
                    </c:when>
                    <c:otherwise>
                        <a href="${context}/members/" class="text-capitalize"><strong>Member login</strong></a>
                    </c:otherwise>
                </c:choose>
            </li>
        </ul>-->
            </div>
        </div>
    </nav>
</div>
