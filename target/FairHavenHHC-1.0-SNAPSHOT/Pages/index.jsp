<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDbFvFGDIWUtgcA-FoQVEe0E-HX9kt-KtM" ></script>
<script type="text/javascript">
    function initialize() {
        var center = new google.maps.LatLng(33.7875783, -117.8787801);

        var mapOptions = {
            center: center,
            zoom: 9,
            minZoom: 4
        };


        var map = new google.maps.Map(document.getElementById("map-canvas"),
                mapOptions);

        var marker = new google.maps.Marker({
            position: center,
            map: map,
            title: 'Fairhaven HHC Offices'
        });

    }

    google.maps.event.addDomListener(window, 'load', initialize);
</script>



<div class="section header-image hide-on-med-and-down">
    <div class="row container">
        <div class="col s12 m12" >

        </div>
    </div>
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

<div class="section white">
    <div class="container">
        <div class="row">
            <div class="col s12 m6">
<<<<<<< HEAD
                <a href="services.htm"><h3 class="grey-text text-darken-1"><i class="fa fa-puzzle-piece light-green-text"></i> Services</h3></a>
=======
                <a href="services/"><h3 class=""><i class="fa fa-puzzle-piece light-green-text"></i> Services</h3></a>
>>>>>>> login
                <p>
                    <fmt:message key="home.section.mission" />
                </p>
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
                            <c:choose>
                                <c:when test="${service.offered && counter.count <= 4}">
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
                                </c:when>
                                <c:otherwise>
                                    <c:if test="${service.offered}">
                                        <tr class="hidden_rows additional_services">
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
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td class="right-align" colspan="3"><a href="" id="more_services"> <i class="fa fa-plus"></i></a></td>
                        </tr>
                    </tfoot>
                </table>
            </div>
            <div class="col s12 m6">
                <p><image src="${context}/images/services-optimized.jpg" class="responsive-img z-depth-1" style="border: 5px solid #fff" /></p>
            </div>
        </div>
    </div>
</div>

<div class="section">
    <div class="container">
        <div class="row">
            <div class="col s12 m3">
<<<<<<< HEAD
                <a href="/about"><h3 class=""><i class="fa fa-info light-blue-text"></i> <fmt:message key="home.section.about.heading" /></h3></a>
=======
<<<<<<< HEAD
                <a href="about.htm"><h3 class="grey-text text-darken-1"><i class="fa fa-info light-blue-text"></i> About us</h3></a>
=======
                <a href="about.htm"><h3 class=""><i class="fa fa-info light-blue-text"></i> <fmt:message key="home.section.about.heading" /></h3></a>
>>>>>>> login
>>>>>>> c4c55a6de9ef3c9716c8d750a5b4d5d57a1445b2
                <p>
                    <fmt:message key="home.section.about.text1" />
                </p>
                <blockquote>
                    <fmt:message key="home.section.about.text2" />
                </blockquote>
            </div>
            <div class="col s12 m3">
<<<<<<< HEAD
                <p><image src="images/about-optimized.jpg" class="responsive-img z-depth-1" style="border: 5px solid #fff;"/></p>
=======
                <p><image src="${context}/images/about-optimized.jpg" class="responsive-img z-depth-1" style="border: 5px solid #fff;"/></p>
>>>>>>> login
            </div>
            <div class="col s12 m6">
                <div class="row">
                    <div class="col s12 m12">
<<<<<<< HEAD
                        <a href="locations.htm"><h3 class="grey-text text-darken-1"><i class="fa fa-map-signs orange-text text-darken-3"></i> We're just around the corner</h3></a>
=======
                        <a href="locations.htm"><h3 class=""><i class="fa fa-map-signs orange-text text-darken-3"></i> <fmt:message key="home.section.location.heading" /></h3></a>
>>>>>>> login
                        <p>
                            <fmt:message key="home.section.location.text" /> <a href="#"><i class="fa fa-map-marker"></i> <fmt:message key="home.section.location.link" /></a>
                        </p>
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
        <div class="col s12 m6">
            <h2 class="thin"><fmt:message key="home.section.goal.heading" /></h2>
        </div>
        <div class="col s12 m6">
            <p>
                <fmt:message key="home.section.goal.text" />
            </p>
        </div>
    </div>
</div>
