let ventaForm =null;
let contentSelectCustomer = null;
let contentSelectSeller = null;
let contentCheckboxesProduct = null;
let formInsertarVenta = null;
let inputs_cantidad = null;
let waitContent = null;
let modalReistrarVenta = null;

window.onload = function () {
    ventaForm = document.getElementById("ventaForm");
    contentSelectCustomer = document.getElementById("content_select_customer");
    contentSelectSeller = document.getElementById("content_select_sellers");
    contentCheckboxesProduct = document.getElementById("content_checkboxes_product");
    inputs_cantidad = document.getElementById("inputs_cantidad");
    formInsertarVenta = document.getElementById("formInsertarVenta");
    waitContent = document.getElementById("waitContent");

    formInsertarVenta.addEventListener("submit", function(event){
		event.preventDefault();
		crearVenta();
	});

    modalReistrarVenta = new bootstrap.Modal(document.getElementById('modalReistrarVenta'), {
        keyboard: false,
    })

    getCustomers("http://localhost/APIenPHPCRUD/Customers/ObtenerCustomer.php");
    getSellers("http://localhost/APIenPHPCRUD/Sellers/ObtenerSeller.php");
    getProducts("http://localhost/APIenPHPCRUD/Products/ObtenerProduct.php");
}


// ------------------------- BLOQUE PARA OBTENER DATOS DE LA API -------------------------

function getCustomers(apiUrl) {
    waitContent.style.display = "block";

    fetch(apiUrl)
        .then(response => response.json())
        .then(data => {
            if (Array.isArray(data.registros)) {
                createCustomerSelect(data.registros);
            } else {
                console.error('La respuesta de la API para clientes no es válida:', data);
            }
        })
        .catch(error => console.error('Error al obtener clientes:', error))
        .finally(() => {
            waitContent.style.display = "none";
        } );
}

function getSellers(apiUrl) {
    waitContent.style.display = "block";

    fetch(apiUrl)
        .then(response => response.json())
        .then(data => {
            if (Array.isArray(data.registros)) {
                createSellerSelect(data.registros);
            } else {
                console.error('La respuesta de la API para vendedores no es válida:', data);
            }
        })
        .catch(error => console.error('Error al obtener vendedores:', error))
        .finally(() => {
            waitContent.style.display = "none";
        });
}

function getProducts(apiUrl) {
    waitContent.style.display = "block";

    fetch(apiUrl)
        .then(response => response.json())
        .then(data => {
            if (Array.isArray(data.registros)) {
                createProductCheckboxes(data.registros);
            } else {
                console.error('La respuesta de la API para productos no es válida:', data);
            }
        })
        .catch(error => console.error('Error al obtener productos:', error))
        .finally(() => {
            waitContent.style.display = "none";
        });
}

// ------------------------- FIN BLOQUE PARA OBTENER DATOS DE LA API -------------------------



// ------------------------- BLOQUE PARA CREAR LOS SELECTS -------------------------

function createCustomerSelect(data) {
    let select = document.createElement('select');
    select.className = 'form-select';
    select.name = 'id_cliente'; 
    select.id = 'id_cliente';
    select.required = true;
    let defaultOption = document.createElement('option');
    defaultOption.value = '';
    defaultOption.textContent = 'Seleccionar cliente...';
    select.appendChild(defaultOption);
    data.forEach(cliente => {
        let option = document.createElement('option');
        option.value = cliente.id_cliente;
        option.textContent = `${cliente.cedula} - ${cliente.nombre} ${cliente.apellido}`;
        select.appendChild(option);
    });
    contentSelectCustomer.appendChild(select);
}

function createSellerSelect(data) {
    let select = document.createElement('select');
    select.className = 'form-select';
    select.name = 'id_vendedor'; 
    select.id = 'id_vendedor';
    select.required = true;
    let defaultOption = document.createElement('option');
    defaultOption.value = '';
    defaultOption.textContent = 'Seleccionar vendedor...';
    select.appendChild(defaultOption);
    data.forEach(vendedor => {
        let option = document.createElement('option');
        option.value = vendedor.id_vendedor;
        option.textContent = `${vendedor.cedula} - ${vendedor.nombre} ${vendedor.apellido}`;
        select.appendChild(option);
    });
    contentSelectSeller.appendChild(select);
}

// ------------------------- FIN BLOQUE PARA CREAR LOS SELECTS -------------------------



// ------------------------- BLOQUE PARA CREAR LOS CHECKBOXES -------------------------

function createProductCheckboxes(data) {
    data.forEach(producto => {
        let checkbox = document.createElement('input');
        checkbox.type = 'checkbox';
        checkbox.id = `producto`;
        checkbox.className = 'product-checkbox';
        checkbox.name = 'productos[]'; 
        checkbox.value = producto.id_producto;

        let label = document.createElement('label');
        label.textContent = `${producto.nombre} - Precio: ${producto.precio}`;

        let container = document.createElement('div');
        container.appendChild(checkbox);
        container.appendChild(label);

        contentCheckboxesProduct.appendChild(container);
    });
}

// ------------------------- FIN BLOQUE PARA CREAR LOS CHECKBOXES -------------------------



// ------------------------- BLOQUE PARA VALIDAR LOS DATOS DEL FORMULARIO  Y ACTUALIZAR EL MODAL -------------------------

function actualizarContenidoModal() {
    console.log("Función actualizarContenidoModal llamada");
    // ------------------------- bloque 1 ----------------------------------

    let selectCliente = document.getElementById("id_cliente");
    let selectVendedor = document.getElementById("id_vendedor");

    let clienteSeleccionado = selectCliente.value;
    let vendedorSeleccionado = selectVendedor.value;

    if (!clienteSeleccionado) {
        Swal.fire({
            title: 'ERROR',
            icon: 'error',
            html: 'Verifica que hayas seleccionado un cliente.',
            showCancelButton: true,
            cancelButtonText: 'CANCELAR',
            confirmButtonText: 'ENTENDIDO',
            confirmButtonColor: '#00A100',
            cancelButtonColor: '#A10000',
        });
        return;
    }

    if (!vendedorSeleccionado) {
        Swal.fire({
            title: 'ERROR',
            icon: 'error',
            html: 'Verifica que hayas seleccionado un vendedor.',
            showCancelButton: true,
            cancelButtonText: 'CANCELAR',
            confirmButtonText: 'ENTENDIDO',
            confirmButtonColor: '#00A100',
        });
        return;
    }

    document.getElementById("clienteSeleccionado").textContent = "Cliente: " + selectCliente.options[selectCliente.selectedIndex].text;
    document.getElementById("vendedorSeleccionado").textContent = "Vendedor: " + selectVendedor.options[selectVendedor.selectedIndex].text;


    // ------------------------- fin bloque 1 ----------------------------------

    // ------------------------- bloque 2 ----------------------------------
    
    let checkboxes = document.querySelectorAll('.product-checkbox:checked');

    if (checkboxes.length === 0) {
        Swal.fire({
            title: 'ERROR',
            icon: 'error',
            html: 'Verifica que hayas seleccionado al menos un producto.',
            showCancelButton: true,
            cancelButtonText: 'CANCELAR',
            confirmButtonText: 'ENTENDIDO',
            confirmButtonColor: '#00A100',
            cancelButtonColor: '#A10000',
        });
        return;
    }
    
    inputs_cantidad.innerHTML = "";

    checkboxes.forEach(function (checkbox) {
        let productoLabel = document.createElement("label");
        productoLabel.textContent = checkbox.nextSibling.textContent.trim(); 

        let productoInput = document.createElement("input");
        productoInput.type = "text";
        productoInput.name = "cantidades[]";
        productoInput.placeholder = "Cantidad";

        inputs_cantidad.appendChild(productoLabel);
        inputs_cantidad.appendChild(productoInput);
    });

    // ------------------------- fin bloque 2 ----------------------------------

    modalReistrarVenta.show();

}

// ------------------------- FIN BLOQUE PARA VALIDAR LOS DATOS DEL FORMULARIO  Y ACTUALIZAR EL MODAL -------------------------



// ------------------------- BLOQUE PARA CREAR LA VENTA -------------------------

function crearVenta() {
    let formData = new FormData();

    // Obtener el valor del cliente y vendedor seleccionados
    clienteSeleccionado = document.getElementById("id_cliente").value;
    vendedorSeleccionado = document.getElementById("id_vendedor").value;

    // Obtener el valor del método de pago desde el select
    let metodoDePago = document.getElementById("metododepago").value;

    // Agregar los valores al formData
    formData.append("id_cliente", clienteSeleccionado);
    formData.append("id_vendedor", vendedorSeleccionado);
    formData.append("metododepago", metodoDePago);


    // Obtener la lista de productos y cantidades desde los inputs
    let cantidadInputsJSON = [];
    let cantidadInputs = document.querySelectorAll("#inputs_cantidad input");
    cantidadInputs.forEach(function (input) {
        cantidadInputsJSON.push({
            cantidad: input.value,
        });
    });
    formData.append("cantidades", JSON.stringify(cantidadInputsJSON));

    // Obtener los productos seleccionados
    let productosSeleccionados = [];
    let productoCheckboxes = document.querySelectorAll('.product-checkbox:checked');
    productoCheckboxes.forEach(function (checkbox) {
        productosSeleccionados.push({
            id: checkbox.value, // Obtener el valor (ID) del checkbox
        });
    });

    // Agregar los productos seleccionados al formData
    formData.append("productos", JSON.stringify(productosSeleccionados));

    console.log('Datos en formData antes de enviar:');
    console.log(formData.get("id_cliente"));
    console.log(formData.get("id_vendedor"));
    console.log(formData.get("metododepago"));
    console.log(formData.get("cantidades"));
    console.log(formData.get("productos"));

    waitContent.style.display = "block";

    let configInsert = {
        method: 'POST',
        headers: {
            "Accept": "application/json",
        },
        body: formData
    };

    fetch("http://localhost/APIenPHPCRUD/Sales/InsertSale.php", configInsert)
        .then(response => response.json())
        .then(data => {
            console.log("respuesta recibida:");
            console.log(data);
            if (data.status) {
                Swal.fire({
                    title: 'EXITO',
                    icon: 'success',
                    html: 'Venta registrada con éxito.',
                    confirmButtonText: 'ENTENDIDO'
                });

                modalReistrarVenta.hide();
                ventaForm.reset();
            } else {
                Swal.fire({
                    title: 'ERROR',
                    icon: 'error',
                    html: 'Se presentó un error al registrar la venta.',
                    showCancelButton: true,
                    cancelButtonText: 'CANCELAR',
                    confirmButtonText: 'ENTENDIDO',
                    confirmButtonColor: '#00A100',
                    cancelButtonColor: '#A10000',
                });
            }
        })
        .catch(error => console.error('Error al registrar la venta:', error))
        .finally(() => {
            waitContent.style.display = "none";
        });
}


// ------------------------- FIN BLOQUE PARA CREAR LA VENTA -------------------------
