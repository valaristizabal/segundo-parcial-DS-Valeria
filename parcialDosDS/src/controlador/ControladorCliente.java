/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.DaoCliente;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cliente;

/**
 *
 * @author val
 */
public class ControladorCliente {
    DaoCliente dao;

    public ControladorCliente() {
        dao = new DaoCliente();
    }
    
    public void agregarCliente(Cliente cliente) throws SQLException {
        dao.agregarCliente(cliente);
    }
    
    public Cliente buscarCliente(int id) throws SQLException {
        return dao.buscarCliente(id);
    }
    
    public void editarCliente(int id, String nombre, String email) throws SQLException {
        dao.editarCliente(id, nombre, email);
    }
    
    public void eliminarCliente(int id) throws SQLException {
        dao.eliminarCliente(id);
    }
    
    public ArrayList<Cliente> listaCliente() throws SQLException {
        return dao.listaCliente();
    }
        
    public int buscarIdDelCiente(String nombre) throws SQLException {
        return dao.buscarIdDelCiente(nombre);
    }
}
