package com.example.design.patterns.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.design.patterns.spring.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{

}
