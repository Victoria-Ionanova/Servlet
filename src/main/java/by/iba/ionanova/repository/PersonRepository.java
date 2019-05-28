package by.iba.ionanova.repository;

import by.iba.ionanova.builder.PersonBuilder;
import by.iba.ionanova.exception.RepositoryException;
import by.iba.ionanova.model.Person;
import by.iba.ionanova.repository.dbconstants.PersonTableConstants;
import by.iba.ionanova.repository.specification.Parameter;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
public class PersonRepository extends AbstractRepository<Person> {
    private static final String TABLE_NAME = "person";
    public PersonRepository(Connection connection){
        super(connection);
    }
    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }
    @Override
    public List<Person> query(String sqlString, Parameter paramater) throws
            RepositoryException {
        String query = sqlString;
        List<Person> persons = executeQuery(query,new PersonBuilder(),
                paramater.getParameters());
        return persons;
    }
    @Override
    public Optional<Person> queryForSingleResult(String sqlString, Parameter
            parameter) throws RepositoryException {
        List<Person> person = query(sqlString, parameter);
        return person.size() == 1 ?
                Optional.of(person.get(0)) :
                Optional.empty();
    }
    public Map<String,Object> getFields(Person person) {
        Map<String,Object> fields = new HashMap<>();
        fields.put(PersonTableConstants.NAME.getFieldName(), person.getName());
        fields.put(PersonTableConstants.PHONE.getFieldName(), person.getPhone());
        fields.put(PersonTableConstants.EMAIL.getFieldName(), person.getEmail());
        return fields;
    }
}