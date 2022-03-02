package com.gsoft.edteam.dao.imp;

import com.gsoft.edteam.dao.UserDao;
import com.gsoft.edteam.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import de.mkammerer.argon2.Argon2Factory.Argon2Types;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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
  public void register(User user) {
    entityManager.persist(user);
  }

  @Transactional
  @Override
  public User update(User user) {
    System.out.println(user);
    return entityManager.merge(user);
  }

  @Transactional
  @Override
  public void delete(long id) {
    User user = get(id);
    entityManager.remove(user);
  }

  @Override
  public User login(User user) {
    boolean isAuthenticated = false;

    String hql = "SELECT u FROM User u WHERE u.password "
        + "is not null and u.email =:email";

    List<User> result = entityManager.createQuery(hql)
        .setParameter("email", user.getEmail())
        .getResultList();
    if (result.size() == 0) {
      return null;
    }

    User loggedUser = result.get(0);
    isAuthenticated = true;

    if (!StringUtils.isEmpty(user.getPassword())) {
      Argon2 argon2 = Argon2Factory.create(Argon2Types.ARGON2id);
      isAuthenticated = argon2.verify(loggedUser.getPassword(), user.getPassword());
    }
    if (isAuthenticated) {
      return user;
    }

    return null;
  }
}
