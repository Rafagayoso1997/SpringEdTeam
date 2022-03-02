package com.gsoft.edteam.dao.imp;

import com.gsoft.edteam.dao.RoleDao;
import com.gsoft.edteam.models.Role;
import com.gsoft.edteam.models.Role;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class RoleDaoImp implements RoleDao {

  @PersistenceContext
  EntityManager entityManager;

  @Transactional
  @Override
  public List<Role> getAll() {
    System.out.println(entityManager.createQuery("SELECT u FROM Role u", Role.class).getResultList());
    return entityManager.createQuery("SELECT u FROM Role u", Role.class).getResultList();
  }

  @Transactional
  @Override
  public Role get(long id) {
    Role role = entityManager.find(Role.class, id);
    return role;
  }

  @Transactional
  @Override
  public Role register(Role role) {
    entityManager.persist(role);
    return role;
  }

  @Transactional
  @Override
  public Role update(Role role) {
    System.out.println(role);
    return entityManager.merge(role);
  }

  @Transactional
  @Override
  public void delete(long id) {
    Role role = get(id);
    entityManager.remove(role);
  }
}
