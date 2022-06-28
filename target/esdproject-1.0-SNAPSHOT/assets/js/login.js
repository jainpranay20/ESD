let login_form = document.getElementById('login-validation');
//window.onload = fetch_courses;

login_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (login_form.checkValidity() === true) {
        console.log("hii");
        let response = await fetch('api/employee/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                email: document.getElementById('email').value,
            })
        });
        let result = await response;
        console.log(result);
        login_form.classList.add('was-validated');
        if(result['status'] === 500){

            location.href = "register.html";
        }

    }
    console.log("hello");

});