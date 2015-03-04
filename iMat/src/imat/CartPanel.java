/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import imat.controller.CartManager;
import imat.model.ShoppingList;
import java.awt.Color;
import java.util.HashMap;
import se.chalmers.ait.dat215.project.CartEvent;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingCart;
import se.chalmers.ait.dat215.project.ShoppingCartListener;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author win8
 */
public class CartPanel extends javax.swing.JPanel {

    /**
     * Creates new form CartPanel
     */
    public CartPanel() {
        initComponents();
        checkoutButton.setBackground(Color.GREEN);
        checkoutButton.setOpaque(true);
        checkoutButton.setContentAreaFilled(false);
        
        cartManager = new CartManager();
        cart = IMatDataHandler.getInstance().getShoppingCart();
        updateTotalValue();
        cart.addShoppingCartListener(new ShoppingCartListener() {

            @Override
            public void shoppingCartChanged(CartEvent ce) {
                if(ce.isAddEvent()) {
                    categorizedShoppingListItemPanel3.shoppingCartChanged(ce);
                }
                else {
                    categorizedShoppingListItemPanel3.shoppingCartChanged(ce);
                }
               updateTotalValue();
               
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkoutButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        categorizedShoppingListItemPanel3 = new imat.CartCategorizedItemListPanel();
        jSeparator1 = new javax.swing.JSeparator();
        totalPanel = new javax.swing.JPanel();
        totalValueLabel = new javax.swing.JLabel();
        totalTextLabel = new javax.swing.JLabel();

        checkoutButton.setBackground(java.awt.Color.green);
        checkoutButton.setText("GÅ TILL KASSAN");
        checkoutButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        checkoutButton.setBorderPainted(false);
        checkoutButton.setContentAreaFilled(false);
        checkoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutButtonActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("KUNDVAGN");

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        categorizedShoppingListItemPanel3.setMaximumSize(categorizedShoppingListItemPanel3.getPreferredSize());
        jPanel1.add(categorizedShoppingListItemPanel3);

        jScrollPane1.setViewportView(jPanel1);

        totalValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalValueLabel.setText("0 :-");

        totalTextLabel.setText("Totalt:");

        javax.swing.GroupLayout totalPanelLayout = new javax.swing.GroupLayout(totalPanel);
        totalPanel.setLayout(totalPanelLayout);
        totalPanelLayout.setHorizontalGroup(
            totalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalPanelLayout.createSequentialGroup()
                .addComponent(totalTextLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totalValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        totalPanelLayout.setVerticalGroup(
            totalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(totalTextLabel)
                .addComponent(totalValueLabel))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(checkoutButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(totalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(checkoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutButtonActionPerformed
 
        showCheckoutContentHandler.showCheckoutContent();
    }//GEN-LAST:event_checkoutButtonActionPerformed

    
    public void setCheckoutButtonPerformedListener(ShowCheckoutContentHandler handler) {
        showCheckoutContentHandler= handler;
    }
    
    private void updateTotalValue() {
         totalValueLabel.setText(cart.getTotal() +" :-");
    }

    public void updateSize() {
        categorizedShoppingListItemPanel3.updateSize();
        setSize(getPreferredSize());
        setMaximumSize(getPreferredSize());
        revalidate();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private imat.CartCategorizedItemListPanel categorizedShoppingListItemPanel3;
    private javax.swing.JButton checkoutButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel totalPanel;
    private javax.swing.JLabel totalTextLabel;
    private javax.swing.JLabel totalValueLabel;
    // End of variables declaration//GEN-END:variables

    private ShoppingCart cart;
    private CartManager cartManager;
    private HashMap<ShoppingList,CartCategorizedItemListPanel> shoppingListPanels;
    private ShowCheckoutContentHandler showCheckoutContentHandler;

}
