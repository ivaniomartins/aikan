package com.aikan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aikan.model.Procedimento;

@Repository
public interface ProcedimentoRepository extends JpaRepository<Procedimento, Long>{

}
