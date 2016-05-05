<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="section">
    <div class="container">
        <div class="row">
            <div class="col s12 m12 l4">
                <h4 class="center-align black-text"><i class="fa fa-phone"></i></h4>
                <h5 class="center-align text-capitalize"><fmt:message key="contact.section.contacts.call" /></h5>
                <p class="center-align">
                    <fmt:message key="contact.section.contacts.call.text1" />
                </p>
            </div>
            <div class="col s12 m12 l4">
                <h4 class="center-align blue-text"><i class="fa fa-mouse-pointer"></i></h4>
                <h5 class="center-align text-capitalize"><fmt:message key="contact.section.contacts.click" /></h5>
                <p class="center-align">
                    <fmt:message key="contact.section.contacts.click.text1" />
                </p>
            </div>
            <div class="col s12 m12 l4">
                <h4 class="center-align green-text"><i class="fa fa-building-o"></i></h4>
                <h5 class="center-align text-capitalize"><fmt:message key="contact.section.contacts.come_in" /></h5>
                <p class="center-align">
                    <fmt:message key="contact.section.contacts.come_in.text1" />
                </p>
            </div>
        </div>
    </div>
</div>

<div class="section">
    <div class="container">
        <div class="row">
            <div class="col s12 m12 l12">
                <h2 class="thin"><fmt:message key="contact.section.main.heading" /></h2>
            </div>
        </div>
        <div class="row">
            <div class="col s12 m12 l6">
                <h4 class="thin"> <fmt:message key="form.message.heading" /></h4>
                <div id="map-canvas" class="z-depth-1" style="min-height: 500px; border: 5px solid #fff;"></div>
            </div>
            <div class="col s12 m12 l6" id="contact_form">
                <h4 class="thin"> <fmt:message key="form.message.heading" /></h4>
                <p>
                    <fmt:message key="form.message.heading.text" var="form_text">
                        <fmt:param value="${contacts['Office phone'].value}" />
                    </fmt:message>
                    <c:out value="${form_text}" />
                </p>
                <form:form action="${context}/services/#contact_form" method="post" commandName="question">
                    <div class="row">
                        <div class="input-field col s12 m6">
                            <form:input path="firstName" />
                            <form:label path="firstName"><fmt:message key="form.message.first.label" /></form:label>
                            <form:errors path="firstName" cssClass="error"/>
                        </div>
                        <div class="input-field col s12 m6">
                            <form:input path="lastName" />
                            <form:label path="lastName"><fmt:message key="form.message.last.label" /></form:label>
                            <form:errors path="lastName" cssClass="error"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12 m6">
                            <form:input path="email" />
                            <form:label path="email"><fmt:message key="form.message.email.label" /></form:label>
                            <form:errors path="email" cssClass="error"/>
                        </div>
                        <div class="input-field col s12 m6">
                            <form:select path="service" >
                                <fmt:message key="form.message.service.default" var="serviceDefault"/>
                                <form:option label="${serviceDefault}" value=""/>
                                <form:options items="${services}" itemValue="id" itemLabel="name" />
                            </form:select>
                            <form:errors path="service" cssClass="error"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12 m6">
                            <form:input path="phone" cssClass="phone_us"/>
                            <form:label path="phone"><fmt:message key="form.message.phone.label" /></form:label>
                            <form:errors path="phone" cssClass="error"/>
                        </div>
                        <div class="input-field col s12 m6">
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
                            <fmt:message key="contact.section.offices.search.heading" var="heading">
                                <fmt:param value="${zipBean.zip}" />
                            </fmt:message>
                            <c:out value="${heading}" />
                        </c:when>
                        <c:otherwise>
                            <fmt:message key="contact.section.offices.heading" />
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
                                        <td colspan="3" class="right-align"><strong><a href="${context}/locations/"><fmt:message key="contact.section.offices.view_all" /></a></strong></td>
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
                <h3 class="thin"><fmt:message key="contact.section.zip.heading" /></h3>
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