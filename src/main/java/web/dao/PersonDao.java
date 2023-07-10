package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class PersonDao implements DAO {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional(readOnly = true)
    public List<User> index() {

        return entityManager.createQuery("select p from User p", User.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void save(User user) {

        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void update(int id, User updatedUser) {

        User userToBeUpdated = show(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setAge(updatedUser.getAge());
        userToBeUpdated.setEmail(updatedUser.getEmail());
    }

    @Override
    @Transactional
    public void delete(int id) {

        entityManager.remove(show(id));
    }
}