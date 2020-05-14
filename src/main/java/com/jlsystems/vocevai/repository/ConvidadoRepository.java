package com.jlsystems.vocevai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jlsystems.vocevai.list.Convidado;

public interface ConvidadoRepository extends JpaRepository<Convidado, Integer> {

	List<Convidado> findByNomeConvidado(String nome);
}
