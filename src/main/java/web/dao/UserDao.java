package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDao implements DAO {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<User> allUsers() {

        return entityManager.createQuery("select p from User p", User.class).getResultList();
    }

    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {

        entityManager.persist(user);
    }

    @Override
    public void update(int id, User updatedUser) {

        User userToBeUpdated = show(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setAge(updatedUser.getAge());
        userToBeUpdated.setEmail(updatedUser.getEmail());
    }

    @Override
    public void delete(int id) {

        entityManager.remove(show(id));
    }
}