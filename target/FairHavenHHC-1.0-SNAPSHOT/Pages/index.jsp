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
    }

    google.maps.event.addDomListener(window, 'load', initialize);
</script>



<div class="section header-image ">
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
                    Improving the quality of life for those we serve through delivery of clinical excellence, 
                    extraordinary service and compassionate care.
                </h3>
            </blockquote>
        </div>
    </div>
</div>

<div class="section white">
    <div class="container">
        <div class="row">
            <div class="col s12 m6">
                <a href="services.htm"><h3 class="grey-text text-darken-1"><i class="fa fa-puzzle-piece light-green-text"></i> Services</h3></a>
                <p>
                    We provide a wide array of services individualized to meet 
                    your specific needs. See how we compare.
                </p>
                <table class="striped bordered">
                    <thead>
                        <tr>
                            <th>Our services</th>
                            <th class="center-align">Fairhaven HHC</th>
                            <th class="center-align">Other HHCs</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Skilled home nursing (RN/LVN)</td>
                            <td class="center-align"><i class="fa fa-check green-text"></i></td>
                            <td class="center-align"><i class="fa fa-check green-text"></i></td>
                        </tr>
                        <tr>
                            <td>Home health aide</td>
                            <td class="center-align"><i class="fa fa-check green-text"></i></td>
                            <td class="center-align"><i class="fa fa-times red-text"></i></td>
                        </tr>
                        <tr>
                            <td>Home care services/companionship</td>
                            <td class="center-align"><i class="fa fa-check green-text"></i></td>
                            <td class="center-align"><i class="fa fa-check green-text"></i></td>
                        </tr>
                        <tr>
                            <td>Medical social work</td>
                            <td class="center-align"><i class="fa fa-check green-text"></i></td>
                            <td class="center-align"><i class="fa fa-times red-text"></i></td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="col s12 m6">
                <p><image src="${context}/images/services-optimized.jpg" class="responsive-img z-depth-1" style="border: 5px solid #fff" /></p>
            </div>
        </div>
        <div class="row">
            <div class="col s12 m3">
                <a href="about.htm"><h3 class="grey-text text-darken-1"><i class="fa fa-info light-blue-text"></i> About us</h3></a>
                <p>
                    Lorem Ipsum is simply dummy text of the printing and 
                    typesetting industry. Lorem Ipsum has been the industry's 
                    standard dummy text <a href="?lang=es">ever since the 1500s</a>, when an unknown 
                    printer took a galley of type and scrambled it to make a 
                    type specimen book
                </p>
            </div>
            <div class="col s12 m3">
                <p><image src="images/about-optimized.jpg" class="responsive-img z-depth-1" style="border: 5px solid #fff;"/></p>
            </div>
            <div class="col s12 m6">
                <div class="row">
                    <div class="col s12 m12">
                        <a href="locations.htm"><h3 class="grey-text text-darken-1"><i class="fa fa-map-signs orange-text text-darken-3"></i> We're just around the corner</h3></a>
                        <p>
                            We currently server the entire Orange county region. <a href="#"><i class="fa fa-map-marker"></i> Map us</a>
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

<div class="section">
    <div class="row container">
        <div class="col s12 m4">
            <h2 class="thin">Inspiration</h2>

        </div>
        <div class="col s12 m4">
            <h5>Some newsworthy story <small>By Sam Indiazi</small></h5>
            <p>
                Sed ut perspiciatis unde omnis iste natus error sit 
                voluptatem accusantium doloremque laudantium, totam rem 
                aperiam, eaque ipsa quae ab illo inventore veritatis et 
                quasi architecto beatae vitae dicta sunt explicabo. Nemo 
                enim ipsam voluptatem quia voluptas sit aspernatur aut odit 
                aut fugit, sed quia consequuntur magni dolores eos qui ratione 
                voluptatem sequi nesciunt. 
            <blockquote>labore et dolore magnam aliquam quaerat voluptatem. Ut enim 
                ad minima veniam, quis nostrum exercitationem ullam corporis 
                suscipit laboriosam, nisi ut aliquid ex ea commodi 
            </blockquote>
            <p  class="right-align"><cite>Some Customer</cite></p>
            </p>
            <p>Neque porro quisquam est, qui 
                dolorem ipsum quia dolor sit amet, consectetur, adipisci 
                velit, sed quia non numquam eius modi tempora incidunt ut 
                 consequatur? 
                Quis autem vel eum iure reprehenderit qui in ea voluptate velit 
                esse quam nihil molestiae consequatur, vel illum qui dolorem eum
                fugiat quo voluptas nulla pariatur?
            </p>
        </div>
    </div>
</div>
