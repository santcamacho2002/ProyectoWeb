package com.proyecto.web.crud.herramientas.proyectowebcrudherramientas.repository;
import com.proyecto.web.crud.herramientas.proyectowebcrudherramientas.entity.Tool;
import com.proyecto.web.crud.herramientas.proyectowebcrudherramientas.repository.IToolRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
public class IToolRepositoryTest {

    @Mock
    private IToolRepository toolRepository;

    /**
     * Prueba el metodo FindByNombre del IToolRepository
     */
    @Test
    public void testFindByNombre() {
        // Arrange
        String nombre = "Prueba";
        Tool tool = new Tool();
        tool.setNombre(nombre);
        when(toolRepository.findByNombre(nombre)).thenReturn(Optional.of(tool));

        // Act
        Optional<Tool> result = toolRepository.findByNombre(nombre);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(nombre, result.get().getNombre());
    }


    /**
     * Prueba el método ExistsByNombre del IToolRepository
     */
    @Test
    public void testExistsByNombre() {
        // Arrange
        String nombre = "Prueba";
        when(toolRepository.existsByNombre(nombre)).thenReturn(true);

        // Act
        boolean result = toolRepository.existsByNombre(nombre);

        // Assert
        assertTrue(result);
    }
}

