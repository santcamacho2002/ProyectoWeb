package com.proyecto.web.crud.herramientas.proyectowebcrudherramientas.repository;

import com.proyecto.web.crud.herramientas.proyectowebcrudherramientas.entity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


/**
 * Interfaz repositorio para la entidad Tool.
 */
public interface IToolRepository extends JpaRepository<Tool,Long> {

    /**
     * Metodo que busca una herramienta por su nombre.
     *
     * @param nombre Nombre de la herramienta a buscar.
     * @return La herramienta encontrada, o vacío si no se encuentra.
     */
    Optional<Tool> findByNombre(String nombre);

    /**
     * Metodo que verifica si existe una herramienta con el nombre dado.
     *
     * @param nombre Nombre de la herramienta a verificar.
     * @return true si la herramienta existe, false en caso contrario.
     */
    boolean existsByNombre(String nombre);
}

