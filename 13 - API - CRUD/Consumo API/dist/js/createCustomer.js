let contentClients = null;
let listaPersonas = null;
let formInsertarCliente = null;
let formEditarCliente = null;
let modalCrearCliente = null;
let modalEditarCliente = null;
let waitContent = null;
let waitContentCreate = null;
let waitContentEdit = null;

window.onload = function(){
	contentClients = document.getElementById("contentClients");
	formInsertarCliente = document.getElementById("formInsertarCliente");
	formEditarCliente = document.getElementById("formEditarCliente");
	waitContent = document.getElementById("waitContent");
	waitContentCreate = document.getElementById("waitContentCreate");
	waitContentEdit = document.getElementById("waitContentEdit");

	formInsertarCliente.addEventListener("submit", function(event){
		event.preventDefault();
		crearPersona();
	});

	formEditarCliente.addEventListener("submit", function(event){
		event.preventDefault();
		editarPersona();
	});


	modalCrearCliente = new bootstrap.Modal(document.getElementById('modalCrearCliente'), {
		keyboard: false,
	})

	modalEditarCliente = new bootstrap.Modal(document.getElementById('modalEditarCliente'), {
		keyboard: false,
	})

	getClients("http://localhost/APIenPHPCRUD/Customers/ObtenerCustomer.php");
}

function getClients( endpoint ){

	waitContent.style.display = "block";
	fetch( endpoint )
	.then( res => res.json() )
	.then( data => {
		listaPersonas = data.registros;
		contentClients.innerHTML = "";
		for (var i = 0; i < data.registros.length; i++) {
			temp = `	<tr>
							<td> ${ data.registros[i].cedula } </td>
							<td> ${ data.registros[i].nombre } </td>
							<td> ${ data.registros[i].apellido } </td>
							<td> ${ data.registros[i].email } </td>
							<td class="p-1">
								<button class="col-12 btn btn-primary" title="Editar Persona" onclick="abrirModalEditar(${i})"> <i class="fa fa-pencil" aria-hidden="true"></i> </button>
							</td>
							<td class="p-1">
								<button class="col-12 btn btn-danger" title="Eliminar Persona" onclick="confirmarEliminacion(${i})"> <i class="fa fa-trash" aria-hidden="true"></i> </button>
							</td>
						</tr> `;
			contentClients.innerHTML += temp;
		}

		waitContent.style.display = "none";
	});
}

function abrirModalEditar( indice ){
	document.getElementById("campo_editar_cedula").value = listaPersonas[indice].cedula;
	document.getElementById("campo_editar_nombres").value = listaPersonas[indice].nombre;
	document.getElementById("campo_editar_apellidos").value = listaPersonas[indice].apellido;
	document.getElementById("campo_editar_telefono").value = listaPersonas[indice].telefono;
	document.getElementById("campo_editar_direccion").value = listaPersonas[indice].direccion;
	document.getElementById("campo_editar_email").value = listaPersonas[indice].email;
	modalEditarCliente.show();
}

function confirmarEliminacion( indice ){
	console.log( "Eliminando: " );
	console.log( listaPersonas[indice] );

	Swal.fire({
				title: '¿Estas seguro?',	
				icon: 'warning',
				html: 'Se eliminara el registro de <b>'+listaPersonas[indice].nombre+' '+listaPersonas[indice].apellido+ ' Cedula: '+listaPersonas[indice].cedula+'</b>',
				showCancelButton: true,
				cancelButtonText: 'CANCELAR',
				confirmButtonText: 'ELIMINAR',
				confirmButtonColor: '#A10000',
				cancelButtonColor: '#00A100',
			}).then((result) => {
				if (result.isConfirmed) {
					eliminarPersona( listaPersonas[indice].cedula );
				}
			});

}

function crearPersona(){
	let datos = new FormData( formInsertarCliente );

	let configuracion = 	{
								method: "POST",
								headers: {
									"Accept": "application/json",
								},
								body: datos,
							};

	waitContentCreate.style.display = "block";
	fetch("http://localhost/APIenPHPCRUD/Customers/InsertCustomer.php", configuracion)
	.then( res => res.json() )
	.then( data => {

		if (data.status){
			formInsertarCliente.reset();
			modalCrearCliente.hide();
			getClients("http://localhost/APIenPHPCRUD/Customers/ObtenerCustomer.php");
			
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
			  html: 'Se presento un error al insertar, es posible que la cedula este repetida.',
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

		waitContentCreate.style.display = "none";
	});





}

function editarPersona(){
	let data = new FormData( formEditarCliente );

	let confifUpdate = 	{
								method: "POST",
								headers: {
									"Accept": "application/json",
								},
								body: data,
							};

	waitContentEdit.style.display = "block";
	fetch("http://localhost/APIenPHPCRUD/Customers/UpdateCustomer.php", confifUpdate)
	.then( res => res.json() )
	.then( data => {

		if (data.status){
			formEditarCliente.reset();
			modalEditarCliente.hide();
			getClients("http://localhost/APIenPHPCRUD/Customers/ObtenerCustomer.php");
			
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
	
	fetch("http://localhost/APIenPHPCRUD/Customers/DeleteCustomer.php", configDelete)
	.then( res => res.json() )
	.then( data => {

		console.log(data);
		
		if (data.status){
			getClients("http://localhost/APIenPHPCRUD/Customers/ObtenerCustomer.php");
			
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
