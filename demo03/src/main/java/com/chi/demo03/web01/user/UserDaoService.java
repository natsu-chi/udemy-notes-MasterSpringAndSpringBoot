package com.chi.demo03.web01.user;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<User>();
    private static int userCnt = 0;
    static {
        users.add(new User(++userCnt, "Joshua", LocalDate.of(1995, 12,30)));
        users.add(new User(++userCnt, "Hoshi", LocalDate.of(1996, 6,15)));
        users.add(new User(++userCnt, "WOOZI", LocalDate.of(1996, 11,22)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(Integer id) {
        Predicate <? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User save(User user) {
        user.setId(++userCnt);
        users.add(user);
        return user;
    }

    public void deleteById(Integer id) {
        users.removeIf(user -> user.getId().equals(id));
    }

}
