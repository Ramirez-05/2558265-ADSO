<?php
  include "Conexion.php";

  if (!empty($_GET['id_usuario']) || !empty($_POST['id_usuario'])){
    $id_usuario = (!empty ($_POST['id_usuario']))? $_POST['id_usuario'] : $_GET['id_usuario']  ;
    $consulta = $base_de_datos->prepare("SELECT * FROM cuestionarios WHERE id_usuario = :id_usuario");
    $consulta->bindParam(":id_usuario",$id_usuario);
    $consulta->execute();
    $datosCuestionarios =$consulta->fetchAll(PDO::FETCH_ASSOC);
    if(!empty($datosCuestionarios)){
      $respuesta = [
        "status" => true,
        "message" => "CORRECTO##DATOS",
        "cuestionarios" => $datosCuestionarios
      ];
      echo json_encode($respuesta);
    }else{
      $respuesta = [
        "status" => false,
        "message" => "ERROR##DATOS"
      ];
      echo json_encode($respuesta);
    }

  }else{
    $respuesta = [
      "status" => false,
      "message" => "ERROR##DATOS"
    ];
    echo json_encode($respuesta);
  }
?>