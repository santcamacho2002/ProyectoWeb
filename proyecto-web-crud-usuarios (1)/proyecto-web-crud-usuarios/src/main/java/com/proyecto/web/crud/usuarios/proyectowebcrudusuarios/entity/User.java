package com.proyecto.web.crud.usuarios.proyectowebcrudusuarios.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Clase que representa a un usuario.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String pwsd;
    private String nombreApellido;

    public User() {
    }

    /**
     * Constructor de la clase User.
     *
     * @param username       Nombre de usuario
     * @param pwsd           Contraseña del usuario
     * @param nombreApellido Nombre y apellido del usuario
     */
    public User(String username, String pwsd, String nombreApellido) {
        this.username = username;
        this.pwsd = pwsd;
        this.nombreApellido = nombreApellido;
    }

    /**
     * Obtiene el ID del usuario.
     *
     * @return ID del usuario
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del usuario.
     *
     * @param id ID del usuario
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de usuario.
     *
     * @return Nombre de usuario
     */
    public String getUsername() {
        return username;
    }

    /**
     * Establece el nombre de usuario.
     *
     * @param username Nombre de usuario
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return Contraseña del usuario
     */
    public String getPwsd() {
        return pwsd;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param pwsd Contraseña del usuario
     */
    public void setPwsd(String pwsd) {
        this.pwsd = pwsd;
    }

    /**
     * Obtiene el nombre y apellido del usuario.
     *
     * @return Nombre y apellido del usuario
     */
    public String getNombreApellido() {
        return nombreApellido;
    }

    /**
     * Establece el nombre y apellido del usuario.
     *
     * @param nombreApellido Nombre y apellido del usuario
     */
    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }
}
