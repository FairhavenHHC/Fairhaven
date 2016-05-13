<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="section">
    <div class="container">
        <div class="row">
            <div class="col s12 m12 l8">
                <h1 class="thin"><fmt:message key="about.section.foundation.heading" /></h1>
                <p>
                    <fmt:message key="about.section.foundation.text1" />
                </p>
                <p>
                    <fmt:message key="about.section.foundation.text2" />
                </p>
            </div>
            <div class="col s12 m12 l4">
                <div class="row">
                    <div class="col s12">
                        <h4 class="thin"><fmt:message key="about.section.contact.heading" /></h4>
                        <table class="table bordered">
                            <tbody>
                                <tr>
                                    <td><i class="fa fa-phone" title="${contacts['Office phone'].type.name}"></i></td>
                                    <td><strong><c:out value="${contacts['Office phone'].value}"/></strong></td>
                                    <td><c:out value="${contacts['Office phone'].type.name}"/></td>
                                </tr>
                                <tr>
                                    <td><i class="fa fa-envelope-o" title="${contacts['General email'].type.name}"></i></td>
                                    <td><strong><a href="mailto:${contacts['General email'].value}"><c:out value="${contacts['General email'].value}"/></a></strong></td>
                                    <td><c:out value="${contacts['General email'].type.name}"/></td>
                                </tr>
                                <tr>
                                    <td><i class="fa fa-envelope-o" title="${contacts['General email'].type.name}"></i></td>
                                    <td><strong><a href="mailto:${contacts['Appointments'].value}"><c:out value="${contacts['Appointments'].value}"/></a></strong></td>
                                    <td><c:out value="${contacts['Appointments'].type.name}"/></td>
                                </tr>
                                <tr>
                                    <td><i class="fa fa-fax" title="${contacts['Fax'].type.name}"></i></td>
                                    <td><strong><c:out value="${contacts['Fax'].value}"/></strong></td>
                                    <td><c:out value="${contacts['Fax'].type.name}"/></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="row">
                    <div class="col s12 m12 l12">
                        <h4 class="thin"><fmt:message key="about.section.locations.heading" /></h4>
                        <c:choose>
                            <c:when test="${!empty locations}">
                                <table>
                                    <tbody>
                                        <c:forEach var="location" items="${locations}">
                                            <tr>
                                                <td>
                                                    <h5><c:out value="${location.name}" /></h5>
                                                    <address>
                                                        <c:out value="${location.street}" /><br>
                                                        <c:out value="${location.city}" /><br>
                                                        <c:out value="${location.country}" />, <c:out value="${location.zip}" />
                                                    </address>
                                                </td>
                                                <td>
                                                    <a href="${context}/contact/?lat=${location.latitude}&long=${location.longitude}">
                                                        <i class="fa fa-map-marker"></i> <fmt:message key="map.link.view" />
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </c:when>
                            <c:otherwise>
                                <p class="thin center-align"><fmt:message key="about.section.locations.empty" /></p>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="section white">
    <div class="container">
        <div class="row">
            <div class="col m6 s12">
                <h1 class="center-align blue-text"><i class="fa fa-lightbulb-o"></i></h1>
                <h5 class="center-align text-capitalize"><fmt:message key="about.section.mission.heading" /></h5>
                <p class="center-align">
                    <fmt:message key="about.section.mission.text1" />
                </p>
            </div>
            <div class="col m6 s12" style="border-left: 1px solid #ccc;">
                <h1 class="center-align green-text"><i class="fa fa-bullseye"></i></h1>
                <h5 class="center-align text-capitalize"><fmt:message key="about.section.goal.heading" /></h5>
                <p class="center-align">
                    <fmt:message key="about.section.goal.text1" />
                </p>
            </div>
        </div>
    </div>
</div>

<div class="section">
    <div class="container">
        <div class="row">
            <div class="col s12 m12 l12 center-align">
                <h3 class="thin"><fmt:message key="about.section.commitment.heading" /></h3>
                <blockquote>
                    <h5>
                        <fmt:message key="about.section.commitment.text1" />
                    </h5>
                </blockquote>
            </div>
        </div>
    </div>
</div>