<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="navbar-fixed ">
    <nav>
        <div class="nav-wrapper ">
            <a href="${context}/index.htm" class="brand-logo"><img src="${context}/images/logo.png" alt="Logo" /></a>
            <a href="#" data-activates="mobile-menu" class="button-collapse"><i class="material-icons">menu</i></a>
            <ul id="nav-mobile" class="hide-on-med-and-down right">
                <li><a href="${context}/index.htm" class="text-capitalize bolden"><fmt:message key="header.menu.item.home" /></a></li>
                <li><a href="${context}/services/" class="text-capitalize"><fmt:message key="header.menu.item.services" /></a></li>
                <li><a class='dropdown-button text-capitalize' href='#' data-constrainwidth="false" data-activates='about_dropdown'><fmt:message key="header.menu.item.about" /> <i class="fa fa-chevron-down"></i></a></li>
            </ul>

            <!-- Dropdown Structure -->
            <ul id='about_dropdown' class='dropdown-content' >
                <li><a href="${context}/about/"><fmt:message key="header.menu.item.about.story" /></a></li>
                <li><a href="${context}/contact/"><fmt:message key="header.menu.item.about.contact" /></a></li>
                <li class="divider"></li>
                <li><a href="${context}/about/careers/"><fmt:message key="header.menu.item.about.careers" /></a></li>
                    <c:choose>
                        <c:when test="${not empty pageContext.request.userPrincipal}">
                        <li><a href="${context}/logout.htm"><fmt:message key="header.menu.item.admin.logout" /></a></li>
                        </c:when>
                        <c:otherwise>
                        <li><a href="${context}/admin/"><fmt:message key="header.menu.item.login" /></a></li>
                        </c:otherwise>
                    </c:choose>
            </ul>

            <ul class="side-nav" id="mobile-menu">
                <li><a href="${context}/index.htm" class="text-capitalize"><fmt:message key="header.menu.item.home" /></a></li>
                <li><a href="${context}/services/" class="text-capitalize"><fmt:message key="header.menu.item.services" /></a></li>
                <li class="no-padding">
                    <ul class="collapsible collapsible-accordion">
                        <li>
                            <a class="collapsible-header"><fmt:message key="header.menu.item.about" /> <i class="fa fa-chevron-right"></i></a>
                            <div class="collapsible-body">
                                <ul>
                                    <li><a href="${context}/about/"><fmt:message key="header.menu.item.about.story" /></a></li>
                                    <li><a href="${context}/contact/"><fmt:message key="header.menu.item.about.contact" /></a></li>
                                    <li class="divider"></li>
                                    <li><a href="${context}/about/careers/"><fmt:message key="header.menu.item.about.careers" /></a></li>
                                        <c:choose>
                                            <c:when test="${not empty pageContext.request.userPrincipal}">
                                            <li><a href="${context}/logout.htm"><fmt:message key="header.menu.item.admin.logout" /></a></li>
                                            </c:when>
                                            <c:otherwise>
                                            <li><a href="${context}/admin/"><fmt:message key="header.menu.item.login" /></a></li>
                                            </c:otherwise>
                                        </c:choose>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</div>
