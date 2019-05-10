package by.iba.ionanova.builder;

import by.iba.ionanova.exception.RepositoryException;

import java.sql.ResultSet;

public interface Builder <T> {
    T build(ResultSet resultSet) throws RepositoryException, RepositoryException;
}
