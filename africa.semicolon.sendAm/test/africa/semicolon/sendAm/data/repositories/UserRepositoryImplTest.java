package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
    UserRepository userRepository = new UserRepositoryImpl();
    @Test
    void createUserTest() {
        User owner = new User("Afolabi Sanni", "afolabi@gmail.com");
        User createdUser = userRepository.create(owner);
        assertEquals(createdUser.getFullName(), "Afolabi Sanni");
        assertEquals(createdUser.getEmail(), ("afolabi@gmail.com"));
        assertEquals(1, userRepository.count());
    }

    @Test
    void findUserByEmailTest() {
        User firstOwner = new User("Afolabi Sanni", "afolabi@gmail.com");
        User secondOwner = new User("Toyosi Sanni", "toyosi@gmail.com");
        User thirdOwner = new User("Zidane Sanni", "dami@email.com");
        UserRepository userRepository = new UserRepositoryImpl();
        userRepository.create(firstOwner);
        userRepository.create(secondOwner);
        userRepository.create(thirdOwner);

        User foundUser = userRepository.findByEmail("toyosi@gmail.com");
        User anotherUser = userRepository.findByEmail("afolabi@gmail.com");

        assertEquals(secondOwner, foundUser);
        assertEquals("toyosi@gmail.com", foundUser.getEmail());
        assertEquals(firstOwner, anotherUser);
        assertEquals("afolabi@gmail.com", anotherUser.getEmail());

    }

    @Test
    void deleteUserByEmailTest() {
        createThreeUsers();
        assertEquals(3, userRepository.count());
        userRepository.delete("zidane@email.com");
        assertEquals(2, userRepository.count());
    }
    void createThreeUsers(){
        User firstOwner = new User("Afolabi Sanni", "afolabi@gmail.com");
        User secondOwner = new User("Toyosi Sanni", "toyosi@gmail.com");
        User thirdOwner = new User("Zidane Sanni", "zidane@email.com");
        userRepository.create(firstOwner);
        userRepository.create(secondOwner);
        userRepository.create(thirdOwner);
    }
    @Test
    void deleteByEmailWorksTest(){
        createThreeUsers();
        userRepository.delete("zidane.email.com");
        User deletedUser = userRepository.findByEmail("zidane.email.com");
        assertNull(deletedUser);

    }
    @Test
    void deleteByUserTest(){
        User firstOwner = new User("Afolabi Sanni", "afolabi@gmail.com");
        User secondOwner = new User("Toyosi Sanni", "toyosi@gmail.com");
        User thirdOwner = new User("Zidane Sanni", "zidane@email.com");
        userRepository.create(firstOwner);
        userRepository.create(secondOwner);
        userRepository.create(thirdOwner);
        userRepository.delete(secondOwner);
        assertEquals(2, userRepository.count());
        User deletedUser = userRepository.findByEmail("zidane.email.com");
        assertNull(deletedUser);
    }
    @Test
    void findAllUserTest(){
        createThreeUsers();
        List<User>  users = userRepository.findAll();
        assertEquals(3, users.size() );
    }

}