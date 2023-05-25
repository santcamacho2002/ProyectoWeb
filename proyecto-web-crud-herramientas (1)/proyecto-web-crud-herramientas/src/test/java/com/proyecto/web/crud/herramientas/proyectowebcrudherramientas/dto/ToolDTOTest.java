package com.proyecto.web.crud.herramientas.proyectowebcrudherramientas.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ToolDTOTest {


    /**
     * Prueba los constructores y los getters del ToolDTO
     */
    @Test
    public void testConstructoresyGetters() {
        // Arrange
        String nombre = "Prueba";
        String descripcion = "Herramienta de Prueba";
        String imageUrl = "link.de.la.imagen";
        Long idMarca = 1L;
        double precio = 10;
        String ciudad = "Medellin";
        int cantidad = 5;

        ToolDTO toolDTO = new ToolDTO(nombre, descripcion, imageUrl, idMarca, precio, ciudad, cantidad);

        assertNotNull(toolDTO);
        assertEquals(nombre, toolDTO.getNombre());
        assertEquals(descripcion, toolDTO.getDescripcion());
        assertEquals(imageUrl, toolDTO.getImageUrl());
        assertEquals(idMarca, toolDTO.getIdMarca());
        assertEquals(precio, toolDTO.getPrecio());
        assertEquals(ciudad, toolDTO.getCiudad());
        assertEquals(cantidad, toolDTO.getCantidad());
    }


    /**
     * Prueba los setters ToolDTO
     */
    @Test
    public void testSetters() {

        ToolDTO toolDTO = new ToolDTO();

        toolDTO.setNombre("Prueba");
        toolDTO.setDescripcion("Herramienta de Prueba");
        toolDTO.setImageUrl("link.de.la.imagen");
        toolDTO.setIdMarca(1L);
        toolDTO.setPrecio(10);
        toolDTO.setCiudad("Medellin");
        toolDTO.setCantidad(5);

        assertEquals("Prueba", toolDTO.getNombre());
        assertEquals("Herramienta de Prueba", toolDTO.getDescripcion());
        assertEquals("link.de.la.imagen", toolDTO.getImageUrl());
        assertEquals(1L, toolDTO.getIdMarca());
        assertEquals(10, toolDTO.getPrecio());
        assertEquals("Medellin", toolDTO.getCiudad());
        assertEquals(5, toolDTO.getCantidad());
    }
}
