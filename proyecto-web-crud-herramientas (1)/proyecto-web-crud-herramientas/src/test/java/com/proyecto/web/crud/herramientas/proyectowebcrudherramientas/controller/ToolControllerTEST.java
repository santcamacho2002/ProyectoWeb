package com.proyecto.web.crud.herramientas.proyectowebcrudherramientas.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.web.crud.herramientas.proyectowebcrudherramientas.dto.ToolDTO;
import com.proyecto.web.crud.herramientas.proyectowebcrudherramientas.entity.Tool;
import com.proyecto.web.crud.herramientas.proyectowebcrudherramientas.service.ToolService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ToolControllerTEST {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ToolService toolService;

    @Autowired
    private ObjectMapper objectMapper;


    /**
     * Metodo que prueba el método `findAll` del controlador.
     *
     * @throws Exception si ocurre algún error durante la prueba.
     */
    @Test
    public void testAllTools() throws Exception {
        // Configurar datos de prueba
        Tool tool1 = new Tool("Prueba", "Herramienta de Prueba", "link.de.la.imagen", 1L, 10, "Medellin", 5);
        Tool tool2 = new Tool("Prueba2", "Segunda Herramienta de Prueba", "link.de.la.imagen.2", 2L, 15, "Cali", 8);
        List<Tool> tools = Arrays.asList(tool1, tool2);

        when(toolService.findAll()).thenReturn(tools);

        //El $[0].nombre indica el atributo nombre del objeto en la posicion 0 de la lista (la herramienta1)
        mockMvc.perform(get("/apiTools/tools"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nombre").value("Prueba"))
                .andExpect(jsonPath("$[0].descripcion").value("Herramienta de Prueba"))
                .andExpect(jsonPath("$[0].imageUrl").value("link.de.la.imagen"))
                .andExpect(jsonPath("$[0].idMarca").value(1))
                .andExpect(jsonPath("$[0].precio").value(10))
                .andExpect(jsonPath("$[0].ciudad").value("Medellin"))
                .andExpect(jsonPath("$[0].cantidad").value(5))
                .andExpect(jsonPath("$[1].nombre").value("Prueba2"))
                .andExpect(jsonPath("$[1].descripcion").value("Segunda Herramienta de Prueba"))
                .andExpect(jsonPath("$[1].imageUrl").value("link.de.la.imagen.2"))
                .andExpect(jsonPath("$[1].idMarca").value(2))
                .andExpect(jsonPath("$[1].precio").value(15))
                .andExpect(jsonPath("$[1].ciudad").value("Cali"))
                .andExpect(jsonPath("$[1].cantidad").value(8));
    }


    /**
     * Prueba el método `findById` del controlador.
     *
     * @throws Exception si ocurre algún error durante la prueba.
     */
    @Test
    public void testGetById() throws Exception {
        // Prepare mock data
        Tool tool = new Tool("Prueba", "Herramienta de Prueba", "link.de.la.imagen", 1L, 10, "Medellin", 5);
        Long id = 1L;

        // Mock the service method
        when(toolService.existsById(id)).thenReturn(true);
        when(toolService.findById(id)).thenReturn(Optional.of(tool));

        // Perform GET request
        mockMvc.perform(get("/apiTools/tools/id/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre").value("Prueba"))
                .andExpect(jsonPath("$.descripcion").value("Herramienta de Prueba"));
    }


    /**
     * Prueba el método `findById` del controlador cuando el ID no existe.
     *
     * @throws Exception si ocurre algún error durante la prueba.
     */
    @Test
    public void testGetById_NoExistente() throws Exception {
        // Prepare mock data
        Long id = 1L;

        // Mock the service method
        when(toolService.existsById(id)).thenReturn(false);

        // Perform GET request
        mockMvc.perform(get("/apiTools/tools/id/{id}", id))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$").value("No existe"));
    }


    /**
     * Prueba el método `getByNombre` del controlador.
     *
     * @throws Exception si ocurre algún error durante la prueba.
     */
    @Test
    public void testGetByNombre() throws Exception {
        // Prepare mock data
        Tool tool = new Tool("Prueba", "Herramienta de Prueba", "link.de.la.imagen", 1L, 10, "Medellin", 5);
        String nombre = "Prueba";

        // Mock the service method
        when(toolService.existsByNombre(nombre)).thenReturn(true);
        when(toolService.getByNombre(nombre)).thenReturn(Optional.of(tool));

        // Perform GET request
        mockMvc.perform(get("/apiTools/tools/nombre/{nombre}", nombre))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre").value("Prueba"))
                .andExpect(jsonPath("$.descripcion").value("Herramienta de Prueba"));
    }


    /**
     * Prueba el método `getByNombre` del controlador cuando el nombre no existe.
     *
     * @throws Exception si ocurre algún error durante la prueba.
     */
    @Test
    public void testGetByNombre_NoExistente() throws Exception {
        // Prepare mock data
        String nombre = "Prueba";

        // Mock the service method
        when(toolService.existsByNombre(nombre)).thenReturn(false);

        // Perform GET request
        mockMvc.perform(get("/apiTools/tools/nombre/{nombre}", nombre))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error").value("No existe"));
    }


    /**
     * Prueba el método `deleteTool` del controlador.
     *
     * @throws Exception si ocurre algún error durante la prueba.
     */
    @Test
    public void testDeleteTool() throws Exception {
        // Prepare mock data
        Long id = 1L;

        // Mock the service method
        when(toolService.existsById(id)).thenReturn(true);

        // Perform DELETE request
        mockMvc.perform(delete("/apiTools/deleteTool/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().string("Herramienta eliminada con exito"));
    }


    /**
     * Prueba el método `deleteTool` del controlador cuando el ID no existe.
     *
     * @throws Exception si ocurre algún error durante la prueba.
     */
    @Test
    public void testDeleteTool_NoExistente() throws Exception {
        // Prepare mock data
        Long id = 1L;

        // Mock the service method
        when(toolService.existsById(id)).thenReturn(false);

        // Perform DELETE request
        mockMvc.perform(delete("/apiTools/deleteTool/{id}", id))
                .andExpect(status().isNotFound());
    }
}
