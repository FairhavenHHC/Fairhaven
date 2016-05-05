<%--
    Document   : service
    Created on : Apr 5, 2016, 8:32:15 AM
    Author     : Sam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="section">
    <div class="row container">
        <div class="col s12 m12 l12">
            <h1 class="thin">
                <c:out value="${service.name}" />
            </h1>
            <p>
                <c:out value="${service.description}" />
            </p>
        </div>
    </div>
</div>
<div class="section">
    <div class="row container">
        <div class="col s12 m12 l12">
            <p>
                <fmt:message key="services.service.contact.text"  var="contact_message">
                    <fmt:param value="${contacts['Office phone'].value}" />
                </fmt:message>
                <c:out value="${contact_message}" escapeXml="false"/>
            </p>
        </div>
    </div>
</div>