package com.proyecto.web.crud.usuarios.proyectowebcrudusuarios.dto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserDTOTest {

    @Test
    public void GetterSetterTest() {

        String username = "user1";
        String pwsd = "password1";
        String nombreApellido = "Daniel Ramirez";


        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(username);
        userDTO.setPwsd(pwsd);
        userDTO.setNombreApellido(nombreApellido);


        Assertions.assertEquals(username, userDTO.getUsername());
        Assertions.assertEquals(pwsd, userDTO.getPwsd());
        Assertions.assertEquals(nombreApellido, userDTO.getNombreApellido());
    }

    @Test
    public void ConstructorTest() {

        String username = "user1";
        String pwsd = "password1";
        String nombreApellido = "Daniel Ramirez";


        UserDTO userDTO = new UserDTO(username, pwsd, nombreApellido);


        Assertions.assertEquals(username, userDTO.getUsername());
        Assertions.assertEquals(pwsd, userDTO.getPwsd());
        Assertions.assertEquals(nombreApellido, userDTO.getNombreApellido());
    }

}
