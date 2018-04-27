/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBD;

import Classes.Acao;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Thais
 */
public class AcaoBD {
    public void inserir (Acao acao) throws Exception{
        Connection con;
        Conexao c = new Conexao();
        con = c.conectar();
        
        String sql = "INSERT INTO acao (tipo, status, id_usuario, id_produto) VALUES (?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1, acao.getTipo());
        ps.setString(2, acao.getStatus());
        ps.setInt(3, acao.getId_usuario());
        ps.setInt(4, acao.getId_produto());
        
        ps.execute();
        con.close();
    }
    
    public void alterar (Acao acao) throws Exception{
        Connection con;
        Conexao c = new Conexao();
        con = c.conectar();
        
        String sql = "UPDATE acao SET tipo=?, status=?, id_usuario=?, id_produto=? WHERE id_acao=?";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1, acao.getTipo());
        ps.setString(2, acao.getStatus());
        ps.setInt(3, acao.getId_usuario());
        ps.setInt(4, acao.getId_produto());
        ps.setInt(5, acao.getIdAcao());
        
        ps.execute();
        con.close();
    }
    
    public void excluir (Acao acao) throws Exception{
        Connection con;
        Conexao c = new Conexao();
        con = c.conectar();
        
        String sql = "DELETE acao WHERE id_acao=?";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setInt(1, acao.getIdAcao());
        
        ps.execute();
        con.close();
    }   
}
