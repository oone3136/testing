package com.Test.praktek.ModuleMembership.controller;

import com.Test.praktek.ModuleMembership.entity.Users;
import com.Test.praktek.ModuleMembership.services.UsersServis;
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

    @PutMapping("/users/{id}")
    public Users updateUsers(@PathVariable("id") String id, @RequestBody Users users){
        return servis.updateKaryawan(users, id);
    }
    @DeleteMapping("users/{id}")
    public void deleteUsers(@PathVariable("id") String id){
        servis.delete(id);
    }



}
