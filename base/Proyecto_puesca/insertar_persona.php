<?php
include "CORE/CrudPersona.php";
$json = isset($_POST['json'])?$_POST['json']:false;

if($json){
    $var = json_decode($json,true);
    foreach ($var as $e) {
        $array = array("nombre" => $e['nombre']
        , "apellido" => $e['apellido']
        , "cedula"=> $e['cedula']
        , "idtipo" => $e['idtipo']
        , "provincia" => $e['provincia']
        , "contacto" => $e['contacto']
        , "fecha_activacion" => $e['fecha_activacion']
        , "idusuario" => $e['idusuario']);
        $idbase = $e['idbase'];
        if($idbase == 0)
                $id = CrudPersona::Insertar($array);
        else
            $id = CrudPersona::Actualizar($array,$idbase);
        echo json_encode($id,JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);
    }
}else{
    echo json_encode(json_encode($json),JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);;
}
