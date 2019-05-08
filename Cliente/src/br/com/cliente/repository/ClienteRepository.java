package br.com.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cliente.doiman.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Integer> {

}