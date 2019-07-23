package dbService;

import dbService.dao.UserDAO;
import dbService.dao.UserDAOImpl;
import dbService.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserService {

    private SessionFactory sessionFactory;

    public UserService() {
        sessionFactory = SessionFactoryUtil.getSessionFactory();
    }

    public User findUser(int id) {
        Session session = sessionFactory.openSession();
        UserDAO dao = new UserDAOImpl(session);
        User user = dao.get(id);
        session.close();
        return user;
    }

    public void saveUser(User user) {
        Session session = sessionFactory.openSession();
        UserDAO dao = new UserDAOImpl(session);
        dao.save(user);
        session.close();
    }

    public void deleteUser(User user) {
        Session session = sessionFactory.openSession();
        UserDAO dao = new UserDAOImpl(session);
        dao.delete(user);
        session.close();
    }

    public void updateUser(User user) {
        Session session = sessionFactory.openSession();
        UserDAO dao = new UserDAOImpl(session);
        dao.update(user);
        session.close();
    }

    public void closeSession(User user) {
        Session session = sessionFactory.openSession();
        UserDAO dao = new UserDAOImpl(session);
        user.setSessionId(null);
        dao.update(user);
        session.close();
    }

    public List<User> findAllUsers() {
        Session session = sessionFactory.openSession();
        UserDAO dao = new UserDAOImpl(session);
        List<User> users = dao.getAll();
        session.close();
        return users;
    }
}
