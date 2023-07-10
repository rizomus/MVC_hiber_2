package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface UserServiceInterface {


    List<User> allUsers();

    User show(int id);

    void save(User user);

    void update(int id, User updatedUser);

    void delete(int id);
}
