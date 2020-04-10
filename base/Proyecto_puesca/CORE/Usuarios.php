<?php

include 'BDD/BDD.php';

class Usuarios
{
    public $idusuarios;
    public $nombre;
    public $estado;
    public $clave;
    public $cedula;

    /**
     * Usuarios constructor.
     * @param $idusuarios
     * @param $nombre
     * @param $estado
     * @param $clave
     */
    public function __construct($idusuarios, $nombre, $estado, $clave,$cedula)
    {
        $this->idusuarios = $idusuarios;
        $this->nombre = $nombre;
        $this->estado = $estado;
        $this->clave = $clave;
        $this->cedula = $cedula;
    }

    /**
     * @return mixed
     */
    public function getCedula()
    {
        return $this->cedula;
    }

    /**
     * @param mixed $cedula
     */
    public function setCedula($cedula)
    {
        $this->cedula = $cedula;
    }

    /**
     * @return mixed
     */
    public function getIdusuarios()
    {
        return $this->idusuarios;
    }

    /**
     * @param mixed $idusuarios
     */
    public function setIdusuarios($idusuarios)
    {
        $this->idusuarios = $idusuarios;
    }

    /**
     * @return mixed
     */
    public function getNombre()
    {
        return $this->nombre;
    }

    /**
     * @param mixed $nombre
     */
    public function setNombre($nombre)
    {
        $this->nombre = $nombre;
    }

    /**
     * @return mixed
     */
    public function getEstado()
    {
        return $this->estado;
    }

    /**
     * @param mixed $estado
     */
    public function setEstado($estado)
    {
        $this->estado = $estado;
    }

    /**
     * @return mixed
     */
    public function getClave()
    {
        return $this->clave;
    }

    /**
     * @param mixed $clave
     */
    public function setClave($clave)
    {
        $this->clave = $clave;
    }



}