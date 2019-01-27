package com.krotos.MoneyTransfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    User getById(long id){
        return userDao.getOne(id);
    }

    User getByName(String name){
        return userDao.findByName(name).get();
    }

    List<User> getAll(){
        return userDao.findAll();
    }

    void delete(long id){
        userDao.deleteById(id);
    }
    void add(User user){
        userDao.save(user);
    }

}
