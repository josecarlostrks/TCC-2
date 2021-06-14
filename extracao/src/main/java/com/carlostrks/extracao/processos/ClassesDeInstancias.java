/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlostrks.extracao.processos;

import com.carlostrks.extracao.modelo.Instancia;
import com.carlostrks.extracao.modelo.Padrao;
import com.carlostrks.extracao.modelo.Role;
import java.util.ArrayList;
import java.util.List;

/**
 * classe que tem como objetivo retornar as classes específicas do projeto e de seus padrões
 * @author jcarlos
 */
public class ClassesDeInstancias {
    
    String nomeProjeto = "";

    
    public ClassesDeInstancias(String nome) {
        this.nomeProjeto = nome; 
    }
    
    
    
    //método que salva cada padrão detectado e as suas instancias
    private Padrao instanciasPadrao(String nome){
        PadroesExtraidos arquivoDpd = new PadroesExtraidos(nomeProjeto);
        List<Padrao> listaDePadroes = arquivoDpd.recuperaInstanciasDoPadrao();
        Padrao padrao = new Padrao();
        
        String nomeP= nome;
        for(Padrao p: listaDePadroes){
            if(p.getNome().equals(nomeP)){
                padrao = p;
            }               
        }
        
        return padrao;       

    }

    // método que retorna o nome de cada classe do padrão factoryMethod
    public List<String> classesFactoryMethod(){
        Padrao padrao = this.instanciasPadrao("Factory Method");
        List<String> nomeClasses = new ArrayList<>();
        List<Instancia> instancias = null;
        instancias = padrao.getInstancias();
        for(Instancia in: instancias){
            List<Role> roles = in.getRoles();
            for(Role role: roles){
                if(role.getNome().equals("Creator")){
                    if(!nomeClasses.contains(role.getElemento()))
                        nomeClasses.add(role.getElemento());
//                }else{
//                    String[] nome = role.getElemento().split(":",4);
//                    if(!nomeClasses.contains(nome[3]))
//                        nomeClasses.add(nome[3]);
                }
            }
        }
        return nomeClasses = this.filtroDeClasses(nomeClasses);        
        //return nomeClasses;
    }
    
    //retorna todas as classes do padrão singleton
    public List<String> classesSingleton(){
        Padrao padrao = this.instanciasPadrao("Singleton");
        List<String> nomeClasses = new ArrayList<>();
        List<Instancia> instancias = null;
        instancias = padrao.getInstancias();
        for(Instancia in: instancias){
            List<Role> roles = in.getRoles();
            for(Role role: roles){
                if(role.getNome().equals("Singleton"))
                    if(!nomeClasses.contains(role.getElemento()))
                        nomeClasses.add(role.getElemento());
            }
        }
        return nomeClasses = this.filtroDeClasses(nomeClasses);
        
    }
    
    private List<String> filtroDeClasses(List<String> instancias){
        String[] nomesP = this.nomeProjeto.split("-");
        String nomeP = nomesP[0];
        List<String> classesFiltradas = new ArrayList<>();
        for(String nomeClasse: instancias){
            if(nomeClasse.contains(nomeP)){
                classesFiltradas.add(nomeClasse);
                System.out.println(nomeClasse);
            }
        }

        return classesFiltradas;
    }
    
    
    
    //selecionar quais classes pegar para pegar os termos 
    
    
}
