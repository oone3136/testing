package com.Test.praktek.moduleMembership.controller;

import com.Test.praktek.component.message.Result;
import com.Test.praktek.moduleMembership.entity.Users;
import com.Test.praktek.moduleMembership.service.UsersServis;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class UsersController {

    private final UsersServis servis;

    @GetMapping("/users")
    public List<Users> findAll(){
        return servis.getAllUsers();
    }

    @GetMapping(value = "/users/{id}")
    public Result findById(@PathVariable("id") String id){
        return servis.getDataUser(id);
    }
    @PostMapping("/users")
    public Users createUsers(@RequestBody Users users){
        return servis.createUsers(users);
    }

    @PutMapping("/users/{id}")
    public Users updateUsers(@PathVariable("id") String id, @RequestBody Users users){
        return servis.updateKaryawan(users, id);
    }
    @DeleteMapping("users/{id}")
    public void deleteUsers(@PathVariable("id") String id){
        servis.delete(id);
    }



}
