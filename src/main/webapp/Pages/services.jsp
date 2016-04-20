<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="section white" id="services-header-section">
    <div class="container">
        <div class="row">
            <div class="col s12 m12 l4">
                <h2 class="thin"><fmt:message key="services.section.main.heading" /></h2>
                <p>
                    <fmt:message key="services.section.main.text1" />
                </p>
                <p>
                    <fmt:message key="services.section.main.text2" />
                </p>
            </div>
        </div>
    </div>
</div>

<div class="section">
    <div class="container">
        <div class="row">
            <div class="col s12 m4 l4">
                <p class="center-align">
                    <img class="responsive-img" src="${context}/images/nurse.png" alt="" />
                </p>
                <a href="#"><h4 class="thin center-align"><i class="fa fa-stethoscope"></i> <fmt:message key="services.section.cards.heading1" /></h4></a>
                <p class="center-align">
                    <fmt:message key="services.section.cards.card1" />
                </p>
            </div>
            <div class="col s12 m4 l4">
                <p class="center-align">
                    <img class="responsive-img" src="${context}/images/caller.png" alt="" />
                </p>
                <a href="#"><h4 class="thin center-align"><i class="fa fa-clock-o"></i> <fmt:message key="services.section.cards.heading3" /></h4></a>
                <p>
                    <fmt:message key="services.section.cards.card3" />
                </p>
            </div>
            <div class="col s12 m4 l4">
                <p class="center-align">
                    <img class="responsive-img" src="${context}/images/clipboard.png" alt="" />
                </p>
                <a href="#"><h4 class="thin center-align"><i class="fa fa-check"></i> <fmt:message key="services.section.cards.heading2" /></h4></a>
                <p>
                    <fmt:message key="services.section.cards.card2" />
                </p>
            </div>
        </div>
    </div>
</div>

<div class="section white">
    <div class="container">
        <div class="row">
            <div class="col s12 m12 l6" id="services_list">
                <h4 class="thin"><fmt:message key="services.section.table.heading" /></h4>
                <table class="striped">
                    <thead>
                        <tr>
                            <th><fmt:message key="home.table.services.heading" /></th>
                            <th class="center-align">Fairhaven</th>
                            <th class="center-align"><fmt:message key="home.table.services.column.others" /></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${services}" var="service" varStatus="counter">
                            <c:if test="${service.offered}">
                                <tr>
                                    <td><c:out value="${service.name}" /></td>
                                    <td class="center-align"><i class="fa fa-check green-text"></i></td>
                                    <td class="center-align">
                                        <c:choose>
                                            <c:when test="${service.competitorOffered}">
                                                <i class="fa fa-check green-text"></i>
                                            </c:when>
                                            <c:otherwise>
                                                <i class="fa fa-times red-text"></i>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td class="right-align" colspan="3"></td>
                        </tr>
                    </tfoot>
                </table>
            </div>

        </div>
    </div>
</div>

<div class="section">
    <div class="container">
        <div class="row">
            <div class="col s12 m12 l5" id="faq">
                <h4 class="thin"><fmt:message key="about.section.faq.heading" /></h4>
                <c:choose>
                    <c:when test="${!empty(faqs)}">
                        <ul class="collapsible z-depth-0" data-collapsible="expandable">
                            <c:forEach var="faq" items="${faqs}">
                                <li>
                                    <div class="collapsible-header truncate"><i class="fa fa-chevron-right chevron-toggle"></i> <c:out value="${faq.question}" /></div>
                                    <div class="collapsible-body white">
                                        <p><c:out value="${faq.answer}" /></p>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </c:when>
                    <c:otherwise>
                        <p>
                            <fmt:message key="about.faq.no_faq_text" />
                        </p>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="col s12 m12 l6 offset-l1" id="contact_form">
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