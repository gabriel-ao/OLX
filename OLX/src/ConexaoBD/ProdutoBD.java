/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBD;

import Classes.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Thais
 */
public class ProdutoBD {
    public void inserir (Produto produto)throws Exception{
        Connection con;
        Conexao c = new Conexao();
        con = c.conectar();
        
        String sql = "INSERT INTO produto (nome, estadoConserv, preco, descricao, categoria, img, status) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1, produto.getNome());
        ps.setString(2, produto.getEstadoConserv());
        ps.setDouble(3, produto.getPreco());
        ps.setString(4, produto.getDescricao());
        ps.setString(5, produto.getCategoria());
        ps.setByte(6, produto.getImg());
        ps.setString(7, produto.getStatus());
        
        ps.execute();
        con.close();
    }
    
    public void alterar (Produto produto)throws Exception{
        Connection con;
        Conexao c = new Conexao();
        con = c.conectar();
        
        String sql = "UPDATE produto SET nome=?, estadoConserv=?, preco=?, descricao=?, categoria=?, img=?, status=? WHERE id_produto=?";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1, produto.getNome());
        ps.setString(2, produto.getEstadoConserv());
        ps.setDouble(3, produto.getPreco());
        ps.setString(4, produto.getDescricao());
        ps.setString(5, produto.getCategoria());
        ps.setByte(6, produto.getImg());
        ps.setString(7, produto.getStatus());
        ps.setInt(8, produto.getId_produto());
        
        ps.execute();
        con.close();
    }
    
    public void excluir (Produto produto)throws Exception{
        Connection con;
        Conexao c = new Conexao();
        con = c.conectar();
        
        String sql = "DELETE produto WHERE id_produto=?";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setInt(1, produto.getId_produto());
        
        ps.execute();
        con.close();
    }
    
    public ArrayList<Produto> listarTodosProdutos (Produto produto)throws Exception{
        Connection con;
        Conexao c = new Conexao();
        con = c.conectar();
             
        String sql = "SELECT * FROM produto WHERE status = 'Disponivel'";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        ArrayList<Produto> listaProduto = new ArrayList<>();
        
        while(rs.next()){
            produto.setId_produto(rs.getInt("id_produto"));
            produto.setNome(rs.getString("nome"));
            produto.setEstadoConserv(rs.getString("estadoConserv"));
            produto.setPreco(rs.getDouble("preco"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setCategoria(rs.getString("categoria"));
            produto.setImg(rs.getByte("img"));
            produto.setStatus(rs.getString("status"));
            produto.setDt_anuncio(rs.getDate("dt_anuncio"));
            
            listaProduto.add(produto);
        }
        con.close();
        
        return listaProduto;
    }
}
