/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;

/**
 *
 * @author Randi
 */
public class koneksi {
    static Connection con;
    public static java.sql.Connection getConnection(){
        try{
            String url = "jdbc:mysql://localhost:3306/db_tka_erlangga";
            String user = "root";
            String pass = "";
            
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            con = DriverManager.getConnection(url, user, pass);
        }catch(Exception e){
            System.out.println("Koneksi Gagal"+e);
        }
        return con;
    }
}
