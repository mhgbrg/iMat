/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import imat.controller.CartManager;
import imat.model.ShoppingList;
import imat.model.SubShoppingCart;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.font.TextAttribute;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;
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
        checkoutButton.setOpaque(true);
        checkoutButton.setContentAreaFilled(false);
        jScrollPane1.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
               // e.getAdjustable().setValue(e.getAdjustable().getMaximum());
            }

        });

        cartManager = CartManager.getInstance();
        cart = IMatDataHandler.getInstance().getShoppingCart();
        updateTotalValue();
        cart.addShoppingCartListener(new ShoppingCartListener() {

            @Override
            public void shoppingCartChanged(CartEvent ce) {
                if (cartManager.getSubCartForItem(ce.getShoppingItem()) == null) {
                    if (ce.isAddEvent()) {
                        categorizedShoppingListItemPanel3.shoppingCartChanged(ce);
                    } else {
                        categorizedShoppingListItemPanel3.shoppingCartChanged(ce);
                    }
                }
                updateTotalValue();

            }
        });

        cartManager.addCartManagerListener(new CartManagerListener() {

            @Override
            public void subCartAdded(SubShoppingCart subcart) {
                System.out.println("sub cart panel ");

                jPanel1.add(new SubCartPanel(subcart));
                jPanel1.add(categorizedShoppingListItemPanel3);

                jPanel1.setMaximumSize(jPanel1.getPreferredSize());
            }

            @Override
            public void subCartRemoved(SubShoppingCart cart) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        emptyCartLabel = new javax.swing.JLabel();

        checkoutButton.setBackground(Constants.CHECKOUT_BUTTON_COLOR);
        checkoutButton.setText("GÅ TILL KASSAN");
        checkoutButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        checkoutButton.setBorderPainted(false);
        checkoutButton.setContentAreaFilled(false);
        checkoutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        emptyCartLabel.setText("(Töm kundvagn)");
        emptyCartLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        emptyCartLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emptyCartLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                emptyCartLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                emptyCartLabelMouseExited(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(emptyCartLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emptyCartLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(checkoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutButtonActionPerformed

        showCheckoutContentHandler.showCheckoutContent();
    }//GEN-LAST:event_checkoutButtonActionPerformed

    private void emptyCartLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emptyCartLabelMouseEntered

        underlineLabel(emptyCartLabel, true);
        // TODO add your handling code here:
    }//GEN-LAST:event_emptyCartLabelMouseEntered

    private void emptyCartLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emptyCartLabelMouseExited
        underlineLabel(emptyCartLabel, false);
    }//GEN-LAST:event_emptyCartLabelMouseExited

    private void emptyCartLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emptyCartLabelMouseClicked
        cart.clear();
    }//GEN-LAST:event_emptyCartLabelMouseClicked

    public void setCheckoutButtonPerformedListener(ShowCheckoutContentHandler handler) {
        showCheckoutContentHandler = handler;
    }

    private void updateTotalValue() {
        DecimalFormat df = new DecimalFormat("0.00##");
        totalValueLabel.setText(df.format(cart.getTotal()) + " :-");
    }

    public void updateSize() {
        categorizedShoppingListItemPanel3.updateSize();
        setSize(getPreferredSize());
        setMaximumSize(getPreferredSize());
        revalidate();
    }

    private void underlineLabel(JLabel label, boolean on) {
        Font font = label.getFont();
        Map attributes = font.getAttributes();
        if (on) {
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        } else {
            attributes.put(TextAttribute.UNDERLINE, -1);
        }
        label.setFont(font.deriveFont(attributes));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private imat.CartCategorizedItemListPanel categorizedShoppingListItemPanel3;
    private javax.swing.JButton checkoutButton;
    private javax.swing.JLabel emptyCartLabel;
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
    private ShowCheckoutContentHandler showCheckoutContentHandler;

}
