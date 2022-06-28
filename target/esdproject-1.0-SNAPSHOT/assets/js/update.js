let update_form = document.getElementById('update-validation');
//window.onload = fetch_courses;

update_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (update_form.checkValidity() === true) {
        let response = await fetch('api/specialization/update', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                specialization_id: document.getElementById('specialization_id').value,
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
    update_form.classList.add('was-validated');
});