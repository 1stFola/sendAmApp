package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private List<User> database = new ArrayList<>();
    @Override
    public User create(User owner) {
        database.add(owner);
        return owner;
    }

    @Override
    public User findByEmail(String email) {
        for (User user: database){
            if(user.getEmail() .equals(email))
                return user;
        }
        return null;
    }

    @Override
    public void delete(String email) {
        User owner = findByEmail(email);
        database.remove(owner);
    }

    @Override
    public void delete(User owner) {
        database.remove(owner);

    }

    @Override
    public List<User> findAll() {
        return database;
    }

    @Override
    public int count() {
        return database.size();
    }
}
