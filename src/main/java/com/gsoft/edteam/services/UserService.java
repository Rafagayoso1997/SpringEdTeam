package com.gsoft.edteam.services;

import com.gsoft.edteam.dao.UserDao;
import com.gsoft.edteam.models.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  UserDao userDao;

  public List<User> getAll(){
    return userDao.getAll();
  }

  public User get(long id) {
    return userDao.get(id);
  }


  public User register(User user) {
    return userDao.register(user);
  }


  public User update( User user) {
    // TODO: actualizarlo en la base de datos
    return userDao.update(user);
  }


  public void delete(long id) {
    // TODO: eliminarlo de la base de datos
    userDao.delete(id);
  }


}
