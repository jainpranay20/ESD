let delete_form = document.getElementById('delete-validation');
//window.onload = fetch_courses;

delete_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (delete_form.checkValidity() === true) {
        let response = await fetch('api/specialization/delete', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                specialization_id: document.getElementById('specialization_id').value,
            })
        });
        let result = await response;
        console.log(result);
    }
    delete_form.classList.add('was-validated');
});