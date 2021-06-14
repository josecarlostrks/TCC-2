/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlostrks.extracao.gui;

import com.carlostrks.extracao.processos.AnaliseDeDados;
import com.carlostrks.extracao.processos.ExportarXML;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import javax.swing.*;
/**
 *
 * @author jcarlos
 */
public class MainFrame extends JFrame{

    private JMenuItem exportarXML;
    private String[] nomesDeProjetos;
    private List<String> nomesArrayprojetos;
      
    
    
    
    public static void main(String[] args) throws IOException {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
            
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame frame = new MainFrame();
            }   
        });    
                

    }


    public MainFrame(){
        super("TermsSearch");
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(criarMenuBar());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
	Rectangle bounds = env.getMaximumWindowBounds();
	this.setSize(bounds.getSize());
        this.setLocationRelativeTo(null);       

        

        initComponents();
        
        setVisible(true);
    }    
    
    private JMenuBar criarMenuBar() {
        JMenuBar menuBar;
        JMenu fileMenu;

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        ExportarAction exportarAction = new ExportarAction();
        exportarXML = new JMenuItem("Exportar como XML");
        exportarXML.addActionListener(exportarAction);
        fileMenu.add(exportarXML);

        return menuBar;
	} 
    
    @SuppressWarnings("unchecked")        
    private void initComponents(){

        jPanelUm = new javax.swing.JPanel();
        jLabelSelecaoProjeto = new javax.swing.JLabel();
        jComboProjetos = new javax.swing.JComboBox<>();
        jLabelSelecaoPadrao = new javax.swing.JLabel();
        jComboSelecaoPadrao = new javax.swing.JComboBox<>();
        jButtonAnalisar = new javax.swing.JButton();
        jLabelValorIndicio = new javax.swing.JLabel();
        jLabelValorEmInstancias = new javax.swing.JLabel();
        jTextFieldValorEmInstancia = new javax.swing.JTextField();
        jTextFieldValorIndicio = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanelDois = new javax.swing.JPanel();
        jLabelListaInstanciaComTermo = new javax.swing.JLabel();
        jLabelListaInstanciaSemTermo = new javax.swing.JLabel();
        jLabelListaComuns = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListComuns = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListInstanciaSemTermo = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListInstanciaComTermo = new javax.swing.JList<>();


        jLabelSelecaoProjeto.setText("Selecione um projeto");
        jComboProjetos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Axion", "Jext",
        "quickserver","sandmark"}));

        jLabelSelecaoPadrao.setText("Selecione um padrão");
        jComboSelecaoPadrao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Singleton", "Factory Method" }));

        
        AnalisarAction analisarAction = new AnalisarAction();
        jButtonAnalisar.setText("Analisar");
        jButtonAnalisar.addActionListener(analisarAction);
        

        jLabelValorIndicio.setText("Valor de Indício de Padrão");

        jLabelValorEmInstancias.setText("Valor em classes de Instância");

        jTextFieldValorEmInstancia.setText("");

        jTextFieldValorIndicio.setText("");

          javax.swing.GroupLayout jPanelUmLayout = new javax.swing.GroupLayout(jPanelUm);
        jPanelUm.setLayout(jPanelUmLayout);
        jPanelUmLayout.setHorizontalGroup(
            jPanelUmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUmLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelSelecaoProjeto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboProjetos, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelSelecaoPadrao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboSelecaoPadrao, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jButtonAnalisar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelUmLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelValorIndicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldValorIndicio, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelValorEmInstancias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldValorEmInstancia, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        ); // saiu de 70
        jPanelUmLayout.setVerticalGroup(
            jPanelUmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUmLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelUmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboSelecaoPadrao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonAnalisar))
                    .addComponent(jLabelSelecaoPadrao)
                    .addComponent(jComboProjetos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSelecaoProjeto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanelUmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelValorIndicio)
                    .addComponent(jLabelValorEmInstancias)
                    .addComponent(jTextFieldValorEmInstancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldValorIndicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)) // mudando aqui, saiu de 24
        );

        jLabelListaInstanciaComTermo.setText("Classes de Instâncias com o termo:");

        jLabelListaInstanciaSemTermo.setText("Classes de Instância sem o termo:");

        jLabelListaComuns.setText("Clases Comuns que possuem o termo:");
        
        listModelComTermo = new DefaultListModel();
        listModelSemTermo = new DefaultListModel();
        listModelComuns = new DefaultListModel();
        
        jListInstanciaComTermo.setModel(listModelComTermo);
        jScrollPane1.setViewportView(jListInstanciaComTermo);

        jListInstanciaSemTermo.setModel(listModelSemTermo);
        jScrollPane2.setViewportView(jListInstanciaSemTermo);

        jListComuns.setModel(listModelComuns);
        jScrollPane3.setViewportView(jListComuns);

        javax.swing.GroupLayout jPanelDoisLayout = new javax.swing.GroupLayout(jPanelDois);
        jPanelDois.setLayout(jPanelDoisLayout);
        jPanelDoisLayout.setHorizontalGroup(
            jPanelDoisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDoisLayout.createSequentialGroup()
                .addGroup(jPanelDoisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelDoisLayout.createSequentialGroup()
                        .addGap(44, 44, 44) 
                        .addComponent(jLabelListaInstanciaComTermo)))
                .addGroup(jPanelDoisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelDoisLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDoisLayout.createSequentialGroup()
                        .addGap(47, 47, 47) //aqui estou mudando saiu de 47
                        .addComponent(jLabelListaInstanciaSemTermo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelListaComuns)
                        .addGap(61, 61, 61)))) //aqui estou mudando saiu de 61
        );
        jPanelDoisLayout.setVerticalGroup(
            jPanelDoisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDoisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDoisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelListaInstanciaComTermo)
                    .addComponent(jLabelListaInstanciaSemTermo)
                    .addComponent(jLabelListaComuns))
                .addGap(18, 18, 18)
                .addGroup(jPanelDoisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelDois, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelUm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelUm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelDois, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }      
    
    
    private JButton jButtonAnalisar;
    private JComboBox<String> jComboProjetos;
    private JComboBox<String> jComboSelecaoPadrao;
    private JLabel jLabelListaComuns;
    private JLabel jLabelListaInstanciaComTermo;
    private JLabel jLabelListaInstanciaSemTermo;
    private JLabel jLabelSelecaoPadrao;
    private JLabel jLabelSelecaoProjeto;
    private JLabel jLabelValorEmInstancias;
    private JLabel jLabelValorIndicio;
    private JList<String> jListComuns;
    private JList<String> jListInstanciaComTermo;
    private JList<String> jListInstanciaSemTermo;
    private JPanel jPanelDois;
    private JPanel jPanelUm;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JSeparator jSeparator1;
    private JTextField jTextFieldValorEmInstancia;
    private JTextField jTextFieldValorIndicio;
    private DefaultListModel listModelComTermo;
    private DefaultListModel listModelSemTermo;
    private DefaultListModel listModelComuns;    
    private AnaliseDeDados analiseDeDados;
    
    private class AnalisarAction implements ActionListener{  

        @Override
        public void actionPerformed(ActionEvent e) {
            analiseDeDados = new AnaliseDeDados();
            analiseDeDados.analisar(jComboProjetos.getSelectedItem().toString(), jComboSelecaoPadrao.getSelectedItem().toString());
            
           if(listModelComTermo.getSize()!=0){
                for(int i= listModelComTermo.getSize()-1;i>=0;--i){
                    listModelComTermo.remove(i);
                }
            }            
           if(listModelSemTermo.getSize()!=0){
                for(int i= listModelSemTermo.getSize()-1;i>=0;--i){
                    listModelSemTermo.remove(i);
                }
            }            
           if(listModelComuns.getSize()!=0){
                for(int i= listModelComuns.getSize()-1;i>=0;--i){
                    listModelComuns.remove(i);
                }
            }            
            for (int i = 0; i < analiseDeDados.getPesquisa().getClassesComTermo().size(); i++) {
                listModelComTermo.add(i, analiseDeDados.getPesquisa().getClassesComTermo().get(i));
            }             
            for (int i = 0; i < analiseDeDados.getPesquisa().getClassesSemTermo().size(); i++) {
                listModelSemTermo.add(i, analiseDeDados.getPesquisa().getClassesSemTermo().get(i));
            }             
            for (int i = 0; i < analiseDeDados.getPesquisa().getClassesComuns().size(); i++) {
                listModelComuns.add(i, analiseDeDados.getPesquisa().getClassesComuns().get(i));
            }
            
            
            String emInstancias = String.format("%f", analiseDeDados.getValorEmInstancias());            
            jTextFieldValorEmInstancia.setText(emInstancias);            
            String valorIndicio = String.format("%f",analiseDeDados.getValorGeral());            
            jTextFieldValorIndicio.setText(valorIndicio);
        }
        
    }
    private class ExportarAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
           if((listModelComTermo.getSize()!=0)||(listModelSemTermo.getSize()!=0)||(listModelComuns.getSize()!=0)){
               ExportarXML exportar = new ExportarXML();
               exportar.gerarArquivo(analiseDeDados,analiseDeDados.getNomeProjetoFiltrado() ,analiseDeDados.getNomePadrao());
            } 
        }        
    }


}
