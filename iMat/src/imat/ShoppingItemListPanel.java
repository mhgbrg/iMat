/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import se.chalmers.ait.dat215.project.CartEvent;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingCartListener;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author win8
 */
public class ShoppingItemListPanel extends javax.swing.JPanel{

    /**
     * Creates new form CartListPanel
     */
    public ShoppingItemListPanel() {
        Product p1 = new Product();
        p1.setName("NAME");
        p1.setPrice(100);
        p1.setUnit("st");
        Product p2 = new Product();
        p2.setName("thas");
        p2.setPrice(100);
        p2.setUnit("st");
        initComponents();
        
        addShoppingItem(new ShoppingItem(p1,1));
        
        
        addShoppingItem(new ShoppingItem(p1,4));
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));
    }// </editor-fold>//GEN-END:initComponents

    
    public void addShoppingItem(ShoppingItem item) {
        add(new ShoppingItemPanel(item));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}