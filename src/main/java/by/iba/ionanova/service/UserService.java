package by.iba.ionanova.service;

import by.iba.ionanova.exception.RepositoryException;
import by.iba.ionanova.exception.ServiceException;
import by.iba.ionanova.model.User;
import by.iba.ionanova.repository.RepositoryCreator;
import by.iba.ionanova.repository.SQLHelper;
import by.iba.ionanova.repository.UserRepository;
import by.iba.ionanova.repository.specification.UserByLogin;
import by.iba.ionanova.repository.specification.UserByLoginPassword;

import java.util.Optional;

public class UserService {
    public Optional<User> login(String login, byte[] password) throws
            ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            UserByLoginPassword params = new UserByLoginPassword(login, password);
            return userRepository.queryForSingleResult(SQLHelper.SQL_GET_USER,
                    params);
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    public Integer save(User user) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            UserByLogin param = new UserByLogin(user.getLogin());
            if (!userRepository.queryForSingleResult(SQLHelper.SQL_CHECK_LOGIN,
                    param).isPresent()) {
                return userRepository.save(user);
            } else {
                return 0;
            }
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }
}