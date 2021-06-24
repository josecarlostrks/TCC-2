/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlostrks.extracao.processos;

/**
 *
 * @author jcarlos
 */
public class AnaliseDeDados {
    private BuscaPorTermo pesquisa;
    private float valorEmInstancias; 
    private float valorGeral;
    private String nomeProjetoFiltrado;
    private String nomePadrao;
    
    public AnaliseDeDados(){
        pesquisa = new BuscaPorTermo();
    }

    public BuscaPorTermo getPesquisa() {
        return pesquisa;
    }

    public float getValorEmInstancias() {
        return valorEmInstancias;
    }

    public float getValorGeral() {
        return valorGeral;
    }

    public String getNomeProjetoFiltrado() {
        return nomeProjetoFiltrado;
    }

    public String getNomePadrao() {
        return nomePadrao;
    }
    
    
    public void analisar(String nomeProjeto, String nomePadrao){
        this.nomePadrao= nomePadrao;
        filtraNomePadrao(nomeProjeto);
        presencaEmInstancias(this.nomeProjetoFiltrado, nomePadrao);
        relacaoComInstancias();
    }
    
    private void filtraNomePadrao(String nome){
        switch(nome){
            case "Axion":
                this.nomeProjetoFiltrado="axion-1.0-M2";
                break;
            case "Jext":
                this.nomeProjetoFiltrado="jext-5.0";
                break;
            case "quickserver":
                this.nomeProjetoFiltrado="quickserver-1.4.7";
                break;
            case "sandmark":
                this.nomeProjetoFiltrado="sandmark-3.4";
                break;
        }
    }
    
    private void presencaEmInstancias(String nomeProjeto, String nomePadrao){
        this.pesquisa.buscaTermos(nomeProjeto, nomePadrao);
        float dividendo =(float) pesquisa.getClassesComTermo().size();
        //System.out.println("dividendo "+ dividendo);
        float divisor =(float) pesquisa.getClassesComTermo().size() + pesquisa.getClassesSemTermo().size();
        //this.valorEmInstancias= (dividendo/divisor)*100;        
        this.valorEmInstancias= (dividendo/divisor);        
        
    }
    
    private void relacaoComInstancias(){
        float dividendo = (float) pesquisa.getClassesComTermo().size();
        float divisor = (float) pesquisa.getClassesComTermo().size() + pesquisa.getClassesComuns().size();
        //this.valorGeral = (dividendo/divisor)*100;
        //this.valorGeral = (dividendo/divisor);
        if(divisor!=0){
            this.valorGeral = (dividendo/divisor);
        }else{
            this.valorGeral = 0;
        }
        
    }
}
