<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="context_path" value="${pageContext.request.contextPath}" />

<div class="container">

    <c:if test="${error != null}" var="true_false">
        <div class="row">
            <div class="col m12 s12">
                <div class="alert alert-danger">
                    <p class="text-center">
                        <small><fmt:message key="login.error"/> </small> <strong><span class="fa fa-times"></span></strong>
                    </p>
                </div>
            </div>
        </div>
    </c:if>

    <div class="row">
        <div class="col m4 s12 offset-m4">
            <h2 class="thin"><fmt:message key="login.subheading" /></h2>

            <form:form method="POST" action="${context_path}/j_spring_security_check" role="form" commandName="login">
                <div class="input-field col s12">
                    <fmt:message key="login.label.username" var="username"/>
                    <form:input class="form-control required" placeholder="${username}" path="username"/>
                </div>
                <div class="input-field col s12">
                    <fmt:message key="login.label.password" var="password"/>
                    <form:password  cssClass="form-control required" path="password" placeholder="${password}" />
                </div>
                <div class="input-field col s6">
                    <fmt:message key="login.label.rememberme" var="rememberMe"/>
                    <form:checkbox path="cookie" label="${rememberMe}"/>
                </div>
                <div class="input-field col s6 right-align">
                    <form:button type="submit" class="btn btn-primary">
                        <span class="fa fa-sign-in"></span> <fmt:message key="login.button.submit" />
                    </form:button>
                </div>
                <form:hidden path="csrf" /> 
            </form:form>
        </div>
    </div>
</div>