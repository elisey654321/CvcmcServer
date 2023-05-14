package ru.cvcmc.CvcmcServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cvcmc.CvcmcServer.entity.Message;

public interface MessageRepository extends JpaRepository<Message,Long> {



}
