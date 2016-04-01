<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<div class="section">
    <div class="container">
        <div class="row">
            <div class="col s12 m4 offset-m8">
                <h2 class="thin"><fmt:message key="services.section.main.heading" /></h2>
                <p>
                    <fmt:message key="services.section.main.text1" />
                </p>
                <p>
                    <fmt:message key="services.section.main.text2" />
                </p>
            </div>
        </div>
        <div class="divider"></div>
    </div>
</div>



<div class="section">
    <div class="container">
        <div class="row">
            <div class="col m12 l4">
                <a href="#"><h4 class="thin"><i class="fa fa-check"></i> <fmt:message key="services.section.cards.heading2" /></h4></a>
                <p>
                    <fmt:message key="services.section.cards.card2" />
                </p>
                <p class="center-align">
                    <img class="responsive-img" src="" alt="" />
                </p>
            </div>
            <div class="col m12 l4">
                <a href="#"><h4 class="thin"><i class="fa fa-clock-o"></i> <fmt:message key="services.section.cards.heading3" /></h4></a>
                <p>
                    <fmt:message key="services.section.cards.card3" />
                </p>
                <p class="center-align">
                    <img class="responsive-img" src="" alt="" />
                </p>
            </div>
            <div class="col m12 l4">
                <a href="#"><h4 class="thin"><i class="fa fa-stethoscope"></i> <fmt:message key="services.section.cards.heading1" /></h4></a>
                <p>
                    <fmt:message key="services.section.cards.card1" />
                </p>
                <p class="center-align">
                    <img class="responsive-img" src="" alt="" />
                </p>
            </div>
        </div>
        <div class="divider"></div>
    </div>
</div>

<div class="section">
    <div class="container">
        <div class="row">
            <div class="col s12 m8">
                <h3 class="thin"><fmt:message key="services.section.table.heading" /></h3>
                <table class="striped bordered">
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