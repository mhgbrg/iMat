/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import imat.controller.UserManager;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import se.chalmers.ait.dat215.project.Customer;

/**
 *
 * @author mats
 */
public class EditProfilePanel extends javax.swing.JPanel implements PropertyChangeListener {
    
    private final UserManager um = UserManager.getInstance();
    
    /**
     * Creates new form EditProfilePanel
     */
    public EditProfilePanel() {
        initComponents();
        um.addPropertyChangeListener(this);
        prefillForm();
    }
    
    public void prefillForm() {
        Customer customer = um.getCustomer();
        
        prenameTextField.setText(customer.getFirstName());
        lastnameTextField.setText(customer.getLastName());
        persnbrTextField.setText(um.getPersnbr());
        emailTextField.setText(customer.getEmail());
        phoneTextField.setText(customer.getMobilePhoneNumber());
        adressTextField.setText(customer.getAddress());
        postadressTextField.setText(customer.getPostCode());
        cityTextField.setText(customer.getPostAddress());
    }
    
    private void saveUserInfo() {
        String persnbr = persnbrTextField.getText();
        
        String address = adressTextField.getText();
        String email = emailTextField.getText();
        String firstname = prenameTextField.getText();
        String lastname = lastnameTextField.getText();
        String phoneNumber = phoneTextField.getText();
        String city = cityTextField.getText();
        String postCode = postadressTextField.getText();

        String oldPassword = new String(oldpasswrdField.getPassword());
        String newPassword = new String(newpasswrdField.getPassword());
        
        um.updateInfo(persnbr, address, email, firstname, lastname, phoneNumber, city, postCode);
        
        if (!um.getPassword().equals(oldPassword) && !newPassword.equals("")) {
            um.setPassword(newPassword);
        }
    }
    
    private void resetFields() {
        eEmailLabel.setForeground(Color.BLACK);
        epersnbrLabel.setForeground(Color.BLACK);
        epostadressLabel.setForeground(Color.BLACK);
        ephoneLabel.setForeground(Color.BLACK);
        oldpasswrdLabel.setForeground(Color.BLACK);
        newpasswrdLabel.setForeground(Color.BLACK);
    }
    
    private boolean validateFields() {
        resetFields();
        
        boolean error = false;
        
        if (!FieldValidations.isValidEmail(emailTextField.getText())) {
            eEmailLabel.setForeground(Constants.ERROR_COLOR);
            error = true;
        }
        
        if (!persnbrTextField.getText().equals("")) {
            if (!FieldValidations.isValidPersnbr(persnbrTextField.getText())) {
                epersnbrLabel.setForeground(Constants.ERROR_COLOR);
                error = true;
            }
        }
        
        if (!postadressTextField.getText().equals("")) {
            if (!FieldValidations.isValidPostCode(postadressTextField.getText())) {
                epostadressLabel.setForeground(Constants.ERROR_COLOR);
                error = true;
            }
        }
        
        if (!phoneTextField.getText().equals("")) {
            if (!FieldValidations.isValidPhoneNumber(phoneTextField.getText())) {
                ephoneLabel.setForeground(Constants.ERROR_COLOR);
                error = true;
            }
        }
        
        String oldPassword = new String(oldpasswrdField.getPassword());
        String newPassword = new String(newpasswrdField.getPassword());
        
        
        if (!oldPassword.equals("") && !um.getPassword().equals(oldPassword)) {
            oldpasswrdLabel.setForeground(Constants.ERROR_COLOR);
            error = true;
        }
        
        if (!oldPassword.equals("") && um.getPassword().equals(oldPassword) && newPassword.equals("")) {
            newpasswrdLabel.setForeground(Constants.ERROR_COLOR);
            error = true;
        }
        
        if (oldPassword.equals("") && !newPassword.equals("")) {
            oldpasswrdLabel.setForeground(Constants.ERROR_COLOR);
            error = true;
        }
        
        return error;
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("updateInfo")) {
            prefillForm();
        }
    }
    
     private void updatePasswordStenght(){
        String password = new String(newpasswrdField.getPassword());
        if(password.length() == 0){
            strengthProgressBar.setValue(0);
        }
        else if(password.length() < 5){
            strengthProgressBar.setValue(33);
            strengthProgressBar.setForeground(Color.red);
        }else if(password.length() < 10){
            strengthProgressBar.setValue(67);
            strengthProgressBar.setForeground(Color.yellow);
        }else if(password.length() >= 10){
            strengthProgressBar.setValue(100);
            strengthProgressBar.setForeground(Color.green);
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
        prenameLabel = new javax.swing.JLabel();
        phoneTextField = new javax.swing.JTextField();
        lastnameTextField = new javax.swing.JTextField();
        ephoneLabel = new javax.swing.JLabel();
        lastnameLabel = new javax.swing.JLabel();
        oldpasswrdLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        newpasswrdLabel = new javax.swing.JLabel();
        eEmailLabel = new javax.swing.JLabel();
        oldpasswrdField = new javax.swing.JPasswordField();
        adressTextField = new javax.swing.JTextField();
        newpasswrdField = new javax.swing.JPasswordField();
        eadressLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        eheadLabel = new javax.swing.JLabel();
        postadressTextField = new javax.swing.JTextField();
        persnbrTextField = new javax.swing.JTextField();
        epostadressLabel = new javax.swing.JLabel();
        epersnbrLabel = new javax.swing.JLabel();
        cityTextField = new javax.swing.JTextField();
        prenameTextField = new javax.swing.JTextField();
        ecityLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        newpasswrdLabel1 = new javax.swing.JLabel();
        newpasswrdField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        strengthProgressBar = new javax.swing.JProgressBar();
        jSeparator2 = new javax.swing.JSeparator();
        backButton1 = new imat.BackButton();

        setBackground(Constants.MAIN_BACKGROUND);

        jPanel1.setBackground(Constants.MAIN_BACKGROUND);

        prenameLabel.setText("Förnamn");

        ephoneLabel.setText("Mobilnr");

        lastnameLabel.setText("Efternamn");

        oldpasswrdLabel.setText("Gammalt lösenord");

        newpasswrdLabel.setText("Nytt Lösenord");

        eEmailLabel.setText("* E-postadress");

        newpasswrdField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                newpasswrdFieldKeyReleased(evt);
            }
        });

        eadressLabel.setText("Gatuadress");

        saveButton.setText("Spara ändringar");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        eheadLabel.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        eheadLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eheadLabel.setText("Redigera kontaktuppgifter");

        epostadressLabel.setText("Postnummer");

        epersnbrLabel.setText("Personnummer");

        ecityLabel.setBackground(new java.awt.Color(255, 255, 255));
        ecityLabel.setText("Stad");

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("<html>E-postadressen du fyller i kommer fungera som användarnamn vid inloggning</html>");

        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Fält markerade med * måste fyllas i");

        jPanel2.setBackground(Constants.MAIN_BACKGROUND);

        jLabel1.setBackground(Constants.MAIN_BACKGROUND);
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("<html>Du behöver bara fylla i något nedan om du vill byta från ditt gamla lösenord</html>");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        newpasswrdLabel1.setText("Bekräfta lösenord");

        jLabel3.setText("Lösenordets styrka");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oldpasswrdLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(newpasswrdLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(newpasswrdLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oldpasswrdField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(newpasswrdField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(newpasswrdField1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(eheadLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(strengthProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(eEmailLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(epersnbrLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(prenameLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lastnameLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(eadressLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(epostadressLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ephoneLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(emailTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(prenameTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lastnameTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(adressTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(postadressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ecityLabel)
                                            .addGap(18, 18, 18)
                                            .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(persnbrTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(saveButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(eheadLabel)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eEmailLabel))
                .addGap(0, 0, 0)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(persnbrTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(epersnbrLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prenameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prenameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastnameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eadressLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(postadressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(epostadressLabel)
                    .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ecityLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ephoneLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oldpasswrdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oldpasswrdLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newpasswrdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newpasswrdLabel))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(strengthProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newpasswrdField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newpasswrdLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton))
        );

        backButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(backButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(backButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (!validateFields()) {
            saveUserInfo();
            oldpasswrdField.setText("");
            newpasswrdField.setText("");
            firePropertyChange("showProfileCard", null, null);
            System.out.println("test");
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void backButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButton1MouseClicked
        prefillForm();
        firePropertyChange("showProfileCard", null, null);
    }//GEN-LAST:event_backButton1MouseClicked

    private void newpasswrdFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newpasswrdFieldKeyReleased
        updatePasswordStenght();
    }//GEN-LAST:event_newpasswrdFieldKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adressTextField;
    private imat.BackButton backButton1;
    private javax.swing.JTextField cityTextField;
    private javax.swing.JLabel eEmailLabel;
    private javax.swing.JLabel eadressLabel;
    private javax.swing.JLabel ecityLabel;
    private javax.swing.JLabel eheadLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel epersnbrLabel;
    private javax.swing.JLabel ephoneLabel;
    private javax.swing.JLabel epostadressLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lastnameLabel;
    private javax.swing.JTextField lastnameTextField;
    private javax.swing.JPasswordField newpasswrdField;
    private javax.swing.JPasswordField newpasswrdField1;
    private javax.swing.JLabel newpasswrdLabel;
    private javax.swing.JLabel newpasswrdLabel1;
    private javax.swing.JPasswordField oldpasswrdField;
    private javax.swing.JLabel oldpasswrdLabel;
    private javax.swing.JTextField persnbrTextField;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JTextField postadressTextField;
    private javax.swing.JLabel prenameLabel;
    private javax.swing.JTextField prenameTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JProgressBar strengthProgressBar;
    // End of variables declaration//GEN-END:variables
}
