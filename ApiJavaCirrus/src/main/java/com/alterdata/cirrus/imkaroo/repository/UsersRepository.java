package com.alterdata.cirrus.imkaroo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alterdata.cirrus.imkaroo.models.User;

public interface UsersRepository extends JpaRepository <User , Long> {
	
	Optional<User> findById (Long Id);

}
