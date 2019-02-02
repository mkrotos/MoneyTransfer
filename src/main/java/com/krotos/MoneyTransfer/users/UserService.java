package com.krotos.MoneyTransfer.users;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class UserService {
    @Autowired
    private UserDao userDao;
    private Logger log= LogManager.getLogger(this.getClass());

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
        log.info("Usuwam usera o id "+id);
    }
    User add(User user){
        User saved = userDao.save(user);
        log.info("Tworzem usera: " + saved);
        return saved;
    }
    User update(long id,User user){
        User byId = userDao.getOne(id);
        byId.setName(user.getName());
        byId.setPassword(user.getPassword());
        byId.setRole(user.getRole());

        User updated = userDao.save(byId);
        log.info("Updejtuje usera: "+updated);
        return updated;
    }

}
