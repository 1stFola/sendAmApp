package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.models.User;
import africa.semicolon.sendAm.data.repositories.UserRepository;
import africa.semicolon.sendAm.data.repositories.UserRepositoryImpl;
import africa.semicolon.sendAm.dtos.requests.RegisterUserRequest;
import africa.semicolon.sendAm.dtos.responses.FindUserResponse;
import africa.semicolon.sendAm.dtos.responses.RegisterUserResponse;
import africa.semicolon.sendAm.exceptions.RegisterFailureException;
import africa.semicolon.sendAm.exceptions.UserNotFoundException;

import java.util.Locale;

public class UserServiceImpl implements UserService{
    private UserRepository userRepository = new UserRepositoryImpl();
    @Override
    public RegisterUserResponse register(RegisterUserRequest requestForm) {
        requestForm.setEmailAddress(requestForm.getEmailAddress().toLowerCase());
        if(emailExist(requestForm.getEmailAddress()))throw new RegisterFailureException("Duplicate email error");
        String fullName = requestForm.getFirstName()+" "+requestForm.getLastName();
        String email = requestForm.getEmailAddress();
        User owner = new User(fullName,email);
        owner.setEmail(requestForm.getEmailAddress());
        owner.setAddress(requestForm.getAddress());
        owner.setFullName(requestForm.getFirstName()+" "+requestForm.getLastName());
        owner.setPhoneNumber(requestForm.getPhoneNumber());

        User savedUser = userRepository.create(owner);
        RegisterUserResponse response = new RegisterUserResponse();
        response.setEmail(savedUser.getEmail());
        response.setFullName(savedUser.getFullName());
        return response;
    }

    private boolean emailExist(String emailAddress) {
        User owner = userRepository.findByEmail(emailAddress);
        if(owner == null)return false;
        return true;
    }

    @Override
    public UserRepository getRepository() {
        return userRepository;
    }

    @Override
    public FindUserResponse findUserByEmail(String email) {
        email = email.toLowerCase();
        User user = userRepository.findByEmail(email);
        // create Response
        if (user == null) throw new UserNotFoundException(email + " " + "Not found");

        FindUserResponse response = new FindUserResponse();

        response.setEmail(user.getEmail());
        response.setFullName(user.getFullName());

        return response;
    }
}
