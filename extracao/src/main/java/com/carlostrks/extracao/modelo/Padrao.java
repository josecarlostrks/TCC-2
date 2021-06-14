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
public class Padrao {
    
    private String nome;
    private List<Instancia> instancias;
    
    public Padrao(){
        this.instancias = new ArrayList<>();
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Instancia> getInstancias() {
        return instancias;
    }
    
    public void addInstancia(Instancia instancia){
        this.instancias.add(instancia);
    }

    @Override
    public String toString() {
        return "PadroesDetectados{" + "nome=" + nome + ", instancias=" + instancias + '}';
    }
    
}
