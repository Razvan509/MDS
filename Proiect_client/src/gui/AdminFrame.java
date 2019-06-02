/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.ClasaController;
import controller.ElevController;
import controller.MaterialController;
import controller.ProfesorController;
import db.Clasa;
import db.Elev;
import db.Material;
import db.Profesor;
import db.User;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * 
 */
public class AdminFrame extends javax.swing.JFrame {
    
    DefaultListModel modelElev = new DefaultListModel();
    DefaultListModel modelProf = new DefaultListModel();
    DefaultListModel modelClasa = new DefaultListModel();
    DefaultListModel modelMaterial = new DefaultListModel();

    /**
     * Creates new form AdminFrame
     */
    public AdminFrame(User user) {
        initComponents();
        
        
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        JPanel jp3 = new JPanel();
        JPanel jp4 = new JPanel();
        
        JList elevList = new JList();
        JList profList = new JList();
        JList clasaList = new JList();
        JList materialList = new JList();
        
        JScrollPane sp1 = new JScrollPane(elevList);
        JScrollPane sp2 = new JScrollPane(profList);
        JScrollPane sp3 = new JScrollPane(clasaList);
        JScrollPane sp4 = new JScrollPane(materialList);
        
        sp1.setPreferredSize(new Dimension(500, 500));
        sp2.setPreferredSize(new Dimension(500, 500));
        sp3.setPreferredSize(new Dimension(500, 500));
        sp4.setPreferredSize(new Dimension(500, 500));
        
        elevList.setVisibleRowCount(19);
        profList.setVisibleRowCount(19);
        clasaList.setVisibleRowCount(19);
        materialList.setVisibleRowCount(19);
        
        jp1.add(sp1);
        jp2.add(sp2);
        jp3.add(sp3);
        jp4.add(sp4);
        
        JButton adaugaMaterial = new JButton();
        adaugaMaterial.setText("Adauga Material");
        adaugaMaterial.setEnabled(true);
        adaugaMaterial.setFont(new Font("Tahoma", Font.PLAIN, 20));
        adaugaMaterial.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                        new AdaugaMaterialFrame().setVisible(true);
                    }  
                });  
        
        JButton refresh = new JButton();
        refresh.setText("Refresh");
        refresh.setEnabled(true);
        refresh.setFont(new Font("Tahoma", Font.PLAIN, 20));
        refresh.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                        populareMateriale();
                    }  
                });  
        jp4.add(adaugaMaterial);
        jp4.add(refresh);
        
        elevList.setModel(modelElev);
        profList.setModel(modelProf);
        clasaList.setModel(modelClasa);
        materialList.setModel(modelMaterial);
        
        elevList.setFont(new Font("Tahoma", Font.PLAIN, 20));
        clasaList.setFont(new Font("Tahoma", Font.PLAIN, 20));
        materialList.setFont(new Font("Tahoma", Font.PLAIN, 20));
        profList.setFont(new Font("Tahoma", Font.PLAIN, 20));
        
        jTabbedPane1.addTab("Elevi", jp1);
        jTabbedPane1.addTab("Profesori", jp2);
        jTabbedPane1.addTab("Clase", jp3);
        jTabbedPane1.addTab("Materiale", jp4);
        
        populareElevi();
        populareProfi();
        populareClase();
        populareMateriale();
        
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }
    
    public void populareElevi(){
        try {
            modelElev.clear();
            List<Elev> elevi = ElevController.getInstance().getAll();
            for(Elev e:elevi){
                modelElev.addElement(e);
            }
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
    
    public void populareProfi(){
        try {
            modelProf.clear();
            List<Profesor> profi = ProfesorController.getInstance().getAll();
            for(Profesor p:profi){
                modelProf.addElement(p);
            }
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
    
    public void populareClase(){
        try {
            modelClasa.clear();
            List<Clasa> clase = ClasaController.getInstance().getAll();
            for(Clasa c:clase){
                modelClasa.addElement(c);
            }
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
    
    public void populareMateriale(){
        try {
            modelMaterial.clear();
            List<Material> materiale = MaterialController.getInstance().getAll();
            for(Material m:materiale){
                modelMaterial.addElement(m + " " + m.getId());
            }
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu3.setText("Profesor");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Adauga profesor");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1005, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new AdaugaProfesorFrame().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
