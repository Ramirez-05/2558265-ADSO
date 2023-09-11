let contentSales = null;
let contentDetalles = null;
let modalDetalle = null;
let waitContent = null;

window.onload = function(){
    contentSales = document.getElementById("contentSales");
    contentDetalles = document.getElementById("contentDetalles");
    waitContent = document.getElementById("waitContent");
    modalDetalle = new bootstrap.Modal(document.getElementById('modalDetalle'), {
        keyboard: false,
    })

    getSales("http://localhost/APIenPHPCRUD/Sales/ObtenerSale.php");
}

function getSales( endpoint ){
    waitContent.style.display = "block";
    fetch( endpoint )
    .then( res => res.json() )
    .then( data => {
        
        contentSales.innerHTML = "";
        for (var i = 0; i < data.registros.length; i++) {
            temp = `	<tr>
                            <td> ${ data.registros[i].id_venta } </td>
                            <td> ${ data.registros[i].id_cliente } </td>
                            <td> ${ data.registros[i].id_vendedor } </td>
                            <td> ${ data.registros[i].metododepago } </td>
                            <td> ${ data.registros[i].fecha } </td>
                            <td> 
                                <button class="col-12 btn btn-primary" onclick="abrirModalTabla(${data.registros[i].id_venta})"> DETALLES</button>
                            </td>
                        </tr>`;
            contentSales.innerHTML += temp;
        }
        waitContent.style.display = "none";
    })
    .catch( error => console.error(error) );
}

function abrirModalTabla( indice ){
    let datos = new FormData();
    datos.append('id_venta', indice);
    console.log(indice);

    modalDetalle.show();

    let configuracion ={
        method: 'POST',
        headers:{
            'Accept': 'application/json',
        },
        body: datos
    };

    fetch('http://localhost/APIenPHPCRUD/Sales/ObtenerDetalles.php', configuracion)
    .then( res => res.json() )
    .then( data => {
        contentDetalles.innerHTML = "";
        for (var i = 0; i < data.registros.length; i++) {
            temp = `	<tr>
                            <td> ${ data.registros[i].id_detalle } </td>
                            <td> ${ data.registros[i].id_venta } </td>
                            <td> ${ data.registros[i].id_producto } </td>
                            <td> ${ data.registros[i].cantidad } </td>
                        </tr>`;
            contentDetalles.innerHTML += temp;
        }
    });
}