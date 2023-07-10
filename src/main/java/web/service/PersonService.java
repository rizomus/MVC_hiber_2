package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.DAO;
import web.model.User;

import java.util.List;

@Service
public class PersonService implements PersonServiseInterface {

    @Autowired
    private DAO PersonDAO;

    @Override
    public List<User> index() {
        return PersonDAO.index();
    }

    @Override
    public User show(int id) {
        return PersonDAO.show(id);
    }

    @Override
    public void save(User user) {
        PersonDAO.save(user);
    }

    @Override
    public void update(int id, User updatedUser) {
        PersonDAO.update(id, updatedUser);
    }

    @Override
    public void delete(int id) {
        PersonDAO.delete(id);
    }
}
