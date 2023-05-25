package com.proyecto.web.crud.herramientas.proyectowebcrudherramientas.controller;
import com.proyecto.web.crud.herramientas.proyectowebcrudherramientas.dto.ToolDTO;
import com.proyecto.web.crud.herramientas.proyectowebcrudherramientas.entity.Tool;
import com.proyecto.web.crud.herramientas.proyectowebcrudherramientas.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/apiTools")
@CrossOrigin(origins = "http://localhost:4200")

/**
 * Clase controladora que maneja las operaciones relacionadas con las herramientas.
 */
public class ToolController {

    @Autowired
    ToolService toolService;

    /**
     * Metodo que obtiene todas las herramientas.
     *
     * @return ResponseEntity con la lista de herramientas y el estado HTTP.
     */
    @GetMapping("/tools")
    public ResponseEntity<List<Tool>> allTools(){
        List<Tool> list = toolService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * Metodo que obtiene las herramientas de forma paginada.
     *
     * @param page  Número de página.
     * @param size  Tamaño de la página.
     * @param order Campo por el cual se ordenarán las herramientas.
     * @param asc   Indica si el orden es ascendente o descendente.
     * @return ResponseEntity con la página de herramientas y el estado HTTP.
     */

    @GetMapping("/tools/paginated")
    public ResponseEntity<Page<Tool>> pageTools(
            @RequestParam(defaultValue = "0")int page,
            @RequestParam(defaultValue = "1")int size,
            @RequestParam(defaultValue = "id")String order,
            @RequestParam(defaultValue = "true")boolean asc)
    {
        Page<Tool> tools = asc ? toolService.findAllToolsPaginated(PageRequest.of(page,size, Sort.by(order))) :
                toolService.findAllToolsPaginated(PageRequest.of(page,size, Sort.by(order).descending()));

        return new ResponseEntity<>(tools,HttpStatus.OK);
    }


    /**
     * Metodo que obtiene una herramienta por su ID.
     *
     * @param id ID de la herramienta.
     * @return ResponseEntity con la herramienta y el estado HTTP.
     */

        @GetMapping("/tools/id/{id}")
        public ResponseEntity<Tool> getById(@PathVariable("id") Long id){
            if(!toolService.existsById(id)){
                return new ResponseEntity("No existe",HttpStatus.NOT_FOUND);
            }
            Tool tool = toolService.findById(id).get();
            return new ResponseEntity<>(tool,HttpStatus.OK);
        }


    /**
     * Metodo que obtiene una herramienta por su nombre.
     *
     * @param nombre Nombre de la herramienta.
     * @return ResponseEntity con la herramienta y el estado HTTP.
     */
    @GetMapping("/tools/nombre/{nombre}")
    public ResponseEntity<?> getByNombre(@PathVariable("nombre") String nombre) {
        if (!toolService.existsByNombre(nombre)) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "No existe");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(errorResponse);
        }

        Tool tool = toolService.getByNombre(nombre).get();
        return ResponseEntity.ok(tool);
    }

    /**
     * Metodo que crea una nueva herramienta.
     *
     * @param toolDTO Objeto ToolDTO que contiene los datos de la herramienta a crear.
     * @return ResponseEntity con el mensaje de éxito y el estado HTTP.
     */
    @PostMapping("/createTool")
    public ResponseEntity<?> createTool(@RequestBody ToolDTO toolDTO){

        Tool tool = new Tool(toolDTO.getNombre(),toolDTO.getDescripcion(),toolDTO.getImageUrl(),
                toolDTO.getIdMarca(),toolDTO.getPrecio(),toolDTO.getCiudad(),toolDTO.getCantidad());

        toolService.saveTool(tool);

        return new ResponseEntity<>("Guardado!", HttpStatus.OK);
    }


    /**
     * Metodo que actualiza una herramienta existente.
     *
     * @param id      ID de la herramienta a actualizar.
     * @param toolDTO Objeto ToolDTO que contiene los nuevos datos de la herramienta.
     * @return ResponseEntity con el mensaje de éxito y el estado HTTP.
     */
    @PutMapping("/updateTool/{id}")
    public ResponseEntity<?> updateTool(@PathVariable("id")Long id, @RequestBody ToolDTO toolDTO){
        if(!toolService.existsById(id)){
            return new ResponseEntity<>("No existe",HttpStatus.NOT_FOUND);
        }

        Tool tool = toolService.findById(id).get();
        tool.setNombre(toolDTO.getNombre());
        tool.setDescripcion(toolDTO.getDescripcion());
        tool.setImageUrl(toolDTO.getImageUrl());
        tool.setCantidad(toolDTO.getCantidad());

        toolService.saveTool(tool);

        return new ResponseEntity<>("Herramienta actualizada",HttpStatus.OK);
    }


    /**
     * Elimina una herramienta por su ID.
     *
     * @param id ID de la herramienta a eliminar.
     * @return ResponseEntity con el mensaje de éxito y el estado HTTP.
     */
    @DeleteMapping("/deleteTool/{id}")
    public ResponseEntity<?> deleteTool(@PathVariable("id")Long id){
        if(!toolService.existsById(id)){
            return new ResponseEntity<>("No existe",HttpStatus.NOT_FOUND);
        }
        toolService.deleteTool(id);

        return new ResponseEntity<>("Herramienta eliminada", HttpStatus.OK);
    }


}
