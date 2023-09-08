<?php
    header("Access-Control-Allow-Origin: *"); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
	header("Access-Control-Allow-Methods: GET, POST");
	header("Access-Control-Allow-Headers: Content-Type");

    include '../Conexion.php';

    if (!empty($_POST['cedula']) and !empty($_POST['nombres']) and !empty($_POST['apellidos']) and !empty($_POST['telefono']) and !empty($_POST['direccion']) and !empty($_POST['email']) ) {

        $documento = $_POST['cedula'];
        $nombre = $_POST['nombres'];
        $apellido = $_POST['apellidos'];
        $telefono = $_POST['telefono'];
        $direccion = $_POST['direccion'];
        $email = $_POST['email'];

        try{

            $query = $base_de_datos->prepare("UPDATE clientes SET nombre = :nom, apellido = :ape, telefono = :tel, direccion = :dir, email = :ema WHERE cedula = :doc");

            $query->bindParam(':doc', $documento);
            $query->bindParam(':nom', $nombre);
            $query->bindParam(':ape', $apellido);
            $query->bindParam(':tel', $telefono);
            $query->bindParam(':dir', $direccion);
            $query->bindParam(':ema', $email);

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