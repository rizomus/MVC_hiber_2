package web.dao;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface DAO {

    @Transactional(readOnly = true)
    List<User> index();

    @Transactional(readOnly = true)
    User show(int id);

    @Transactional
    void save(User user);

    @Transactional
    void update(int id, User updatedUser);

    @Transactional
    void delete(int id);
}
