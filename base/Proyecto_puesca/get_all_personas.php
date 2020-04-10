<?php

header('Content-type: application/json');
include "CORE/Persona.php";

$id = isset($_GET['persona'])?$_GET['persona']:false;
if($id){
    $id = "where nombre='$id'";
}else{
    $id = "";
}

$data = BDD::QUERY("select * from persona $id");

foreach ($data as $v)
{

    $usario = new Persona($v['idpersona']
        ,$v['nombre']
        ,$v['apellido']
        ,$v['cedula']
        ,$v['idtipo']
        ,$v['provincia']
        ,$v['contacto']
        ,$v['fecha_activacion']
        ,$v['estado']);
    $array[] = $usario;
}



if ($array) {
    $datas = array("persona"=>$array);
    echo json_encode($datas, JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);
} else {
    echo json_encode("error", JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);
}