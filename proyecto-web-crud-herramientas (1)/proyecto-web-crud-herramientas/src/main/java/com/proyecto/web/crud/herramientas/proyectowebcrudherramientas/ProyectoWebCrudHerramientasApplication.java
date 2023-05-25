package com.proyecto.web.crud.herramientas.proyectowebcrudherramientas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * Clase principal del Proyecto Web CRUD de Herramientas.
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.proyecto.web.crud.herramientas.proyectowebcrudherramientas")
public class ProyectoWebCrudHerramientasApplication {

	/**
	 * Método principal de ejecución que inicia la aplicación.
	 *
	 * @param args Arreglo de strings con argumentos.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ProyectoWebCrudHerramientasApplication.class, args);
	}
}
