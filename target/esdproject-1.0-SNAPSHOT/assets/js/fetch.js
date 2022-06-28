async function sample_data(){

    let response = await fetch('api/specialization/fetch');
    let result = await response.json();
    result=JSON.stringify(result);

    var obj = JSON.parse(result);

    for (x in obj) {
        console.log(x);
        console.log(obj[x]);

    }

    let table_data = document.getElementById('myTable1');
    table_data.innerHTML = '';

    for (x in obj) {
        //<th scope="row">'+(i+1)+'</th>\n
        let tr_data = document.createElement('tr');
        tr_data.innerHTML= //'<th scope="row"></th>\n' +
            '               <td>'+x+'</td>\n' +
            '               <td>'+obj[x]+'</td>';

        table_data.appendChild(tr_data);

    }




}