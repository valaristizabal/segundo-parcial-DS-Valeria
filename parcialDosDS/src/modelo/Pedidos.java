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
    private LocalDate fechaPedido;
    private int total;
    private int idCliente;
    
    
    public Pedidos(int id, LocalDate fechaPedido, int total, int idCliente) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.total = total;
        this.idCliente = idCliente;
    }
    
    
}
