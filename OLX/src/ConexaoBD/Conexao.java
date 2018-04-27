/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Thais
 */
public class Conexao {
    public static Connection conectar() throws Exception {

        String url = "jdbc:postgresql://localhost:5432/Banco_OLX";
        String usuario = "postgres";
        String senha = "admin";

        Class.forName("org.postgresql.Driver");
        System.out.println("Conexão realizada com sucesso.");
        return DriverManager.getConnection(url, usuario, senha);
    }    
}
