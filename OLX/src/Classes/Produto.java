/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Date;

/**
 *
 * @author Andressa
 */
public class Produto extends Usuario{
 private int Id_produto;
 private String nome;
 private String estadoConserv;
 private String categoria;
 private String descricao;
 private double preco;
 private byte[] img;
 private String status;
 private Date dt_anuncio;

    public int getId_produto() {
        return Id_produto;
    }

    public void setId_produto(int Id_produto) {
        this.Id_produto = Id_produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstadoConserv() {
        return estadoConserv;
    }

    public void setEstadoConserv(String estadoConserv) {
        this.estadoConserv = estadoConserv;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getStatusProd() {
        return status;
    }

    public void setStatusProd(String status) {
        this.status = status;
    }

    public Date getDt_anuncio() {
        return dt_anuncio;
    }

    public void setDt_anuncio(Date dt_anuncio) {
        this.dt_anuncio = dt_anuncio;
    }

 
}
