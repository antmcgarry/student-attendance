
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Module;
import model.Student;
import model.Tutor;
import student.attendance.JDBConnection.CISConnection;
import student.attendance.StudentList;
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
public class ModuleSetupForm extends javax.swing.JFrame {
    Module m;
    CISConnection cis = new CISConnection("cis4005");
    StudentList list = new StudentList();
    StudentList tList = new StudentList();
    TutorList tutorList = new TutorList();
    private static DefaultTableModel model;
    Boolean leader = false;
    /**
     * Creates new form ProgramSetupForm
     * @param module getting the module passed from the setup Page
     */
    public ModuleSetupForm(Module module) {
        initComponents();
        loadStudents();
        loadTutors();
        model = (DefaultTableModel) studentTable.getModel();
        this.m = module;
        labelModuleTitle.setText(m.getModuleTitle());
        labelModuleCode.setText(m.getModuleCode());
        labelModuleLevel.setText(Integer.toString(m.getModuleLevel()));
        getStudentAssigned();
        getModuleLeader();
    }
    /**
     * getModuleLeader
     * This method checks if the module which was selected has a module leader
     * if the is a leader in the DB records then the label will show the Tutors name
     */
    private void getModuleLeader() {
       Tutor temp = cis.getModuleLeader(m.getModuleId());
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
     * getStudentAssigned
     * Fetches all the current students that are assigned to module
     */
    private void getStudentAssigned(){
        cis.getStudenttoModule(tList, m.getModuleId());
        tList.getStudents();
        for(int i = 0; i < tList.Size(); i++){
           insertTableRow(tList.get(i));
        }
    }

    ModuleSetupForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * loadStudents
     * loads all the students in the DB and stores them in a list and
     * populates their names in a comboBox so the user can select each student
     */
    private void loadStudents(){
        cis.getAllStudents(list);
        comboBoxStudent.addItem("Select...");
        for(int i = 0; i < list.Size(); i++){
           String fName = list.get(i).getFirstName();
           String lName = list.get(i).getLastName();
           comboBoxStudent.addItem(fName + " " + lName);
        }
    }
    
    /**
     * loadTutors
     * loads all the tutors in the DB and stores them in a list and
     * populates their names in a comboBox so the user can select each tutor
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
     * Loads all the students that are currently assigned to the module and displays
     * the information in a JTable
     * @param student get the student model passed from getStudentsAssigned
     */
    public static void insertTableRow(Student student){
      Object rowData[] = new Object[9];
      rowData[0] = student.getFirstName();
      rowData[1] = student.getLastName();
      rowData[2] = student.getAge();
      rowData[3] = student.getDateofBirth();
      rowData[4] = student.getAddress();
      rowData[5] = student.getEmail();
      rowData[6] = student.getRegisteredType();
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
        labelModuleTitle = new javax.swing.JLabel();
        labelTutorName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboBoxStudent = new javax.swing.JComboBox<>();
        comboBoxTutors = new javax.swing.JComboBox<>();
        removeStudentButton = new javax.swing.JButton();
        assignStudentButton = new javax.swing.JButton();
        onAssignModuleLeader = new javax.swing.JButton();
        onRemoveModuleLeader = new javax.swing.JButton();
        onBackButton = new javax.swing.JButton();
        labelModuleCode = new javax.swing.JLabel();
        labelProgrammeTitle2 = new javax.swing.JLabel();
        labelModuleLevel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        onTakeRegister = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Module setup -");

        labelModuleTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        labelModuleTitle.setForeground(new java.awt.Color(255, 255, 255));
        labelModuleTitle.setText("Module Title");

        labelTutorName.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        labelTutorName.setForeground(new java.awt.Color(255, 255, 255));
        labelTutorName.setText("Tutor Name");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Module Leader -");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Assign Student:");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Assign Module Leader:");

        removeStudentButton.setText("Remove Student");
        removeStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeStudentButtonActionPerformed(evt);
            }
        });

        assignStudentButton.setText("Assign Student");
        assignStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignStudentButtonActionPerformed(evt);
            }
        });

        onAssignModuleLeader.setText("Assign Module Leader");
        onAssignModuleLeader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onAssignModuleLeaderActionPerformed(evt);
            }
        });

        onRemoveModuleLeader.setText("Remove Module Leader");
        onRemoveModuleLeader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onRemoveModuleLeaderActionPerformed(evt);
            }
        });

        onBackButton.setBackground(new java.awt.Color(153, 0, 51));
        onBackButton.setText("Back");
        onBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onBackButtonActionPerformed(evt);
            }
        });

        labelModuleCode.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        labelModuleCode.setForeground(new java.awt.Color(255, 255, 255));
        labelModuleCode.setText("Module Code");

        labelProgrammeTitle2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        labelProgrammeTitle2.setForeground(new java.awt.Color(255, 255, 255));
        labelProgrammeTitle2.setText("Level");

        labelModuleLevel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        labelModuleLevel.setForeground(new java.awt.Color(255, 255, 255));
        labelModuleLevel.setText("0");

        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Last Name", "Age", "Date of Birth", "Address", "Email", "Register"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(studentTable);

        onTakeRegister.setText("Take Register");
        onTakeRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onTakeRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(comboBoxStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 417, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(assignStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(removeStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(onTakeRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(330, 330, 330)))
                                .addComponent(onBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboBoxTutors, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(onAssignModuleLeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(onRemoveModuleLeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelTutorName, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelModuleTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelModuleCode)
                                .addGap(31, 31, 31)
                                .addComponent(labelProgrammeTitle2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelModuleLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelModuleTitle)
                    .addComponent(labelModuleCode)
                    .addComponent(labelProgrammeTitle2)
                    .addComponent(labelModuleLevel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(labelTutorName))
                .addGap(301, 301, 301)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboBoxTutors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(comboBoxStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(onAssignModuleLeader)
                    .addComponent(assignStudentButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(onRemoveModuleLeader)
                    .addComponent(removeStudentButton)
                    .addComponent(onBackButton)
                    .addComponent(onTakeRegister))
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(77, 77, 77)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(135, Short.MAX_VALUE)))
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
     * assignStudentButtonActionPerformed
     * if a student is selected in the comboBox and the user press the assign student button
     * then the student is enrolled to module unless the student is already 
     * assigned a warning message will appear
     * The information will also be stored in the DB
     * @param evt 
     */
    private void assignStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignStudentButtonActionPerformed
        // TODO add your handling code here:
        int s = comboBoxStudent.getSelectedIndex();
        if (s < 1){
            JOptionPane.showMessageDialog(null, "Please select a valid student", "Warning",JOptionPane.WARNING_MESSAGE);
            return;
        } ;
        Student student = list.get(s -1);
        student.setStudentId(list.get(s -1).getStudentId());
        if(tList.Contains(student)) {
            JOptionPane.showMessageDialog(null, "Can't have duplicate students in the module", "Warning",JOptionPane.WARNING_MESSAGE);
            return;
        };
        int studentId = student.getStudentId();
        int moduleId = m.getModuleId();
        cis.addStudenttoModule(studentId, moduleId);
        tList.add(student);
        insertTableRow(student);
    }//GEN-LAST:event_assignStudentButtonActionPerformed
    
    /**
     * removeStudentButtonActionPerformed
     * This method requires the user to select a student from the JTable
     * and press the remove student which will unassign the selected student 
     * from the module and update the table and DB.
     * @param evt 
     */
    private void removeStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeStudentButtonActionPerformed
        int selectedRowIndex = studentTable.getSelectedRow();
        if(selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(null, "Please select a student to remove", "Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        Student s = tList.get(selectedRowIndex);
        int id =  s.getStudentId();
        for(int i = 0; i < tList.Size(); i++){
            if(id == tList.get(i).getStudentId()){
               cis.removeStudentFromModule(id, m.getModuleId());
               model.removeRow(selectedRowIndex);
               tList.remove(s);
               System.out.println("REMOVE");
               return;
            }
        }
    }//GEN-LAST:event_removeStudentButtonActionPerformed
    /**
     * onAssignModuleLeaderActionPerformed
     * This method requires the user to select a tutor to assign as module leader
     * If the module already has a leader then the user will be given a warning massage
     * when tutor is assigned as the module leader the label will be update along side with the DB
     * @param evt 
     */
    private void onAssignModuleLeaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onAssignModuleLeaderActionPerformed
        // TODO add your handling code here:
        int s = comboBoxTutors.getSelectedIndex();
        if (s < 1) {
            JOptionPane.showMessageDialog(null, "Please select a valid tutor", "Warning",JOptionPane.WARNING_MESSAGE);
            return;
        } ;
        if(leader) {
            JOptionPane.showMessageDialog(null, "Programme leader already assigned", "Warning",JOptionPane.WARNING_MESSAGE);
            return;
        };
        int tutorId = tutorList.get(s).getTutorId();
        int moduleId = m.getModuleId();
        cis.assignModuleLeader(tutorId, moduleId);
        System.out.println("Programme Leader Assigned");
        leader = true;
        String tutorNo = tutorList.get(s).getTutorNo();
        String fName = tutorList.get(s).getFirstName();
        String lName = tutorList.get(s).getLastName();
        labelTutorName.setText(tutorNo + " " + fName + " " + lName );
    }//GEN-LAST:event_onAssignModuleLeaderActionPerformed
    /**
     * onRemoveModuleLeaderActionPerformed
     * This method requires for a leader to already be assigned to the module
     * as an extra check a DB call is made to check if the module has a leader or not
     * if the module leader is found then the tutor is unassigned as the module leader and the DB is updated
     * @param evt 
     */
    private void onRemoveModuleLeaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onRemoveModuleLeaderActionPerformed
        // TODO add your handling code here:
        if (!leader) {
            JOptionPane.showMessageDialog(null, "No Module leader assigned", "Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        Tutor t = cis.getProgrammeLeader(m.getModuleId());
        if (t == null) {
            JOptionPane.showMessageDialog(null, "Uable to find Module Leader in database please try again", "Warning",JOptionPane.WARNING_MESSAGE);
            return;
        };
        int tutorId = t.getTutorId();
        int moduleId = m.getModuleId();
        cis.removeModuleLeader(tutorId, moduleId);
        labelTutorName.setText("No Leader Assigned");
        leader = false;
        System.out.println("REMOVE");

    }//GEN-LAST:event_onRemoveModuleLeaderActionPerformed
    /**
     * onBackButtonActionPerformed
     * Returns the user back to the Setup Form and closes this form
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
     * onTakeRegisterActionPerformed
     * navigates the user to the register form for the given module to take the register
     * a check is made first to make sure that the module has students assigned and a module leader is able to take register
     * @param evt 
     */
    private void onTakeRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onTakeRegisterActionPerformed
        // TODO add your handling code here:
        if (tList.Size() <= 0) {
            JOptionPane.showMessageDialog(null, "Module has no students assigned for the register", "Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!leader) {
            JOptionPane.showMessageDialog(null, "No Module leader assigned to take register", "Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        RegisterForm rf = new RegisterForm(tList, m);
        rf.setVisible(true);
        rf.pack();
        rf.setLocationRelativeTo(null);
        this.dispose();  
    }//GEN-LAST:event_onTakeRegisterActionPerformed

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
    private javax.swing.JButton assignStudentButton;
    private javax.swing.JComboBox<String> comboBoxStudent;
    private javax.swing.JComboBox<String> comboBoxTutors;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelModuleCode;
    private javax.swing.JLabel labelModuleLevel;
    private javax.swing.JLabel labelModuleTitle;
    private javax.swing.JLabel labelProgrammeTitle2;
    private javax.swing.JLabel labelTutorName;
    private javax.swing.JButton onAssignModuleLeader;
    private javax.swing.JButton onBackButton;
    private javax.swing.JButton onRemoveModuleLeader;
    private javax.swing.JButton onTakeRegister;
    private javax.swing.JButton removeStudentButton;
    private javax.swing.JTable studentTable;
    // End of variables declaration//GEN-END:variables
}
