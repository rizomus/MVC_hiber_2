package web.dao;

import org.springframework.transaction.annotation.Transactional;
import web.models.Person;

import java.util.List;

public interface DAO {

    @Transactional(readOnly = true)
    List<Person> index();

    @Transactional(readOnly = true)
    Person show(int id);

    @Transactional
    void save(Person person);

    @Transactional
    void update(int id, Person updatedPerson);

    @Transactional
    void delete(int id);
}
