package com.inter.desafioInter.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inter.desafioInter.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
