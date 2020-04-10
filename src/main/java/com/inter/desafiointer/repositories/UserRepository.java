package com.inter.desafiointer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inter.desafiointer.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
