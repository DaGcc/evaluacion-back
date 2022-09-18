/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.serviceImpl;

import com.example.demo.model.Recibo;
import com.example.demo.repo.IReciboRepo;
import com.example.demo.service.IReciboService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Daniel
 */
@Service
public class ReciboServiceImpl implements IReciboService{ 
    
    @Autowired
    private IReciboRepo repo;
    @Override
    public Recibo registrar(Recibo t) {
        t.getListaDetalle().forEach(det->{
            det.setRecibo(t);
        });
        return repo.save(t);
    }

    @Override
    public List<Recibo> listar() {
        return repo.findAll();
    }

    @Override
    public Recibo modificar(Recibo t) {
        return repo.save(t);
    }

    @Override
    public void eliminar(Integer id) {
        Recibo o = new Recibo();
        o.setIdRecibo(id);  
        repo.delete(o);
        
    }

    @Override
    public Recibo buscarPorId(Integer id) {
        Optional<Recibo> oRecibo = repo.findById(id);
        return oRecibo.isPresent()? oRecibo.get() :  null;
    }
}
