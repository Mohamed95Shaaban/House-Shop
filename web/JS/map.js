var  map,infoWindow, pos;
var marker;
function initMap() {
    var egy ={lat: 30.397, lng: 31.644};
    
    
    
     map = new google.maps.Map(document.getElementById('map'), {
        zoom: 12
    });
     marker = new google.maps.Marker({
        map: map
    });
    infowindow = new google.maps.InfoWindow;
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            egy = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
            };
            map.setCenter(egy);
            marker.setPosition(egy);
            infowindow.setContent('Latitude: ' + egy.lat + '<br>Longitude: ' + egy.lng);
            infowindow.open(map, marker);
            map.panTo(egy);
        }, function () {
            handleLocationError(true, infoWindow, map.getCenter());
        });
    } else {
        // Browser doesn't support Geolocation
        handleLocationError(false, infoWindow, map.getCenter());
    }

    google.maps.event.addListener(map,'click', function (event) {
        placeMarker(map,event.latLng);
    });
    
}
function placeMarker(map,location) {
    marker.setPosition(location);
    infowindow.setContent('Latitude: ' + location.lat() + '<br>Longitude: ' + location.lng());
    infowindow.open(map, marker);
    map.panTo(location);
    alert(location.pathname);
    document.getElementById("lat").value = location.lat();
    document.getElementById("lon").value = location.lng();
   
}
function handleLocationError(browserHasGeolocation, infoWindow, pos) {
    infoWindow.setPosition(pos);
    infoWindow.setContent(browserHasGeolocation ?
            'Error: The Geolocation service failed.' :
            'Error: Your browser doesn\'t support geolocation.');
    infoWindow.open(map);
}
 


   



