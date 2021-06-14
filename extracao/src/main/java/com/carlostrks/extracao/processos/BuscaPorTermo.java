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
 *
 * @author jcarlos
 */
public class BuscaPorTermo {
    
    private List<String> classesComTermo;
    private List<String> classesSemTermo;
    private List<String> classesComuns;

    public BuscaPorTermo() {
        this.classesComTermo = new ArrayList<>();
        this.classesSemTermo = new ArrayList<>();
        this.classesComuns = new ArrayList<>();
    }

    public List<String> getClassesComTermo() {
        return classesComTermo;
    }

    public List<String> getClassesSemTermo() {
        return classesSemTermo;
    }

    public List<String> getClassesComuns() {
        return classesComuns;
    }
    



      //busca por termos em conjunto, no nome da classe e internamente.
    public void buscaTermos(String nomeProjeto,String nomePadrao ){
        String nomeClasse = "";
        String termo="";
        String termoInterno="";
        switch(nomePadrao){
            case "Factory Method":
                termo="factory";
                termoInterno="creat";                
                break;
            case "Singleton":
                termo="singleton";
                termoInterno="instanc";                
                break;                
        }
        SelecionaClasses selecionarClasses = new SelecionaClasses();
        selecionarClasses.separaClasses(nomeProjeto, nomePadrao);
        for(ClassesETermos classe: selecionarClasses.getClassesDeInstancias()){
            nomeClasse = classe.getNomeEntidade().toLowerCase();
            if((nomeClasse.contains(termo))&&(classe.getTermos().contains(termoInterno))){
                this.classesComTermo.add(classe.getNomeEntidade());
            }else{
                this.classesSemTermo.add(classe.getNomeEntidade());
            }
        }
        
        for(ClassesETermos classe: selecionarClasses.getClassesComuns()){
            nomeClasse = classe.getNomeEntidade().toLowerCase();
            if((nomeClasse.contains(termo))&&(classe.getTermos().contains(termoInterno))){
                this.classesComuns.add(classe.getNomeEntidade());
            }
        }
    }





    
//    método que busca o termo no nome da classe.
//    public void buscaTermos(String nomeProjeto,String nomePadrao ){
//        String nomeClasse = "";
//        String termo="";
//        switch(nomePadrao){
//            case "Factory Method":
//                termo="factory";                
//                break;
//            case "Singleton":
//                termo="singleton";                
//                break;                
//        }
//        SelecionaClasses selecionarClasses = new SelecionaClasses();
//        selecionarClasses.separaClasses(nomeProjeto, nomePadrao);
//        for(ClassesETermos classe: selecionarClasses.getClassesDeInstancias()){
//            nomeClasse= classe.getNomeEntidade().toLowerCase();
//            if(nomeClasse.contains(termo)){               
//                this.classesComTermo.add(classe.getNomeEntidade());
//                //System.out.println("classes com termo: "+this.classesComTermo.size());
//            }else{
//                this.classesSemTermo.add(classe.getNomeEntidade());
//                //System.out.println("classes sem termo: "+this.classesSemTermo.size());
//            }
//        }
//        
//        for(ClassesETermos classe: selecionarClasses.getClassesComuns()){
//            nomeClasse=classe.getNomeEntidade().toLowerCase();
//            if(nomeClasse.contains(termo)){
//                this.classesComuns.add(classe.getNomeEntidade());
//            }
//        }
//    }
    



    
        
    // busca por termo interno em todo o vocabulário
//    public void buscaTermos(String nomeProjeto,String nomePadrao ){
//        String termo="";
//        switch(nomePadrao){
//            case "Factory Method":
//                termo="creat";
//                break;
//            case "Singleton":
//                termo="instanc";
//                break;                
//        }
//        SelecionaClasses selecionarClasses = new SelecionaClasses();
//        selecionarClasses.separaClasses(nomeProjeto, nomePadrao);
//        for(ClassesETermos classe: selecionarClasses.getClassesDeInstancias()){
//            if(classe.getTermos().contains(termo)){
//                this.classesComTermo.add(classe.getNomeEntidade());
//            }else{
//                this.classesSemTermo.add(classe.getNomeEntidade());
//            }
//        }
//        
//        for(ClassesETermos classe: selecionarClasses.getClassesComuns()){
//            if(classe.getTermos().contains(termo)){
//                this.classesComuns.add(classe.getNomeEntidade());
//            }
//        }
//    }
    
}
