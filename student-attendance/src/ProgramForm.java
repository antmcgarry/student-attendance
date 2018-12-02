
import javax.swing.table.DefaultTableModel;
import model.Programme;
import student.attendance.JDBConnection.CISConnection;
import student.attendance.ProgrammeList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anthonymcgarry
 */
public class ProgramForm extends javax.swing.JFrame {
    private static DefaultTableModel model;
    private ProgrammeList list = new ProgrammeList();
    private int level = 1;
    /**
     * Creates new form ProgramForm
     */
    public ProgramForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        getProgrammeList();
    }
    
    public void getProgrammeList(){
        CISConnection cis = new CISConnection("cis4005");
        cis.getProgrammeList(list);
        list.getProgrammes();
        model = (DefaultTableModel) programmeTable.getModel();
        System.out.println(list);
        for(int i = 0; i < list.Size(); i++){
           insertTableRow(list.get(i));
        }
    }
    
    private void insertTableRow(Programme p){
      Object rowData[] = new Object[3];
      rowData[0] = p.getProgramCode();
      rowData[1] = p.getProgramTitle();
      rowData[2] = p.getProgramLevel();
      model.addRow(rowData);  
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        programmeTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textFieldProgrammeTitle = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        textFieldProgrammeCode = new javax.swing.JFormattedTextField();
        addProgramme = new javax.swing.JButton();
        removeProgramme = new javax.swing.JButton();
        modulesButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        comboBoxLevel = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        programmeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Programme Code", "Programme TIlte", "Level"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(programmeTable);
        if (programmeTable.getColumnModel().getColumnCount() > 0) {
            programmeTable.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Programme Portal");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Programme Title:");

        textFieldProgrammeTitle.setBackground(new java.awt.Color(255, 255, 255));
        textFieldProgrammeTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldProgrammeTitleActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Programme Code:");

        textFieldProgrammeCode.setBackground(new java.awt.Color(255, 255, 255));
        textFieldProgrammeCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldProgrammeCodeActionPerformed(evt);
            }
        });

        addProgramme.setText("Add Programme");
        addProgramme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProgrammeActionPerformed(evt);
            }
        });

        removeProgramme.setText("Remove Programme");
        removeProgramme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeProgrammeActionPerformed(evt);
            }
        });

        modulesButton.setBackground(new java.awt.Color(153, 0, 153));
        modulesButton.setText("Modules");

        backButton.setBackground(new java.awt.Color(153, 0, 51));
        backButton.setText("Back");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Programme Level:");

        comboBoxLevel.setBackground(new java.awt.Color(255, 255, 255));
        comboBoxLevel.setForeground(new java.awt.Color(0, 0, 0));
        comboBoxLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Level 1", "Level 2", "Level 3" }));
        comboBoxLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxLevelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldProgrammeTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldProgrammeCode, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(removeProgramme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addProgramme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modulesButton, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldProgrammeTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(addProgramme)
                    .addComponent(modulesButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textFieldProgrammeCode, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboBoxLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeProgramme)
                    .addComponent(backButton))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldProgrammeTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldProgrammeTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldProgrammeTitleActionPerformed

    private void textFieldProgrammeCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldProgrammeCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldProgrammeCodeActionPerformed

    private void addProgrammeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProgrammeActionPerformed
        // TODO add your handling code here:
        String code = textFieldProgrammeCode.getText();
        String title = textFieldProgrammeTitle.getText();
 
        if(code == null || code.equals("") || title == null || title.equals("") ){
            return;
        }

        int newId = list.get(list.Size() -1).getProgramId();
        if (newId >= 1) {
          newId++;
        } else {
           newId = 1;
        }
        int id = newId;
        Programme p = new Programme(id,code,title,level);
        CISConnection cis = new CISConnection("cis4005");
        cis.insertProgramme(p);
        list.add(p);
        insertTableRow(p);
        textFieldProgrammeCode.setText("");
        textFieldProgrammeTitle.setText("");
        comboBoxLevel.setSelectedIndex(0);
        level = 1;
    }//GEN-LAST:event_addProgrammeActionPerformed

    private void comboBoxLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxLevelActionPerformed
        // TODO add your handling code here:
        if(comboBoxLevel.getSelectedItem().equals("Level 1")){
            this.level = 1;
        }
        else if(comboBoxLevel.getSelectedItem().equals("Level 2")){
            this.level = 2;
        }
        else if(comboBoxLevel.getSelectedItem().equals("Level 3")){
            this.level = 3;
        }
    }//GEN-LAST:event_comboBoxLevelActionPerformed

    private void removeProgrammeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeProgrammeActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = programmeTable.getSelectedRow();
        Object programmeCode = programmeTable.getValueAt(selectedRowIndex, 0);
        String code = programmeCode.toString();
        CISConnection cis = new CISConnection("cis4005");
        for(int i = 0; i < list.Size(); i++){
            Programme p = list.get(i);
            if(code == p.getProgramCode()){
               list.remove(p);
            }
        }
        cis.removeProgramme(code);
        model.removeRow(selectedRowIndex);
        System.out.println("REMOVE");
    }//GEN-LAST:event_removeProgrammeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProgramForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProgramForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProgramForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProgramForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProgramForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProgramme;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> comboBoxLevel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modulesButton;
    private javax.swing.JTable programmeTable;
    private javax.swing.JButton removeProgramme;
    private javax.swing.JFormattedTextField textFieldProgrammeCode;
    private javax.swing.JFormattedTextField textFieldProgrammeTitle;
    // End of variables declaration//GEN-END:variables
}
