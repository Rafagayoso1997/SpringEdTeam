package com.gsoft.edteam.models;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.util.Date;
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
@Table(name = "user")
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

  //Para que solo se pueda leer la propiedad. /**SEGURIDAD**/
  @JsonProperty(access = Access.READ_ONLY)
  //Eager para que traiga todo el contenido
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "role_id")
  @Getter
  @Setter
  private Role role;

  @Column(name = "name")
  @Getter
  @Setter
  private String name;

  @Column(name = "lastname")
  @Getter
  @Setter
  private String lastName;

  @JsonProperty(access = Access.WRITE_ONLY)
  @Column(name = "password")
  @Setter
  @Getter// Lombok Anotation
  private String password;

  @Column(name = "email")
  @Getter
  @Setter
  private String email;

  @Column(name = "phone")
  @Getter
  @Setter
  private String phone;

  //Para que matchee con la columna de la BD
  @Column(name = "birthdate")
  @Getter
  @Setter
  private Date birthDate;


}
