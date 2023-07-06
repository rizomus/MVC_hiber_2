package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.dao.DAO;
import web.models.Person;

import java.util.List;

@Component
public class PersonService implements PersonServiseInterface {

    @Autowired
    private DAO PersonDAO;

    @Override
    public List<Person> index() {
        return PersonDAO.index();
    }

    @Override
    public Person show(int id) {
        return PersonDAO.show(id);
    }

    @Override
    public void save(Person person) {
        PersonDAO.save(person);
    }

    @Override
    public void update(int id, Person updatedPerson) {
        PersonDAO.update(id, updatedPerson);
    }

    @Override
    public void delete(int id) {
        PersonDAO.delete(id);
    }
}
