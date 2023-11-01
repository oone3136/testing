package com.Test.praktek.ModuleMembership.repository;

import com.Test.praktek.ModuleMembership.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, String> {

}
