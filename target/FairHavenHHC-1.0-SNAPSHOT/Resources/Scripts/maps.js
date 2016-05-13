$(document).ready(function ($) {
    var center = new google.maps.LatLng(33.7876371, -117.87810389);
    var mapOptions = {
        center: center,
        zoom: 16,
        minZoom: 9
    };


    var map = new google.maps.Map($("#map-canvas").get(0),
            mapOptions);

    var marker = new google.maps.Marker({
        position: center,
        animation: google.maps.Animation.DROP,
        map: map,
        title: 'Main Office'
    });

    $(".marker").click(function (e) {
        e.preventDefault();
        setMarker($(e.target).attr('href'));
    });

    var setMarker = function (url) {
        var lat = Number(extractParam(url, "lat"));
        var long = Number(extractParam(url, "long"));
        var position = {lat: lat, lng: long};
        marker.setPosition(position);
        marker.setAnimation(google.maps.Animation.BOUNCE);
        map.panTo(position);
    }

    var extractParam = function (url, parameter) {
        var results = new RegExp('[\?&]' + parameter + '=([^&#]*)').exec(url);
        return results[1] || 0;
    }

    var latitude = extractParam(window.location.href, "lat");
    var longitude = extractParam(window.location.href, "long");

    if (latitude && longitude) {
        setMarker(window.location.href);
    }

});