package com.gsoft.edteam.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "permission")
@NoArgsConstructor
@AllArgsConstructor
public class Permission extends BaseEntity{

  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
      property = "id")
  //Para que traiga solo el id
  @JsonIdentityReference(alwaysAsId = true)
  //Nombre que va a tener en json la propiedad
  // que se traiga
  @JsonProperty("role_id")
  //Aqui es lazy ya que no nos hace falta
  //todo el contenido del rol
  @ManyToOne(fetch = FetchType.LAZY)
  //nombre de la columna donde hacer el join
  @JoinColumn(name = "role_id")
  @Getter @Setter
  private Role role;

  @Column(name = "name")
  @Getter @Setter
  private String name;


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Permission that = (Permission) o;
    return name.equals(that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return "Permission{" +
        "id=" + id +
        ", createdDate=" + createdDate +
        ", updatedDate=" + updatedDate +
        ", name='" + name + '\'' +
        '}';
  }
}
