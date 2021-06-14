/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlostrks.extracao.processos;

import com.carlostrks.extracao.modelo.ClassesETermos;
import java.util.ArrayList;
import java.util.List;

/**
 * classe que tem como objetivo fazer a separação entre as classes que serão analisadas
 * @author jcarlos
 */
public class SelecionaClasses {
    
    private List<ClassesETermos> todasAsClasses;
    private List<ClassesETermos> classesDeInstancias;
    private List<ClassesETermos> classesComuns;
    private List<ClassesETermos> classesFiltradas;

    public SelecionaClasses() {
        this.classesFiltradas = new ArrayList<>();
        this.classesDeInstancias = new ArrayList<>();
        this.classesComuns = new ArrayList<>();
        this.todasAsClasses = new ArrayList<>();
    }

    public List<ClassesETermos> getClassesDeInstancias() {
        return classesDeInstancias;
    }

    public List<ClassesETermos> getClassesComuns() {
        return classesComuns;
    }
    
    
    
    //método que separa as listas de classes que pertencem e que não pertencem ao padrão FactoryMethod
    //ou ao padrão singleton
    public void separaClasses(String nomeProjeto, String nomePadrao){  
        this.filtrarClasses(nomeProjeto);
        ClassesDeInstancias classesInstancias = new ClassesDeInstancias(nomeProjeto);
        List<String> nomeInstancias=new ArrayList<>();
        switch(nomePadrao){
            case "Factory Method":
                nomeInstancias = classesInstancias.classesFactoryMethod();
                break;
            case "Singleton":
                nomeInstancias = classesInstancias.classesSingleton();
                break;
        }
        
        for(ClassesETermos classe: this.classesFiltradas){
            for(String nome: nomeInstancias){
                if(classe.getNomeEntidade().equals(nome)){
                    this.classesDeInstancias.add(classe);
                    this.classesComuns.remove(classe);

                }              
            }
        }       
        
    }    
    
    
    //método que recupera todas as classes do projeto e seleciona apenas as pertencentes ao projeto
    private void filtrarClasses(String nomeProjeto){
        TermosExtraidos extrairTermos = new TermosExtraidos(nomeProjeto);
        this.todasAsClasses = extrairTermos.recuperandoTermosDeEntidades();
        String[] nomesP = nomeProjeto.split("-");
        String nomeP = nomesP[0];
        System.out.println("método que filtra as classes do projeto "+nomeP);
        for(ClassesETermos classe: this.todasAsClasses){
            if(classe.getNomeEntidade().contains(nomeP)){
                classesFiltradas.add(classe);
                classesComuns.add(classe);
            }            
        }
        
    }
      
    
}
