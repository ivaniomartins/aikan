package com.aikan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aikan.model.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {

}
