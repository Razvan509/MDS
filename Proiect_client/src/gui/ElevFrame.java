/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.MaterialController;
import db.Elev;
import db.Material;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import static java.util.Comparator.comparing;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * 
 */
public class ElevFrame extends javax.swing.JFrame {
    
    DefaultListModel modelCont = new DefaultListModel();
    DefaultListModel modelMaterial = new DefaultListModel();
    DefaultListModel modelTest = new DefaultListModel();

    private Elev elev;
    public ElevFrame(Elev elev) {
        initComponents();
        
        this.elev = elev;
        
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        JPanel jp3 = new JPanel();
        
        jp1.setLayout(new BoxLayout(jp1,1));
        
        JList testList = new JList();
        JList materialList = new JList();
        
        
        
        JScrollPane sp1 = new JScrollPane(testList);
        JScrollPane sp2 = new JScrollPane(materialList);
        
        materialList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent m){
                JList l = (JList) m.getSource();
                if(m.getClickCount() == 2 && m.getButton() == MouseEvent.BUTTON1){
                    try {
                        String []sp = ((String)l.getSelectedValue()).split("\\s+");
                        int id = Integer.parseInt(sp[sp.length-1]);
                        Material mat = MaterialController.getInstance().findById(id);
                        new MaterialFrame(mat.getText());
                    } catch (RemoteException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        
        testList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent m){
                JList l = (JList) m.getSource();
                if(m.getClickCount() == 2 && m.getButton() == MouseEvent.BUTTON1){
                    try {
                        String []sp = ((String)l.getSelectedValue()).split("\\s+");
                        int id = Integer.parseInt(sp[sp.length-1]);
                        Material mat = MaterialController.getInstance().findById(id);
                        new TestFrame(mat);
                    } catch (RemoteException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        
        sp1.setPreferredSize(new Dimension(500, 500));
        sp2.setPreferredSize(new Dimension(500, 500));
        
        testList.setVisibleRowCount(19);
        materialList.setVisibleRowCount(19);
        
        jp2.add(sp2);
        jp3.add(sp1);
        
        
        JLabel nume = new JLabel();
        JLabel prenume = new JLabel();
        nume.setText("Nume: " + elev.getNume());
        prenume.setText("Prenume: " + elev.getPrenume());
        
        nume.setFont(new Font("Tahoma", Font.PLAIN, 18));
        prenume.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        jp1.add(nume);
        jp1.add(prenume);
        
        
        testList.setModel(modelTest);
        materialList.setModel(modelMaterial);
        
        materialList.setFont(new Font("Tahoma", Font.PLAIN, 20));
        testList.setFont(new Font("Tahoma", Font.PLAIN, 20));
        
        jTabbedPane1.addTab("Cont", jp1);
        jTabbedPane1.addTab("Materiale", jp2);
        jTabbedPane1.addTab("Teste", jp3);
        
        JButton delogare = new JButton();
        delogare.setText("Delogare");
        delogare.setEnabled(true);
        delogare.setFont(new Font("Tahoma", Font.PLAIN, 20));
        delogare.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                        dispose();
                        new LoginFrame();
                    }  
                });  
        
        jp1.add(delogare);
        populareMateriale();
        populareTest();
        
        setTitle("Invatacel 0.5 beta");
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }
    
    public void populareMateriale(){
        try {
            modelMaterial.clear();
            List<Material> materiale = MaterialController.getInstance().getAllForElev(elev);
            materiale.stream().sorted(comparing(Material::getNume)).forEach(a -> modelMaterial.addElement(a + " "+a.getId()));
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
    
    public void populareTest(){
        try {
            modelTest.clear();
            List<Material> materiale = MaterialController.getInstance().getAllForElev(elev);
            materiale.stream().sorted(comparing(Material::getNume)).forEach(a -> modelTest.addElement(a + " "+a.getId()));
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
