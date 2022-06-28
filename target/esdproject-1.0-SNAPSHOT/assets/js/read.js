async function fetch_data(){

        let response = await fetch('api/specialization/read');
        let result = await response.json();
        console.log(result);

        let table_data = document.getElementById('myTable');
        table_data.innerHTML = '';

        for (let i = 0; i < result.length; i++) {
                //<th scope="row">'+(i+1)+'</th>\n
                let tr_data = document.createElement('tr');
                tr_data.innerHTML= //'<th scope="row"></th>\n' +
                    '               <td>'+result[i]['specialization_id']+'</td>\n' +
                    '               <td>'+result[i]['code']+'</td>\n' +
                    '               <td>'+result[i]['name']+'</td>\n' +
                    '               <td>'+result[i]['description']+'</td>\n' +
                    '               <td>'+result[i]['year']+'</td>\n' +
                    '               <td>'+result[i]['credits']+'</td>';
                table_data.appendChild(tr_data);

        }

}