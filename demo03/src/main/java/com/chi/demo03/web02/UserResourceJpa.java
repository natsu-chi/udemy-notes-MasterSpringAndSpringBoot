package com.chi.demo03.web02;

import com.chi.demo03.web01.user.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
public class UserResourceJpa {

    private UserRepository repository;
    private WordRepository wordRepository;

    public UserResourceJpa(UserRepository repository, WordRepository wordRepository) {
        this.repository = repository;
        this.wordRepository = wordRepository;
    }

    @GetMapping("/basicauth")
    public String basicAuthCheck() {
		return "Success"; 
	}

    @GetMapping("/users/jpa/list")
    public List<User> retrieveAll() {
        return repository.findAll();
    }

    @GetMapping("/users/jpa/{id}")
    public EntityModel<User> findById(@PathVariable int id) {
        Optional<User> user = repository.findById(id);
        if(user.isEmpty()) {
            throw new UserNotFoundException("user_id: " + id);
        }
        EntityModel<User> model = EntityModel.of(user.get());
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAll());
        model.add(link.withRel("all-users"));
        return model;
    }

    @PostMapping("/users/jpa/insert")
    public void addOne(@Valid @RequestBody User user) {
        repository.save(user);
    }

    @DeleteMapping("/users/jpa/{id}")
    public void deleteOne(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @PostMapping("/users/jpa")
    public ResponseEntity<User> createOne(@Valid @RequestBody User user) {
        User savedUser = repository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getUserId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("users/jpa/{userId}/words")
    public List<Word> retrieveWordsByUserId(@PathVariable Integer userId) {
        Optional<User> user = repository.findById(userId);
        if(user.isEmpty()) {
            throw new UserNotFoundException("user_id: " + userId);
        }
        return user.get().getWords();
    }

    @PostMapping("users/jpa/{userId}/words")
    public ResponseEntity<Object> createWordByUserId(@PathVariable int userId, @Valid @RequestBody Word word) {
        Optional<User> user = repository.findById(userId);
        if(user.isEmpty()) {
            throw new UserNotFoundException("user_id: " + userId);
        }

        word.setUser(user.get());
        Word savedWord = wordRepository.save(word);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(savedWord.getId())
                        .toUri();
        // 讓客戶端就可以知道新創建的資源的位置並可以直接訪問它
        return ResponseEntity.created(location).build();
    }
    
}
