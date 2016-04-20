<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="section">
    <div class="container">
        <div class="row">
            <div class="col s12 m12">
                <h2 class="thin"><fmt:message key="locations.section.map.heading" /></h2>
                <div id="map-canvas" class="z-depth-1" style="min-height: 500px; border: 5px solid #fff;"></div>
            </div>
        </div>
    </div>
</div>

<div class="section white bottom-div">
    <div class="container">
        <div class="row">
            <div class="col s12 m12 l6">
                <h3 class="thin">
                    <c:choose>
                        <c:when test="${search_results}">
                            <fmt:message key="locations.section.offices.search.heading" var="heading">
                                <fmt:param value="${zipBean.zip}" />
                            </fmt:message>
                            <c:out value="${heading}" />
                        </c:when>
                        <c:otherwise>
                            <fmt:message key="locations.section.offices.heading" />
                        </c:otherwise>
                    </c:choose>
                </h3>
                <c:choose>
                    <c:when test="${!empty locations}">
                        <table class="striped">
                            <thead>
                            <th><fmt:message key="about.table.locations.column.office" /></th>
                            <th colspan="2"><fmt:message key="about.table.locations.column.address" /></th>
                            </thead>
                            <tbody>
                                <c:forEach var="location" items="${locations}">
                                    <tr>
                                        <td>
                                            <strong><c:out value="${location.name}" /></strong>
                                        </td>
                                        <td>
                                            <address>
                                                <c:out value="${location.street}" /><br>
                                                <c:out value="${location.city}" /><br>
                                                <c:out value="${location.country}" />, <c:out value="${location.zip}" />
                                            </address>
                                        </td>
                                        <td>
                                            <a href="${context}/locatoins?lat=${location.latitude}&long=${location.longitude}" class="marker">
                                                <i class="fa fa-map-marker"></i> <fmt:message key="map.link.view" />
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                            <c:if test="${search_results}">
                                <tfoot>
                                    <tr>
                                        <td colspan="3" class="right-align"><strong><a href="${context}/locations/"><fmt:message key="locations.section.offices.view_all" /></a></strong></td>
                                    </tr>
                                </tfoot>
                            </c:if>
                        </table>
                    </c:when>
                    <c:otherwise>
                        <p class="thin center-align"><fmt:message key="locatinos.section.offices.empty" /></p>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="col s12 m12 l5 offset-l1" id="zip_lookup">
                <h3 class="thin"><fmt:message key="locations.section.zip.heading" /></h3>
                <form:form action="${context}/locations/zip/#zip_lookup" method="post" commandName="zipBean">
                    <div class="row">
                        <div class="input-field col s12 m6 l6">
                            <form:input path="zip" cssClass="zip_us"/>
                            <form:label path="zip">
                                <fmt:message key="form.location.zip.label" />
                            </form:label>
                        </div>
                        <div class="input-field col s12 m6 l6 center-align">
                            <button class="btn col s12" value="Submit" type="submit">
                                <fmt:message key="form.button.submit" />
                            </button>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col s12">
                            <form:errors path="zip" cssClass="error"/>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>