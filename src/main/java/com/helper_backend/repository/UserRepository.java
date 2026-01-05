package com.helper_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helper_backend.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmailId(String emailId);

	Optional<User> findByUid(String uid);

}
