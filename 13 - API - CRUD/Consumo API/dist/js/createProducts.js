let contentProducts = null;
let listaVendedores = null;
let formInsertarProduct = null;
let formEditarProduct = null;
let modalCrearProduct = null;
let modalEditarProduct = null;
let waitContent = null;
let waitContentCreate = null;
let waitContentEdit = null;

window.onload = function(){
	contentProducts = document.getElementById("contentProducts");
	formInsertarProduct = document.getElementById("formInsertarProduct");
	formEditarProduct = document.getElementById("formEditarProduct");
	waitContent = document.getElementById("waitContent");
	waitContentCreate = document.getElementById("waitContentCreate");
	waitContentEdit = document.getElementById("waitContentEdit");

	formInsertarProduct.addEventListener("submit", function(event){
		event.preventDefault();
		crearPersona();
	});

	formEditarProduct.addEventListener("submit", function(event){
		event.preventDefault();
		editarPersona();
	});


	modalCrearProduct = new bootstrap.Modal(document.getElementById('modalCrearProduct'), {
		keyboard: false,
	})

	modalEditarProduct = new bootstrap.Modal(document.getElementById('modalEditarProduct'), {
		keyboard: false,
	})

	getClients("http://localhost/APIenPHPCRUD/Products/ObtenerProduct.php");
}

function getClients( endpoint ){

	waitContent.style.display = "block";
	fetch( endpoint )
	.then( res => res.json() )
	.then( data => {
		listaVendedores = data.registros;
		contentProducts.innerHTML = "";
		for (var i = 0; i < data.registros.length; i++) {
			temp = `	<tr>
							<td> ${ data.registros[i].nombre } </td>
							<td> ${ data.registros[i].descripcion } </td>
							<td> ${ data.registros[i].precio } </td>
							<td> ${ data.registros[i].stock } </td>
							<td class="p-1">
								<button class="col-12 btn btn-primary" title="Editar Persona" onclick="abrirModalEditar(${i})"> <i class="fa fa-pencil" aria-hidden="true"></i> </button>
							</td>
							<td class="p-1">
								<button class="col-12 btn btn-danger" title="Eliminar Persona" onclick="confirmarEliminacion(${i})"> <i class="fa fa-trash" aria-hidden="true"></i> </button>
							</td>
						</tr> `;
			contentProducts.innerHTML += temp;
		}

		waitContent.style.display = "none";
	});
}

function abrirModalEditar( indice ){
	document.getElementById("campo_editar_nombres").value = listaVendedores[indice].nombre;
	document.getElementById("campo_editar_descripcion").value = listaVendedores[indice].descripcion;
	document.getElementById("campo_editar_precio").value = listaVendedores[indice].precio;
	document.getElementById("campo_editar_stock").value = listaVendedores[indice].stock;
	modalEditarProduct.show();
}

function confirmarEliminacion( indice ){
	console.log( "Eliminando: " );
	console.log( listaVendedores[indice] );

	Swal.fire({
				title: '¿Estas seguro?',	
				icon: 'warning',
				html: 'Se eliminara el registro de <b>'+listaVendedores[indice].nombre+'</b>',
				showCancelButton: true,
				cancelButtonText: 'CANCELAR',
				confirmButtonText: 'ELIMINAR',
				confirmButtonColor: '#A10000',
				cancelButtonColor: '#00A100',
			}).then((result) => {
				if (result.isConfirmed) {
					eliminarPersona( listaVendedores[indice].cedula );
				}
			});

}

function crearPersona(){
	let datos = new FormData( formInsertarProduct );

	let configuracion = 	{
								method: "POST",
								headers: {
									"Accept": "application/json",
								},
								body: datos,
							};

	waitContentCreate.style.display = "block";
	fetch("http://localhost/APIenPHPCRUD/Products/InsertProduct.php", configuracion)
	.then( res => res.json() )
	.then( data => {

		if (data.status){
			formInsertarProduct.reset();
			modalCrearProduct.hide();
			getClients("http://localhost/APIenPHPCRUD/Products/ObtenerProduct.php");
			
			Swal.fire({
			  title: 'EXITO',
			  icon: 'success',
			  html: 'Registro creado con exito.',
			  confirmButtonText: 'ENTENDIDO'
			});

		}else{
			
			Swal.fire({
			  title: 'ERROR',
			  icon: 'error',
			  html: 'Se presento un error al insertar',
			  showCancelButton: true,
			  cancelButtonText: 'CANCELAR',
			  confirmButtonText: 'ENTENDIDO',
			  confirmButtonColor: '#00A100',
			  cancelButtonColor: '#A10000',
			}).then((result) => {
			  if (result.isConfirmed) {
			  	document.getElementById("campo_nombre").value = "";
			    document.getElementById("campo_nombre").focus();
			  }
			});

		}

		waitContentCreate.style.display = "none";
	});


}

function editarPersona(){
	let data = new FormData( formEditarProduct );

	let confifUpdate = 	{
								method: "POST",
								headers: {
									"Accept": "application/json",
								},
								body: data,
							};

	waitContentEdit.style.display = "block";
	fetch("http://localhost/APIenPHPCRUD/Products/UpdateProduct.php", confifUpdate)
	.then( res => res.json() )
	.then( data => {

		if (data.status){
			formEditarProduct.reset();
			modalEditarProduct.hide();
			getClients("http://localhost/APIenPHPCRUD/Products/ObtenerProduct.php");
			
			Swal.fire({
			  title: 'EXITO',
			  icon: 'success',
			  html: 'Registro actualizado con exito.',
			  confirmButtonText: 'ENTENDIDO'
			});

		}else{
			
			Swal.fire({
			  title: 'ERROR',
			  icon: 'error',
			  html: 'Se presento un error al actualizar.',
			  showCancelButton: true,
			  cancelButtonText: 'CANCELAR',
			  confirmButtonText: 'ENTENDIDO',
			  confirmButtonColor: '#00A100',
			  cancelButtonColor: '#A10000',
			}).then((result) => {
			  if (result.isConfirmed) {
			  	document.getElementById("campo_cedula").value = "";
			    document.getElementById("campo_cedula").focus();
			  }
			});

		}

		waitContentEdit.style.display = "none";
	});

}

function eliminarPersona( cedula ){

	let formData = new FormData();
    formData.append('cedula', cedula); // Agrega la cédula al FormData

    let configDelete = {
							method: "POST",
							headers: {
								"Accept": "application/json",
							},
							body: formData, // Envía el FormData como cuerpo
						};
	
	fetch("http://localhost/APIenPHPCRUD/Products/DeleteProduct.php", configDelete)
	.then( res => res.json() )
	.then( data => {

		console.log(data);
		
		if (data.status){
			getClients("http://localhost/APIenPHPCRUD/Products/ObtenerProduct.php");
			
			Swal.fire({
				title: 'EXITO',
				icon: 'success',
				html: 'Registro eliminado con exito.',
				confirmButtonText: 'ENTENDIDO'
			});

		}else{
				Swal.fire({
				title: 'ERROR',
				icon: 'error',
				html: 'Se presento un error al eliminar.',
				showCancelButton: true,
				cancelButtonText: 'CANCELAR',
				confirmButtonText: 'ENTENDIDO',
				confirmButtonColor: '#00A100',
				cancelButtonColor: '#A10000',
				}).then((result) => {
				if (result.isConfirmed) {
					document.getElementById("campo_cedula").value = "";
					document.getElementById("campo_cedula").focus();
				}
			});

		}

	});



}
