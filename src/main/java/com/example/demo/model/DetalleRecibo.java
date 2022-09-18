/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="detalle_recibo")
public class DetalleRecibo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleRecibo;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="id_recibo",nullable = false)
    private Recibo recibo;
    
    @ManyToOne
    @JoinColumn(name="id_producto",nullable = false)
    private Producto producto;
    
    @Column(name="descripcion",nullable = false,length= 60)
    private String descripcion;
    
    @Column(name="cantidad",nullable = false,length= 60)
    private Integer cantidad;
    
    
    

    public Integer getIdDetalleRecibo() {
        return idDetalleRecibo;
    }

    public void setIdDetalleRecibo(Integer idDetalleRecibo) {
        this.idDetalleRecibo = idDetalleRecibo;
    }

    public Recibo getRecibo() {
        return recibo;
    }

    public void setRecibo(Recibo recibo) {
        this.recibo = recibo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    

    
    
    
    
}
