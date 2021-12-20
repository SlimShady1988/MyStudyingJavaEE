document.addEventListener('DOMContentLoaded', function () {
    const xhttp = new XMLHttpRequest();
    let sendBtn = document.getElementById('send');
    sendBtn.addEventListener('click', () => {
            let name = document.getElementById("name").value;
            let pass = document.getElementById("pass").value;
            console.log(name);
            console.log(pass);


        xhttp.open("POST", "/user/blog");
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send("name=" + name + "&pass=" + pass);
        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === XMLHttpRequest.DONE) {
                if (xhttp.status === 200) {
                    console.log('200');
                    document.getElementById("myDiv").innerHTML = xhttp.status;
                }
                else if (xhttp.status === 400) {
                    document.getElementById("myDiv").innerHTML = xhttp.status;
                    console.log('There was an error 400');
                } else {
                    document.getElementById("myDiv").innerHTML = xhttp.status;
                    console.log('something else other than 200 was returned');
                }
            }
        }
    });
});
