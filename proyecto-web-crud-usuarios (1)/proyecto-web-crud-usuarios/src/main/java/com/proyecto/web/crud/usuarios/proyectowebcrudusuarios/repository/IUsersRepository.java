package com.proyecto.web.crud.usuarios.proyectowebcrudusuarios.repository;

import com.proyecto.web.crud.usuarios.proyectowebcrudusuarios.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad User.
 */
public interface IUsersRepository extends JpaRepository<User, Long> {

    /**
     * Busca un usuario por su nombre de usuario.
     *
     * @param username Nombre de usuario
     * @return Usuario encontrado o null si no se encuentra
     */
    Optional<User> findByUsername(String username);

    /**
     * Verifica si existe un usuario con el nombre de usuario especificado.
     *
     * @param username Nombre de usuario a verificar
     * @return true si existe, false si no existe
     */
    boolean existsByUsername(String username);

    /**
     * Elimina un usuario por su nombre de usuario.
     *
     * @param username Nombre de usuario
     */
    void deleteByUsername(String username);
}

