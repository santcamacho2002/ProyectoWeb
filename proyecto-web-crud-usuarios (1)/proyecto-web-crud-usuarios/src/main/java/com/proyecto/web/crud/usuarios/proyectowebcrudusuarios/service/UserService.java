package com.proyecto.web.crud.usuarios.proyectowebcrudusuarios.service;


import com.proyecto.web.crud.usuarios.proyectowebcrudusuarios.entity.User;
import com.proyecto.web.crud.usuarios.proyectowebcrudusuarios.repository.IUsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Clase de servicio que maneja las operaciones relacionadas con la entidad User.
 */
@Service
@Transactional
public class UserService {
    @Autowired
    IUsersRepository usersRepository;

    /**
     * Obtiene todos los usuarios.
     *
     * @return Lista de usuarios
     */
    public List<User> findAll() {
        return usersRepository.findAll();
    }

    /**
     * Busca un usuario por su ID.
     *
     * @param id ID del usuario a buscar
     * @return Usuario encontrado o null si no se encuentra
     */
    public Optional<User> findById(Long id) {
        return usersRepository.findById(id);
    }

    /**
     * Busca un usuario por su nombre de usuario.
     *
     * @param username Nombre de usuario a buscar
     * @return Usuario encontrado o null si no se encuentra
     */
    public Optional<User> getByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

    /**
     * Guarda un usuario en la base de datos.
     *
     * @param user Usuario a guardar
     */
    public void saveUser(User user) {
        usersRepository.save(user);
    }

    /**
     * Elimina un usuario por su ID.
     *
     * @param id ID del usuario a eliminar
     */
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

    /**
     * Verifica si existe un usuario con el ID especificado.
     *
     * @param id ID del usuario a verificar
     * @return true si existe, false si no existe
     */
    public boolean existsById(Long id) {
        return usersRepository.existsById(id);
    }

    /**
     * Verifica si existe un usuario con el nombre de usuario especificado.
     *
     * @param username Nombre de usuario a verificar
     * @return true si existe, false si no existe
     */
    public boolean existsByUsername(String username) {
        return usersRepository.existsByUsername(username);
    }
}
