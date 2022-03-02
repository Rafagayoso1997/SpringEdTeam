package com.gsoft.edteam.dao;

import com.gsoft.edteam.models.Permission;
import com.gsoft.edteam.models.User;
import java.util.List;

public interface PermissionDao {

  List<Permission> getAll();

  Permission get(long id);

  Permission register(Permission user);

  Permission update(Permission user);

  void delete(long id);
}
