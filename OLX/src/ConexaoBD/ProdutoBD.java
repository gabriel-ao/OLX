/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBD;

import Classes.Produto;
import Classes.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Thais
 */
public class ProdutoBD {

    public void inserir(Produto produto) throws Exception {
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
        ps.setBytes(6, produto.getImg());
        ps.setString(7, produto.getStatus());

        ps.execute();

        sql = "SELECT MAX(id_produto) FROM produto";
        ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("max");

            sql = "INSERT INTO acao (tipo, status, id_usuario, id_produto) VALUES (?,?,?,?)";
            ps = con.prepareStatement(sql);

            ps.setString(1, "Venda");
            ps.setString(2, "Aguardando Compradores");
            ps.setInt(3, produto.getId_usuario());
            ps.setInt(4, id);
            ps.execute();
        }
        con.close();
    }

    public void alterar(Produto produto) throws Exception {
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
        ps.setBytes(6, produto.getImg());
        ps.setString(7, produto.getStatus());
        ps.setInt(8, produto.getId_produto());

        ps.execute();
        con.close();
    }

    public void excluir(Produto produto) throws Exception {
        Connection con;
        Conexao c = new Conexao();
        con = c.conectar();

        String sql = "DELETE produto WHERE id_produto=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, produto.getId_produto());

        ps.execute();

        con.close();
    }

    public ArrayList<Produto> listarMeusProdutos(Usuario usuario) throws Exception {
        Connection con;
        Conexao c = new Conexao();
        con = c.conectar();

        JOptionPane.showMessageDialog(null, "ID: " + usuario.getId_usuario());
        
        String sql = "select prod.*, usuario.*, acao.status, acao.tipo from Acao as acao\n"
                + "inner join usuario as usuario  on (acao.id_usuario = usuario.id_usuario)\n"
                + "inner join Produto as prod on (acao.Id_produto = prod.id_produto)  "
                + "where acao.tipo = 'Venda' and usuario.id_usuario ="+ usuario.getId_usuario() + " order by prod.dt_anuncio desc";
        PreparedStatement ps = con.prepareStatement(sql);
                
        ResultSet rs = ps.executeQuery();

        ArrayList<Produto> listaProduto = new ArrayList<>();

        while (rs.next()) {
            Produto produto = new Produto();
            
            produto.setId_produto(rs.getInt("id_produto"));
            produto.setNome(rs.getString("nome"));
            produto.setEstadoConserv(rs.getString("estadoConserv"));
            produto.setPreco(rs.getDouble("preco"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setCategoria(rs.getString("categoria"));
            produto.setImg(rs.getBytes("img"));
            produto.setStatus(rs.getString("status"));
            produto.setDt_anuncio(rs.getDate("dt_anuncio"));

            listaProduto.add(produto);
        }
        con.close();

        return listaProduto;
    }

    public ArrayList<Produto> listarTodosProdutos() throws Exception {
        Connection con;
        Conexao c = new Conexao();
        con = c.conectar();

        String sql = "select prod.*, usuario.*, acao.status from Acao as acao\n"
                + "inner join usuario as usuario  on (acao.id_usuario = usuario.id_usuario)\n"
                + "inner join Produto as prod on (acao.Id_produto = prod.id_produto) order by prod.dt_anuncio desc\n";

        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList<Produto> listaProduto = new ArrayList<>();

        while (rs.next()) {
            Produto produto = new Produto();

            produto.setId_produto(rs.getInt("id_produto"));
            produto.setNome(rs.getString("nome"));
            produto.setEstadoConserv(rs.getString("estadoConserv"));
            produto.setPreco(rs.getDouble("preco"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setCategoria(rs.getString("categoria"));
            produto.setImg(rs.getBytes("img"));
            produto.setStatus(rs.getString("status"));
            produto.setDt_anuncio(rs.getDate("dt_anuncio"));
            produto.setBairro(rs.getString("bairro"));
            produto.setCidade(rs.getString("cidade"));
            produto.setUF(rs.getString("uf"));
            produto.setId_usuario(rs.getInt("id_usuario"));

            listaProduto.add(produto);
        }
        con.close();

        return listaProduto;
    }
}
