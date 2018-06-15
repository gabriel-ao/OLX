/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBD;

import Classes.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Thais
 */
public class UsuarioBD {
    public void inserir(Usuario usuario) throws Exception {
        Connection con;
        Conexao c = new Conexao();
        con = c.conectar();
                
        String sql = "INSERT INTO usuario (nome, bairro, cidade,uf,email,telefone,usuario,senha) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1, usuario.getNomeUser());
        ps.setString(2, usuario.getBairro());
        ps.setString(3, usuario.getCidade());
        ps.setString(4, usuario.getUF());
        ps.setString(5, usuario.getEmail());
        ps.setString(6, usuario.getTelefone());
        ps.setString(7, usuario.getUsuario());
        ps.setString(8, usuario.getSenha());

        ps.execute();
        con.close();
    }
    
    public void alterar(Usuario usuario) throws Exception{
        Connection con;
        Conexao c = new Conexao();
        con = c.conectar();
        
        String sql = "UPDATE usuario SET nome=?, bairro=?, cidade=?, uf=?, email=?, telefone=?, usuario=?, senha=? WHERE id_usuario =?";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1, usuario.getNomeUser());
        ps.setString(2, usuario.getBairro());
        ps.setString(3, usuario.getCidade());
        ps.setString(4, usuario.getUF());
        ps.setString(5, usuario.getEmail());
        ps.setString(6, usuario.getTelefone());
        ps.setString(7, usuario.getUsuario());
        ps.setString(8, usuario.getSenha());
        ps.setInt(9, usuario.getId_usuario());
        
        ps.execute();     
        con.close();
    }
    
    public Usuario getDados(Usuario usuario) throws Exception{
        Connection con;
        Conexao c = new Conexao();
        con = c.conectar();
        
        String sql = "SELECT * FROM usuario WHERE id_usuario=?";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setInt(1,usuario.getId_usuario());
        
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
            usuario.setNomeUser(rs.getString("nome"));
            usuario.setBairro(rs.getString("bairro"));
            usuario.setCidade(rs.getString("cidade"));
            usuario.setUF(rs.getString("uf"));
            usuario.setEmail(rs.getString("email"));
            usuario.setTelefone(rs.getString("telefone"));
            usuario.setUsuario(rs.getString("usuario"));
            usuario.setSenha(rs.getString("senha"));
        }
        
        con.close();
        return usuario;        
    } 
}
