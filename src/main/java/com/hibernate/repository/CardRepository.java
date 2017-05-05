package com.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hibernate.domain.CardDetails;

@Repository
public interface CardRepository extends JpaRepository<CardDetails, Integer> {

}
