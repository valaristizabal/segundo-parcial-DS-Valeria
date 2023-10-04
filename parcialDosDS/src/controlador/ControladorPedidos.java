/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.DaoPedidos;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Pedidos;

/**
 *
 * @author val
 */
public class ControladorPedidos {
    DaoPedidos dao;

    public ControladorPedidos() {
        dao = new DaoPedidos();
    }
    
    public void agregarPedido(Pedidos pedido) throws SQLException {
        dao.agregarPedido(pedido);
    }
    
    public Pedidos buscarPedido(int id) throws SQLException {
        return dao.buscarPedido(id);
    }
    
    public void editarPedido(int id, int total, int ClienteID) throws SQLException {
        dao.editarPedido(id, total, ClienteID);
    }
    
    public void eliminarPedido(int id) throws SQLException {
        dao.eliminarPedido(id);
    }
    
    public ArrayList<Pedidos> listaPedidos() throws SQLException {
        return dao.listaPedidos();
    }
    
    public ArrayList<Pedidos> listaPedidosFiltrada(int idCliente) throws SQLException {
        return dao.listaPedidosFiltrada(idCliente);
    }
}
