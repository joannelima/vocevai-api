package com.jlsystems.vocevai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jlsystems.vocevai.list.Presente;

public interface PresenteRepository extends JpaRepository<Presente, Integer>{

	List<Presente> findByDescricao(String descricao);
	
}
