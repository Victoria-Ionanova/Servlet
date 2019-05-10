package by.iba.ionanova.builder;

import by.iba.ionanova.exception.RepositoryException;
import by.iba.ionanova.model.Person;
import by.iba.ionanova.repository.dbconstants.PersonTableConstants;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonBuilder implements Builder <Person>{
    @Override
    public Person build(ResultSet resultSet) throws RepositoryException {
        try {
            int id = resultSet.getInt(PersonTableConstants.ID.getFieldName());
            String name =
                    resultSet.getString(PersonTableConstants.NAME.getFieldName());
            String phone =
                    resultSet.getString(PersonTableConstants.PHONE.getFieldName());
            String email =
                    resultSet.getString(PersonTableConstants.EMAIL.getFieldName());
            return new Person(id,name,phone,email);
        }catch (SQLException exception){
            throw new RepositoryException(exception.getMessage(),exception);
        }
    }
}
