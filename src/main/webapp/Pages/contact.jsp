<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="section">
    <div class="container">
        <div class="row">
            <div class="col s12 m12 l12">
                <h2 class="thin"><fmt:message key="about.section.contact.heading" /></h2>
            </div>
        </div>
        <div class="row">
            <div class="col s12 m12 l6">
                <div class="row">
                    <div class="col s12 m12 l12">
                        <div id="map-canvas" class="z-depth-1" style="min-height: 500px; border: 5px solid #fff;"></div>
                    </div>
                </div>
                <div class="row">
                    <div class="col s12 m12 l12">
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
                                                    <strong><c:out value="${location.name}" /></strong><br/>
                                                    <fmt:formatDate value="${location.open}" timeStyle="short" type="time" /> - <fmt:formatDate value="${location.close}" timeStyle="short" type="time"/>                                         </td>
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
                </div>
            </div>
            <div class="col s12 m12 l6">
                <div class="row">
                    <div class="col s12 m12 l12">
                        <ul class="tabs">
                            <li class="tab col s3"><a class="active" href="#call"><strong><i class="fa fa-phone"></i> <fmt:message key="contact.section.contacts.call" /></strong></a></li>
                            <li class="tab col s3"><a href="#click"><strong><i class="fa fa-envelope-o"></i> <fmt:message key="contact.section.contacts.click" /></strong></a></li>
                            <li class="tab col s3"><a href="#appointment"><strong><i class="fa fa-calendar"></i> <fmt:message key="contact.section.contacts.come_in" /></strong></a></li>
                        </ul>
                    </div>
                </div>
                <div class="row">
                    <div id="call" class="col s12 m12 l12">
                        <h4 class="thin"><fmt:message key="form.contact.call.heading" /></h4>
                        <table class="table bordered">
                            <tbody>
                                <tr>
                                    <td><i class="fa fa-phone" title="${contacts['Office phone'].type.name}"></i></td>
                                    <td><strong><c:out value="${contacts['Office phone'].value}"/></strong></td>
                                    <td><c:out value="${contacts['Office phone'].type.name}"/></td>
                                </tr>
                                <tr>
                                    <td><i class="fa fa-envelope-o" title="${contacts['General email'].type.name}"></i></td>
                                    <td><strong><c:out value="${contacts['General email'].value}"/></strong></td>
                                    <td><c:out value="${contacts['General email'].type.name}"/></td>
                                </tr>
                                <tr>
                                    <td><i class="fa fa-fax" title="${contacts['Fax'].type.name}"></i></td>
                                    <td><strong><c:out value="${contacts['Fax'].value}"/></strong></td>
                                    <td><c:out value="${contacts['Fax'].type.name}"/></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div id="click" class="col s12 m12 l12">
                        <h4 class="thin"><fmt:message key="form.message.heading.text" /></h4>
                        <form:form action="${context}/contact/#click" method="post" commandName="question">
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
                                    <button class="btn" value="Submit" type="submit"><fmt:message key="form.button.send" /></button>
                                </div>
                            </div>
                        </form:form>
                    </div>
                    <div id="appointment" class="col s12 m12 l12">
                        <c:choose>
                            <c:when test="${appointment_success}">
                                <fmt:message key="contact.section.contacts.appointment.success" var="appointment_success_text">
                                    <fmt:formatDate type="date" pattern="MMMM dd yyyy" value="${appointment.appointmentDate}" var="date"/>
                                    <fmt:formatDate type="time" pattern="hh:mm a" value="${appointment.appointmentTime}" var="time"/>
                                    <fmt:param value="${date} ${time}" />
                                    <fmt:param value="${appointment.location.name}" />
                                </fmt:message>
                                <h4 class="center-align thin"><c:out value="${appointment_success_text}" /></h4>
                            </c:when>
                            <c:otherwise>
                                <form:form action="${context}/contact/appointment/#appointment" method="post" commandName="appointment">
                                    <div class="row">
                                        <div class="col s12 m12 l12">
                                            <h4 class="thin"><fmt:message key="form.appointment.personal.section" /></h4>
                                        </div>
                                    </div>
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
                                            <form:input path="phone" cssClass="phone_us" />
                                            <form:label path="phone"><fmt:message key="form.message.phone.label" /></form:label>
                                            <form:errors path="phone" cssClass="error"/>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="input-field col s12 m12">
                                            <h4 class="thin"><fmt:message key="form.appointment.appointment.section" /></h4>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="input-field col s12 m6">
                                            <form:input path="appointmentDate" cssClass="datepicker" />
                                            <form:label path="appointmentDate"><fmt:message key="form.appointment.date.label" /></form:label>
                                            <form:errors path="appointmentDate" cssClass="error"/>
                                        </div>
                                        <div class="input-field col s12 m6">
                                            <form:input path="appointmentTime" id="appointment_time" cssClass="apt_time"/>
                                            <form:label path="appointmentTime"><fmt:message key="form.appointment.time.label" /></form:label>
                                            <form:errors path="appointmentTime" cssClass="error"/>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="input-field col s12 m6">
                                            <form:select path="service" >
                                                <fmt:message key="form.message.service.default" var="serviceDefault"/>
                                                <form:option label="${serviceDefault}" value=""/>
                                                <form:options items="${services}" itemValue="id" itemLabel="name" />
                                            </form:select>
                                            <form:errors path="service" cssClass="error"/>
                                        </div>
                                        <div class="input-field col s12 m6">
                                            <form:select path="bestCallTime" >
                                                <form:option value="Morning" label="Morning" />
                                                <form:option value="Noon" label="Noon" />
                                                <form:option value="Night" label="Night" />
                                            </form:select>
                                            <form:label path="bestCallTime"><fmt:message key="form.appointment.best_time.label" /></form:label>
                                            <form:errors path="bestCallTime" cssClass="error"/>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="input-field col s12 m12 l6">
                                            <form:select path="location" >
                                                <fmt:message key="form.appointment.location.default" var="locationDefault"/>
                                                <form:option label="${locationDefault}" value=""/>
                                                <form:options items="${locations}" itemValue="id" itemLabel="name" />
                                            </form:select>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="input-field col s12 right-align">
                                            <button class="btn" value="Submit" type="submit"><fmt:message key="form.button.schedule" /></button>
                                        </div>
                                    </div>
                                </form:form>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="section">
    <div class="container">

    </div>
</div>
