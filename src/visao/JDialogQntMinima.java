/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ProdutoController;
import fachada.Produto;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author miserani
 */
public class JDialogQntMinima extends javax.swing.JDialog {

    /**
     * Creates new form JDialogQntMinima
     */
    public JDialogQntMinima(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        preencherTabela();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Qnt em Estoque", "Qnt Minima"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/arrow_undo.png"))); // NOI18N
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("ATENÇÃO: Os seguintes produtos estão abaixo do estoque minimo.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void preencherTabela() {
        ProdutoController p = new ProdutoController();
        p.buscarProdutos();
        ArrayList<Produto> list = p.getProdsQntMinimaProduto();
        DefaultTableModel dt;
        dt = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Produto", "Em estoque", "Est. Minimo"}) {

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        Object[] linha = new Object[3];
        for (int i = 0; i < list.size(); i++) {
            linha[0] = list.get(i).getNome();
            linha[2] = list.get(i).getQntMinima();
            linha[1] = "<html><font color=\"red\">"+list.get(i).getQnt()+"</font></html>";
            dt.addRow(linha);
        }
        jTable1 = new JTable(dt);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setBorder(null);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(85);
        jTable1.getColumnModel().getColumn(1).setMinWidth(85);
        jTable1.getColumnModel().getColumn(2).setMaxWidth(85);
        jTable1.getColumnModel().getColumn(2).setMinWidth(85);

        TableCellRenderer centerRenderer = new CenterRenderer();
        TableColumn column = jTable1.getColumnModel().getColumn(1);
        TableColumn column1 = jTable1.getColumnModel().getColumn(2);
        column.setCellRenderer(centerRenderer);
        column1.setCellRenderer(centerRenderer);

        repaint();

    }

    class CenterRenderer extends DefaultTableCellRenderer {

        public CenterRenderer() {
            setHorizontalAlignment(CENTER);
        }
    }
}
