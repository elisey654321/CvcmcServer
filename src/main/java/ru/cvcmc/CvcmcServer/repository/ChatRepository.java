package ru.cvcmc.CvcmcServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cvcmc.CvcmcServer.entity.Chat;

public interface ChatRepository extends JpaRepository<Chat,Long> {



}
