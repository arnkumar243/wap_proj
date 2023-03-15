function createUser() {

    const form = document.getElementById('member-registration');
    const formData = new FormData(form);
    const jsonObject = {};

    for (const [key, value] of formData.entries()) {
        jsonObject[key] = value;
    }

    jsonObject['enabled'] = true;
    const baseUrl = `${window.location.protocol}//${window.location.hostname}:${window.location.port}`;
    const json = JSON.stringify(jsonObject);

    console.log("formData in string : " + json);
    console.log("url : " + baseUrl);

    fetch('/api/user/signup?url=' + baseUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: json
    }).then(response => response.json()
    ).then(data =>{
        console.log("Created User "  + data);
        window.location.href = baseUrl + '/login';
    }).catch(error => console.error(error));

}