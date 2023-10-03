/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author val
 */
public class Pedidos {
    private int id;
    private String fechaPedido;
    private int total;
    private int idCliente;
    private String nombreCliente;
    
    public Pedidos(int id, String fechaPedido, int total, int idCliente) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.total = total;
        this.idCliente = idCliente;
    }

    public Pedidos(int id, String fechaPedido, int total, String nombreCliente) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.total = total;
        this.nombreCliente = nombreCliente;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    
}
