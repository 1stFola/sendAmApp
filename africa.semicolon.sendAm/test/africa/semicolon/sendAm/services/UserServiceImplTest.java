package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.dtos.requests.RegisterUserRequest;
import africa.semicolon.sendAm.dtos.responses.FindUserResponse;
import africa.semicolon.sendAm.dtos.responses.RegisterUserResponse;
import africa.semicolon.sendAm.exceptions.RegisterFailureException;
import africa.semicolon.sendAm.exceptions.SendAmAppException;
import africa.semicolon.sendAm.exceptions.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
//    private UserServiceImpl userService;
    private UserService userService;

    @BeforeEach
    void testSetup() {
        userService = new UserServiceImpl();
    }

    @Test
    void afterRegister_repositoryContainsOneElement() {
        RegisterUserRequest newForm = createRegisterForm();
        userService.register(newForm);
//    userService.register(registerForm);
        assertEquals(1, userService.getRepository().count());
    }

    private RegisterUserRequest createRegisterForm() {
        RegisterUserRequest registerForm = new RegisterUserRequest();
        registerForm.setFirstName("Afolabi");
        registerForm.setLastName("Sanni");
        registerForm.setEmailAddress("muhyden02@gmail.com");
        registerForm.setAddress("Aguda Surulere Lagos");
        registerForm.setPhoneNumber("08034200200");
        return registerForm;
    }

    @Test
    public void duplicateEmail_throwExceptionTest() {
        RegisterUserRequest newForm = createRegisterForm();
//        RegisterUserResponse service = userService.register(newForm);

        userService.register(newForm);
        assertThrows(SendAmAppException.class, () -> userService.register(newForm));
        assertThrows(RegisterFailureException.class, () -> userService.register(newForm));

    }

    @Test
    public void duplicateEmailWithDifferentCase_throwExceptionTest() {
        RegisterUserRequest newForm = createRegisterForm();
        userService.register(newForm);
        newForm.setEmailAddress("Muhyden02@gmail.com");
        assertThrows(SendAmAppException.class, () -> userService.register(newForm));
        assertThrows(RegisterFailureException.class, () -> userService.register(newForm));
    }

    @Test
    public void registrationComplete_ReturnsCorrectResponseTest() {
        RegisterUserRequest newForm = createRegisterForm();
        RegisterUserResponse response = userService.register(newForm);
        assertEquals("Afolabi Sanni", response.getFullName());
        assertEquals("muhyden02@gmail.com", response.getEmail());
    }

    @Test
    public void findRegisteredUserByEmailTest() {
        RegisterUserRequest newForm = createRegisterForm();
        userService.register(newForm);

        FindUserResponse response = userService.findUserByEmail(newForm.getEmailAddress().toLowerCase());

        assertEquals("Afolabi Sanni", response.getFullName());
        assertEquals("muhyden02@gmail.com", response.getEmail());

    }

    @Test
    public void findingUnRegisteredEmail_throwsExceptionTest() {
        RegisterUserRequest newForm = createRegisterForm();
        userService.register(newForm);

        assertThrows(UserNotFoundException.class, () -> userService.findUserByEmail("zizu@gmail.com"));

    }

    @Test
    public void findByUserEmailIsNotCaseSensitiveTest() {
        RegisterUserRequest newForm = createRegisterForm();
        userService.register(newForm);

        FindUserResponse response = userService.findUserByEmail("MuhYDen02@gmail.com");

        assertEquals("Afolabi Sanni", response.getFullName());
        assertEquals("muhyden02@gmail.com", response.getEmail());

    }

}