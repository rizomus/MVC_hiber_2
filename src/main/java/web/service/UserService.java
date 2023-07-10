package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.DAO;
import web.model.User;

import java.util.List;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private DAO UserDao;

    @Override
    @Transactional(readOnly = true)
    public List<User> allUsers() {
        return UserDao.allUsers();
    }

    @Override
    @Transactional(readOnly = true)
    public User show(int id) {
        return UserDao.show(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        UserDao.save(user);
    }

    @Override
    @Transactional
    public void update(int id, User updatedUser) {
        UserDao.update(id, updatedUser);
    }

    @Override
    @Transactional
    public void delete(int id) {
        UserDao.delete(id);
    }
}
