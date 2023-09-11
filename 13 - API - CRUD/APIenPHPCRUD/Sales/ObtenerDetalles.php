<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");

include '../Conexion.php';

if(isset($_POST['id_venta']) && !empty($_POST['id_venta'])){
    $idVenta = $_POST['id_venta'];

    $consulta = $base_de_datos->prepare("SELECT * FROM detalles_venta WHERE id_venta = :idVenta");
    $consulta->bindParam(':idVenta', $idVenta);
    $consulta->execute();

    $datos = $consulta->fetchAll();

    $respuesta['registros'] = $datos;
    echo json_encode($respuesta);
} else {
    http_response_code(400);
    echo json_encode(array("mensaje" => "ID de venta no proporcionado o vacío"));
}
?>
