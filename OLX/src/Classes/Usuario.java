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
    private String CPF;
    private Date data; 
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Date getDataNascimento() {
        return data;
    }

    public void setDataNascimento(Date data) {
        this.data = data;
    }
    
    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String Bairro) {
        this.bairro = Bairro;
    }
    
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
    
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String Cidade) {
        this.cidade = Cidade;
    }
    
       public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
