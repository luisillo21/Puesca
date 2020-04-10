<?php
include 'BDD/BDD.php';


class Persona
{
    public $idpersona;
    public $nombre;
    public $apellido;
    public $cedula;
    public $idtipo;
    public $provincia;
    public $contacto;
    public $fecha_activacion;
    public $estado;


    /**
     * Persona constructor.
     * @param $idpersona
     * @param $nombre
     * @param $apellido
     * @param $cedula
     * @param $idtipo
     * @param $provincia
     * @param $contacto
     * @param $fecha_activacion
     * @param $estado

     */
    public function __construct($idpersona, $nombre, $apellido, $cedula, $idtipo, $provincia, $contacto, $fecha_activacion, $estado)
    {
        $this->idpersona = $idpersona;
        $this->nombre = $nombre;
        $this->apellido = $apellido;
        $this->cedula = $cedula;
        $this->idtipo = $idtipo;
        $this->provincia = $provincia;
        $this->contacto = $contacto;
        $this->fecha_activacion = $fecha_activacion;
        $this->estado = $estado;

    }

    /**
     * @return mixed
     */
    public function getIdpersona()
    {
        return $this->idpersona;
    }

    /**
     * @param mixed $idpersona
     */
    public function setIdpersona($idpersona)
    {
        $this->idpersona = $idpersona;
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
    public function getApellido()
    {
        return $this->apellido;
    }

    /**
     * @param mixed $apellido
     */
    public function setApellido($apellido)
    {
        $this->apellido = $apellido;
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
    public function getIdtipo()
    {
        return $this->idtipo;
    }

    /**
     * @param mixed $idtipo
     */
    public function setIdtipo($idtipo)
    {
        $this->idtipo = $idtipo;
    }

    /**
     * @return mixed
     */
    public function getProvincia()
    {
        return $this->provincia;
    }

    /**
     * @param mixed $provincia
     */
    public function setProvincia($provincia)
    {
        $this->provincia = $provincia;
    }

    /**
     * @return mixed
     */
    public function getContacto()
    {
        return $this->contacto;
    }

    /**
     * @param mixed $contacto
     */
    public function setContacto($contacto)
    {
        $this->contacto = $contacto;
    }

    /**
     * @return mixed
     */
    public function getFechaActivacion()
    {
        return $this->fecha_activacion;
    }

    /**
     * @param mixed $fecha_activacion
     */
    public function setFechaActivacion($fecha_activacion)
    {
        $this->fecha_activacion = $fecha_activacion;
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