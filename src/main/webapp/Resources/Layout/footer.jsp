<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div id="footer" class="container">
    <div class="row">
        <div class="col l2 hide-on-med-and-down">
            <h6><strong>FairHaven HHC &copy;</strong></h6>
        </div>
        <div class="col m2 s4">
            <h6 class="white-text">Our services</h6>
            <ul>
                <c:choose>
                    <c:when test="${!empty(services) && fn:length(services)> 0}">
                        <c:forEach var="service" items="${services}">
                            <c:if test="${service.offered}">
                                <li>
                                    <a href="${context}/services/${service.id}">
                                        <c:out value="${service.name}" />
                                    </a>
                                </li>
                            </c:if>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <fmt:message key="${footer.menu.services.none}" />
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
        <div class="col m2 s4">
            <h6 class="white-text">About us</h6>
            <ul>
                <li><a href="${context}/about/#our_story">Our story</a></li>
                <li><a href="${context}/about/#contact">Contact us</a></li>
                <li><a href="${context}/locations/">Find a location</a></li>
            </ul>

            <h6 class="white-text">Join our team</h6>
            <ul>
                <li><a href="${context}/about/careers/">Careers</a></li>
            </ul>
        </div>
        <div class="col m2 s4">
            <h6 class="white-text">Connect</h6>
            <ul>
                <li><a href="http://www.facebook.com/fairhavenhhc"><i class="fa fa-facebook fa-fw blue-text text-darken-4"></i> Facebook</a></li>
                <li><a href="http://www.twitter.com/fairhavenhhc"><i class="fa fa-twitter fa-fw light-blue-text"></i> Twitter</a></li>
                <li><a href="http://plus.google.com/"><i class="fa fa-google-plus fa-fw red-text"></i> Google Plus</a></li>
            </ul>
        </div>
        <div class="col m4 s12">
            <h6 class="black-text"><i class="fa fa-info blue-text"></i> <fmt:message key="footer.nondiscrimination.heading" /></h6>
            <small>
                <fmt:message key="footer.nondiscrimination.text" />
            </small>
        </div>
    </div>
</div>
<div class="footer-copyright">
    <div class="container">
        <div class="row">
            <div class="col s12">
                <h6 class="center-align black-text"><strong>FairHaven HHC &copy;</strong></h6>
            </div>
        </div>
    </div>
</div>
