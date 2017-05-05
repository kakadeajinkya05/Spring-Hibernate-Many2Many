package com.hibernate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hibernate.domain.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer> {

	@Query("select a from UserDetails a")
	List<UserDetails> findAllData();
}
