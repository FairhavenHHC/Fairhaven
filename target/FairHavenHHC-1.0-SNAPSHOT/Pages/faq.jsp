
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<div class="container">
    <div class="row">
        <div class="col s12">
            <h3 class="thin"><fmt:message key="about.section.faq.heading" /></h3>
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