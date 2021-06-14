/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlostrks.extracao.modelo;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author jcarlos
 */
public class ClassesETermos {
    
    private String nomeEntidade;
    private List<String> termos;
    
    public ClassesETermos(){
        this.termos = new ArrayList<>();
    }
    
    public ClassesETermos(String nomeDaEntidade){
        this();
        this.nomeEntidade = nomeDaEntidade;
    }

    public String getNomeEntidade() {
        return nomeEntidade;
    }

    public void setNomeEntidade(String nomeEntidade) {
        this.nomeEntidade = nomeEntidade;
    }

    public List<String> getTermos() {
        return termos;
    }

    public void setTermos(List<String> termos) {
        this.termos = termos;
    }

    
    
    public void inserirTermos(String termo){
        this.termos.add(termo);
    }

    @Override
    public String toString() {
        return "TermosEncontrados{" + "nomeEntidade=" + nomeEntidade + ", termos=" + termos + '}';
    }
    
    
}
