<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<div class="section">
    <div class="container">
        <div class="row">
            <div class="col s12 m12 l12">
                <h1 class="thin">
                    <fmt:message key="admin.dashboard.index.heading" />
                </h1>
            </div>
        </div>
        <div class="row">
            <div class="col s12 m12 l6">
                <p>
                    <fmt:message key="admin.dashboard.index.text1" var="app_text">
                        <fmt:param value="${application_name}" />
                    </fmt:message>
                    <c:out value="${app_text}" />
                </p>
            </div>
            <div class="col s12 m12 l6">
                <h3 class="thin"><fmt:message key="admin.dashboard.summary.heading" /></h3>
                <table class="striped">
                    <thead>
                        <tr>
                            <th><fmt:message key="admin.dashboard.summary.table.column.item" /></th>
                            <th><fmt:message key="admin.dashboard.summary.table.column.status" /></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <a href="${context}/admin/appointments/"><fmt:message key="admin.dashboard.summary.table.appointment.label" /></a>
                            </td>
                            <td>
                                <strong><a href="${context}/admin/appointments/"><c:out value="${fn:length(appointments)}" /></a></strong>
                            </td>
                        </tr>
                    </tbody>
                </table>

            </div>
        </div>
    </div>
</div>



