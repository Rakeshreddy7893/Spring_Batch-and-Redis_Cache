package com.recykal.Model_Mapper.repo;

import com.recykal.Model_Mapper.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo  extends CrudRepository<User,Long> {
}
