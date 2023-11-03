package com.Test.praktek.moduleMembership.service;

import com.Test.praktek.component.message.Result;
import com.Test.praktek.component.message.StringUtil;
import com.Test.praktek.moduleMembership.entity.Users;
import com.Test.praktek.moduleMembership.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RequiredArgsConstructor
@Service
@Slf4j
public class UsersServis {

    private final UsersRepository repository;

    private final PasswordEncoder passwordEncoder;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final StringUtil stringUtil;
    private Result result;
    public List<Users> getAllUsers(){
        return repository.findAll();
    }
    public Result getDataUser(String id){
        result = new Result();
        Optional<Users> users = repository.findById(id);
        try {
            if (repository.findById(id).isPresent()){
                result.setSuccess(false);
                result.setMessage("Error: Tidak ada kelas dengan id " + id);
                result.setCode(HttpStatus.BAD_REQUEST.value());
            }else{
                Map items = new HashMap();
                items.put("items",repository.findById(id).get());
                result.setData(items);
            }
        } catch (Exception e) {
            logger.error(stringUtil.getError(e));
        }
        return result;
    }
    public Users createUsers(Users request){
        try {
            Users users = new Users();
            users.setId(request.getId());
            users.setFirst_name(request.getLast_name());
            users.setLast_name(request.getLast_name());
            users.setPassword(passwordEncoder.encode(request.getPassword()));
            Users create =new Users(request.getId(), request.getFirst_name(), request.getLast_name(), request.getPassword());
            return repository.save(create);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public Users updateKaryawan(Users request, String id){
        try {
            Users users = new Users();
            users.setId(request.getId());
            users.setFirst_name(request.getLast_name());
            users.setLast_name(request.getLast_name());
            users.setPassword(passwordEncoder.encode(request.getPassword()));
            Users update =new Users(request.getId(), request.getFirst_name(), request.getLast_name(), request.getPassword());
            return repository.save(update);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(String ID_Karyawan){
        repository.deleteById(ID_Karyawan);
    }
}
