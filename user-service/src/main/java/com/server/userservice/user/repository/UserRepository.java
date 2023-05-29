package com.server.userservice.user.repository;

import com.server.userservice.common.entity.BaseEntity;
import com.server.userservice.user.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByNicknameAndStatus(String nickname, BaseEntity.Status status);
}
