<?php
include "BDD/BDD.php";


class CrudPersona
{
    public static function Insertar($array){
        $id = BDD::INSERTAR_DESDE_ARRAY("persona",$array);
        if($id){
            return $array = array("id"=>$id);
        }else{
            return $array = array();
        }
    }
    public static function Actualizar($array,$id){
        if(BDD::ACTUALIZAR_DESDE_ARRAY("persona",$array,"idpersona=$id")){
            return $array = array("id"=>$id);
        }else{
            return $array = array();
        }
    }
}