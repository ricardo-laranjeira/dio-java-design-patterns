package com.example.design.patterns.spring.service;

import com.example.design.patterns.spring.model.Cliente;

public interface ClienteService {
	Iterable<Cliente> buscarTodos();
	Cliente buscarPorId(Long id);
	void salvar(Cliente cliente);
	void atualizar(Long id, Cliente cliente);
	void deletar(Long id);
}
