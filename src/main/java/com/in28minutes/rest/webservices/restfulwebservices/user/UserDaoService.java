package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount, "John", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Doe", LocalDate.now().minusYears(40)));
    }
    public List<User> findAllUsers(){
        return users;
    }

    public User findUser(int id) {
        Optional<User> user = users.stream().filter(x -> x.getId().equals(id)).findFirst();
        if (user.isPresent()) {
            return user.get();
        }

        throw new UserNotFoundException("User " + id + " not found");
    }

    public boolean deleteUser(int id) {
        Optional<User> user = users.stream().filter(x -> x.getId().equals(id)).findFirst();
        if (user.isPresent()) {
            return users.removeIf(x -> x.getId() == id);
        }

        throw new UserNotFoundException("User " + id + " not found");
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
}
