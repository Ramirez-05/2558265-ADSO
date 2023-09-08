<?php 
    header("Access-Control-Allow-Origin: *"); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
    header("Access-Control-Allow-Methods: GET, POST");
    header("Access-Control-Allow-Headers: Content-Type");
    
    include '../Conexion.php';

    if (!empty($_POST['nombre']) and !empty($_POST['descripcion']) and !empty($_POST['precio']) ) {

        $nombres = $_POST['nombre'];
        $descripcion = $_POST['descripcion'];
        $precio = $_POST['precio'];
        $stock = $_POST['stock'];

        try {
            $consulta = $base_de_datos->prepare("INSERT INTO productos (nombre, descripcion, precio, stock) VALUES( :nom, :descr, :prec, :sto) ");

            $consulta->bindParam(':nom', $nombres);
            $consulta->bindParam(':descr', $descripcion);
            $consulta->bindParam(':prec', $precio);
            $consulta->bindParam(':sto', $stock);
            
            $proceso = $consulta->execute();

            if( $proceso ){
                $respuesta = [
                                'status' => true,
                                'mesagge' => "OK##CLIENT##INSERT"
                              ];
                echo json_encode($respuesta);
            }else{
                $respuesta = [
                                'status' => false,
                                'mesagge' => "ERROR##CLIENT##INSERT"
                              ];
                echo json_encode($respuesta);
            }
        } catch (Exception $e) {
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
