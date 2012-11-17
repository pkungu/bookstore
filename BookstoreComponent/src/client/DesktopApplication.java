/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
import javax.swing.*;
import bookstore.*;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author crichers
 */
public class DesktopApplication extends JFrame {

    BookstoreManagerComp manager;
    
    /**
     * Creates new form DesktopApplication
     */
    public DesktopApplication() {
        initComponents();
        manager = new BookstoreManagerComp();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button_search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_search = new javax.swing.JTable();
        textfield_search = new javax.swing.JTextField();
        dropdownmenu_search = new javax.swing.JComboBox();
        label_search = new javax.swing.JLabel();
        label_by = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_cart = new javax.swing.JTable();
        button_checkout = new javax.swing.JButton();
        label_cart = new javax.swing.JLabel();
        button_addtocart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        button_search.setText("Search");
        button_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_searchActionPerformed(evt);
            }
        });

        table_search.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_search.getTableHeader().setResizingAllowed(false);
        table_search.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table_search);
        try
        {
            manager.QueryAllBooks(table_search);
        }
        catch (Exception ex) { }

        textfield_search.setText("Search by book, title, author, ...");

        dropdownmenu_search.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "ISBN", "Title", "Publisher", "Authors" }));

        label_search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_search.setText("Search");

        label_by.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_by.setText("By");

        table_cart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ISBN", "Title", "Publisher", "Authors", "Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_cart.getTableHeader().setResizingAllowed(false);
        table_cart.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(table_cart);
        table_cart.getColumnModel().getColumn(0).setResizable(false);
        table_cart.getColumnModel().getColumn(1).setResizable(false);
        table_cart.getColumnModel().getColumn(2).setResizable(false);
        table_cart.getColumnModel().getColumn(3).setResizable(false);
        table_cart.getColumnModel().getColumn(4).setResizable(false);
        table_cart.getColumnModel().getColumn(5).setResizable(false);
        table_cart.getColumnModel().getColumn(6).setResizable(false);

        button_checkout.setText("Check Out");
        button_checkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_checkoutActionPerformed(evt);
            }
        });

        label_cart.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_cart.setText("Cart");

        button_addtocart.setText("Add To Cart");
        button_addtocart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_addtocartActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane2)
                    .add(jScrollPane1)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(textfield_search, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 627, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(label_search, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 95, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(dropdownmenu_search, 0, 134, Short.MAX_VALUE)
                            .add(label_by, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(label_cart, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(button_addtocart)
                        .add(18, 18, 18)
                        .add(button_search, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 74, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(button_checkout)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(label_search, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .add(label_by, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(5, 5, 5)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(textfield_search, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(dropdownmenu_search, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 194, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(label_cart, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(button_search, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .add(button_addtocart, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 151, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(button_checkout, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_searchActionPerformed

        manager.QueryAllBooks(table_search);
    }//GEN-LAST:event_button_searchActionPerformed

    private void button_checkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_checkoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button_checkoutActionPerformed

    private void button_addtocartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_addtocartActionPerformed
        int selectedRow = table_search.getSelectedRow();
        Book bookToAdd = new Book();
        if (selectedRow != -1)
            {
            for (int i = 0; i < table_search.getModel().getColumnCount(); i++)
            {
                if (i == 0)
                {
                    System.out.println(table_search.getModel().getValueAt(selectedRow, i));
                    bookToAdd._id = Integer.parseInt(table_search.getModel().getValueAt(selectedRow, i).toString());
                }
                else if (i == 1)
                {
                    bookToAdd._isbn = table_search.getModel().getValueAt(selectedRow, i).toString();
                }
                else if (i == 2)
                {
                    bookToAdd._title = table_search.getModel().getValueAt(selectedRow, i).toString();
                }
                else if (i == 3)
                {
                    bookToAdd._publisher = table_search.getModel().getValueAt(selectedRow, i).toString();
                }
                else if (i == 4)
                {
                    bookToAdd._authors = table_search.getModel().getValueAt(selectedRow, i).toString();
                }
                else if (i == 5)
                {
                    bookToAdd._quantity = Integer.parseInt(table_search.getModel().getValueAt(selectedRow, i).toString());
                }
                else
                {
                    bookToAdd._price = Double.parseDouble(table_search.getModel().getValueAt(selectedRow, i).toString());
                }
            }
            manager.Cart().addToCart(bookToAdd);
            UpdateCartTable();
        }
    }//GEN-LAST:event_button_addtocartActionPerformed

    private void UpdateCartTable()
    {
        List<Book> books = manager.Cart().retrieveBooksFromCart();
        DefaultTableModel dtm = (DefaultTableModel)table_cart.getModel();
        Vector<Object> rowData;
        // Clear table.
        while (dtm.getRowCount() != 0)
        {
            dtm.removeRow(0);
        }
        // Repopulate.
        for (Book b : books)
        {
            rowData = new Vector();
            rowData.add(b._id);
            rowData.add(b._isbn);
            rowData.add(b._title);
            rowData.add(b._publisher);
            rowData.add(b._authors);
            rowData.add(b._quantity);
            rowData.add(b._price);
            dtm.addRow(rowData);
        }
//        table_cart.setModel(dtm);
    }
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
            java.util.logging.Logger.getLogger(DesktopApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DesktopApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DesktopApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DesktopApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DesktopApplication().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_addtocart;
    private javax.swing.JButton button_checkout;
    private javax.swing.JButton button_search;
    private javax.swing.JComboBox dropdownmenu_search;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_by;
    private javax.swing.JLabel label_cart;
    private javax.swing.JLabel label_search;
    private javax.swing.JTable table_cart;
    private javax.swing.JTable table_search;
    private javax.swing.JTextField textfield_search;
    // End of variables declaration//GEN-END:variables
}
