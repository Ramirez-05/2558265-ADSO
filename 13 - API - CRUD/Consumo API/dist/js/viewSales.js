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
                            <td> ${ data.id_venta } </td>
                            <td> ${ data.id_cliente } </td>
                            <td> ${ data.id_vendedor } </td>
                            <td> ${ data.metododepago } </td>
                            <td> ${ data.fecha } </td>
                            <td> 
                                <button class="col-12 btn btn-primary" onclick="abrirModalTabla(${data.registros[i].id_venta})"> DETALLES</button>
                            </td>
                            <td> 
                                <button class="col-12 btn btn-danger" onclick="deleteVenta (${data.registros[i].id_venta})"> ELIMINAR</button>
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

function deleteVenta( indice ){

    Swal.fire({
        title: '¿Estás seguro?',	
        icon: 'warning',
        html: 'Se eliminará el registro de una venta',
        showCancelButton: true,
        cancelButtonText: 'CANCELAR',
        confirmButtonText: 'ELIMINAR',
        confirmButtonColor: '#A10000',
        cancelButtonColor: '#00A100',
    }).then((result) => {
        if (result.isConfirmed) {

            let datos = new FormData()
            datos.append('id_venta', indice);

            let configDelete = {
                method: "POST",
                headers: {
                    "Accept": "application/json",
                },
                body: datos, // Cambia formData por datos
            };

            fetch("http://localhost/APIenPHPCRUD/Sales/DeleteSale.php", configDelete)
            .then( res => res.json() )
            .then( data => {
        
                console.log(data);
                
                if (data.status){
                    getSales("http://localhost/APIenPHPCRUD/Sales/ObtenerSale.php");
                    
                    Swal.fire({
                        title: 'EXITO',
                        icon: 'success',
                        html: 'Registro eliminado con éxito.',
                        confirmButtonText: 'ENTENDIDO'
                    });

                } else {
                    Swal.fire({
                        title: 'ERROR',
                        icon: 'error',
                        html: 'Se presentó un error al eliminar.',
                        showCancelButton: true,
                        cancelButtonText: 'CANCELAR',
                        confirmButtonText: 'ENTENDIDO',
                        confirmButtonColor: '#00A100',
                        cancelButtonColor: '#A10000',
                    });
                }
            });
        }
    });
}

