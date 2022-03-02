package com.gsoft.edteam.controllers;

import com.gsoft.edteam.email.EmailPort;
import com.gsoft.edteam.models.Role;
import com.gsoft.edteam.services.RoleService;
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
@RequestMapping("role")
public class RoleController {

  @Autowired
  private RoleService roleService;

  @Autowired
  private EmailPort emailPort;

  // Trae todos los usuarios
  @ResponseStatus(HttpStatus.FOUND)
  @GetMapping("/")
  List<Role> getAll(){
    return roleService.getAll();

  }
  // Trae un usuario por su id
  @ResponseStatus(HttpStatus.FOUND)
  @GetMapping("/{id}")
  Role get(@PathVariable long id) {

    return roleService.get(id);
  }

  // Registrar usuario
  // Trae un usuario por su id
  @ResponseStatus(HttpStatus.FOUND)
  @PostMapping("/")
  Role register(@RequestBody Role role) {
    //TODO: registrarlo en la base de datos
    /*EmailBody email = new EmailBody();
    email.setEmail(role.getEmail());
    email.setSubject("Authentication");
    email.setContent("Welcome to REST API");
    emailPort.sendEmail(email);*/
    return roleService.register(role);
  }

  // Actualizar usuario
  // Trae un usuario por su id
  @ResponseStatus(HttpStatus.FOUND)
  @PutMapping("/{id}")
  Role update(@RequestBody Role role) {
    // TODO: actualizarlo en la base de datos
    return roleService.update(role);
  }

  // Eliminar usuario
  // Trae un usuario por su id
  @ResponseStatus(HttpStatus.FOUND)
  @DeleteMapping("/{id}")
  void delete(@PathVariable long id) {
    // TODO: eliminarlo de la base de datos
    roleService.delete(id);
  }

}
