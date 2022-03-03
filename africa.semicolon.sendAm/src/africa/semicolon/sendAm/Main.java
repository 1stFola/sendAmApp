package africa.semicolon.sendAm;

import africa.semicolon.sendAm.controllers.UserController;
import africa.semicolon.sendAm.dtos.requests.RegisterUserRequest;
import africa.semicolon.sendAm.dtos.responses.FindUserResponse;
import africa.semicolon.sendAm.dtos.responses.RegisterUserResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Main {
    public static UserController userController = new UserController();

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        // Load Options
//        loadOptions();

        // if option is registered
             // Load form
            // print output
            // load options


        // if option is searched by email
            // Ask for email
            // show
            // Load Options


    }

    private static void loadOptions() {
        String options = """
                -> A for Register
                -> B for Find email
                """;
        display(options);
        String input = collectStringInput(options);
         switch (input.toLowerCase()){
             case "a" -> loadRegisterForm();
             case "b" -> askUserForEmail();
             default -> {
                 display("get sense");
                 loadOptions();
             }
         }

    }

    private static void askUserForEmail() {
        String userEmail = collectStringInput("Enter the email you want to search");
        FindUserResponse response = userController.getUserByEmail(userEmail);
        display(response.toString());
        loadOptions();
    }

    public static void loadRegisterForm() {
        RegisterUserRequest form = new RegisterUserRequest();
        form.setFirstName(collectStringInput("Enter your first name"));
        form.setLastName(collectStringInput("Enter your last name"));
        form.setEmailAddress(collectStringInput("Enter your email address"));
        form.setPhoneNumber(collectStringInput("Enter your phone number"));
        form.setAddress(collectStringInput("Enter your home Address"));
        RegisterUserResponse response = userController.registerNewUser(form);
        display(response.toString());
        loadOptions();

//        String aTrial = ()
    }

    private static String collectStringInput(String message) {
        Scanner scanner = new Scanner(System.in);
        display(message);
        return scanner.nextLine();
    }

    private static void display( String message) {
        System.out.println(message);
    }
}
