/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import java.text.DecimalFormat;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author win8
 */
public class CartItemPanel extends javax.swing.JPanel {

    /**
     * Creates new form cartItemPanel
     *
     * @param item
     */
    public CartItemPanel(ShoppingItem item) {

        initComponents();
        setShoppingItem(item);
        amountSpinner.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("here");
                if (listener != null) {
                    if (getAmount() != item.getAmount()) {
                        if(getAmount() > 0) {
                            System.out.println("notify change");
                            listener.amountChanged(item, getAmount());
                        }
                        else {
                            listener.itemRemoved(item);
                        }
                    }
                }
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

        productNameLabel = new javax.swing.JLabel();
        amountSpinner = new javax.swing.JSpinner();
        productUnitLabel = new javax.swing.JLabel();
        productPriceLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        productNameLabel.setText("Mjölk");

        productUnitLabel.setText("st");

        productPriceLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        productPriceLabel.setText("10 :-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(productNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(amountSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productUnitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(productNameLabel)
                .addComponent(productPriceLabel)
                .addComponent(amountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(productUnitLabel))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner amountSpinner;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel productNameLabel;
    private javax.swing.JLabel productPriceLabel;
    private javax.swing.JLabel productUnitLabel;
    // End of variables declaration//GEN-END:variables
    private ShoppingItem item;
    private ShoppingItemPanelListener listener;

    public void setPanelListener(ShoppingItemPanelListener listener) {
        this.listener = listener;
    }

    public double getAmount() {
        return (Integer) amountSpinner.getValue();
    }

    public void setShoppingItem(ShoppingItem item) {
        this.item = item;
        Product product = item.getProduct();
        productNameLabel.setText(product.getName());
        DecimalFormat df = new DecimalFormat("0.00##");
        productPriceLabel.setText(df.format(item.getTotal()) + " :-");
        productUnitLabel.setText(product.getUnitSuffix());
        amountSpinner.setValue(item.getAmount());
    }

}
