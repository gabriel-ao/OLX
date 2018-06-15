/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBD;

import Classes.Acao;
import Classes.Produto;
import Classes.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Thais
 */
public class AcaoBD {

    public void inserir(Acao acao) throws Exception {
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

    public void alterar(Acao acao) throws Exception {
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

    public void excluir(Acao acao) throws Exception {
        Connection con;
        Conexao c = new Conexao();
        con = c.conectar();

        String sql = "DELETE acao WHERE id_acao=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, acao.getIdAcao());

        ps.execute();
        con.close();
    }

    public ArrayList<Acao> listarUser(Produto produto, String tipo) throws Exception {
        Connection con;
        Conexao c = new Conexao();
        con = c.conectar();

        String sql = "select usuario.nome, usuario.bairro, usuario.cidade, usuario.uf, usuario.telefone, acao.status, acao.tipo \n"
                + "from Acao as acao inner join usuario as usuario  on (acao.id_usuario = usuario.id_usuario)\n"
                + "inner join Produto as prod on (acao.Id_produto = prod.id_produto)\n"
                + "where prod.status = 'Disponivel' and acao.tipo= '"+ tipo  +"' and prod.id_produto ="+ produto.getId_produto() +" order by prod.dt_anuncio desc;";

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        ArrayList<Acao> listaUser = new ArrayList<>();

        while (rs.next()) {
            Acao acao = new Acao();
            
            acao.setNomeUser(rs.getString("nome"));
            acao.setBairro(rs.getString("bairro"));
            acao.setCidade(rs.getString("cidade"));
            acao.setUF(rs.getString("uf"));
            acao.setTelefone(rs.getString("telefone"));
            acao.setStatus(rs.getString("status"));

            listaUser.add(acao);
        }

        con.close();

        return listaUser;
    }
    
    public ArrayList<Acao> listarMeusPedidos(Usuario usuario) throws Exception {
        Connection con;
        Conexao c = new Conexao();
        con = c.conectar();

        String sql = "select prod.*, usuario.*, acao.status as statusacao, acao.tipo from Acao as acao\n"
                + "inner join usuario as usuario  on (acao.id_usuario = usuario.id_usuario)\n"
                + "inner join Produto as prod on (acao.Id_produto = prod.id_produto)  "
                + "where usuario.id_usuario ="+ usuario.getId_usuario() + " and acao.tipo != 'Venda' order by prod.dt_anuncio desc;";

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        ArrayList<Acao> listaPedidos = new ArrayList<>();

        while (rs.next()) {
            Acao acao = new Acao();
            
            
            acao.setId_produto(rs.getInt("id_produto"));
            acao.setNome(rs.getString("nome"));
            acao.setEstadoConserv(rs.getString("estadoConserv"));
            acao.setPreco(rs.getDouble("preco"));
            acao.setDescricao(rs.getString("descricao"));
            acao.setCategoria(rs.getString("categoria"));
            acao.setImg(rs.getBytes("img"));
            acao.setStatusProd(rs.getString("status"));
            acao.setDt_anuncio(rs.getDate("dt_anuncio"));
            acao.setNomeUser(rs.getString("nome"));
            acao.setBairro(rs.getString("bairro"));
            acao.setCidade(rs.getString("cidade"));
            acao.setUF(rs.getString("uf"));
            acao.setTelefone(rs.getString("telefone"));
            acao.setStatus(rs.getString("statusacao"));            

            listaPedidos.add(acao);
        }

        con.close();

        return listaPedidos;
    }
}
