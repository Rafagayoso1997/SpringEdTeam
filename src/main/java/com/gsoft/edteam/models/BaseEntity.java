package com.gsoft.edteam.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

//No es una entidad final
//Como estas propiedades son comunes para todas las clases
//se ponen en una clase padre para reutilizarlas
@MappedSuperclass
public class BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  @Getter
  @Setter
  protected long id;


  @Column(columnDefinition = "DATETIME", updatable = false, nullable = false)
  @Getter
  @Setter
  protected Date createdDate;

  @Column(columnDefinition = "DATETIME", updatable = false, nullable = false)
  @Getter
  @Setter
  protected Date updatedDate;


  //Antes de persistir va a ejecutar este codigo
  @PrePersist
  protected void onCreate() {
    updatedDate = new Date();
    if (createdDate == null) {
      createdDate = new Date();
    }
  }

  @PreUpdate
  protected void onUpdate() {
    updatedDate = new Date();
  }

}
