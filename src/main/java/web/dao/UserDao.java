package web.dao;

import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;
import web.model.User;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDao implements UserDaoInterface {

    private final SessionFactory sessionFactory;

    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User", User.class);

        return query.getResultList();
    }

    @Transactional
    @Override
    public User find(long id) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User u WHERE u.id=:id", User.class)
                .setParameter("id", id);

        User user = null;

        try {
            user = query.setMaxResults(1).getSingleResult();
        } catch (NoResultException exception) {
            //
        }

        return user;
    }


    @Override
    @Transactional
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }
}
