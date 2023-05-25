package com.proyecto.web.crud.usuarios.proyectowebcrudusuarios.controller;

import com.proyecto.web.crud.usuarios.proyectowebcrudusuarios.dto.UserDTO;
import com.proyecto.web.crud.usuarios.proyectowebcrudusuarios.entity.User;
import com.proyecto.web.crud.usuarios.proyectowebcrudusuarios.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para la gestión de usuarios.
 */
@RestController
@RequestMapping("/apiUsers")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * Obtiene todos los usuarios.
     *
     * @return Lista de usuarios
     */
    @GetMapping("/users")
    public ResponseEntity<List<User>> allUsers(){
        List<User> list = userService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * Obtiene un usuario por su ID.
     *
     * @param id ID del usuario
     * @return Usuario encontrado
     */
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getById(@PathVariable("id")Long id){
        if(!userService.existsById(id)){
            return new ResponseEntity("No existe",HttpStatus.NOT_FOUND);
        }
        User user = userService.findById(id).get();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    /**
     * Crea un nuevo usuario.
     *
     * @param userDTO Datos del usuario a crear
     * @return Respuesta HTTP
     */
    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO){
        if(userService.existsByUsername(userDTO.getUsername())){
            return new ResponseEntity<>("Ya existe ese nombre de usuario",HttpStatus.BAD_REQUEST);
        }
        User user = new User(userDTO.getUsername(),userDTO.getPwsd(),userDTO.getNombreApellido());
        userService.saveUser(user);
        return new ResponseEntity<>("Usuario guardado!",HttpStatus.OK);
    }

    /**
     * Actualiza un usuario existente.
     *
     * @param id ID del usuario a actualizar
     * @param userDTO Datos del usuario actualizado
     * @return Respuesta HTTP
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id")Long id, @RequestBody UserDTO userDTO){

        if(!userService.existsById(id)){
            return new ResponseEntity("No existe",HttpStatus.NOT_FOUND);
        }
        if(userService.existsByUsername(userDTO.getUsername()) &&
                userService.getByUsername(userDTO.getUsername()).get().getId() != id){
            return new ResponseEntity<>("Ya existe ese nombre de usuario",HttpStatus.BAD_REQUEST);
        }

        User user = userService.findById(id).get();
        user.setUsername(userDTO.getUsername());
        user.setPwsd(userDTO.getPwsd());
        user.setNombreApellido(userDTO.getNombreApellido());
        userService.saveUser(user);

        return new ResponseEntity<>("Usuario actualizado!",HttpStatus.OK);
    }

    /**
     * Elimina un usuario por su ID.
     *
     * @param id ID del usuario a eliminar
     * @return Respuesta HTTP
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id")Long id){
        if(!userService.existsById(id)){
            return new ResponseEntity("No existe",HttpStatus.NOT_FOUND);
        }
        userService.deleteUser(id);
        return new ResponseEntity<>("Usuario eliminado!",HttpStatus.OK);
    }

}
