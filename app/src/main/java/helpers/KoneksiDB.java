/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author A11.2022.14727
 */
public class KoneksiDB {
    public static Connection conn;

    private KoneksiDB(){}

    public static Connection connect() throws SQLException{
        if(conn == null || conn.isClosed()){
            conn = DriverManager.getConnection("jdbc:sqlite:manajemen.db");
        }

        return conn;
    }
}

