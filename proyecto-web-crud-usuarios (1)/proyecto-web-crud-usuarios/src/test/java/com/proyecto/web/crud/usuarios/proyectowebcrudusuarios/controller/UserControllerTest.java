package com.proyecto.web.crud.usuarios.proyectowebcrudusuarios.controller;

import com.proyecto.web.crud.usuarios.proyectowebcrudusuarios.dto.UserDTO;
import com.proyecto.web.crud.usuarios.proyectowebcrudusuarios.entity.User;
import com.proyecto.web.crud.usuarios.proyectowebcrudusuarios.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserControllerTest {
    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAllUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("user1", "password1", "Daniel Ramirez"));
        userList.add(new User("user2", "password2", "Juliana Salamanca"));

        when(userService.findAll()).thenReturn(userList);

        ResponseEntity<List<User>> response = userController.allUsers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userList, response.getBody());

        verify(userService, times(1)).findAll();
        verifyNoMoreInteractions(userService);
    }


    @Test
    public void testGetById_Existente() {
        Long userId = 1L;
        User user = new User("user1", "password1", "Nombre1 Apellido1");

        when(userService.existsById(userId)).thenReturn(true);
        when(userService.findById(userId)).thenReturn(Optional.of(user));

        ResponseEntity<User> responseEntity = userController.getById(userId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(user, responseEntity.getBody());

        verify(userService, times(1)).existsById(userId);
        verify(userService, times(1)).findById(userId);
    }

    @Test
    public void testGetById_NoExistente() {
        Long userId = 1L;

        when(userService.existsById(userId)).thenReturn(false);

        ResponseEntity<User> responseEntity = userController.getById(userId);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

        verify(userService, times(1)).existsById(userId);
        verify(userService, never()).findById(userId);
    }


    @Test
    public void testCreateUser_NoExistente() {
        UserDTO userDTO = new UserDTO("user1", "password1", "Nombre1 Apellido1");

        when(userService.existsByUsername(userDTO.getUsername())).thenReturn(false);

        ResponseEntity<?> responseEntity = userController.createUser(userDTO);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Usuario guardado!", responseEntity.getBody());

        verify(userService, times(1)).existsByUsername(userDTO.getUsername());
        verify(userService, times(1)).saveUser(any(User.class));
    }

    @Test
    public void testCreateUser_Existente() {
        UserDTO userDTO = new UserDTO("user1", "password1", "Nombre1 Apellido1");

        when(userService.existsByUsername(userDTO.getUsername())).thenReturn(true);

        ResponseEntity<?> responseEntity = userController.createUser(userDTO);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Ya existe ese nombre de usuario", responseEntity.getBody());

        verify(userService, times(1)).existsByUsername(userDTO.getUsername());
        verify(userService, never()).saveUser(any(User.class));
    }


    @Test
    public void testUpdateUser_Existente() {
        Long userId = 1L;
        UserDTO userDTO = new UserDTO("user1", "password1", "Nombre1 Apellido1");
        User existingUser = new User("existingUser", "password", "Nombre Apellido");

        when(userService.existsById(userId)).thenReturn(true);
        when(userService.existsByUsername(userDTO.getUsername())).thenReturn(false);
        when(userService.findById(userId)).thenReturn(Optional.of(existingUser));

        ResponseEntity<?> responseEntity = userController.updateUser(userId, userDTO);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Usuario actualizado!", responseEntity.getBody());

        verify(userService, times(1)).existsById(userId);
        verify(userService, times(1)).existsByUsername(userDTO.getUsername());
        verify(userService, times(1)).findById(userId);
        verify(userService, times(1)).saveUser(any(User.class));
    }


    @Test
    public void testUpdateUser_NoExistente() {
        Long userId = 1L;
        UserDTO userDTO = new UserDTO("user1", "password1", "Nombre1 Apellido1");

        when(userService.existsById(userId)).thenReturn(false);

        ResponseEntity<?> responseEntity = userController.updateUser(userId, userDTO);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

        verify(userService, times(1)).existsById(userId);
        verify(userService, never()).existsByUsername(userDTO.getUsername());
        verify(userService, never()).findById(userId);
        verify(userService, never()).saveUser(any(User.class));
    }



    @Test
    public void testUpdateUser_ExistenteConMismoUsuario() {
        Long userId = 1L;
        UserDTO userDTO = new UserDTO("user1", "password1", "Nombre1 Apellido1");
        User existingUser = new User("user1", "password", "Nombre Apellido");

        when(userService.existsById(userId)).thenReturn(true);
        when(userService.existsByUsername(userDTO.getUsername())).thenReturn(true);
        when(userService.getByUsername(userDTO.getUsername())).thenReturn(Optional.of(existingUser));

        ResponseEntity<?> responseEntity = userController.updateUser(userId, userDTO);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Ya existe ese nombre de usuario", responseEntity.getBody());

        verify(userService, times(1)).existsById(userId);
        verify(userService, times(1)).existsByUsername(userDTO.getUsername());
        verify(userService, times(1)).getByUsername(userDTO.getUsername());
        verify(userService, never()).findById(userId);
        verify(userService, never()).saveUser(any(User.class));
    }



    @Test
    public void testDeleteUser_Existente() {
        Long userId = 1L;

        when(userService.existsById(userId)).thenReturn(true);

        ResponseEntity<?> responseEntity = userController.deleteUser(userId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Usuario eliminado!", responseEntity.getBody());

        verify(userService, times(1)).existsById(userId);
        verify(userService, times(1)).deleteUser(userId);
    }


    @Test
    public void testDeleteUser_NoExistente() {
        Long userId = 1L;

        when(userService.existsById(userId)).thenReturn(false);

        ResponseEntity<?> responseEntity = userController.deleteUser(userId);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

        verify(userService, times(1)).existsById(userId);
        verify(userService, never()).deleteUser(userId);
    }
}
