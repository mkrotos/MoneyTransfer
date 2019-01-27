package com.krotos.MoneyTransfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class UserService {
    @Autowired
    private UserDao userDao;

    User getById(long id){
        return userDao.getOne(id);
    }

    User getByName(String name){
        Optional<User> byName = userDao.findByName(name);
        return byName.orElse(null);
    }

    List<User> getAll(){
        return userDao.findAll();
    }

    void delete(long id){
        userDao.deleteById(id);
    }
    User add(User user){
        return userDao.save(user);
    }

}
