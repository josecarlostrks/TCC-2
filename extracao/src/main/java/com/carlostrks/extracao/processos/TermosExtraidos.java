/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlostrks.extracao.processos;

import com.carlostrks.extracao.modelo.ClassesETermos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author jcarlos
 */

//classe que recupera todos os termos presentes do projeto
public class TermosExtraidos {
    
    private File file;
    Iterable<CSVRecord> records;
    

    
    public TermosExtraidos(String nome){
        this.file= new File(String.format("../inputs/%s/%s_Matriz.csv", nome, nome));
        this.records = this.lendoCSV();
        
    }
    
    //lê o arquivo CSV e salva seus dados em um iterável
    private Iterable<CSVRecord> lendoCSV(){
        try{
            Reader in = new FileReader(this.file);
            return CSVFormat.RFC4180.parse(in);
        }catch(FileNotFoundException ex) {
            Logger.getLogger(TermosExtraidos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TermosExtraidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //recupera os dados do arquivo CSV e preenche a lista de termos de entidades
    public List<ClassesETermos> recuperandoTermosDeEntidades(){
        List<ClassesETermos> termosDasEntidades = new ArrayList<>();
        int linhaNomes = 0;
        
        for(CSVRecord record : this.records) {
            if(linhaNomes==0){
                for(int i=1;i<record.size();i++){
                    String nomeEntidade = record.get(i);                    
                        String[] nome = nomeEntidade.split(":");
                        ClassesETermos entidade = new ClassesETermos();                
                        entidade.setNomeEntidade(nome[1]);
                        termosDasEntidades.add(entidade);
                }    
            }else{
                for(int i=1;i<record.size();i++){
                    if(!record.get(i).equals("0")){
                        termosDasEntidades.get(i-1).inserirTermos(record.get(0));
                        //System.out.println(record.get(0)+" ,"+record.get(i));
                    }
                }
            }
            ++linhaNomes;
        }
        
        return termosDasEntidades;
  
    }
    
}
