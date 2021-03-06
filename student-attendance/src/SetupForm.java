
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Module;
import model.Programme;
import model.Student;
import student.attendance.JDBConnection.CISConnection;
import student.attendance.ModuleList;
import student.attendance.ProgrammeList;
import student.attendance.StudentList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anthonymcgarry
 */
public class SetupForm extends javax.swing.JFrame {
    CISConnection cis = new CISConnection("cis4005");
    ProgrammeList pList = new ProgrammeList();
    ModuleList mList = new ModuleList();
    StudentList sList = new StudentList();
    /**
     * Creates new form SetupForm
     */
    public SetupForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        loadProgrammes();
        loadModules();
        loadStudents();
    }
     /**
      * loadProgrammes
      * gets all the programmes from the DB and stores them in a list
      * which populates respected comboBox with the title for the user to select
      */
    private void loadProgrammes() {
        cis.getProgrammeList(pList);
        pList.getProgrammes();
        comboBoxProgramme.addItem("Select...");
        for(int i = 0; i < pList.Size(); i++){
           comboBoxProgramme.addItem(pList.get(i).getProgramTitle());
        }
    }
    /**
      * loadModules
      * gets all the modules from the DB and stores them in a list
      * which populates respected comboBox with the title for the user to select
      */
    private void loadModules(){
        cis.getModuleList(mList);
        mList.getModules();
        comboBoxModule.addItem("Select...");
        for(int i = 0; i < mList.Size(); i++){
           comboBoxModule.addItem(mList.get(i).getModuleTitle());
        }
    }
     /**
      * loadStudents
      * gets all the students from the DB and stores them in a list
      * which populates respected comboBox with the name for the user to select
      */
    private void loadStudents(){
        cis.getAllStudents(sList);
        sList.getStudents();
        comboBoxStudent.addItem("Select...");
        for(int i = 0; i < sList.Size(); i++){
           comboBoxStudent.addItem((sList.get(i).getFirstName() + " " + 
                                    sList.get(i).getLastName()));
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboBoxProgramme = new javax.swing.JComboBox<>();
        comboBoxModule = new javax.swing.JComboBox<>();
        comboBoxStudent = new javax.swing.JComboBox<>();
        setupProgrammeButton = new javax.swing.JButton();
        setupModuleButton = new javax.swing.JButton();
        viewStudentButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        onLogoutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Select Programme");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Select Module");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Select Student");

        comboBoxProgramme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxProgrammeActionPerformed(evt);
            }
        });

        setupProgrammeButton.setText("Setup Programme");
        setupProgrammeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setupProgrammeButtonActionPerformed(evt);
            }
        });

        setupModuleButton.setText("Setup Module");
        setupModuleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setupModuleButtonActionPerformed(evt);
            }
        });

        viewStudentButton.setText("View Student");
        viewStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewStudentButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tutor Zone");

        onLogoutButton.setBackground(new java.awt.Color(153, 0, 0));
        onLogoutButton.setText("Logout");
        onLogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onLogoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(setupProgrammeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(comboBoxProgramme, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(36, 36, 36))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxModule, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(setupModuleButton, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(onLogoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(viewStudentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addGap(74, 74, 74)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxProgramme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxModule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(setupProgrammeButton)
                    .addComponent(setupModuleButton)
                    .addComponent(viewStudentButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(onLogoutButton)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void comboBoxProgrammeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxProgrammeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxProgrammeActionPerformed
    
    /**
     * setupProgrammeButtonActionPerformed
     * Checks if a valid option has been selected
     * If a valid option has been selected then the Programme Setup Form is loaded by passing the 
     * selected option to the required parameter
     * this form is closed
     * @param evt 
     */
    private void setupProgrammeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setupProgrammeButtonActionPerformed
        // TODO add your handling code here:
        int s = comboBoxProgramme.getSelectedIndex();
        if (s < 1) {
            JOptionPane.showMessageDialog(null, "Please select a valid programme", "Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        Programme p = pList.get(s -1);
        ProgramSetupForm psf = new ProgramSetupForm(p);
            psf.setVisible(true);
            psf.pack();
            psf.setLocationRelativeTo(null);
            psf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
    }//GEN-LAST:event_setupProgrammeButtonActionPerformed
     /**
     * setupModuleButtonActionPerformed
     * Checks if a valid option has been selected
     * If a valid option has been selected then the Module Setup Form is loaded by passing the 
     * selected option to the required parameter
     * this form is closed
     * @param evt 
     */
    private void setupModuleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setupModuleButtonActionPerformed
        // TODO add your handling code here:
        int s = comboBoxModule.getSelectedIndex();
        if (s < 1){
            JOptionPane.showMessageDialog(null, "Please select a valid module", "Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        Module m = mList.get(s -1);
        ModuleSetupForm msf = new ModuleSetupForm(m);
            msf.setVisible(true);
            msf.pack();
            msf.setLocationRelativeTo(null);
            msf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
    }//GEN-LAST:event_setupModuleButtonActionPerformed
     /**
     * onLogoutButtonActionPerformed
     * Checks if the user want to logout or not
     * if true the user is navigated back to the Login Form
     * if false the message is closed
     * @param evt 
     */
    private void onLogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onLogoutButtonActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(null, "Do you really want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
        if(option == 1) return;
        LoginForm lf = new LoginForm();
        lf.setVisible(true);
        lf.pack();
        lf.setLocationRelativeTo(null);
        this.dispose();  
    }//GEN-LAST:event_onLogoutButtonActionPerformed
    /**
     * viewStudentButtonActionPerformed
     * Checks if a valid option has been selected
     * If a valid option has been selected then the Student Info Form is loaded by passing the 
     * selected option to the required parameter
     * this form is closed
     * @param evt 
     */
    private void viewStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewStudentButtonActionPerformed
        // TODO add your handling code here:
        int s = comboBoxStudent.getSelectedIndex();
        if (s < 1){
            JOptionPane.showMessageDialog(null, "Please select a valid student", "Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        Student student = sList.get(s -1);
        StudentInfoForm form = new StudentInfoForm(student);
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_viewStudentButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SetupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SetupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SetupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SetupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SetupForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBoxModule;
    private javax.swing.JComboBox<String> comboBoxProgramme;
    private javax.swing.JComboBox<String> comboBoxStudent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton onLogoutButton;
    private javax.swing.JButton setupModuleButton;
    private javax.swing.JButton setupProgrammeButton;
    private javax.swing.JButton viewStudentButton;
    // End of variables declaration//GEN-END:variables
}
