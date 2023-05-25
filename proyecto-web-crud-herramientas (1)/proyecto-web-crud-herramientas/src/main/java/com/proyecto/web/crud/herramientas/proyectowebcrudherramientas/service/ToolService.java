package com.proyecto.web.crud.herramientas.proyectowebcrudherramientas.service;

import com.proyecto.web.crud.herramientas.proyectowebcrudherramientas.entity.Tool;
import com.proyecto.web.crud.herramientas.proyectowebcrudherramientas.repository.IToolRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
@Transactional

/**
 * Clase de servicio para la gestión de herramientas.
 */
public class ToolService {

    @Autowired
    IToolRepository toolRepository;


    /**
     * Metodo que obtiene todas las herramientas.
     *
     * @return Lista de todas las herramientas.
     */
    public List<Tool> findAll(){
        return toolRepository.findAll();
    }


    /**
     * Metodo que obtiene una herramienta por su ID.
     *
     * @param id ID de la herramienta.
     * @return La herramienta encontrada, o vacío si no se encuentra.
     */
    public Optional<Tool> findById(Long id){
        return toolRepository.findById(id);
    }


    /**
     * Metodo que obtiene una herramienta por su nombre.
     *
     * @param nombre Nombre de la herramienta.
     * @return La herramienta encontrada, o vacío si no se encuentra.
     */
    public Optional<Tool> getByNombre(String nombre){
        return toolRepository.findByNombre(nombre);
    }


    /**
     * Metodo que guarda una herramienta.
     *
     * @param tool La herramienta a guardar.
     */
    public void saveTool(Tool tool){
        toolRepository.save(tool);
    }


    /**
     * Metodo que elimina una herramienta por su ID.
     *
     * @param id ID de la herramienta a eliminar.
     */
    public void deleteTool(Long id){
        toolRepository.deleteById(id);
    }


    /**
     * Metodo que verifica si una herramienta existe por su ID.
     *
     * @param id ID de la herramienta.
     * @return true si la herramienta existe, false en caso contrario.
     */

    public boolean existsById(Long id){
        return toolRepository.existsById(id);
    }


    /**
     * Metodo que verifica si una herramienta existe por su nombre.
     *
     * @param nombre Nombre de la herramienta.
     * @return true si la herramienta existe, false en caso contrario.
     */
    public boolean existsByNombre(String nombre){
        return toolRepository.existsByNombre(nombre);
    }


    /**
     * Metodo que obtiene todas las herramientas paginadas.
     *
     * @param pageable Información de paginación.
     * @return Página de herramientas.
     */
    public Page<Tool> findAllToolsPaginated(Pageable pageable){
        return this.toolRepository.findAll(pageable);
    }

}