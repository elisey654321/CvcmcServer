package ru.cvcmc.CvcmcServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cvcmc.CvcmcServer.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {



}
