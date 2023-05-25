package com.proyecto.web.crud.usuarios.proyectowebcrudusuarios.service;
import com.proyecto.web.crud.usuarios.proyectowebcrudusuarios.entity.User;
import com.proyecto.web.crud.usuarios.proyectowebcrudusuarios.repository.IUsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class UserServiceTest {

    @Mock
    private IUsersRepository usersRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindById() {
        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        when(usersRepository.findById(userId)).thenReturn(Optional.of(user));

        Optional<User> result = userService.findById(userId);

        assertEquals(user, result.orElse(null));
        verify(usersRepository, times(1)).findById(userId);
    }


    @Test
    public void testGetByUsername() {
        String username = "user1";
        User user = new User();
        user.setUsername(username);
        when(usersRepository.findByUsername(username)).thenReturn(Optional.of(user));

        Optional<User> result = userService.getByUsername(username);

        assertEquals(user, result.orElse(null));
        verify(usersRepository, times(1)).findByUsername(username);
    }
}
