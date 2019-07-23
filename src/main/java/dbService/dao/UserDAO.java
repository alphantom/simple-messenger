package dbService.dao;

import dbService.model.User;

import java.util.List;

public interface UserDAO {

    User get(long id);

    User getByName(String name);

    long save(User user);

    void update(User user);

    void delete(User user);

    List<User> getAll();
}
