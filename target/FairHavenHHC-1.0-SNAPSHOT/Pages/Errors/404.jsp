<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<div class="container">
    <div class="row">
        <div class="col s12">
            <fmt:message key="error.404.heading" var="error_heading">
                <fmt:param value="${error_data.statusCode}" />
            </fmt:message>
            <h1 class="center-align"><c:out value="${error_heading}" /></h1>
            </div>
        </div>

        <div class="row">
            <div class="col s12">
                <h4 class="center-align thin">
                    <fmt:message key="error.404.text" />
                </h4>
                <c:if test="${error_message != null && not empty error_message}">
                    <h4><fmt:message key="error.messageheading" /></h4>
                    <code>
                        <c:out value="${error_message}" />
                    </code>
                </c:if>
                <c:if test="${(detailed_message != null && not empty detailed_message) && detailed_message != message}">
                    <div class="divider"></div>
                    <h4><fmt:message key="error.detailheading" /></h4>
                    <code>
                        <c:out value="${detailed_message}" />
                    </code>
                </c:if>
                <div class="divider"></div>
                <p class="right-align">
                    <a class="btn btn-primary back_button" href="#"><fmt:message key="error.button.text" /></a>
                </p>
            </div>
        </div>
    </div>


