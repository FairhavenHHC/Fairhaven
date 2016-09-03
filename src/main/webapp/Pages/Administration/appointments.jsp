<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="section">
    <div class="container">
        <div class="row">
            <div class="col s12 m12 l8">
                <h1 class="thin">
                    <fmt:message key="admin.appointments.heading" />
                </h1>
                <p>
                    <fmt:message key="admin.appointments.text1" />
                </p>
            </div>
        </div>
    </div>
</div>

<div class="section white">
    <div class="container">
        <div class="row">
            <div class="col s12 m12 l8">
                <table class="striped bordered">
                    <thead>
                        <tr>
                            <th><fmt:message key="admin.appointments.table.column.date" /></th>
                            <th><fmt:message key="admin.appointments.table.column.location" /></th>
                            <th><fmt:message key="admin.appointments.table.column.name" /></th>
                            <th><fmt:message key="admin.appointments.table.column.topic" /></th>
                            <th colspan="2" class="center-align"><fmt:message key="admin.appointments.table.actions.heading" /></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:choose>
                            <c:when test="${!empty appointments}">
                                <c:forEach var="appointment" items="${appointments}">
                                    <tr>
                                        <td>
                                            <strong><fmt:formatDate value="${appointment.appointmentDate}" type="date" pattern="MMMM dd, yyyy"/></strong><br/>
                                            <h5 class="thin"><fmt:formatDate value="${appointment.appointmentTime}" type="date" pattern="hh:mm a"/></h5>
                                        </td>
                                        <td><c:out value="${appointment.location.name}" /></td>
                                        <td>
                                            <c:out value="${appointment.firstName} ${appointment.lastName}" /><br/>
                                            <strong><c:out value="${appointment.phone}" /></strong>
                                        </td>
                                        <td><c:out value="${appointment.service.name}" /></td>
                                        <fmt:message key="general.edit" var="edit"/>
                                        <fmt:message key="general.delete" var="delete"/>
                                        <td class="center-align"><i class="fa fa-pencil-square-o" title="${edit}"></i></td>
                                        <td class="center-align"><a href="${context}/admin/appointments/delete?id=${appointment.id}"><i class="fa fa-trash-o red-text" title="${delete}"></i></a></td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td colspan="5" class="center-align"><h5><fmt:message key="admin.appointments.table.empty.text" /></h5></td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                    </tbody>
                </table>
            </div>
            <div class="col s12 m12 l4">
                <h5 class="thin"><fmt:message key="admin.appointments.menu.heading" /></h5>
                <div class="collection">
                    <a href="${context}/contact/#appointment" class="collection-item"><fmt:message key="admin.appointments.table.new" /> <i class="fa fa-file-text-o right"></i></a>
                    <a href="${context}/admin/appointments/calendar" class="collection-item"><fmt:message key="admin.appointments.table.calendar" /> <i class="fa fa-calendar-o right"></i></a>
                </div>
            </div>
        </div>
    </div>
</div>

<!--
<div class="row">
<div class="col s12 m12 l8 right-align">
<a href="${context}/contact/#appointment" class="btn grey darken-2"><fmt:message key="admin.appointments.table.new" /></a>
</div>
</div>
-->