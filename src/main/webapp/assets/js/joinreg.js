let specialization_form = document.getElementById('specialization-validation');
//window.onload = fetch_courses;


/*specialization_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (specialization_form.checkValidity() === true) {
        let response = await fetch('api/specialization/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                code: document.getElementById('code').value,
                name: document.getElementById('name').value,
                description: document.getElementById('description').value,
                year: document.getElementById('year').value,
                credits: document.getElementById('credits').value,
            })
        });
        let result = await response;
        console.log(result);
    }
    specialization_form.classList.add('was-validated');
});*/

specialization_form.onsubmit = async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (specialization_form.checkValidity() === true) {
      let form_data = new FormData();
        form_data.append('code', document.getElementById('code').value);
      form_data.append('name', document.getElementById('name').value);
      form_data.append('description', document.getElementById('description').value);
      form_data.append('year', document.getElementById('year').value);
      form_data.append('credits', document.getElementById('credits').value);
      form_data.append('check1', document.getElementById('check1').value);
      form_data.append('check2', document.getElementById('check2').value);
      form_data.append('check3', document.getElementById('check3').value);

        // $.ajax({
        //   type: "POST",
        //   url: "api/courses/register",
        //   enctype: 'multipart/form-data',
        //   data: form_data,
        //   processData: false,
        //   contentType: false,
        // }).done(function(response, status) {
        //   console.log(response, status);
        // });
        let response = await fetch('api/courses/register', {
        method: 'POST',
        body: form_data
      });
      let result = await response;
      console.log(result);
    }
    specialization_form.classList.add('was-validated');
};

/*
async function fetch_courses(){
    let response = await fetch("api/courses/get");
    let courses = await response.json(); // read response body and parse as JSON
    console.log(courses);
    let courses_option = document.getElementById('courses');
    courses_option.innerHTML = '<option value=""> Choose...</option>';

    for(let i = 0 ; i<courses.length ; i++){
        courses_option.innerHTML += '<option value="'+courses[i]+'">'+courses[i]+'</option>';
    }
}

 */