let contentSellers = null;
let listaVendedores = null;
let formInsertarSeller = null;
let formEditarSeller = null;
let modalCrearSeller = null;
let modalEditarSeller = null;
let waitContent = null;
let waitContentCreate = null;
let waitContentEdit = null;

window.onload = function(){
	contentSellers = document.getElementById("contentSellers");
	formInsertarSeller = document.getElementById("formInsertarSeller");
	formEditarSeller = document.getElementById("formEditarSeller");
	waitContent = document.getElementById("waitContent");
	waitContentCreate = document.getElementById("waitContentCreate");
	waitContentEdit = document.getElementById("waitContentEdit");

	formInsertarSeller.addEventListener("submit", function(event){
		event.preventDefault();
		crearPersona();
	});

	formEditarSeller.addEventListener("submit", function(event){
		event.preventDefault();
		editarPersona();
	});


	modalCrearSeller = new bootstrap.Modal(document.getElementById('modalCrearSeller'), {
		keyboard: false,
	})

	modalEditarSeller = new bootstrap.Modal(document.getElementById('modalEditarSeller'), {
		keyboard: false,
	})

	getClients("http://localhost/APIenPHPCRUD/Sellers/ObtenerSeller.php");
}

function getClients( endpoint ){

	waitContent.style.display = "block";
	fetch( endpoint )
	.then( res => res.json() )
	.then( data => {
		listaVendedores = data.registros;
		contentSellers.innerHTML = "";
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
			contentSellers.innerHTML += temp;
		}

		waitContent.style.display = "none";
	});
}

function abrirModalEditar( indice ){
	document.getElementById("campo_editar_cedula").value = listaVendedores[indice].cedula;
	document.getElementById("campo_editar_nombres").value = listaVendedores[indice].nombre;
	document.getElementById("campo_editar_apellidos").value = listaVendedores[indice].apellido;
	document.getElementById("campo_editar_telefono").value = listaVendedores[indice].telefono;
	document.getElementById("campo_editar_direccion").value = listaVendedores[indice].direccion;
	document.getElementById("campo_editar_email").value = listaVendedores[indice].email;
	modalEditarSeller.show();
}

function confirmarEliminacion( indice ){
	console.log( "Eliminando: " );
	console.log( listaVendedores[indice] );

	Swal.fire({
				title: '¿Estas seguro?',	
				icon: 'warning',
				html: 'Se eliminara el registro de <b>'+listaVendedores[indice].nombre+' '+listaVendedores[indice].apellido+ ' Cedula: '+listaVendedores[indice].cedula+'</b>',
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
	let datos = new FormData( formInsertarSeller );

	let configuracion = 	{
								method: "POST",
								headers: {
									"Accept": "application/json",
								},
								body: datos,
							};

	waitContentCreate.style.display = "block";
	fetch("http://localhost/APIenPHPCRUD/Sellers/InsertSeller.php", configuracion)
	.then( res => res.json() )
	.then( data => {

		if (data.status){
			formInsertarSeller.reset();
			modalCrearSeller.hide();
			getClients("http://localhost/APIenPHPCRUD/Sellers/ObtenerSeller.php");
			
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
	let data = new FormData( formEditarSeller );

	let confifUpdate = 	{
								method: "POST",
								headers: {
									"Accept": "application/json",
								},
								body: data,
							};

	waitContentEdit.style.display = "block";
	fetch("http://localhost/APIenPHPCRUD/Sellers/UpdateSeller.php", confifUpdate)
	.then( res => res.json() )
	.then( data => {

		if (data.status){
			formEditarSeller.reset();
			modalEditarSeller.hide();
			getClients("http://localhost/APIenPHPCRUD/Sellers/ObtenerSeller.php");
			
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
	
	fetch("http://localhost/APIenPHPCRUD/Sellers/DeleteSeller.php", configDelete)
	.then( res => res.json() )
	.then( data => {

		console.log(data);
		
		if (data.status){
			getClients("http://localhost/APIenPHPCRUD/Sellers/ObtenerSeller.php");
			
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
