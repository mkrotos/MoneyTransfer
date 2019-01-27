package com.krotos.MoneyTransfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{name}")
    User getByName(@PathVariable("name") String name){
        return userService.getByName(name);
    }

    @PostMapping("/create")
    User create(@RequestBody User user){
        User saved = userService.add(user);
        System.out.println("Tworzem usera: "+saved);
        return saved;
    }

}
