<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<div class="section header-image hide-on-med-and-down center-align">

</div>

<div class="section">
    <div class="row container">
        <div class="col s12 m12">
            <blockquote>
                <h3 class="thin">
                    <fmt:message key="home.section.mission" />
                </h3>
            </blockquote>
        </div>
    </div>
</div>

<div class="section light-green lighten-2">
    <div class="row">
        <div class="col s12 m12 l12 center-align" >
            <fmt:message key="services.callout.phone" var="phone_support">
                <fmt:param value="${contacts['Office phone'].value}"/>
            </fmt:message>
            <h1 class="no-wrap"><c:out value="${phone_support}"/></h1>
            <p>
                <strong><fmt:message key="contact.hours.text" /></strong>
            </p>
            <p>
                <a class="btn no-wrap" href="${context}/contact/#appointment"><fmt:message key="services.callout.appointment" /></a>
            </p>
        </div>
    </div>
</div>

<div class="section white">
    <div class="container">
        <div class="row">
            <div class="col s12 m12 l6">
                <a href="${context}/services/"><h3 class="thin"><i class="fa fa-puzzle-piece light-green-text"></i> Services</h3></a>
                <p>
                    <fmt:message key="home.section.services.text" />
                </p>
                <table class="striped bordered">
                    <thead>
                        <tr>
                            <th><fmt:message key="home.table.services.heading" /></th>
                            <th class="center-align">Fairhaven</th>
                            <!--<th class="center-align"><fmt:message key="home.table.services.column.others" /></th>-->
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${services}" var="service" varStatus="counter">
                            <c:choose>
                                <c:when test="${service.offered && counter.count <= 4}">
                                    <tr>
                                        <td><a href="${context}/services/${service.id}"><c:out value="${service.name}" /></a></td>
                                        <td class="center-align"><i class="fa fa-check green-text"></i></td>
                                        <!--<td class="center-align">
                                        <c:choose>
                                            <c:when test="${service.competitorOffered}">
                                                <i class="fa fa-check green-text"></i>
                                            </c:when>
                                            <c:otherwise>
                                                <i class="fa fa-times red-text"></i>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>-->
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <c:if test="${service.offered}">
                                        <tr class="hidden_rows additional_services">
                                            <td><a href="${context}/services/${service.id}"><c:out value="${service.name}" /></a></td>
                                            <td class="center-align"><i class="fa fa-check green-text"></i></td>
                                        </tr>
                                    </c:if>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td class="right-align" colspan="3"><a href="" id="more_services"><i class="fa fa-plus red-text"></i></a></td>
                        </tr>
                    </tfoot>
                </table>
            </div>
            <div class="col s12 m12 l6">
                <p class="center-align"><img src="${context}/images/services-optimized.jpg" class="responsive-img z-depth-1" style="border: 5px solid #fff" alt="Services image"/></p>
            </div>
        </div>
    </div>
</div>



<div class="section">
    <div class="container">
        <div class="row">
            <div class="col s12 m12 l6">
                <div class="row">
                    <div class="s12 m12 l12">
                        <a href="${context}/contact/#appointment"><h3 class="thin"><i class="fa fa-calendar-o light-blue-text"></i> <fmt:message key="home.section.about.heading" /></h3></a>
                    </div>
                </div>
                <div class="row">
                    <div class="col s12 m6 l6">
                        <p>
                            <fmt:message key="home.section.about.text1" />
                        </p>
                        <blockquote>
                            <fmt:message key="home.section.about.text2" />
                        </blockquote>
                        <h6><a href="${context}/contact/#appointment"><fmt:message key="button.appointment.setup" /> <i class="fa fa-calendar-o"></i></a></h6>
                    </div>
                    <div class="col s12 m6 l6">
                        <p class="center-align"><img src="${context}/images/about-optimized.jpg" class="responsive-img z-depth-1" style="border: 5px solid #fff;" alt="About image"/></p>
                    </div>
                </div>
            </div>
            <div class="col s12 m12 l6">
                <div class="row">
                    <div class="s12 m12 l12">
                        <a href="${context}/contact/"><h3 class="thin"><i class="fa fa-phone orange-text text-darken-3"></i> <fmt:message key="home.section.location.heading" /></h3></a>
                    </div>
                </div>
                <div class="row">
                    <div class="col s12 m12 l12">
                        <p>
                            <fmt:message key="home.section.location.text" />
                        </p>
                        <p>
                            <a href="${context}/contact/"><i class="fa fa-map-marker"></i> <fmt:message key="home.section.location.link" /></a>
                        </p>
                    </div>
                </div>
                <div class="row">
                    <div class="col s12 m12">
                        <table class="table bordered">
                            <tbody>
                                <tr>
                                    <td><i class="fa fa-phone" title="${contacts['Office phone'].type.name}"></i></td>
                                    <td><strong><c:out value="${contacts['Office phone'].value}"/></strong></td>
                                    <td><c:out value="${contacts['Office phone'].type.name}"/></td>
                                </tr>
                                <tr>
                                    <td><i class="fa fa-envelope-o" title="${contacts['General email'].type.name}"></i></td>
                                    <td><strong><a href="mailto:${contacts['General email'].value}"><c:out value="${contacts['General email'].value}"/></a></strong></td>
                                    <td><c:out value="${contacts['General email'].type.name}"/></td>
                                </tr>
                                <tr>
                                    <td><i class="fa fa-envelope-o" title="${contacts['General email'].type.name}"></i></td>
                                    <td><strong><a href="mailto:${contacts['Appointments'].value}"><c:out value="${contacts['Appointments'].value}"/></a></strong></td>
                                    <td><c:out value="${contacts['Appointments'].type.name}"/></td>
                                </tr>
                                <tr>
                                    <td><i class="fa fa-fax" title="${contacts['Fax'].type.name}"></i></td>
                                    <td><strong><c:out value="${contacts['Fax'].value}"/></strong></td>
                                    <td><c:out value="${contacts['Fax'].type.name}"/></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="row">
                    <div class="col s12 m12">
                        <div class="col s12 m12">
                            <div id="map-canvas" class="z-depth-1" style="min-height: 300px; border: 5px solid #fff;"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="section white bottom-div">
    <div class="row container">
        <div class="col s12 m12 l6">
            <h2 class="thin"><fmt:message key="home.section.goal.heading" /></h2>
        </div>
        <div class="col s12 m12 l6">
            <p>
                <fmt:message key="home.section.goal.text" />
            </p>
        </div>
    </div>
</div>
