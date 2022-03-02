package com.gsoft.edteam.services;

import com.gsoft.edteam.dao.PermissionDao;
import com.gsoft.edteam.dao.UserDao;
import com.gsoft.edteam.models.Permission;
import com.gsoft.edteam.models.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionService {

  @Autowired
  PermissionDao permissionDao;

  public List<Permission> getAll(){
    return permissionDao.getAll();
  }

  public Permission get(long id) {
    return permissionDao.get(id);
  }


  public Permission register(Permission permission) {
    return permissionDao.register(permission);
  }


  public Permission update( Permission permission) {
    // TODO: actualizarlo en la base de datos
    return permissionDao.update(permission);
  }


  public void delete(long id) {
    // TODO: eliminarlo de la base de datos
    permissionDao.delete(id);
  }

}
