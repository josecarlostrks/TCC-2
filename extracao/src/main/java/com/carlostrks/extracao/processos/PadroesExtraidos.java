/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlostrks.extracao.processos;

import com.carlostrks.extracao.modelo.Instancia;
import com.carlostrks.extracao.modelo.Padrao;
import com.carlostrks.extracao.modelo.Role;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;
import org.jdom2.Element;

/**
 *
 * @author jcarlos
 */
public class PadroesExtraidos {
    
    private File caminhoArquivo;
    public String nomeProjeto;
    
    
//    public PadroesExtraidos(){
//        this.caminhoArquivo= new File("../saidas/jext-5.0/jext-5.0.xml");
//    }
    
    public PadroesExtraidos(String nome){
        this.nomeProjeto = nome;
        this.caminhoArquivo = new File(String.format("../inputs/%s/%s.xml", nomeProjeto, nomeProjeto));
    }
    
    public List<Padrao> recuperaInstanciasDoPadrao(){
        List<Padrao> listaPadroes = new ArrayList<>();
        
        Document doc = null;
        SAXBuilder builder = new SAXBuilder();
        
        try{
            doc = builder.build(this.caminhoArquivo);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        Element arquivo = doc.getRootElement();
        List<Element> padroes = arquivo.getChildren();
        for(Element p: padroes){
            
            Padrao padrao = new Padrao();
            String nomePadrao = p.getAttributeValue("name");
            padrao.setNome(nomePadrao);
            //System.out.println("\n"+nomePadrao+"\n");
            
            List<Element> instancias = p.getChildren();            
            for(Element i: instancias){
                
                Instancia instancia = new Instancia();
                
                List<Element> roles = i.getChildren();                
                for(Element r: roles){
                    String nomeRole = r.getAttributeValue("name");
                    String nomeEntidade = r.getAttributeValue("element");
                    //System.out.println(nomeRole);
                    //System.out.println(nomeEntidade);
                    
                    Role role = new Role(nomeRole, nomeEntidade);
                    //System.out.println(role.getNome());
                    //System.out.println(role.getElemento());
                    instancia.addRole(role);
                }
                padrao.addInstancia(instancia);
                
                //System.out.println(instancia.getRoles().get(0).getElemento());
            }
            listaPadroes.add(padrao);
            
        }
        
        
        
        
        return listaPadroes;
    }
    
}
