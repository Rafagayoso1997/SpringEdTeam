package com.gsoft.edteam.controllers;

import com.gsoft.edteam.models.Permission;
import com.gsoft.edteam.models.User;
import com.gsoft.edteam.services.PermissionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("permission")
public class PermissionController {

  @Autowired
  private PermissionService permissionService;


  // Trae todos los usuarios
  @ResponseStatus(HttpStatus.FOUND)
  @GetMapping("/")
  List<Permission> getAll(){
    return permissionService.getAll();

  }
  // Trae un usuario por su id
  @ResponseStatus(HttpStatus.FOUND)
  @GetMapping("/{id}")
  Permission get(@PathVariable long id) {

    return permissionService.get(id);
  }


  @ResponseStatus(HttpStatus.FOUND)
  @PostMapping("/")
  Permission register(@RequestBody Permission permission) {
    //TODO: registrarlo en la base de datos
    return permissionService.register(permission);
  }

  // Actualizar usuario
  // Trae un usuario por su id
  @ResponseStatus(HttpStatus.FOUND)
  @PutMapping("/{id}")
  Permission update(@RequestBody Permission permission) {
    // TODO: actualizarlo en la base de datos
    return permissionService.update(permission);
  }

  // Eliminar usuario
  // Trae un usuario por su id
  @ResponseStatus(HttpStatus.FOUND)
  @DeleteMapping("/{id}")
  void delete(@PathVariable long id) {
    // TODO: eliminarlo de la base de datos
    permissionService.delete(id);
  }

}
