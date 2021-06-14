/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlostrks.extracao.modelo;

/**
 *
 * @author jcarlos
 */
public class Role {
    private String nome;
    private String nomeEntidade;
    
    public Role(String nome, String nomeEntidade){
        this.nome = nome;
        this.nomeEntidade = nomeEntidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getElemento() {
        return this.nomeEntidade;
    }

    public void setElemento(String nomeEntidade) {
        this.nomeEntidade = nomeEntidade;
    }

    @Override
    public String toString() {
        return "Role{" + "nome=" + nome + ", nomeEntidade=" + nomeEntidade + '}';
    }
    
    
    
}
