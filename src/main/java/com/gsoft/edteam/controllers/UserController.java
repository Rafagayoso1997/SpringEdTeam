package com.gsoft.edteam.controllers;

import com.gsoft.edteam.email.EmailBody;
import com.gsoft.edteam.email.EmailPort;
import com.gsoft.edteam.models.User;
import com.gsoft.edteam.services.UserService;
import java.util.List;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
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
@RequestMapping("user")
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private EmailPort emailPort;

  // Trae todos los usuarios
  @ResponseStatus(HttpStatus.FOUND)
  @GetMapping("/")
  List<User> getAll(){
    return userService.getAll();

  }
  // Trae un usuario por su id
  @ResponseStatus(HttpStatus.FOUND)
  @GetMapping("/{id}")
  User get(@PathVariable long id) {

    return userService.get(id);
  }

  // Registrar usuario
  // Trae un usuario por su id
  @ResponseStatus(HttpStatus.FOUND)
  @PostMapping("/")
  User register(@RequestBody User user) {
    //TODO: registrarlo en la base de datos
    EmailBody email = new EmailBody();
    email.setEmail(user.getEmail());
    email.setSubject("Authentication");
    email.setContent("Welcome to REST API");
    emailPort.sendEmail(email);
    return userService.register(user);
  }

  // Actualizar usuario
  // Trae un usuario por su id
  @ResponseStatus(HttpStatus.FOUND)
  @PutMapping("/{id}")
  User update(@RequestBody User user) {
    // TODO: actualizarlo en la base de datos
    return userService.update(user);
  }

  // Eliminar usuario
  // Trae un usuario por su id
  @ResponseStatus(HttpStatus.FOUND)
  @DeleteMapping("/{id}")
  void delete(@PathVariable long id) {
    // TODO: eliminarlo de la base de datos
    userService.delete(id);
  }

}