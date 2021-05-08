package ru.netology.springsecuritytask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.springsecuritytask.entities.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
