/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import imat.controller.FavouritesManager;
import imat.controller.ShoppingListManager;
import imat.controller.UserManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
/**
 *
 * @author Oskar
 */
public class ProductPanel extends javax.swing.JPanel {
    private Product product = null;
    private final Icon emptyIcon = new ImageIcon(getClass().getResource("/imat/img/favoriteStartEmpty.png"));
    private final Icon filledIcon = new ImageIcon(getClass().getResource("/imat/img/favoriteStartFilled.png"));
    
    public ProductPanel(){
        initComponents();
    }
    
    /**
     * Creates new form ProductPanel
     * @param product
     */
    public ProductPanel(Product product) {
        initComponents();
        setProduct(product);
        this.setVisible(true);
    }
    public double getAmount(){
        int i = (int) amountSpinner.getValue();
        return (double)i;
    }
    public Product getProduct(){
        return product;
    }
    public void setProduct(Product product){
        this.product = product;
        
        nameLabel.setText(product.getName());
        priceLabel.setText(product.getPrice() + " " + product.getUnit());
        imageLabel.setIcon(ResourceHandler.getInstance().getImage(product.getImageName()));
        if(IMatDataHandler.getInstance().isFavorite(product)){
            favoriteButton.setIcon(filledIcon);
        }
        if(!UserManager.getInstance().isLoggedIn()){
            favoriteButton.setVisible(false);
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
        amountSpinner = new javax.swing.JSpinner();
        addToCartButton = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        priceLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        favoriteButton = new javax.swing.JButton();
        addToListButton = new javax.swing.JButton();

        setBackground(Constants.MAIN_BACKGROUND);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(235, 235, 235)));

        amountSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        addToCartButton.setBackground(new java.awt.Color(102, 255, 102));
        addToCartButton.setText("Lägg till i kundvagnen");
        addToCartButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addToCartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartButtonActionPerformed(evt);
            }
        });

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        priceLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        priceLabel.setText("100 :-/st");

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("VARA");

        imageLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(priceLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceLabel)
                .addContainerGap())
        );

        favoriteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imat/img/favoriteStartEmpty.png"))); // NOI18N
        favoriteButton.setToolTipText("Spara som favorit");
        favoriteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        favoriteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                favoriteButtonActionPerformed(evt);
            }
        });

        addToListButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imat/img/add.png"))); // NOI18N
        addToListButton.setBorderPainted(false);
        addToListButton.setContentAreaFilled(false);
        addToListButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addToListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToListButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(amountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addToCartButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(addToListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(favoriteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addToListButton)
                    .addComponent(favoriteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addToCartButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addToCartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCartButtonActionPerformed
        IMatDataHandler.getInstance().getShoppingCart().addProduct(product, getAmount());
    }//GEN-LAST:event_addToCartButtonActionPerformed

    private void favoriteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_favoriteButtonActionPerformed
        if(IMatDataHandler.getInstance().isFavorite(product)){
            favoriteButton.setIcon(emptyIcon);
        }else{
            favoriteButton.setIcon(filledIcon);
        }
        FavouritesManager manager = FavouritesManager.getInstance();
        manager.toggleFavourite(product);
        
    }//GEN-LAST:event_favoriteButtonActionPerformed

    private void addToListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToListButtonActionPerformed

        ShoppingListManager shoppingListManager = ShoppingListManager.getInstance();
        shoppingListManager.addItemToActiveList(product, getAmount());

// TODO add your handling code here:
    }//GEN-LAST:event_addToListButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToCartButton;
    private javax.swing.JButton addToListButton;
    private javax.swing.JSpinner amountSpinner;
    private javax.swing.JButton favoriteButton;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel priceLabel;
    // End of variables declaration//GEN-END:variables

    void showFavouriteButton(boolean b) {
        favoriteButton.setVisible(b);
    }
}