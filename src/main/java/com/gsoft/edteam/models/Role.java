package com.gsoft.edteam.models;

import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "role")
@ToString// with FetchType.Lazy no podemos usar esta anotacion. Debemos generalo manualmente
@EqualsAndHashCode// with FetchType.Lazy no podemos usar esta anotacion. Debemos generalo manualmente
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity{

  //un Rol puede tener varios permisos
  @OneToMany(cascade = CascadeType.ALL
      ,fetch = FetchType.EAGER, mappedBy = "role")
  @Getter
  @Setter
  private Set<Permission> permissions;

  @Column(name = "name")
  @Getter
  @Setter
  private String name;

}
