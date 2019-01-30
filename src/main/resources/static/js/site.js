function calculateImpostoDeRenda(){
    var salary = document.getElementById('salary').value;
    var redirectLink = window.location.protocol + "//" + window.location.host + window.location.pathname + '?salary=' + salary;
    console.log('Redirecting to: ' + redirectLink);
    window.location.href = redirectLink;
};