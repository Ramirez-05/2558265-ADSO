<?php
    include "Conexion.php";
    if (!empty($_GET['id_cuestionario']) || !empty($_POST['id_cuestionario'])){
        $id_cuestionario = (!empty ($_POST['id_cuestionario']))? $_POST['id_cuestionario'] : $_GET['id_cuestionario']  ;

        $consulta = $base_de_datos->prepare("SELECT * FROM cuestionarios WHERE id = :id_cuestionario");
        $consulta->bindParam(":id_cuestionario",$id_cuestionario);
        $consulta->execute();
        $registro = $consulta->fetch(PDO::FETCH_ASSOC);

        if($registro["cant_preguntas"]>0){
            $consulta = $base_de_datos->prepare("SELECT * FROM respuestas WHERE id_cuestionario = :id_cuestionario");
            $consulta->bindParam(":id_cuestionario",$id_cuestionario);
            $consulta->execute();
            $datosRespuestas =$consulta->fetchAll(PDO::FETCH_ASSOC);
            if(empty($datosRespuestas)){
                $respuesta = [
                    "status" => false,
                    "message"=> "Cuestionario sin respuestas",
                    ];
                echo json_encode($respuesta);
                exit();
            }
            for ($i=0; $i < count($datosRespuestas); $i++) { 
                $consulta = $base_de_datos->prepare("SELECT * FROM preguntas WHERE id = :id_pregunta");
                $consulta->bindParam(":id_pregunta",$datosRespuestas[$i]['id_pregunta']);
                $consulta->execute();
                $datosPregunta =$consulta->fetchAll(PDO::FETCH_ASSOC);
                $temp_id_pregunta = $datosRespuestas[$i]['id_pregunta'];
                $datosRespuestas[$i]['pregunta'] = $datosPregunta[0];
                
                unset($datosRespuestas[$i]['id_pregunta']);
                $consulta = $base_de_datos->prepare("SELECT * FROM opciones WHERE id_pregunta = :id_pregunta");
                $consulta->bindParam(":id_pregunta",$temp_id_pregunta);
                $consulta->execute();
                $datosOpciones =$consulta->fetchAll(PDO::FETCH_ASSOC);
                $datosRespuestas[$i]['opciones'] = $datosOpciones;
            }
        }else{
            $respuesta = [
                "status" => false,
                "message"=> "Cuestionario sin preguntas",
                ];
            echo json_encode($respuesta);
            exit();
        }
                
        if(!empty($datosRespuestas)){
            $respuesta = [
                "status" => true,
                "message" => "CORRECTO##DATOS",
                "respuestas" => $datosRespuestas
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
