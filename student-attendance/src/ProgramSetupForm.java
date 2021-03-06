
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Module;
import model.Programme;
import model.Tutor;
import student.attendance.JDBConnection.CISConnection;
import student.attendance.ModuleList;
import student.attendance.TutorList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anthonymcgarry
 */
public class ProgramSetupForm extends javax.swing.JFrame {
    Programme p;
    CISConnection cis = new CISConnection("cis4005");
    ModuleList list = new ModuleList();
    ModuleList tList = new ModuleList();
    TutorList tutorList = new TutorList();
    private static DefaultTableModel model;
    Boolean leader = false;
    /**
     * Creates new form ProgramSetupForm
     * Set the labels based on the programme information
     * @param p getting the programme passed from the setup Page
     */
    public ProgramSetupForm(Programme p) {
        initComponents();
        loadModules();
        loadTutors();
        model = (DefaultTableModel) moduleTable.getModel();
        this.p = p;
        labelProgrammeTitle.setText(p.getProgramTitle());
        labelProgrammeCode.setText(p.getProgramCode());
        labelProgrammeLevel.setText(Integer.toString(p.getProgramLevel()));
        getModulesAssigned();
        getProgrammeLeader();
    }
    /**
     * getProgrammeLeader
     * check if the Programme already has a leader of not
     * if the no tutor leader available then the label is set
     * if the tutor is assigned as the leader then the label is set to the tutor name
     */
    private void getProgrammeLeader() {
       Tutor temp = cis.getProgrammeLeader(p.getProgramId());
       if(temp == null){
           labelTutorName.setText("No Leader Assigned");
       } else {
           String fName = temp.getFirstName();
           String lName = temp.getLastName();
           String tutorNo = temp.getTutorNo();
           leader = true;
           labelTutorName.setText(tutorNo + " " + fName + " " + lName);
        }
    }
    
    /**
     * getModulesAssigned
     * Get all the modules from the DB that are assigned to the programme
     * and populate the information to the JTable
     */
    private void getModulesAssigned(){
        cis.getModluesToProgramme(tList, p.getProgramId());
        tList.getModules();
        for(int i = 0; i < tList.Size(); i++){
           insertTableRow(tList.get(i));
        }
    }

    ProgramSetupForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * loadModules
     * Loads all the modules from the DB and stores them in a list
     * and add them to the comboBox
     */
    private void loadModules(){
        cis.getModuleList(list);
        comboBoxModule.addItem("Select...");
        for(int i = 0; i < list.Size(); i++){
           comboBoxModule.addItem(list.get(i).getModuleTitle());
        }
    }
    
     /**
     * loadTutors
     * Loads all the Tutors from the DB and stores them in a list
     * and add them to the comboBox
     */
    private void loadTutors(){
        cis.getAllTutors(tutorList);
        tutorList.getTutors();
        comboBoxTutors.addItem("Select...");
        for(int i = 0; i < tutorList.Size(); i++){
           comboBoxTutors.addItem(tutorList.get(i).getFirstName() + " " + tutorList.get(i).getLastName());
        }
    }
    /**
     * insertTableRow
     * @param m get the module Object passed and populates 
     * all the data required in the JTable
     */
    private void insertTableRow(Module m){
        Object rowData[] = new Object[5];
        rowData[0] = m.getModuleCode();
        rowData[1] = m.getModuleTitle();
        rowData[2] = m.getModuleCredit();
        rowData[3] = m.getModuleLevel();
        rowData[4] = m.getModuleSemester();
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        moduleTable = new javax.swing.JTable();
        labelProgrammeTitle = new javax.swing.JLabel();
        labelTutorName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboBoxModule = new javax.swing.JComboBox<>();
        comboBoxTutors = new javax.swing.JComboBox<>();
        removeModuleButton = new javax.swing.JButton();
        assignModuleButton = new javax.swing.JButton();
        onAssignProgrammeLeader = new javax.swing.JButton();
        onRemoveProgrammeLeader = new javax.swing.JButton();
        onBackButton = new javax.swing.JButton();
        labelProgrammeCode = new javax.swing.JLabel();
        labelProgrammeTitle2 = new javax.swing.JLabel();
        labelProgrammeLevel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Programme setup -");

        moduleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Module Code", "Title", "Credit", "Level", "Semester"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(moduleTable);

        labelProgrammeTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        labelProgrammeTitle.setForeground(new java.awt.Color(255, 255, 255));
        labelProgrammeTitle.setText("Programme Title");

        labelTutorName.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        labelTutorName.setForeground(new java.awt.Color(255, 255, 255));
        labelTutorName.setText("Tutor Name");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Programme Leader -");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Assign Module:");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Assign Programme Leader:");

        removeModuleButton.setText("Remove Module");
        removeModuleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeModuleButtonActionPerformed(evt);
            }
        });

        assignModuleButton.setText("Assign Module");
        assignModuleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignModuleButtonActionPerformed(evt);
            }
        });

        onAssignProgrammeLeader.setText("Assign Programme Leader");
        onAssignProgrammeLeader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onAssignProgrammeLeaderActionPerformed(evt);
            }
        });

        onRemoveProgrammeLeader.setText("Remove Programme Leader");
        onRemoveProgrammeLeader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onRemoveProgrammeLeaderActionPerformed(evt);
            }
        });

        onBackButton.setBackground(new java.awt.Color(153, 0, 51));
        onBackButton.setText("Back");
        onBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onBackButtonActionPerformed(evt);
            }
        });

        labelProgrammeCode.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        labelProgrammeCode.setForeground(new java.awt.Color(255, 255, 255));
        labelProgrammeCode.setText("Programme Code");

        labelProgrammeTitle2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        labelProgrammeTitle2.setForeground(new java.awt.Color(255, 255, 255));
        labelProgrammeTitle2.setText("Level");

        labelProgrammeLevel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        labelProgrammeLevel.setForeground(new java.awt.Color(255, 255, 255));
        labelProgrammeLevel.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(comboBoxModule, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3))
                                    .addComponent(assignModuleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(removeModuleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(onBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(122, 122, 122)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboBoxTutors, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(onAssignProgrammeLeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(onRemoveProgrammeLeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelTutorName, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelProgrammeTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelProgrammeCode)
                                .addGap(31, 31, 31)
                                .addComponent(labelProgrammeTitle2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelProgrammeLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelProgrammeTitle)
                    .addComponent(labelProgrammeCode)
                    .addComponent(labelProgrammeTitle2)
                    .addComponent(labelProgrammeLevel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(labelTutorName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboBoxTutors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(comboBoxModule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(onAssignProgrammeLeader)
                    .addComponent(assignModuleButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(onRemoveProgrammeLeader)
                    .addComponent(removeModuleButton)
                    .addComponent(onBackButton))
                .addGap(20, 20, 20))
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
    /**
     * assignModuleButtonActionPerformed
     * This method assigns modules to the Programme
     * checks if the programme has too many modules already assigned depending on the level 
     * checks if the module has been selected or not
     * checks if the is duplicates of the module in the module list
     * if all checks pass then the JTable, List and DB is updated with the module assigned
     * @param evt 
     */
    private void assignModuleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignModuleButtonActionPerformed
        // TODO add your handling code here:
        int s = comboBoxModule.getSelectedIndex();
        int level = p.getProgramLevel();

        if(level == 1 && tList.Size() >= 5) {
            JOptionPane.showMessageDialog(null, "Programme at Level 1 can only have 5 modules", "Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(level == 2 && tList.Size() >= 10) {
            JOptionPane.showMessageDialog(null, "Programme at Level 2 can only have 10 modules", "Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(level == 3 && tList.Size() >= 15) {
            JOptionPane.showMessageDialog(null, "Programme at Level 3 can only have 15 modules", "Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (s < 1){
            JOptionPane.showMessageDialog(null, "Please select a valid module", "Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        Module m = list.get(s -1);
        if(tList.Contains(m)){
            JOptionPane.showMessageDialog(null, "Can't have duplicate modules in the Programme", "Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        int moduleID = m.getModuleId();
        int programmeID = p.getProgramId();
        cis.addModuleToProgramme(moduleID, programmeID);
        tList.add(m);
        insertTableRow(m);
    }//GEN-LAST:event_assignModuleButtonActionPerformed
    /**
     * removeModuleButtonActionPerformed
     * This method unassigns modules from the programme
     * Checks if a module has been selected in the JTable
     * if module has been selected and it is valid then the module is unassigned
     * and the DB is updated and the JTable removes the selected module
     * @param evt 
     */
    private void removeModuleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeModuleButtonActionPerformed
        // TODO add your handling code here:
       int selectedRowIndex = moduleTable.getSelectedRow();
       if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(null, "Please select a module", "Warning",JOptionPane.WARNING_MESSAGE);
            return;
       }
        Module m = tList.get(selectedRowIndex);
        System.out.println(m.getModuleTitle());
        int id =  m.getModuleId();
        for(int i = 0; i < tList.Size(); i++){
            if(id == tList.get(i).getModuleId()){
               cis.removeModuleFromProgramme(id, p.getProgramId());
               model.removeRow(selectedRowIndex);
               tList.remove(m);
               System.out.println("REMOVE");
               return;
            }
        }
    }//GEN-LAST:event_removeModuleButtonActionPerformed
    /**
     * onAssignProgrammeLeaderActionPerformed
     * This method assigns tutors to be the programme leader
     * Checks if a tutor has been selected
     * Checks if a tutor has already been assigned as leader
     * if successful then the tutor is assigned and the label is updated along side with the DB
     * @param evt 
     */
    private void onAssignProgrammeLeaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onAssignProgrammeLeaderActionPerformed
        // TODO add your handling code here:
        int s = comboBoxTutors.getSelectedIndex();
        if (s < 1) {
            JOptionPane.showMessageDialog(null, "Please select a valid tutor", "Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }  
        if(leader){
            JOptionPane.showMessageDialog(null, "Programme already has a leader assigned", "Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        int tutorId = tutorList.get(s -1).getTutorId();
        int programmeID = p.getProgramId();
        cis.assignProgrammeLeader(tutorId, programmeID);
        System.out.println("Programme Leader Assigned");
        leader = true;
        String tutorNo = tutorList.get(s -1).getTutorNo();
        String fName = tutorList.get(s -1).getFirstName();
        String lName = tutorList.get(s -1).getLastName();
        labelTutorName.setText(tutorNo + " " + fName + " " + lName );
    }//GEN-LAST:event_onAssignProgrammeLeaderActionPerformed
    /**
     * onRemoveProgrammeLeaderActionPerformed
     * Ask the user if they are sure they want to unassign the leader
     * Checks if a leader has been assigned or not
     * Checks if the DB as a record of the leader
     * After all the checks the tutor is unassigned from the programme
     * label and DB is updated accordingly
     * @param evt 
     */
    private void onRemoveProgrammeLeaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onRemoveProgrammeLeaderActionPerformed
        // TODO add your handling code here:
        if (!leader){
           JOptionPane.showMessageDialog(null, "A leader is already assigned", "Warning",JOptionPane.WARNING_MESSAGE);
           return; 
        }
        int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove programme leader?", "Remove", JOptionPane.YES_NO_OPTION);
        if(option == 1) return;
        Tutor t = cis.getProgrammeLeader(p.getProgramId());
        if (t == null) {
            JOptionPane.showMessageDialog(null, "Unable to find record in the database", "Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        int tutorId = t.getTutorId();
        int programmeId = p.getProgramId();
        cis.removeProgrammeLeader(tutorId, programmeId);
        labelTutorName.setText("No Leader Assigned");
        leader = false;
        System.out.println("REMOVE");

    }//GEN-LAST:event_onRemoveProgrammeLeaderActionPerformed
    /**
     * onBackButtonActionPerformed
     * Navigate the user back to the Setup Form
     * @param evt 
     */
    private void onBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onBackButtonActionPerformed
        // TODO add your handling code here:
        SetupForm sf = new SetupForm();
        sf.setVisible(true);
        sf.pack();
        sf.setLocationRelativeTo(null);
        this.dispose();       
    }//GEN-LAST:event_onBackButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ProgramSetupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProgramSetupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProgramSetupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProgramSetupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProgramSetupForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignModuleButton;
    private javax.swing.JComboBox<String> comboBoxModule;
    private javax.swing.JComboBox<String> comboBoxTutors;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelProgrammeCode;
    private javax.swing.JLabel labelProgrammeLevel;
    private javax.swing.JLabel labelProgrammeTitle;
    private javax.swing.JLabel labelProgrammeTitle2;
    private javax.swing.JLabel labelTutorName;
    private javax.swing.JTable moduleTable;
    private javax.swing.JButton onAssignProgrammeLeader;
    private javax.swing.JButton onBackButton;
    private javax.swing.JButton onRemoveProgrammeLeader;
    private javax.swing.JButton removeModuleButton;
    // End of variables declaration//GEN-END:variables
}
