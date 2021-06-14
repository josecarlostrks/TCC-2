/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlostrks.extracao.modelo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;


/**
 *
 * @author jcarlos
 */
public class NomesDosProjetos {
    
    private File arquivo;
    
    public NomesDosProjetos(){
        this.arquivo = new File("../inputs/NomeDosProjetos.txt");
    }

    public List<String> lerNomes() throws IOException{
        return Files.readAllLines(arquivo.toPath());
    }
    
    
}
