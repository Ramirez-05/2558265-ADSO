let contentPersons = null;
let waitContent = null;

window.onload = function(){
    contentPersons = document.getElementById("contentPersons");
    waitContent = document.getElementById("waitContent");

    getSales("http://localhost:8080/listaPersonas");
}

function getSales( endpoint ){
    waitContent.style.display = "block";
    fetch( endpoint )
    .then( res => res.json() )
    .then( data => {
        console.table(data);
        
        contentPersons.innerHTML = "";
        for (var i = 0; i < data.length; i++) {
            temp = `	<tr>
                            <td> ${ data[i].cedula } </td>
                            <td> ${ data[i].nombres } </td>
                            <td> ${ data[i].apellidos } </td>
                            <td> ${ data[i].telefono } </td>
                            <td> ${ data[i].email } </td>                                                               
                        </tr>`;
            contentPersons.innerHTML += temp;
        }
        waitContent.style.display = "none";
    })
    .catch( error => console.error(error) );
}
