<%-- 
    Document   : login
    Created on : Dec 4, 2014, 12:02:15 PM
    Author     : XUG590
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="context_path" value="${pageContext.request.contextPath}" />

<div class="container">
    <div class="row">
        <div class="col-md-12 last-col">
            <div class="page-header">
                <h2 class="text-right"><fmt:message key="login.heading" /> <small><fmt:message key="login.heading.small" /></small></h2>
            </div>
        </div>
    </div>

    <c:if test="${error != null}" var="true_false">
        <div class="row">
            <div class="col-md-12">
                <div class="alert alert-danger">
                    <p class="text-center">
                        <small><fmt:message key="login.error"/> </small> <strong><span class="fa fa-times"></span></strong>
                    </p>
                </div>
            </div>
        </div>
    </c:if>

    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <p class="lead"><fmt:message key="login.subheading" /></p>

            <form:form method="POST" action="${context_path}/j_spring_security_check" role="form" commandName="login">
                <div class="form-group">
                    <form:label path="username"><fmt:message key="login.label.username" /></form:label>
                    <fmt:message key="login.placeholder.username" var="username_placeholder"/>
                    <c:choose>
                        <c:when test="${!empty employee}">
                            <form:input class="form-control required" placeholder="${username_placeholder}" path="username"  readonly="true"/>
                        </c:when>
                        <c:otherwise>
                            <form:input class="form-control required" placeholder="${username_placeholder}" path="username"/>
                        </c:otherwise>
                    </c:choose>

                </div>
                <div class="form-group">
                    <form:label path="password"><fmt:message key="login.label.password" /></form:label>
                    <fmt:message key="login.label.password" var="password_placeholder"/>
                    <form:password  cssClass="form-control required" path="password" placeholder="${password_placeholder}" />
                </div>
                <div class="form-group">
                    <form:label class="checkbox" path="cookie">
                        <form:checkbox path="cookie"/>
                        <fmt:message key="login.label.rememberme" />
                    </form:label>
                </div>
                <div class="text-right">
                    <form:button type="submit" class="btn btn-primary">
                        <span class="fa fa-sign-in"></span> <fmt:message key="login.button.submit" />
                    </form:button>
                </div>
                    <form:hidden path="csrf" /> 
            </form:form>
        </div>
    </div>
</div>