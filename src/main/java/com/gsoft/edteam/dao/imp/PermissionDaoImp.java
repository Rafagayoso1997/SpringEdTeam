package com.gsoft.edteam.dao.imp;

import com.gsoft.edteam.dao.PermissionDao;
import com.gsoft.edteam.models.Permission;
import com.gsoft.edteam.models.Permission;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class PermissionDaoImp implements PermissionDao {

  @PersistenceContext
  EntityManager entityManager;

  @Transactional
  @Override
  public List<Permission> getAll() {
    return entityManager.createQuery("SELECT u FROM Permission u", Permission.class).getResultList();
  }

  @Transactional
  @Override
  public Permission get(long id) {
    Permission permission = entityManager.find(Permission.class, id);
    return permission;
  }

  @Transactional
  @Override
  public Permission register(Permission permission) {
    entityManager.persist(permission);
    return permission;
  }

  @Transactional
  @Override
  public Permission update(Permission permission) {
    System.out.println(permission);
    return entityManager.merge(permission);
  }

  @Transactional
  @Override
  public void delete(long id) {
    Permission permission = get(id);
    entityManager.remove(permission);
  }
}
