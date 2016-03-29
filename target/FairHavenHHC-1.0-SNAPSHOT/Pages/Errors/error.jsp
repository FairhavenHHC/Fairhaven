<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:redirect url="/error.htm" >
    <c:set var="error_data" value="${pageContext.errorData}" scope="session"/>
    <c:set var="debug" value="true" scope="session" />
    <c:set var="error_message" value="${requestScope['javax.servlet.error.message']}" scope="session"/>
</c:redirect>