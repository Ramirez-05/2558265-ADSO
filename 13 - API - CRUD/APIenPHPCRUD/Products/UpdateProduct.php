<?php
    header("Access-Control-Allow-Origin: *"); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
	header("Access-Control-Allow-Methods: GET, POST");
	header("Access-Control-Allow-Headers: Content-Type");

    include '../Conexion.php';

    if (!empty($_POST['nombre']) and !empty($_POST['descripcion']) and !empty($_POST['precio']) and !empty($_POST['stock']) ) {
;
        $nombre = $_POST['nombres'];
        $descripcion = $_POST['descripcion'];
        $precio = $_POST['precio'];
        $stock = $_POST['stock'];

        try{

            $query = $base_de_datos->prepare("UPDATE productos SET descripcion = :descp, precio = :prec, stock = :stock WHERE nombre = :doc");

            $query->bindParam(':nom', $nombre);
            $query->bindParam(':descp', $descripcion);
            $query->bindParam(':prec', $precio);
            $query->bindParam(':stock', $stock);

            $proceso = $query->execute();

            if( $proceso ){
                $respuesta = [
                                'status' => true,
                                'mesagge' => "OK##CLIENT##UPDATE"
                              ];
                echo json_encode($respuesta);

            }else{
                $respuesta = [
                                'status' => false,
                                'mesagge' => "ERROR##CLIENT##UPDATE"
                              ];
                echo json_encode($respuesta);
            }

        }catch(Exception $e){
            $respuesta = [
                            'status' => false,
                            'mesagge' => "ERROR##SQL",
                            'exception' => $e
                          ];
            echo json_encode($respuesta);
        }
    }else{
        $respuesta = [
                        'status' => false,
                        'mesagge' => "ERROR##DATOS##POST"
                      ];
        echo json_encode($respuesta);
    }


?>