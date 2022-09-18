/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.Producto;
import com.example.demo.service.IProductoService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Daniel
 */
@RestController
@RequestMapping("/productos")
public class PorductoController {
    
    
    @Autowired
    private IProductoService service;
    
    
    @PostMapping
    public ResponseEntity<?> registrar(@Valid @RequestBody Producto obj){
        Producto entity = service.registrar(obj);
        return new ResponseEntity<Producto>(entity,HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<?> modificar(@Valid @RequestBody Producto obj){
        Producto entity = service.modificar(obj);
        return new ResponseEntity<Producto>(entity,HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<?> listar(){
        List<Producto> lista = service.listar(); 
        return new ResponseEntity<List<Producto>>(lista,HttpStatus.OK);  
    } 
    
     @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable("id")Integer id){
        Producto entity = service.buscarPorId(id);
        return new ResponseEntity<Producto>(entity,HttpStatus.OK);  
    } 
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id")Integer id){
        service.eliminar(id);
        return new ResponseEntity<Producto>(HttpStatus.OK);  
    } 
     
    
    
}
