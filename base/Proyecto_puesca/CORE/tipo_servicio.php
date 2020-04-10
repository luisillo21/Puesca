<?php

include 'BDD/BDD.php';

class tipo_servicio
{
    public $idtipo_servicio;
    public $servicio;
    public $estado;

    /**
     * tipo_servicio constructor.
     * @param $idtipo_servicio
     * @param $servicio
     * @param $estado
     */
    public function __construct($idtipo_servicio, $servicio, $estado)
    {
        $this->idtipo_servicio = $idtipo_servicio;
        $this->servicio = $servicio;
        $this->estado = $estado;
    }

    /**
     * @return mixed
     */
    public function getIdtipoServicio()
    {
        return $this->idtipo_servicio;
    }

    /**
     * @param mixed $idtipo_servicio
     */
    public function setIdtipoServicio($idtipo_servicio)
    {
        $this->idtipo_servicio = $idtipo_servicio;
    }

    /**
     * @return mixed
     */
    public function getServicio()
    {
        return $this->servicio;
    }

    /**
     * @param mixed $servicio
     */
    public function setServicio($servicio)
    {
        $this->servicio = $servicio;
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


}