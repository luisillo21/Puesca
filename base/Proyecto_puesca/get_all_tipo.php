<?php

header('Content-type: application/json');
include "CORE/tipo_servicio.php";

$id = isset($_GET['tipo'])?$_GET['tipo']:false;
if($id){
    $id = "where idtipo_servicio='$id'";
}else{
    $id = "";
}

$data = BDD::QUERY("select * from tipo_servicio $id");

foreach ($data as $v)
{

    $usario = new tipo_servicio($v['idtipo_servicio'],$v['servicio']
        ,$v['estado']);
    $array[] = $usario;
}



if ($array) {
    $datas = array("tipo"=>$array);
    echo json_encode($datas, JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);
} else {
    echo json_encode("error", JSON_NUMERIC_CHECK | JSON_UNESCAPED_UNICODE | JSON_PRESERVE_ZERO_FRACTION | JSON_PRETTY_PRINT);
}