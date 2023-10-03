/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import modelo.Pedidos;
import singleton.DatabaseSingleton;

/**
 *
 * @author val
 */
public class DaoPedidos {
    private Connection con;

    public DaoPedidos() {
        con = DatabaseSingleton.getInstance().getConnection();
    }
    
    
    public void agregarPedido(Pedidos pedido) throws SQLException {
        try {
            PreparedStatement ps = null;

            String sql = "INSERT INTO Pedidos (PedidoID, FechaPedido, Total, IdCliente) VALUES (?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getId());
            ps.setString(2, String.valueOf(pedido.getFechaPedido()));
            ps.setInt(3, pedido.getTotal());
            ps.setInt(4, pedido.getIdCliente());
            ps.execute();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }
    }

    
    public Pedidos buscarPedido(int id) throws SQLException {
        Pedidos productoEncontrado = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String where = " WHERE id = '" + id + "'";
        String sql = "SELECT * FROM Pedidos" + where;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String fechaPedido = rs.getString("FechaPedido");
                int total = rs.getInt("Total");
                int idCliente = rs.getInt("ClienteID");
                productoEncontrado = new Pedidos(id, fechaPedido, total, idCliente);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }

        return productoEncontrado;
    }

     public void editarPedido(int id, int total, int ClienteID) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("UPDATE Pedidos SET Total=?, IdCliente=? WHERE PedidoID=?");
            ps.setInt(1, total);
            ps.setInt(2, ClienteID);
            ps.setInt(3,id);
            ps.execute();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }
    }


    public void eliminarPedido(int id) throws SQLException {
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("DELETE FROM Pedidos WHERE id= '" + id + "'");
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }
    }
    
        public ArrayList<Pedidos> listaPedidos() throws SQLException {
        ArrayList<Pedidos> lista = new ArrayList<>();
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;

            String sql = "SELECT p.PedidoID, p.FechaPedido, p.Total, c.Nombre AS nombreCliente "
                    + "FROM pedidos p "
                    + "INNER JOIN clientes c ON p.ClienteId = c.id";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("PedidoID");
                String Fecha = rs.getString("FechaPedido");
                int total = rs.getInt("Total");
                String nombreCliente = rs.getString("nombreCliente");

                Pedidos pedidos = new Pedidos(id, Fecha, total, nombreCliente);
                lista.add(pedidos);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }

        return lista;
    }
    
}
