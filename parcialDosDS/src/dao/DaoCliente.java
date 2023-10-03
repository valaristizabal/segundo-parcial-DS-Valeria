/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cliente;
import singleton.DatabaseSingleton;

/**
 *
 * @author val
 */
public class DaoCliente {
    
    private Connection con;

    public DaoCliente() {
        con = DatabaseSingleton.getInstance().getConnection();
    }
    
    public void agregarCliente(Cliente cliente) throws SQLException {
        try {
            PreparedStatement ps = null;

            String sql = "INSERT INTO clientes (Nombre, Email) VALUES (?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getEmail());
            ps.execute();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }
    }

    public Cliente buscarCliente(int id) throws SQLException {
        Cliente encontrado = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String where = " WHERE id = '" + id + "'";
        String sql = "SELECT * FROM clientes" + where;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                String correo = rs.getString("Email");
                encontrado = new Cliente(nombre, correo);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }

        return encontrado;
    }

    public void editarCliente(int id, String nombre, String email) throws SQLException {
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("UPDATE clientes SET Nombre=?, Email=? WHERE id=?");
            ps.setString(1, nombre);
            ps.setString(2, email);
            ps.setInt(3, id);
            ps.execute();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }
    }

    public void eliminarCliente(int id) throws SQLException {
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("DELETE FROM clientes WHERE id= '" + id + "'");
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }
    }

    public ArrayList<Cliente> listaCliente() throws SQLException {
        ArrayList<Cliente> lista = new ArrayList<>();
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;

            String sql = "SELECT * FROM clientes";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");
                String nombre = rs.getString("Nombre");
                String email = rs.getString("Email");
                
                Cliente carrera = new Cliente(id, nombre, email);
                lista.add(carrera);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }

        return lista;
    }
}
