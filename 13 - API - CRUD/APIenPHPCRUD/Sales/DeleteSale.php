<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");

include '../Conexion.php';

if(isset($_POST['id_venta']) && !empty($_POST['id_venta'])){
    $idVenta = $_POST['id_venta'];

    // eliminar registros de la tabla `detalles_venta`
    $consultaDetalles = $base_de_datos->prepare("DELETE FROM detalles_venta WHERE id_venta = :idVenta");
    $consultaDetalles->bindParam(':idVenta', $idVenta);

    $procesoDeleteDetalle = $consultaDetalles->execute();

    // eliminar el registro de la tabla `venta`
    $consultaVenta = $base_de_datos->prepare("DELETE FROM ventas WHERE id_venta = :idVenta");
    $consultaVenta->bindParam(':idVenta', $idVenta);

    $procesoDeleteVenta = $consultaVenta->execute();



    if($procesoDeleteDetalle && $procesoDeleteVenta) {
        $respuesta = [
            'status' => true,
            'message' => 'Venta registrada correctamente.',
        ];
        echo json_encode($respuesta);
    }else {
        $respuesta = [
            'status' => false,
            'message' => 'Error al insertar la venta o los detalles.',
        ];
        echo json_encode($respuesta);
    }

} else {
    http_response_code(400);
    echo json_encode(array("mensaje" => "ID de venta no proporcionado o vacío"));
}
?>
