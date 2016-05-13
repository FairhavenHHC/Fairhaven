<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="section white" id="services-header-section">
    <div class="container">
        <div class="row">
            <div class="col s12 m12 l6">
                <h1 class="thin"><fmt:message key="services.section.main.heading" /></h1>
                <p>
                    <fmt:message key="services.section.main.text1" />
                </p>
                <p>
                    <fmt:message key="services.section.main.text2" />
                </p>
                <blockquote>
                    <h4 class="thin"><fmt:message key="services.section.main.blockquote" /></h4>
                </blockquote>
            </div>
            <div class="col l6 hide-on-med-and-down">
                <p class="center-align">
                    <img src="${context}/images/logo-circle-text-alt.png" class="responsive-img" style="max-height: 300px;"/>
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
                    <img class="responsive-img z-depth-1 bordered" src="${context}/images/nurse.png" alt="" />
                </p>
                <a href="#"><h4 class="thin"><i class="fa fa-stethoscope"></i> <fmt:message key="services.section.cards.heading1" /></h4></a>
                <p>
                    <fmt:message key="services.section.cards.card1" />
                </p>
            </div>
            <div class="col s12 m4 l4">
                <p class="center-align">
                    <img class="responsive-img z-depth-1 bordered"  src="${context}/images/caller.png" alt="" />
                </p>
                <a href="#"><h4 class="thin"><i class="fa fa-clock-o"></i> <fmt:message key="services.section.cards.heading3" /></h4></a>
                <p>
                    <fmt:message key="services.section.cards.card3" var="phone_support">
                        <fmt:param value="${contacts['Office phone'].value}"/>
                    </fmt:message>
                    <c:out value="${phone_support}"/>
                </p>
            </div>
            <div class="col s12 m4 l4">
                <p class="center-align">
                    <img class="responsive-img z-depth-1 bordered" src="${context}/images/clipboard.png" alt="" />
                </p>
                <a href="#"><h4 class="thin"><i class="fa fa-check"></i> <fmt:message key="services.section.cards.heading2" /></h4></a>
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
            <div class="col s12 m12 l12">
                <h2 class="thin"><fmt:message key="services.section.table.heading" /></h2>
            </div>
        </div>
        <div class="row">
            <div class="col s12 m12 l6" id="services_list">
                <table class="striped bordered">
                    <thead>
                        <tr>
                            <th><fmt:message key="home.table.services.heading" /></th>
                            <th class="center-align">Offered?</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${services}" var="service" varStatus="counter">
                            <c:if test="${service.offered}">
                                <tr>
                                    <td>
                                        <strong><a href="${context}/services/${service.id}"><c:out value="${service.name}" /></a></strong>
                                        <p>
                                            <c:out value="${service.description}" />
                                        </p>
                                    </td>
                                    <td class="center-align"><i class="fa fa-check green-text"></i></td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td class="right-align" colspan="3"><!--<small><fmt:message key="services.table.footer" /></small>--></td>
                        </tr>
                    </tfoot>
                </table>
            </div>
            <div class="col s12 m12 l6">
                <p class="center-align">
                    <img class="responsive-img bordered z-depth-1" src="${context}/images/nurse-contract-optimized.jpg" />
                </p>
                <h5><fmt:message key="services.howto.care.heading" /></h5>
                <p>
                    <fmt:message key="services.howto.care.text1"/>
                </p>
                <p>
                    <fmt:message key="services.howto.care.text2"/>
                </p>
                <p>
                    <fmt:message key="services.howto.care.text3"/>
                </p>
                <div class="divider"></div>
                <h5><fmt:message key="services.benefits.care.heading" /></h5>
                <p>
                    <fmt:message key="services.benfits.care.text1"/>
                </p>
                <p>
                    <fmt:message key="services.benefits.care.text2"/>
                </p>
                <p>
                    <fmt:message key="services.benefits.care.text3"/>
                </p>
            </div>
        </div>
    </div>
</div>

<div class="section light-green lighten-2">
    <div class="row">
        <div class="col s12 m12 l12 center-align">
            <fmt:message key="services.callout.phone" var="phone_support">
                <fmt:param value="${contacts['Office phone'].value}"/>
            </fmt:message>
            <h1><c:out value="${phone_support}"/></h1>
            <p>
                <strong><fmt:message key="contact.hours.text" /></strong>
            </p>
            <p>
                <a class="btn red-btn" href="${context}/contact/#appointment"><fmt:message key="services.callout.appointment" /></a>
            </p>
        </div>
    </div>
</div>

<div class="section">
    <div class="container">
        <div class="row">
            <div class="col s12 m12 l6 center-align valign">
                <img class="responsive-img z-depth-1 bordered" src="${context}/images/faq.jpg" alt="Faq Image" />
            </div>
            <div class="col s12 m12 l6" id="faq">
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
        </div>
    </div>
</div>