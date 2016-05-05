<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="section white" id="services-header-section">
    <div class="container">
        <div class="row">
            <div class="col s12 m12 l6">
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
                    <fmt:message key="services.section.cards.card3" />
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
            <div class="col s12 m12 l6">

            </div>
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


