package ru.cvcmc.CvcmcServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cvcmc.CvcmcServer.entity.User;


public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);


}
