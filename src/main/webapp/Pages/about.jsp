<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="section">
    <div class="container">
        <div class="row">
            <div class="col s12 m4">
                <h3 class="thin"><fmt:message key="about.section.foundation.heading" /></h3>
                <p class="">
                    <fmt:message key="about.section.foundation.text1" />
                </p>
                <p>
                    <fmt:message key="about.section.foundation.text2" />
                </p>
            </div>
            <div class="col s12 m6">


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
                <div class="row">
                    <div class="col s12">
                        <h3 class="thin">Send us a message</h3>
                        <form:form action="${context}/about/" method="post" commandName="message">
                            <div class="row">
                                <div class="input-field col s6">
                                    <form:input path="firstName" />
                                    <form:label path="firstName">First Name</form:label>
                                    <form:errors path="firstName" />
                                </div>
                                <div class="input-field col s6">
                                    <form:input path="lastName" />
                                    <form:label path="lastName">Last Name</form:label>
                                    <form:errors path="lastName" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s6">
                                    <form:input path="email" />
                                    <form:label path="email">Email Address</form:label>
                                    <form:errors path="email" />
                                </div>
                                <div class="input-field col s6">
                                    <form:select path="service" >
                                        <form:option label="Pick a service" value="" />
                                        <form:options items="${services}" itemValue="id" itemLabel="name" />
                                    </form:select>
                                    <form:errors path="service" />
                                </div>
                            </div> 
                            <div class="row">
                                <div class="input-field col s12">
                                    <form:textarea path="message"  rows="10" cssClass="materialize-textarea"/>
                                    <form:label path="message">Message</form:label>
                                    <form:errors path="message" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s12 right-align">
                                    <button class="btn" value="Submit" type="submit">Submit</button>
                                </div>
                            </div> 
                        </form:form>
                    </div>
                </div>
                <div class="row">
                    <div class="col s12">
                        <h3 class="thin">Frequently asked questions</h3>
                        <c:choose>
                            <c:when test="${!empty(faqs)}">
                                <ul class="collapsible z-depth-0" data-collapsible="accordion">
                                    <c:forEach var="faq" items="${faqs}">
                                        <li>
                                            <div class="collapsible-header"><i class="fa fa-chevron-right chevron-toggle"></i> <c:out value="${faq.question}" /></div>
                                            <div class="collapsible-body white"><p><c:out value="${faq.answer}" /></p></div>
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
                </div>
            </div>
        </div>
    </div>
</div>