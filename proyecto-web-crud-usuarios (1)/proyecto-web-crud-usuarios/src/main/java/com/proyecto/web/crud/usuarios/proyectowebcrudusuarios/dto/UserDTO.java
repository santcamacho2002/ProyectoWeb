package com.proyecto.web.crud.usuarios.proyectowebcrudusuarios.dto;

/**
 * Clase que representa los datos de un usuario.
 */
public class UserDTO {

    private String username;
    private String pwsd;
    private String nombreApellido;

    public UserDTO() {
    }

    /**
     * Constructor de la clase UserDTO.
     *
     * @param username       Nombre de usuario
     * @param pwsd           Contraseña del usuario
     * @param nombreApellido Nombre y apellido del usuario
     */
    public UserDTO(String username, String pwsd, String nombreApellido) {
        this.username = username;
        this.pwsd = pwsd;
        this.nombreApellido = nombreApellido;
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
