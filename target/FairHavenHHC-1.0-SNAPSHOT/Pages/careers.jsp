<%--
    Document   : careers
    Created on : Apr 3, 2016, 3:14:47 PM
    Author     : Sam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<div class="section" id="careers-header-section">
    <div class="container">
        <div class="row">
            <div class="col s12 m12 l12">
                <h2 class="thin center-align"><fmt:message key="careers.section.main.heading" /></h2>
            </div>
        </div>
        <div class="row">
            <div class="col s12 m12 l4 offset-l1">
                <div class="card">
                    <div class="card-image waves-effect waves-block waves-light">
                        <img src="${context}/images/services-optimized.jpg" alt="Caregiver">
                    </div>
                    <div class="card-content">
                        <span class="card-title activator grey-text text-darken-4"><fmt:message key="careers.section.card.caregiver" /><i class="material-icons right">more_vert</i></span>
                        <p><a href="#">This is a link</a></p>
                    </div>
                    <div class="card-reveal">
                        <span class="card-title grey-text text-darken-4"><fmt:message key="careers.section.card.caregiver" /><i class="material-icons right">close</i></span>
                        <p>Here is some more information about this product that is only revealed once clicked on.</p>
                    </div>
                </div>
            </div>
            <div class="col s12 m12 l4 offset-l2">
                <div class="card">
                    <div class="card-image waves-effect waves-block waves-light">
                        <img src="${context}/images/services-optimized.jpg" alt="Administration">
                    </div>
                    <div class="card-content">
                        <span class="card-title activator grey-text text-darken-4"><fmt:message key="careers.section.card.administration" /><i class="material-icons right">more_vert</i></span>
                        <p><a href="#">This is a link</a></p>
                    </div>
                    <div class="card-reveal">
                        <span class="card-title grey-text text-darken-4"><fmt:message key="careers.section.card.administration" /><i class="material-icons right">close</i></span>
                        <p>Here is some more information about this product that is only revealed once clicked on.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
