<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="context_path" value="${pageContext.request.contextPath}" />

<div class="container">
    <div class="form-signin">
        <c:if test="${error != null}" var="true_false">
            <div class="row">
                <div class="col m12 s12">
                    <div class="error">
                        <p class="center-align red-text ">
                            <strong><fmt:message key="login.error"/></strong>
                        </p>
                    </div>
                </div>
            </div>
        </c:if>

        <div class="row">
            <div class="col s12 m8 l4 offset-m2 offset-l4">
                <h1 class="thin center-align"><fmt:message key="login.subheading" /></h1>
                <form:form method="POST" action="${context_path}/security_check" role="form" commandName="login" autocomplete="off">
                    <form:hidden path="csrf" />
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
                            <fmt:message key="login.button.submit" />
                        </form:button>
                    </div>
                </form:form>
            </div>
        </div>

        <div class="row">
            <div class="col s12 m8 l4 offset-m2 offset-l4">
                <div class="divider"></div>
                <p class="right-align"><a href="${context}/reset.htm">Forgot your password?</a></p>
            </div>
        </div>
    </div>
</div>