package com.chi.demo03.web01.user;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import javax.swing.text.html.parser.Entity;
import java.net.URI;
import java.util.List;
import java.util.Locale;

@RestController
public class UserResource {

    private final UserDaoService service;
    private final MessageSource messageSource;

    // Constructor injection
    @Autowired
    public UserResource(UserDaoService service, @Qualifier("messageSource") MessageSource messageSource) {
        this.service = service;
        this.messageSource = messageSource;
    }

    @GetMapping("/users/list")
    public List<User> list() {
        return service.findAll();
    }

    // v1
    // @GetMapping("/users/{id}")
    // public User retrieveOne(@PathVariable Integer id) {
    //     User user = service.findById(id);
    //     System.out.println(user);
    //     if (user == null) {
    //         System.out.println("User not found");
    //         throw new UserNotFoundException("id: " + id);
    //     }
    //     return user;
    // }

    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveOne(@PathVariable Integer id) {
        User user = service.findById(id);
        System.out.println(user);
        if (user == null) {
            System.out.println("User not found");
            throw new UserNotFoundException("id: " + id);
        }

        // 使用 WebMvcLinkBuilder 連接 controller 連接到方法來建立一個指向 controller 方法的連接
        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).list());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @PostMapping("/users/insert")
    public void addOne(@Valid @RequestBody User user) {
        service.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteOne(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createOne(@Valid @RequestBody User user) {
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/i18n")
    public String i18nDemo() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default message", locale);
    }
}
