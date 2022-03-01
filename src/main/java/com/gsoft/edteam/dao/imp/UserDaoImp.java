package com.gsoft.edteam.dao.imp;

import com.gsoft.edteam.dao.UserDao;
import com.gsoft.edteam.models.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class UserDaoImp implements UserDao {

  @PersistenceContext
  EntityManager entityManager;

  @Transactional
  @Override
  public List<User> getAll() {
    return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
  }

  @Transactional
  @Override
  public User get(long id) {
    User user = entityManager.find(User.class, id);
    return user;
  }

  @Transactional
  @Override
  public User register(User user) {
    User returnedUser = entityManager.merge(user);
    return returnedUser;
  }

  @Transactional
  @Override
  public User update(User user) {
    User returnedUser = entityManager.merge(user);
    return returnedUser;
  }

  @Transactional
  @Override
  public void delete(long id) {
    User user = get(id);
    entityManager.remove(user);
  }
}
