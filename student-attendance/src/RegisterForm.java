
import javax.swing.JOptionPane;
import model.Module;
import model.Student;
import student.attendance.JDBConnection.CISConnection;
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
public class RegisterForm extends javax.swing.JFrame {
   private StudentList list;
   private Module module;
   CISConnection cis = new CISConnection("cis4005");

    /**
     * Creates new form RegisterForm
     */
    public RegisterForm(StudentList l, Module m) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.list = l;
        this.module = m;
        labelModuleTitle.setText(module.getModuleTitle());
        labelModuleCode.setText(module.getModuleCode());
        loadStudents();
    }

    private RegisterForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void loadStudents(){
        comboBoxStudent.addItem("Select...");
        for(int i = 0; i < list.Size(); i++){
           String fName = list.get(i).getFirstName();
           String lName = list.get(i).getLastName();
           comboBoxStudent.addItem(fName + " " + lName);
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
        jLabel1 = new javax.swing.JLabel();
        comboBoxStudent = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        onAbsentButton = new javax.swing.JButton();
        onPresentButton = new javax.swing.JButton();
        onBackButton = new javax.swing.JButton();
        labelModuleTitle = new javax.swing.JLabel();
        labelModuleCode = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Student:");

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Register");

        onAbsentButton.setText("Absent");
        onAbsentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onAbsentButtonActionPerformed(evt);
            }
        });

        onPresentButton.setText("Present");
        onPresentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onPresentButtonActionPerformed(evt);
            }
        });

        onBackButton.setBackground(new java.awt.Color(153, 0, 51));
        onBackButton.setText("Back");
        onBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onBackButtonActionPerformed(evt);
            }
        });

        labelModuleTitle.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labelModuleTitle.setForeground(new java.awt.Color(255, 255, 255));
        labelModuleTitle.setText("Module Title");

        labelModuleCode.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labelModuleCode.setForeground(new java.awt.Color(255, 255, 255));
        labelModuleCode.setText("Module code");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(onAbsentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                        .addComponent(onPresentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(onBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(164, 164, 164))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(labelModuleCode)
                        .addGap(18, 18, 18)
                        .addComponent(labelModuleTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelModuleTitle)
                    .addComponent(labelModuleCode))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboBoxStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(onAbsentButton)
                    .addComponent(onPresentButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(onBackButton)
                .addContainerGap())
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

    private void onBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onBackButtonActionPerformed
        // TODO add your handling code here:
        ModuleSetupForm msf = new ModuleSetupForm(module);
        msf.setVisible(true);
        msf.pack();
        msf.setLocationRelativeTo(null);
        this.dispose(); 
    }//GEN-LAST:event_onBackButtonActionPerformed

    private void onPresentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onPresentButtonActionPerformed
        // TODO add your handling code here:
        int s = comboBoxStudent.getSelectedIndex();
        if (s < 1){
            JOptionPane.showMessageDialog(null, "Please select a valid student", "Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        Student student = list.get(s-1);
        System.out.println(student.getFirstName());
        int moduleId = module.getModuleId();
        int studentId = student.getStudentId();
        int moduleSemester = module.getModuleSemester();
        int attended = 1;
        cis.submitRegister(moduleId, studentId, moduleSemester, attended);
        list.remove(student);
        comboBoxStudent.removeItemAt(s);
        System.out.println("Student Present Sent");
    }//GEN-LAST:event_onPresentButtonActionPerformed

    private void onAbsentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onAbsentButtonActionPerformed
        // TODO add your handling code here:
        int s = comboBoxStudent.getSelectedIndex();
        if (s < 1){
            JOptionPane.showMessageDialog(null, "Please select a valid student", "Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        Student student = list.get(s-1);
        System.out.println(student.getFirstName());
        int moduleId = module.getModuleId();
        int studentId = student.getStudentId();
        int moduleSemester = module.getModuleSemester();
        int attended = 0;
        cis.submitRegister(moduleId, studentId, moduleSemester, attended);
        list.remove(student);
        comboBoxStudent.removeItemAt(s);
        System.out.println("Student Absent Sent");
    }//GEN-LAST:event_onAbsentButtonActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBoxStudent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelModuleCode;
    private javax.swing.JLabel labelModuleTitle;
    private javax.swing.JButton onAbsentButton;
    private javax.swing.JButton onBackButton;
    private javax.swing.JButton onPresentButton;
    // End of variables declaration//GEN-END:variables
}
