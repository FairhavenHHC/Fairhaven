<<<<<<< HEAD
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
            <div class="col s12 m12 l12">
                <h4 class="thin"><fmt:message key="services.section.table.heading" /></h4>
            </div>
        </div>
        <div class="row">
            <div class="col s12 m12 l6" id="services_list">
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
                                    <td><a href="${context}/services/${service.id}"><c:out value="${service.name}" /></a></td>
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
                            <td class="right-align" colspan="3"><!--<small><fmt:message key="services.table.footer" /></small>--></td>
                        </tr>
                    </tfoot>
                </table>
            </div>
            <div class="col s12 m12 l6">
                <p class="center-align">
                    <img class="responsive-img bordered z-depth-1" src="${context}/images/nurse-contract-optimized.jpg" />
                </p>
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
<<<<<<< HEAD
</div>


=======
</div>
=======
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<<<<<<< HEAD
=======

<div class="section white row valign-wrapper" style="min-height: 400px;">
    <div class="col m3 s12">
        <h5 class="center-align valign text-capitalize">Skilled home nursing (RN/LVN)</h5>
        <p class="center-align">
            Improving the quality of life for those we serve through delivery of clinical excellence, 
            extraordinary service and compassionate care.
        </p>
    </div>
    <div class="col m9 s12">
        
    </div>
</div>
<div class="section row valign-wrapper" style="min-height: 400px;">
    <div class="col m9 s12">
        
    </div>
    <div class="col m3 s12">
        <h5 class="center-align valign text-capitalize">Home health aide</h5>
        <p class="center-align">
            Improving the quality of life for those we serve through delivery of clinical excellence, 
            extraordinary service and compassionate care.
        </p>
    </div>
</div>
<div class="section light-green row lighten-4 valign-wrapper" style="min-height: 400px;">
   <div class="col m3 s12">
        <h5 class="center-align valign text-capitalize">Home care services/companionship</h5>
        <p class="center-align">
            Improving the quality of life for those we serve through delivery of clinical excellence, 
            extraordinary service and compassionate care.
        </p>
    </div>
    <div class="col m9 s12">
        
    </div>
</div>
<div class="section row valign-wrapper" style="min-height: 400px;">
    <div class="col m9 s12">
        
    </div>
    <div class="col m3 s12">
        <h5 class="center-align valign text-capitalize">Medical social work</h5>
        <p class="center-align grey-text">
            Improving the quality of life for those we serve through delivery of clinical excellence, 
            extraordinary service and compassionate care.
        </p>
    </div>
</div>
>>>>>>> c4c55a6de9ef3c9716c8d750a5b4d5d57a1445b2
>>>>>>> 2bf9b035f0db61dbe80228b054532731c6f55b2d
>>>>>>> master
