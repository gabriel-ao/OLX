/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;

/**
 *
 * @author gabri
 */
public class Usuario {
    
    private int id_usuario;
    private String nome;
    private String bairro;
    private String cidade;
    private String uf;
    private String telefone;
    private String email;
    private String usuario;
    private String senha;


    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
        
    public int getId_usuario() {
        return id_usuario;
    }

    public String getNomeUser() {
        return nome;
    }

    public void setNomeUser(String nome) {
        this.nome = nome;
    }
    
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String Bairro) {
        this.bairro = Bairro;
    }
    
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String Cidade) {
        this.cidade = Cidade;
    }
    
       public String getUF() {
        return uf;
    }

    public void setUF(String estado) {
        this.uf = estado;
    }
    
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String Telefone) {
        this.telefone = Telefone;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    // final classe
}
