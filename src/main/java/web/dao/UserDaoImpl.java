package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select user from User user ", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(long userId) {
        entityManager.remove(entityManager.find(User.class, userId));
    }

    @Override
    public void updateUser(long id, User userUpdate) {
        getUser(id).setName(userUpdate.getName());
        getUser(id).setEmail(userUpdate.getEmail());
        entityManager.merge(getUser(id));
    }


    @Override
    public User getUser(long userId) {
        return entityManager.find(User.class, userId);
    }
}
