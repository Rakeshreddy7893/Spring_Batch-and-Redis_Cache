package com.recykal.Specifications.repo;

import com.recykal.Specifications.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository  extends JpaRepository<User,Long>, JpaSpecificationExecutor {
}
