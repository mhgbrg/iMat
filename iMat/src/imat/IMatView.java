/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import imat.controller.UserManager;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
    
    private final IMatDataHandler imat = IMatDataHandler.getInstance();

    /**
     * Listens for changes in SubcategoryList
     * @param evt 
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String property = evt.getPropertyName();
        
        if (property.equals("subcategoryChange")) {
            Category category = (Category) evt.getNewValue();
            if (category != null) {
                productListPanel.updateProducts(category.getProducts());
            }
        } else if (property.equals("login")) {
            switchToCard("login");
        } else if (property.equals("register")) {
            switchToCard("profile");
        } else if (property.equals("gotoRegister")) {
            switchToCard("register");
        } else if (property.equals("showProfileCard")) {
            switchToCard("profile");
        } else if (property.equals("showEditProfileCard")) {
            switchToCard("editProfile");
        }
    }
    
    private class ConcreteSearchListener implements SearchListener {
        @Override
        public void search(String str) {
            resetButtons();
            List<Product> results = imat.findProducts(str);
            productListPanel.updateProducts(results);
            switchToCard("productList");
        }
    }
    
    /**
     * Creates new form IMatView
     */
    public IMatView() {
        initComponents();
        
        //request focus so search panel isnt focus on start
        homeButton.requestFocus();
        
        //topPanel
        searchPanel.addSearchButtonListener(new ConcreteSearchListener());
        
        //sideBar
        subcategoryList.addPropertyChangeListener(this);
        
        //progressBar
        loadResourcesWithProgressBar();
        
        //checkoutButtonHandler
        shoppingPanel1.setCheckoutButtonPerformedListener(new ShowCheckoutContentHandler() {
            @Override
            public void showCheckoutContent() {
                resetButtons();
                switchToCard("checkOut");
            }
        });
        
        imat.getShoppingCart().addShoppingCartListener(checkOutItem2);
        
        loginPanel.addPropertyChangeListener(this);
        registerPanel.addPropertyChangeListener(this);
        profilePanel.addPropertyChangeListener(this);
        editProfilePanel.addPropertyChangeListener(this);
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
        fruitButton.setCategory(new MainProductCategory(MainProductCategory.Name.FRUIT_AND_VEGETABLES));
        charkButton = new imat.MainCategoryItem();
        charkButton.setCategory(new MainProductCategory(MainProductCategory.Name.CHARK));
        diaryButton = new imat.MainCategoryItem();
        diaryButton.setCategory(new MainProductCategory(MainProductCategory.Name.DIARIES));
        breadButton = new imat.MainCategoryItem();
        breadButton.setCategory(new MainProductCategory(MainProductCategory.Name.BREAD));
        snacksButton = new imat.MainCategoryItem();
        snacksButton.setCategory(new MainProductCategory(MainProductCategory.Name.DRINKS_AND_SNACKS));
        recipeButton = new imat.MainCategoryItem();
        dryButton = new imat.MainCategoryItem();
        dryButton.setCategory(new MainProductCategory(MainProductCategory.Name.DRY));
        searchPanel = new imat.SearchPanel();
        subHeadPanel = new javax.swing.JPanel();
        checkOutItem2 = new imat.CheckOutItem();
        profileButton = new imat.ProfileItem();
        homeButton = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        rightSplitPane = new javax.swing.JPanel();
        contentScrollPane = new javax.swing.JScrollPane();
        mainContentPanel = new javax.swing.JPanel();
        startPagePanel = new imat.StartPagePanel();
        checkOutPanel = new imat.CheckOutPanel();
        profilePanel = new imat.ProfilePanel();
        loginPanel = new imat.LoginPanel();
        registerPanel = new imat.RegisterPanel();
        productListPanel = new imat.ProductListPanel();
        editProfilePanel = new imat.EditProfilePanel();
        shoppingPanel1 = new imat.ShoppingPanel();
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
                .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        subHeadPanel.setBackground(new java.awt.Color(102, 102, 102));

        checkOutItem2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        checkOutItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkOutItem2MouseClicked(evt);
            }
        });

        profileButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        profileButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout subHeadPanelLayout = new javax.swing.GroupLayout(subHeadPanel);
        subHeadPanel.setLayout(subHeadPanelLayout);
        subHeadPanelLayout.setHorizontalGroup(
            subHeadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subHeadPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(checkOutItem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        subHeadPanelLayout.setVerticalGroup(
            subHeadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(checkOutItem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jSplitPane1.setBorder(null);
        jSplitPane1.setDividerSize(0);

        contentScrollPane.setBorder(null);

        mainContentPanel.setMinimumSize(new java.awt.Dimension(934, 602));
        mainContentPanel.setPreferredSize(new java.awt.Dimension(100, 602));
        mainContentPanel.setLayout(new java.awt.CardLayout());
        mainContentPanel.add(startPagePanel, "startPage");
        mainContentPanel.add(checkOutPanel, "checkOut");
        mainContentPanel.add(profilePanel, "profile");
        mainContentPanel.add(loginPanel, "login");
        mainContentPanel.add(registerPanel, "register");
        mainContentPanel.add(productListPanel, "productList");
        mainContentPanel.add(editProfilePanel, "editProfile");

        contentScrollPane.setViewportView(mainContentPanel);

        javax.swing.GroupLayout rightSplitPaneLayout = new javax.swing.GroupLayout(rightSplitPane);
        rightSplitPane.setLayout(rightSplitPaneLayout);
        rightSplitPaneLayout.setHorizontalGroup(
            rightSplitPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightSplitPaneLayout.createSequentialGroup()
                .addComponent(contentScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 931, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shoppingPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        rightSplitPaneLayout.setVerticalGroup(
            rightSplitPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(shoppingPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contentScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(rightSplitPane);
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
                .addGap(0, 0, 0)
                .addComponent(jSplitPane1))
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
        
        switchToCard("productList");
        
        setList(source.getCategory());
    }
    
    private void homeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseClicked
        resetButtons();
        resetProductList();
        
        subcategoryList.clear();
        
        switchToCard("startPage");
    }//GEN-LAST:event_homeButtonMouseClicked

    private void profileButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileButtonMouseClicked
        resetButtons();
        if (UserManager.getInstance().isLoggedIn()) {
            switchToCard("profile");
        } else {
            switchToCard("login");
        }
    }//GEN-LAST:event_profileButtonMouseClicked

    private void checkOutItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkOutItem2MouseClicked

        
            shoppingPanel1.showContent(!(shoppingPanel1.getCurrentCard().equals("cartCard") && shoppingPanel1.isContentVisible()));
            shoppingPanel1.setContentToCart();
        
    }//GEN-LAST:event_checkOutItem2MouseClicked

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
    private imat.CheckOutPanel checkOutPanel;
    private javax.swing.JScrollPane contentScrollPane;
    private imat.MainCategoryItem diaryButton;
    private imat.MainCategoryItem dryButton;
    private imat.EditProfilePanel editProfilePanel;
    private imat.MainCategoryItem fruitButton;
    private javax.swing.JLabel homeButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSplitPane jSplitPane1;
    private imat.LoginPanel loginPanel;
    private javax.swing.JPanel mainContentPanel;
    private javax.swing.JPanel mainPanel;
    private imat.ProductListPanel productListPanel;
    private imat.ProfileItem profileButton;
    private imat.ProfilePanel profilePanel;
    private imat.MainCategoryItem recipeButton;
    private imat.RegisterPanel registerPanel;
    private javax.swing.JPanel rightSplitPane;
    private imat.SearchPanel searchPanel;
    private imat.ShoppingPanel shoppingPanel1;
    private imat.MainCategoryItem snacksButton;
    private imat.StartPagePanel startPagePanel;
    private javax.swing.JPanel subHeadPanel;
    private imat.SubcategoryList subcategoryList;
    private javax.swing.JPanel topHeadPanel;
    private javax.swing.JPanel topPanel;
    private javax.swing.JPanel topTabsPanel;
    // End of variables declaration//GEN-END:variables

    private void switchToCard(String card) {
        System.out.println("switchToCard: " + card);
        
        CardLayout manager = (CardLayout) mainContentPanel.getLayout();
        manager.show(mainContentPanel, card);
        subcategoryList.clear();
    }
    
    private void setList(MainProductCategory mainCategory) {
        List<Category> subcategories = mainCategory.getSubcategories();
        subcategories.add(0, mainCategory);
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
