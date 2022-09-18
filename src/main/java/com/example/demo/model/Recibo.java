/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="recibo")
public class Recibo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRecibo;
    
    
    @ManyToOne
    @JoinColumn(name="id_cliente",nullable = false)
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name="id_trabajador",nullable = false)
    private Trabajador trabajador;
    
    
    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime fecha;
    
    
    @OneToMany(mappedBy = "recibo", cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE}, fetch=FetchType.LAZY,orphanRemoval = true)
    private List<DetalleRecibo> listaDetalle;
    
    public Integer getIdRecibo() {
        return idRecibo;
    }

    public void setIdRecibo(Integer idRecibo) {
        this.idRecibo = idRecibo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public List<DetalleRecibo> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(List<DetalleRecibo> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }

    
    
    
    
    
}
