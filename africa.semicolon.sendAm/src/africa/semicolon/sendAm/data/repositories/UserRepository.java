package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.Package;
import africa.semicolon.sendAm.data.models.User;

import java.util.List;

public interface UserRepository {
    User create(User owner);
    User findByEmail(String email);
    void delete(String email);
    void delete(User owner);
    List<User> findAll();

    int count();
}
