package com.example.demo.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.repository.IClienteRepository;
import com.example.demo.uce.repository.modelo.Cliente;
@Service
public class ClienteServiceImpl implements IClienteService {
	@Autowired
	private IClienteRepository clienteRepository;
	@Override
	public void crearCliente(Cliente c) {
		
		clienteRepository.crearCliente(c);
	}
	
}
