package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.models.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class PersonDao implements DAO {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional(readOnly = true)
    public List<Person> index() {

        return entityManager.createQuery("select p from Person p", Person.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Person show(int id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    @Transactional
    public void save(Person person) {

        entityManager.persist(person);
    }

    @Override
    @Transactional
    public void update(int id, Person updatedPerson) {

        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    @Override
    @Transactional
    public void delete(int id) {

        entityManager.remove(show(id));
    }
}