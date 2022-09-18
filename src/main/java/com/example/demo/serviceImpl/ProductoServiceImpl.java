/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.serviceImpl;

import com.example.demo.model.Producto;
import com.example.demo.repo.IProductoRepo;
import com.example.demo.service.IProductoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Daniel
 */
@Service
public class ProductoServiceImpl implements IProductoService{ 
    
    @Autowired
    private IProductoRepo repo;
    @Override
    public Producto registrar(Producto t) {
        return repo.save(t);
    }

    @Override
    public List<Producto> listar() {
        return repo.findAll();
    }

    @Override
    public Producto modificar(Producto t) {
        return repo.save(t);
    }

    @Override
    public void eliminar(Integer id) {
        Producto o = new Producto();
        o.setIdProducto(id);  
        repo.delete(o);
        
    }

    @Override
    public Producto buscarPorId(Integer id) {
        Optional<Producto> oProducto = repo.findById(id);
        return oProducto.isPresent()? oProducto.get() :  null;
    }
}
