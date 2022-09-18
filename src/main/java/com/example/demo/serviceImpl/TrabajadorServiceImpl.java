/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.serviceImpl;

import com.example.demo.model.Trabajador;
import com.example.demo.repo.ITrabajadorRepo;
import com.example.demo.service.ITrabajadorService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Daniel
 */
@Service
public class TrabajadorServiceImpl implements ITrabajadorService{ 
    
    @Autowired
    private ITrabajadorRepo repo;
    @Override
    public Trabajador registrar(Trabajador t) {
        return repo.save(t);
    }

    @Override
    public List<Trabajador> listar() {
        return repo.findAll();
    }

    @Override
    public Trabajador modificar(Trabajador t) {
        return repo.save(t);
    }

    @Override
    public void eliminar(Integer id) {
        Trabajador o = new Trabajador();
        o.setIdTrabajador(id);  
        repo.delete(o);
        
    }

    @Override
    public Trabajador buscarPorId(Integer id) {
        Optional<Trabajador> oTrabajador = repo.findById(id);
        return oTrabajador.isPresent()? oTrabajador.get() :  null;
    }
}
