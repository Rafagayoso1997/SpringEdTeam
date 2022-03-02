package com.gsoft.edteam.services;

import com.gsoft.edteam.dao.UserDao;
import com.gsoft.edteam.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import de.mkammerer.argon2.Argon2Factory.Argon2Types;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  UserDao userDao;

  public List<User> getAll() {
    return userDao.getAll();
  }

  public User get(long id) {
    return userDao.get(id);
  }


  public void register(User user) {
    String hash = getHashedPassword(user.getPassword());
    user.setPassword(hash);
   userDao.register(user);
  }

  public User update(User user) {
    return userDao.update(user);
  }

  public void delete(long id) {
    userDao.delete(id);
  }

  private String getHashedPassword(String password) {
    Argon2 argon2 = Argon2Factory.create(Argon2Types.ARGON2id);
    //1st parameter iteraciones: mientras mas iteraciones mas seguro pero mas proceso gasta
    //2nd:Tamaño en memoria en caracteres
    return argon2.hash(1, 1024 * 1, 1, password);
  }

  public User login(User user){
    return userDao.login(user);
  }


}
