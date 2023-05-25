package com.proyecto.web.crud.usuarios.proyectowebcrudusuarios.repository;
import com.proyecto.web.crud.usuarios.proyectowebcrudusuarios.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import java.util.Optional;

@DataJpaTest
@ActiveProfiles("test")
public class UsersRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private IUsersRepository usersRepository;

    private User user;

    @BeforeEach
    public void setup() {
        user = new User();
        user.setUsername("user1");
        user.setPwsd("password1");
        user.setNombreApellido("Daniel Ramirez");
        entityManager.persist(user);
    }

    @Test
    public void testFindByUsername() {
        Optional<User> foundUser = usersRepository.findByUsername("user1");
        Assertions.assertTrue(foundUser.isPresent());
        Assertions.assertEquals(user.getId(), foundUser.get().getId());
        Assertions.assertEquals(user.getUsername(), foundUser.get().getUsername());
        Assertions.assertEquals(user.getPwsd(), foundUser.get().getPwsd());
        Assertions.assertEquals(user.getNombreApellido(), foundUser.get().getNombreApellido());
    }

    @Test
    public void testExistsByUsername() {
        boolean exists = usersRepository.existsByUsername("user1");
        Assertions.assertTrue(exists);
    }

}
