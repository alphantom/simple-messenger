package dbService.dao;

import dbService.model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAOImpl implements UserDAO{

    private Session session;

    public UserDAOImpl(Session session) {
        this.session = session;
    }

    @Override
    public User get(long id) {
        return session.get(User.class, id);
    }

    @Override
    public User getByName(String name) {
        String hql = "from User where name=:name";
        Query query = session.createQuery(hql);
        query.setParameter("name", name);
        return (User) query.uniqueResult();

    }

    @Override
    public long save(User user) {
        return (long) session.save(user);
    }

    @Override
    public void update(User user) {
        session.update(user);
    }

    @Override
    public void delete(User user) {
        session.delete(user);
    }

    @Override
    public List<User> getAll() {
        return session.createQuery("from User").list();
    }
}
