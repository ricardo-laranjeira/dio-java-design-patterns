package com.example.design.patterns.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.design.patterns.spring.model.Cliente;
import com.example.design.patterns.spring.model.Endereco;
import com.example.design.patterns.spring.repository.ClienteRepository;
import com.example.design.patterns.spring.repository.EnderecoRepository;

@Service
public class ClienteServiceImplement implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepService viaCepService;

	@Override
	public Iterable<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	@Override
	public void salvar(Cliente cliente) {
		salvarDadosCliente(cliente);
	}	

	@Override
	public void atualizar(Long id, Cliente cliente) {
		Optional<Cliente> clienteDb = clienteRepository.findById(id);
		if (clienteDb.isPresent()) {
			salvarDadosCliente(cliente);
		}
	}

	@Override
	public void deletar(Long id) {
		clienteRepository.deleteById(id);		
	}
	
	private void salvarDadosCliente(Cliente cliente) {
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(()->{
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		cliente.setEndereco(endereco);
		clienteRepository.save(cliente);
	}

}
