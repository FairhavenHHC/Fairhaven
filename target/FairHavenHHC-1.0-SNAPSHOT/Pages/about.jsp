<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="section">
    <div class="container">
        <div class="row">
            <div class="col s12 m6">
                <h2 class="thin"><fmt:message key="about.section.foundation.heading" /></h2>
                <p class="">
                    <fmt:message key="about.section.foundation.text1" />
                </p>
                <p>
                    <fmt:message key="about.section.foundation.text2" />
                </p>
            </div>
            <div class="col s12 m4 offset-m4">

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
            <div class="col s12 m6">
                <h4 class="thin">Send us a message</h4>
                <p>
                    <fmt:message key="form.heading.text" var="form_text">
                        <fmt:param value="${contacts['Office phone'].value}" />
                    </fmt:message>
                    <c:out value="${form_text}" />
                </p>
                <form:form action="${context}/about/" method="post" commandName="message">
                    <div class="row">
                        <div class="input-field col s6">
                            <form:input path="firstName" />
                            <form:label path="firstName"><fmt:message key="form.message.first.label" /></form:label>
                            <form:errors path="firstName" cssClass="error"/>
                        </div>
                        <div class="input-field col s6">
                            <form:input path="lastName" />
                            <form:label path="lastName"><fmt:message key="form.message.last.label" /></form:label>
                            <form:errors path="lastName" cssClass="error"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6">
                            <form:input path="email" />
                            <form:label path="email"><fmt:message key="form.message.email.label" /></form:label>
                            <form:errors path="email" cssClass="error"/>
                        </div>
                        <div class="input-field col s6">
                            <form:select path="service" >
                                <fmt:message key="form.message.service.default" var="serviceDefault"/>
                                <form:option label="${serviceDefault}" value=""/>
                                <form:options items="${services}" itemValue="id" itemLabel="name" />
                            </form:select>
                            <form:errors path="service" cssClass="error"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6">
                            <form:input path="phone" cssClass="phone_us"/>
                            <form:label path="phone"><fmt:message key="form.message.phone.label" /></form:label>
                            <form:errors path="phone" cssClass="error"/>
                        </div>
                        <div class="input-field col s6">
                            <fmt:message key="form.message.newsletter.label" var="newsletterMessage"/>
                            <form:checkbox path="newsletter" label="${newsletterMessage}"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <form:textarea path="message"  rows="10" cssClass="materialize-textarea" length="250" />
                            <form:label path="message"><fmt:message key="form.message.message.label" /></form:label>
                            <form:errors path="message" cssClass="error"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12 right-align">
                            <button class="btn" value="Submit" type="submit"><fmt:message key="form.button.submit" /></button>
                        </div>
                    </div> 
                </form:form>
            </div>
            <div class="col s12 m5 offset-m1">
                <div class="row">
                    <div class="col s12">
                        <h4 class="thin"><fmt:message key="about.section.contact.heading" /></h4>
                        <table class="table bordered">
                            <tbody>
                                <tr>
                                    <td><i class="fa fa-phone" title="${contacts['Office phone'].type.name}"></i></td>
                                    <td><strong><c:out value="${contacts['Office phone'].value}"/></strong></td>
                                </tr>
                                <tr>
                                    <td><i class="fa fa-envelope-o" title="${contacts['General email'].type.name}"></i></td>
                                    <td><strong><c:out value="${contacts['General email'].value}"/></strong></td>
                                </tr>
                                <tr>
                                    <td><i class="fa fa-fax" title="${contacts['Fax'].type.name}"></i></td>
                                    <td><strong><c:out value="${contacts['Fax'].value}"/></strong></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="row">
                    <div class="col s12">
                        <h4 class="thin"><fmt:message key="about.section.locations.heading" /></h4>
                        <c:choose>
                            <c:when test="${!empty locations}">
                                <table class="bordered">
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
                                                    <a href="#">
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