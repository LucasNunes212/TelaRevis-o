package com.mycompany.remedio.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexao {
    static Connection con;
    static String url = "jdbc:postgresql://200.18.128.54/aula";
    static String usuario="aula";
    
    public static Connection getConexao(){
        try {
            if(con==null || con.isClosed()){
                con = DriverManager.getConnection(url, usuario,usuario);
            }
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public static void main(String[] args) {
        try {
            Connection c = Conexao.getConexao();
            if(c!=null && ! c.isClosed()){
                System.out.println("Conectado!");
            }
            System.out.println(c);
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
