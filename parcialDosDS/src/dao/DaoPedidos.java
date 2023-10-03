/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
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
    
    
}
