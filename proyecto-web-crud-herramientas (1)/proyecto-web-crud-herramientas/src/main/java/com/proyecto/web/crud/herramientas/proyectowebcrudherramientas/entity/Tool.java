package com.proyecto.web.crud.herramientas.proyectowebcrudherramientas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


/**
 * Entidad que indica los atributos de una herramienta
 */
@Entity
public class Tool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private String imageUrl;
    private Long idMarca;
    private double precio;
    private String ciudad;
    private int cantidad;


    /**
     * Constructor vacío de Tool.
     */
    public Tool(){

    }


    /**
     * Constructor de Tool que acepta todos los campos.
     *
     * @param nombre      Nombre de la herramienta.
     * @param descripcion Descripción de la herramienta.
     * @param imageUrl    URL de la imagen de la herramienta.
     * @param idMarca     ID de la marca de la herramienta.
     * @param precio      Precio de la herramienta.
     * @param ciudad      Ciudad de la herramienta.
     * @param cantidad    Cantidad de la herramienta disponible.
     */
    public Tool(String nombre, String descripcion, String imageUrl, Long idMarca, double precio,
                String ciudad, int cantidad) {

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imageUrl = imageUrl;
        this.idMarca = idMarca;
        this.precio = precio;
        this.ciudad = ciudad;
        this.cantidad = cantidad;
    }

    /**
     * Metodo que obtiene el ID de la herramienta.
     *
     * @return ID de la herramienta.
     */
    public Long getId() {
        return id;
    }

    /**
     * Metodo que establece el ID de la herramienta.
     *
     * @param id ID de la herramienta.
     */
    public void setId(Long id) {
        this.id = id;
    }


    /**
     * Metodo que obtiene el nombre de la herramienta.
     *
     * @return Nombre de la herramienta.
     */
    public String getNombre() {
        return nombre;
    }


    /**
     * Metodo que establece el nombre de la herramienta.
     *
     * @param nombre Nombre de la herramienta.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    /**
     * Metodo que obtiene la descripción de la herramienta.
     *
     * @return Descripción de la herramienta.
     */
    public String getDescripcion() {
        return descripcion;
    }


    /**
     * Metodo que establece la descripción de la herramienta.
     *
     * @param descripcion Descripción de la herramienta.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Metodo que obtiene la URL de la imagen de la herramienta.
     *
     * @return URL de la imagen de la herramienta.
     */
    public String getImageUrl() {
        return imageUrl;
    }


    /**
     * Metodo que establece la URL de la imagen de la herramienta.
     *
     * @param imageUrl URL de la imagen de la herramienta.
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    /**
     * Metodo que obtiene el ID de la marca de la herramienta.
     *
     * @return ID de la marca de la herramienta.
     */
    public Long getIdMarca() {
        return idMarca;
    }


    /**
     * Metodo que establece el ID de la marca de la herramienta.
     *
     * @param idMarca ID de la marca de la herramienta.
     */
    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
    }


    /**
     * Metodo que obtiene el precio de la herramienta.
     *
     * @return Precio de la herramienta.
     */
    public double getPrecio() {
        return precio;
    }


    /**
     * Metodo que establece el precio de la herramienta.
     *
     * @param precio Precio de la herramienta.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }


    /**
     * Metodo que obtiene la ciudad de la herramienta.
     *
     * @return Ciudad de la herramienta.
     */
    public String getCiudad() {
        return ciudad;
    }


    /**
     * Metodo que establece la ciudad de la herramienta.
     *
     * @param ciudad Ciudad de la herramienta.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }


    /**
     * Metodo que obtiene la cantidad de la herramienta disponible.
     *
     * @return Cantidad de la herramienta disponible.
     */
    public int getCantidad() {
        return cantidad;
    }


    /**
     * Metodo que establece la cantidad de la herramienta disponible.
     *
     * @param cantidad Cantidad de la herramienta disponible.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
