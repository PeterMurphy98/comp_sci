let map;

function initMap() {
    fetch("/stations").then( response => {
        return response.json();
    }).then(data => {
        console.log("data: ", data);

        map = new google.maps.Map(document.getElementById("map"), {
            center: { lat: 53.349804, lng: -6.260310 },
            zoom: 13.5,
        });

        // Create global variable to store one infoWindow
        const infoWindow = new google.maps.InfoWindow();
        data.forEach(station => {
            const marker = new google.maps.Marker({
                position: { lat: station.pos_lat, lng: station.pos_lng },
                map: map,
            });
            marker.addListener("click", async () => {
                clickedStation = await onStationClicked(station).then(data => {
                    return data;
                }).catch(err => {
                    console.log("Error: ", err);
                });
                const lastUpdate = new Date(clickedStation[0].last_update).toLocaleTimeString();

                infoWindow.setContent(
                    "<div id=info><table><tr>" +
                    "<td>Location:</td><td>" + station.address + "</td></tr><tr>" +
                    "<td>Available Bikes:</td><td>" + clickedStation[0].available_bikes + "</td></tr><tr>" +
                    "<td>Available Bikestands:</td><td>" + clickedStation[0].available_bike_stands + "</td></tr>" +
                    "<td>Last update:</td><td>" + lastUpdate + "</td></tr>" +
                    "</table></div>"
                    );
                infoWindow.open(map, marker);
            });
        });

    }).catch(err => {
        console.log("Error.", err);
    });
}

async function onStationClicked(obj){
    try {
        const response = await fetch("/current/"+obj.number);
        const bikes = await response.json();
        return bikes;
    } catch (err) {
        console.log("Error: ", err);
    }
}


