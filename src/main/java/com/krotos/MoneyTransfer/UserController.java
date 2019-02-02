package com.krotos.MoneyTransfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    private Logger log= LogManager.getLogger(this.getClass());

    @GetMapping
    List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{name}")
    User getByName(@PathVariable("name") String name) {
        return userService.getByName(name);
    }

    @PostMapping("/create")
    User create(@RequestBody User user) {
        User saved = userService.add(user);
        log.info("Tworzem usera: " + saved);
        return saved;
    }

    @PutMapping("/{id}")
    User update(@PathVariable("id") long id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") long id) {
        userService.delete(id);
    }

}
