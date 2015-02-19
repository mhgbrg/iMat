/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import java.awt.Color;

/**
 *
 * @author mats
 */
public class MainCategoryItem extends javax.swing.JPanel {
    private static Color DEFAULT_COLOR = Color.white;
    private static Color HOVER_COLOR = new Color(246, 246, 246);
    private static Color PRESSED_COLOR = new Color(237, 237, 237);
    
    private boolean mouseOver = false;
    private boolean mousePressed = false;

    /**
     * Creates new form MainCategoryItem
     */
    public MainCategoryItem() {
        initComponents();
    }
    
    public void setText(String label) {
        categoryName.setText(label);
    }
    
    public void highlight() {
        // TODO highlight panel
    }
    
    public void reset() {
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        categoryName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMaximumSize(new java.awt.Dimension(100, 60));
        setPreferredSize(new java.awt.Dimension(100, 60));
        setSize(new java.awt.Dimension(100, 60));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        categoryName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        categoryName.setText("Label");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(categoryName, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(categoryName, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        this.setBackground(HOVER_COLOR);
        mouseOver = true;
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        if (!mousePressed) {
            this.setBackground(DEFAULT_COLOR);
        }
        mouseOver = false;
    }//GEN-LAST:event_formMouseExited

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        this.setBackground(PRESSED_COLOR);
        mousePressed = true;
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        if (mouseOver) {
            this.setBackground(HOVER_COLOR);
        } else {
            this.setBackground(DEFAULT_COLOR);
        }
        mousePressed = false;
    }//GEN-LAST:event_formMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel categoryName;
    // End of variables declaration//GEN-END:variables
}
