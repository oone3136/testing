package com.Test.praktek.ModuleMembership.services;

import com.Test.praktek.ModuleMembership.entity.Users;
import com.Test.praktek.ModuleMembership.exception.ResourceNotFoundException;
import com.Test.praktek.ModuleMembership.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
@Slf4j
public class UsersServis {

    private final UsersRepository repository;

    private final PasswordEncoder passwordEncoder;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public List<Users> getAllUsers(){
        return repository.findAll();
    }
    public Users getDataUser(String id){

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Users dengan id = " + id));
    }
    public Users createUsers(Users request){
        try {
            Users users = new Users();
            users.setId(request.getId());
            users.setFrist_name(request.getFrist_name());
            users.setLast_name(request.getFrist_name());
            users.setPassword(passwordEncoder.encode(request.getPassword()));
            Users create =new Users(request.getId(), request.getFrist_name(), request.getLast_name(), request.getPassword());
            return repository.save(create);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public Users updateKaryawan(Users req, String id){
         repository.findById(id);
         Users users = new Users();
        users.setId(req.getId());
        users.setFrist_name(req.getFrist_name());
        users.setLast_name(req.getLast_name());
        users.setPassword(req.getPassword());
        users.setRoles(req.getRoles());
        Users update =new Users(req.getId(), req.getFrist_name(), req.getLast_name(), req.getPassword(), req.getRoles());

        return repository.save(update);
    }
    public void delete(String ID_Karyawan){
        repository.deleteById(ID_Karyawan);
    }
}
