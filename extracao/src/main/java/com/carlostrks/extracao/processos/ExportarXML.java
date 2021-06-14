/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlostrks.extracao.processos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author jcarlos
 */
public class ExportarXML {

    public ExportarXML() {
    }
    

   
    public void gerarArquivo(AnaliseDeDados analise, String nomeProjeto, String nomePadrao){
        
        Element padrao = new Element("padrao");
        Document meuDocumento = new Document(padrao);
    
        Element valorEmInstancias = new Element("valorEmInstancias");    
        valorEmInstancias.setAttribute("valor", String.valueOf(analise.getValorEmInstancias()));
        
        Element valorGeral = new Element("valorGeral");
        valorGeral.setAttribute("valor", String.valueOf(analise.getValorGeral()));
        
        Element classesComTermo = new Element("classesComTermo");
        Element classesSemTermo = new Element("classesSemTermo");
        Element classesComuns = new Element("classesComuns");
        
        for(String nomeClasse: analise.getPesquisa().getClassesComTermo()){
            Element classe = new Element("classe");
            classe.setAttribute("nome", nomeClasse);
            classesComTermo.addContent(classe);
        }
        for(String nomeClasse: analise.getPesquisa().getClassesSemTermo()){
            Element classe = new Element("classe");
            classe.setAttribute("nome", nomeClasse);            
            classesSemTermo.addContent(classe);
        }
        for(String nomeClasse: analise.getPesquisa().getClassesComuns()){
            Element classe = new Element("classe");
            classe.setAttribute("nome", nomeClasse);            
            classesComuns.addContent(classe);
        }
        
        padrao.addContent(valorEmInstancias);
        padrao.addContent(valorGeral);
        padrao.addContent(classesComTermo);
        padrao.addContent(classesSemTermo);
        padrao.addContent(classesComuns);
        
        //Format f = Format.getRawFormat();
        //f.setIndent("\t");
        //f.setLineSeparator("\n");

        //XMLOutputter xout = new XMLOutputter(f);        
        XMLOutputter xout = new XMLOutputter();        
        

        File caminho = new File(String.format("../outputs/%s", nomeProjeto));
        if(!caminho.isDirectory())
            caminho.mkdirs();

        try{
            FileOutputStream arquivo = new FileOutputStream(new File(String.format("../outputs/%s/%s.xml", nomeProjeto, nomePadrao)));
            xout.output(meuDocumento, arquivo);
            arquivo.close();
        }catch (IOException e) {
            e.printStackTrace();

        }
    }
    
/*<padrao>
    <especifico valor="">
    <geral valor="">
    <classesComTermo>
        <classe nome="">
    </classesComTermo>

    <classesSemTermo>
        <classe nome="">
    </classesSemTermo>

    <classesComuns>
        <classe nome="">
    </classesComuns>
  </padrao>  
*/    
           
}
