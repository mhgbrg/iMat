/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;

/**
 *
 * @author Oskar
 */
public class IMatView extends javax.swing.JFrame implements PropertyChangeListener {
    private final ListHandler lh = new ListHandler();
    
    private final IMatDataHandler imat = IMatDataHandler.getInstance();
    
    private final ShoppingItemListPanel shoppingList;
    /**
     * Listens for changes in SubcategoryList
     * @param evt 
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ProductCategoryWrapper category = (ProductCategoryWrapper) evt.getNewValue();
        if (category != null) {
            productListPanel.updateProducts(imat.getProducts(category.getProductCategory()));
        }
    }
    
    private class ConcreteSearchListener implements SearchListener {
        @Override
        public void search(String str) {
            List<Product> results = imat.findProducts(str);
            productListPanel.updateProducts(results);
            
        }
    }
    
    /**
     * Creates new form IMatView
     */
    public IMatView() {
        this.shoppingList = new ShoppingItemListPanel();
        initComponents();
        
       //topPanel
        searchPanel.addSearchButtonListener(new ConcreteSearchListener());
        
       //sideBar
        subcategoryList.addObserver(this);
        
       //progressBar
        loadResourcesWithProgressBar();
        
        IMatDataHandler.getInstance().getShoppingCart().addShoppingCartListener(shoppingList);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        topTabsPanel = new javax.swing.JPanel();
        topHeadPanel = new javax.swing.JPanel();
        fruitButton = new imat.MainCategoryItem();
        fruitButton.setCategory(MainProductCategory.FRUIT_AND_VEGETABLES);
        charkButton = new imat.MainCategoryItem();
        charkButton.setCategory(MainProductCategory.CHARK);
        diaryButton = new imat.MainCategoryItem();
        diaryButton.setCategory(MainProductCategory.DIARIES);
        breadButton = new imat.MainCategoryItem();
        breadButton.setCategory(MainProductCategory.BREAD);
        snacksButton = new imat.MainCategoryItem();
        snacksButton.setCategory(MainProductCategory.DRINKS_AND_SNACKS);
        recipeButton = new imat.MainCategoryItem();
        dryButton = new imat.MainCategoryItem();
        dryButton.setCategory(MainProductCategory.DRY);
        searchPanel = new imat.SearchPanel();
        subHeadPanel = new javax.swing.JPanel();
        checkOutItem2 = new imat.CheckOutItem();
        profileItem1 = new imat.ProfileItem();
        homeButton = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        contentScrollPane = new javax.swing.JScrollPane();
        mainContentPanel = new javax.swing.JPanel();
        startPagePanel = new imat.StartPagePanel();
        productListPanel = new imat.ProductListPanel();
        subcategoryList = new imat.SubcategoryList();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("iMat - Mat..Mat!");

        fruitButton.setMinimumSize(new java.awt.Dimension(100, 60));
        fruitButton.setName(""); // NOI18N
        fruitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fruitButtonMouseClicked(evt);
            }
        });

        charkButton.setMinimumSize(new java.awt.Dimension(100, 60));
        charkButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                charkButtonMouseClicked(evt);
            }
        });

        diaryButton.setMinimumSize(new java.awt.Dimension(100, 60));
        diaryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                diaryButtonMouseClicked(evt);
            }
        });

        breadButton.setMinimumSize(new java.awt.Dimension(100, 60));
        breadButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                breadButtonMouseClicked(evt);
            }
        });

        snacksButton.setMinimumSize(new java.awt.Dimension(100, 60));
        snacksButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                snacksButtonMouseClicked(evt);
            }
        });

        recipeButton.setMinimumSize(new java.awt.Dimension(100, 60));
        recipeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recipeButtonMouseClicked(evt);
            }
        });

        dryButton.setMinimumSize(new java.awt.Dimension(100, 60));
        dryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dryButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout topHeadPanelLayout = new javax.swing.GroupLayout(topHeadPanel);
        topHeadPanel.setLayout(topHeadPanelLayout);
        topHeadPanelLayout.setHorizontalGroup(
            topHeadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topHeadPanelLayout.createSequentialGroup()
                .addComponent(fruitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(breadButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(charkButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(diaryButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(dryButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(snacksButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(recipeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE))
        );
        topHeadPanelLayout.setVerticalGroup(
            topHeadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topHeadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(fruitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(charkButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(diaryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(breadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(snacksButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(recipeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        subHeadPanel.setBackground(new java.awt.Color(0, 0, 255));

        checkOutItem2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        profileItem1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout subHeadPanelLayout = new javax.swing.GroupLayout(subHeadPanel);
        subHeadPanel.setLayout(subHeadPanelLayout);
        subHeadPanelLayout.setHorizontalGroup(
            subHeadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subHeadPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(profileItem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(checkOutItem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        subHeadPanelLayout.setVerticalGroup(
            subHeadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(checkOutItem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(profileItem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout topTabsPanelLayout = new javax.swing.GroupLayout(topTabsPanel);
        topTabsPanel.setLayout(topTabsPanelLayout);
        topTabsPanelLayout.setHorizontalGroup(
            topTabsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topHeadPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(subHeadPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        topTabsPanelLayout.setVerticalGroup(
            topTabsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topTabsPanelLayout.createSequentialGroup()
                .addComponent(topHeadPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(subHeadPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imat/img/logo.jpg"))); // NOI18N
        homeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        homeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addComponent(homeButton)
                .addGap(0, 0, 0)
                .addComponent(topTabsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topTabsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(homeButton)
        );

        jSplitPane1.setDividerSize(0);

        mainContentPanel.setLayout(new java.awt.CardLayout());
        mainContentPanel.add(startPagePanel, "start");

        productListPanel.setLayout(new java.awt.GridLayout(0, 4));
        mainContentPanel.add(productListPanel, "product");

        contentScrollPane.setViewportView(mainContentPanel);

        jSplitPane1.setRightComponent(contentScrollPane);
        jSplitPane1.setLeftComponent(subcategoryList);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSplitPane1)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fruitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fruitButtonMouseClicked
        handleClick(evt);
    }//GEN-LAST:event_fruitButtonMouseClicked

    private void breadButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_breadButtonMouseClicked
        handleClick(evt);
    }//GEN-LAST:event_breadButtonMouseClicked

    private void charkButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_charkButtonMouseClicked
        handleClick(evt);
    }//GEN-LAST:event_charkButtonMouseClicked

    private void diaryButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diaryButtonMouseClicked
        handleClick(evt);
    }//GEN-LAST:event_diaryButtonMouseClicked

    private void dryButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dryButtonMouseClicked
        handleClick(evt);
    }//GEN-LAST:event_dryButtonMouseClicked

    private void snacksButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_snacksButtonMouseClicked
        handleClick(evt);
    }//GEN-LAST:event_snacksButtonMouseClicked

    private void recipeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recipeButtonMouseClicked
        handleClick(evt);
    }//GEN-LAST:event_recipeButtonMouseClicked

    private void handleClick(java.awt.event.MouseEvent evt) {
        MainCategoryItem source = (MainCategoryItem)evt.getSource();
  
        resetButtons();
        source.highlight();
        
        showProductPage();
        
        setList(source.getCategory());
    }
    
    private void homeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseClicked
        resetButtons();
        resetProductList();
        
        subcategoryList.clear();
        
        showStartPage();
    }//GEN-LAST:event_homeButtonMouseClicked

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
            java.util.logging.Logger.getLogger(IMatView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IMatView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IMatView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IMatView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IMatView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private imat.MainCategoryItem breadButton;
    private imat.MainCategoryItem charkButton;
    private imat.CheckOutItem checkOutItem2;
    private javax.swing.JScrollPane contentScrollPane;
    private imat.MainCategoryItem diaryButton;
    private imat.MainCategoryItem dryButton;
    private imat.MainCategoryItem fruitButton;
    private javax.swing.JLabel homeButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel mainContentPanel;
    private javax.swing.JPanel mainPanel;
    private imat.ProductListPanel productListPanel;
    private imat.ProfileItem profileItem1;
    private imat.MainCategoryItem recipeButton;
    private imat.SearchPanel searchPanel;
    private imat.MainCategoryItem snacksButton;
    private imat.StartPagePanel startPagePanel;
    private javax.swing.JPanel subHeadPanel;
    private imat.SubcategoryList subcategoryList;
    private javax.swing.JPanel topHeadPanel;
    private javax.swing.JPanel topPanel;
    private javax.swing.JPanel topTabsPanel;
    // End of variables declaration//GEN-END:variables

    private void showStartPage() {
        CardLayout manager = (CardLayout) mainContentPanel.getLayout();
        manager.show(mainContentPanel, "start");
    }
    
    private void showProductPage() {
        CardLayout manager = (CardLayout) mainContentPanel.getLayout();
        manager.show(mainContentPanel, "product");
    }
    
    private void setList(MainProductCategory mainCategory) {
        List<ProductCategoryWrapper> subcategories = mainCategory.getSubcategories();
        Object[] arr = subcategories.toArray();
        subcategoryList.update(arr);
    }

    private void resetButtons() {
        fruitButton.reset();
        breadButton.reset();
        charkButton.reset();
        dryButton.reset();
        snacksButton.reset();
        diaryButton.reset();
        recipeButton.reset();
    }

    private void resetProductList() {
        productListPanel.reset();
    }

    private void listProducts(String p) {
        ArrayList<Product> list = new ArrayList<>();
        if(p == "ALLA"){
            list.addAll(lh.getProducts(getMainCategory()));
        }else{
            list.addAll(lh.getProducts(lh.parseString(p)));
        }
        
        productListPanel.updateProducts(list);
    }

    private String getMainCategory() {
        if(fruitButton.isHighlighted()){
            return "FoG";
        }else if(breadButton.isHighlighted()){
            return "Bröd";
        }else if(charkButton.isHighlighted()){
            return "Chark";
        }else if(dryButton.isHighlighted()){
            return "Torr";
        }else if(snacksButton.isHighlighted()){
            return "DS";
        }else if(diaryButton.isHighlighted()){
            return "Mejeri";
        }else if(recipeButton.isHighlighted()){
            return null;
        }
        return null;
    }

    private void loadResourcesWithProgressBar() {
        final JDialog dlg = new JDialog(this, "Loading Resources...", true);
        JProgressBar bar = new JProgressBar(0,500);
        dlg.add(BorderLayout.CENTER, bar);
        dlg.add(BorderLayout.NORTH, new JLabel("Progress..."));
        dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dlg.setSize(300, 75);
        dlg.setLocationRelativeTo(this);
        bar.setMaximum(150);
        Thread t = new Thread(new Runnable() {
            public void run() {
                dlg.setVisible(true);
            }
        });
        t.start();      
        ResourceHandler.getInstance(bar);
        dlg.setVisible(false);
    }
}
