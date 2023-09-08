let contentClients = null;
let listaPersonas = null;
let formInsertarUsuario = null;
let formEditarUsuario = null;
let modalCrearUsuario = null;
let modalEditarUsuario = null;
let waitContent = null;
let waitContentCreate = null;
let waitContentEdit = null;

window.onload = function(){
	contentClients = document.getElementById("contentClients");
	formInsertarUsuario = document.getElementById("formInsertarUsuario");
	formEditarUsuario = document.getElementById("formEditarUsuario");
	waitContent = document.getElementById("waitContent");
	waitContentCreate = document.getElementById("waitContentCreate");
	waitContentEdit = document.getElementById("waitContentEdit");

	formInsertarUsuario.addEventListener("submit", function(event){
		event.preventDefault();
		crearPersona();
	});

	formEditarUsuario.addEventListener("submit", function(event){
		event.preventDefault();
		editarPersona();
	});

	modalCrearUsuario = new bootstrap.Modal(document.getElementById('modalCrearUsuario'), {
		keyboard: false,
	})

	modalEditarUsuario = new bootstrap.Modal(document.getElementById('modalEditarUsuario'), {
		keyboard: false,
	})

	getClients("http://localhost/APIenPHP/Obtener.php");
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
							<td> ${ data.registros[i].nombres } </td>
							<td> ${ data.registros[i].apellidos } </td>
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
	document.getElementById("campo_editar_nombres").value = listaPersonas[indice].nombres;
	document.getElementById("campo_editar_apellidos").value = listaPersonas[indice].apellidos;
	document.getElementById("campo_editar_telefono").value = listaPersonas[indice].telefono;
	document.getElementById("campo_editar_direccion").value = listaPersonas[indice].direccion;
	document.getElementById("campo_editar_email").value = listaPersonas[indice].email;
	modalEditarUsuario.show();
}

function confirmarEliminacion( indice ){
	console.log( "Eliminando: " );
	console.log( listaPersonas[indice] );

	Swal.fire({
				title: '¿Estas seguro?',	
				icon: 'warning',
				html: 'Se eliminara el registro de <b>'+listaPersonas[indice].nombres+' '+listaPersonas[indice].apellidos+ ' Cedula: '+listaPersonas[indice].cedula+'</b>',
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
	let datos = new FormData( formInsertarUsuario );

	let configuracion = 	{
								method: "POST",
								headers: {
									"Accept": "application/json",
								},
								body: datos,
							};

	waitContentCreate.style.display = "block";
	fetch("http://localhost/APIenPHP/Insert.php", configuracion)
	.then( res => res.json() )
	.then( data => {

		if (data.status){
			formInsertarUsuario.reset();
			modalCrearUsuario.hide();
			getClients("http://localhost/APIenPHP/Obtener.php");
			
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
	let data = new FormData( formEditarUsuario );

	let confifUpdate = 	{
								method: "POST",
								headers: {
									"Accept": "application/json",
								},
								body: data,
							};

	waitContentEdit.style.display = "block";
	fetch("http://localhost/APIenPHP/Update.php", confifUpdate)
	.then( res => res.json() )
	.then( data => {

		if (data.status){
			formEditarUsuario.reset();
			modalEditarUsuario.hide();
			getClients("http://localhost/APIenPHP/Obtener.php");
			
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
	
	fetch("http://localhost/APIenPHP/Delete.php", configDelete)
	.then( res => res.json() )
	.then( data => {

		console.log(data);
		
		if (data.status){
			getClients("http://localhost/APIenPHP/Obtener.php");
			
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
