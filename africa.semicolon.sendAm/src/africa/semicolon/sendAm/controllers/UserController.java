package africa.semicolon.sendAm.controllers;

import africa.semicolon.sendAm.dtos.requests.RegisterUserRequest;
import africa.semicolon.sendAm.dtos.responses.FindUserResponse;
import africa.semicolon.sendAm.dtos.responses.RegisterUserResponse;
import africa.semicolon.sendAm.services.UserService;
import africa.semicolon.sendAm.services.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")

public class UserController {

    private UserService userService = new UserServiceImpl();

    @PostMapping("/register")

    public RegisterUserResponse registerNewUser (@RequestBody RegisterUserRequest request){
        return userService.register(request);
    }

    @GetMapping("/{email}")
    public FindUserResponse getUserByEmail(@PathVariable String email){
        return userService.findUserByEmail(email);
    }
}
