/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.serviceImpl;

import com.example.demo.model.Cliente;
import com.example.demo.repo.IClienteRepo;
import com.example.demo.service.IClienteService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Daniel
 */
@Service
public class ClienteServiceImpl implements IClienteService{ 
    
    @Autowired
    private IClienteRepo repo;
    @Override
    public Cliente registrar(Cliente t) {
        return repo.save(t);
    }

    @Override
    public List<Cliente> listar() {
        return repo.findAll();
    }

    @Override
    public Cliente modificar(Cliente t) {
        return repo.save(t);
    }

    @Override
    public void eliminar(Integer id) {
        Cliente o = new Cliente();
        o.setIdCliente(id);  
        repo.delete(o);
        
    }

    @Override
    public Cliente buscarPorId(Integer id) {
        Optional<Cliente> oCliente = repo.findById(id);
        return oCliente.isPresent()? oCliente.get() :  null;
    }
}
