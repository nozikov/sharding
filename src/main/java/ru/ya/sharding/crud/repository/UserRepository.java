package ru.ya.sharding.crud.repository;

import org.springframework.data.repository.CrudRepository;
import ru.ya.sharding.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

  User findByName(String name);
}
