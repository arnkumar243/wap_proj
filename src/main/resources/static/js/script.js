function fetchLatestImage() {
    fetch('/api/esp/latest')
        .then(response => response.json())
        .then(data =>
            {
                console.log(data)
                let imageElement = document.getElementById("camera-image");
                imageElement.src = 'data:image/jpeg;base64,' + data.image;

                const d = new Date(data.date).toLocaleString(undefined, {
                    timeZone: 'America/Los_Angeles'
                });
                let dateElement = document.getElementById("camera-time");
                dateElement.innerHTML = 'Image captured at ' + d + ' PDT <i onclick="changeCameraState(\'none\')" class="fa fa-refresh" aria-hidden="true"></i>';
            }
        )
        .catch(error => console.error(error));
}
fetchLatestImage();

function getDoorState() {
    const url = "/api/pir/action";
    fetch(url)
        .then(response => {
            return response.text();
        })
        .then(data => {
            console.log(data)
            changeButtonState(data);
        })
        .catch(error => console.error(error));
}
getDoorState();

function changeDoorState(action) {
    fetch('/api/pir/action', {
        method: 'POST',
        body: action
    }).then(response => {
        return response.text();
    }).then(data=>
            changeButtonState(action)
    ).catch(error => console.error(error));
}

function changeCameraState(action) {
    fetch('/api/esp/action', {
        method: 'POST',
        body: action
    }).then(response => {
        return response.text();
    }).then(data=> {
        console.log("Changed camera state to post.");
    }).catch(error => console.error(error));
}
changeCameraState();

setInterval(fetchLatestImage, 5000);

function changeButtonState(action) {

    let lockDoorElement = document.getElementById("lock-door");
    let unLockDoorElement = document.getElementById("unlock-door");

    if(action === 'lock') {
        lockDoorElement.classList.add('disabled');
        unLockDoorElement.classList.remove('disabled');
    } else {
        unLockDoorElement.classList.add('disabled');
        lockDoorElement.classList.remove('disabled');
    }

}