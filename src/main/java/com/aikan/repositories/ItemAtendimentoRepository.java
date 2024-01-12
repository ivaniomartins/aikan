package com.aikan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aikan.model.ItemAtendimento;

@Repository
public interface ItemAtendimentoRepository extends JpaRepository<ItemAtendimento, Long> {

	
	
}
