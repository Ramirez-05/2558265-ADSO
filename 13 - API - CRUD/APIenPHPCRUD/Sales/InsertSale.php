<?php
    header("Access-Control-Allow-Origin: *");
    header("Access-Control-Allow-Methods: POST");
    header("Access-Control-Allow-Headers: Content-Type");
    include '../Conexion.php';

    // Verifica si se recibieron datos en la solicitud POST
    if ($_SERVER['REQUEST_METHOD'] === 'POST') {
        // Verifica si se proporcionaron los campos necesarios
        if (
            !empty($_POST['id_cliente']) &&
            !empty($_POST['id_vendedor']) &&
            !empty($_POST['metododepago']) &&
            !empty($_POST['productos']) // Esto es un arreglo de productos que escogió el cliente
        ) {
            $clienteNombre = $_POST['id_cliente'];
            $vendedorNombre = $_POST['id_vendedor'];
            $metodoDePago = $_POST['metododepago'];
            $productos = json_decode($_POST['productos'], true);
            $cantidades = json_decode($_POST['cantidades'], true);
            
            error_log("clienteNombre:".$clienteNombre);
            error_log("vendedorNombre:".$vendedorNombre);
            error_log("metodoDePago:". $metodoDePago);
            error_log("Productos: " . json_encode($productos));
            error_log("Cantidades: " . json_encode($cantidades));

            try {
                // Insertar la venta principal
                $consultaVenta = $base_de_datos->prepare("INSERT INTO ventas (id_cliente, id_vendedor, metododepago) VALUES (:idCliente, :idVendedor, :metodoDePago)");
                $consultaVenta->bindParam(':idCliente', $clienteNombre);
                $consultaVenta->bindParam(':idVendedor', $vendedorNombre);
                $consultaVenta->bindParam(':metodoDePago', $metodoDePago);

                $procesoVenta = $consultaVenta->execute();

                // Obtener el ID de la venta recién insertada
                $idVenta = $base_de_datos->lastInsertId();

                // Insertar los detalles de la venta
                $consultaDetalle = $base_de_datos->prepare("INSERT INTO detalles_venta (id_venta, id_producto, cantidad) VALUES (:idVenta, :idProducto, :cantidad)");

                foreach ($productos as $key => $producto) {
                    $productoId = $producto['id'];
                    $cantidad = $cantidades[$key]['cantidad'];
                    error_log("productoId:");
                    error_log($productoId);
                    error_log("cantidad:");
                    error_log($cantidad);

                    $consultaDetalle->bindParam(':idVenta', $idVenta);
                    $consultaDetalle->bindParam(':idProducto', $productoId);
                    $consultaDetalle->bindParam(':cantidad', $cantidad);

                    error_log("idVenta:" . $idVenta);

                    $procesoDetalle = $consultaDetalle->execute();

                }
                

                if ($procesoVenta && $procesoDetalle) {
                    $respuesta = [
                        'status' => true,
                        'message' => 'Venta registrada correctamente.',
                    ];
                    echo json_encode($respuesta);
                } else {
                    $respuesta = [
                        'status' => false,
                        'message' => 'Error al insertar la venta o los detalles.',
                    ];
                    echo json_encode($respuesta);
                }
            } catch (Exception $e) {
                $respuesta = [
                    'status' => false,
                    'message' => "Error en la consulta SQL.",
                    'exception' => $e->getMessage(),
                ];
                echo json_encode($respuesta);
            }
        } else {
            $faltanDatos = [];

            if (empty($_POST['id_cliente'])) {
                $faltanDatos[] = 'id_cliente';
            }

            if (empty($_POST['id_vendedor'])) {
                $faltanDatos[] = 'id_vendedor';
            }

            if (empty($_POST['metododepago'])) {
                $faltanDatos[] = 'metododepago';
            }

            if (empty($_POST['productos'])) {
                $faltanDatos[] = 'productos';
            }

            $respuesta = [
                'status' => false,
                'message' => 'Faltan datos requeridos en la solicitud POST.',
                'missing_fields' => $faltanDatos,
            ];
            echo json_encode($respuesta);
        }
    } else {
        $respuesta = [
            'status' => false,
            'message' => 'Solicitud no válida. Se espera una solicitud POST.',
        ];
        echo json_encode($respuesta);
    }
?>
