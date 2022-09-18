/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import java.util.List;

/**
 *
 * @author Daniel
 */
public interface ICRUD <T>{
    
    T registrar(T t);
    List<T> listar();
    T modificar(T t);
    
    void eliminar(Integer id);
    
    T buscarPorId(Integer id);
}
