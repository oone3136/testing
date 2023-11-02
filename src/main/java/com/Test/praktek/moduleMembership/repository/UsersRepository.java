package com.Test.praktek.moduleMembership.repository;

import com.Test.praktek.moduleMembership.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, String> {

}
