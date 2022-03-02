package com.gsoft.edteam.services;

import com.gsoft.edteam.dao.PermissionDao;
import com.gsoft.edteam.dao.RoleDao;
import com.gsoft.edteam.models.Permission;
import com.gsoft.edteam.models.Role;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

  @Autowired
  RoleDao roleDao;

  public List<Role> getAll(){
    return roleDao.getAll();
  }

  public Role get(long id) {
    return roleDao.get(id);
  }


  public Role register(Role role) {
    return roleDao.register(role);
  }


  public Role update( Role role) {
    // TODO: actualizarlo en la base de datos
    return roleDao.update(role);
  }


  public void delete(long id) {
    // TODO: eliminarlo de la base de datos
    roleDao.delete(id);
  }

}
