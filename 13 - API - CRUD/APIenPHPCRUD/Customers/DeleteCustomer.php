<?php
    header("Access-Control-Allow-Origin: *"); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
	header("Access-Control-Allow-Methods: GET, POST");
	header("Access-Control-Allow-Headers: Content-Type");

    include '../Conexion.php';
    
    if (!empty($_POST['cedula']) ) {

        $documento = $_POST['cedula'];

        try{

            $query = $base_de_datos->prepare("DELETE FROM clientes WHERE cedula = :doc");

            $query->bindParam(':doc', $documento);

            $proceso = $query->execute();

            if( $proceso ){
                $respuesta = [
                                'status' => true,
                                'message' => "OK##CLIENT##DELETE"
                              ];
                echo json_encode($respuesta);

            }else{
                $respuesta = [
                                'status' => false,
                                'message' => "ERROR##CLIENT##DELETE"
                              ];
                echo json_encode($respuesta);
            }

        }catch(Exception $e){
            $respuesta = [
                            'status' => false,
                            'message' => "ERROR##SQL",
                            'exception' => $e
                          ];
            echo json_encode($respuesta);
        }
    }else{
        $respuesta = [
                        'status' => false,
                        'message' => "ERROR##DATOS##POST"
                      ];
        echo json_encode($respuesta);
    }
?>
