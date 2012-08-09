/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.FormaDePagamentoController;
import fachada.FormaPagamento;
import fachada.Produto;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author miserani
 */
public class jDialogFormaPagamento extends javax.swing.JDialog {

    FormaDePagamentoController formaPagamento = new FormaDePagamentoController();

    /**
     * Creates new form jDialogFormaPAgamento
     */
    public jDialogFormaPagamento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        preencherFormaPagamento();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jRadioVista = new javax.swing.JRadioButton();
        jRadioPrazo = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel1.setText("Forma de Pagamento");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Descrição:");

        jLabel3.setText("Tipo de pagamento:");

        jRadioVista.setText("À Vista");

        jRadioPrazo.setText("À Prazo");

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioVista)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioPrazo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(31, 31, 31))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jRadioVista)
                            .addComponent(jRadioPrazo))
                        .addContainerGap(35, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addContainerGap())))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        jRadioPrazo.setMnemonic(KeyEvent.VK_P);
        jRadioVista.setMnemonic(KeyEvent.VK_V);
        
        buttonGroup1.add(jRadioPrazo);
        buttonGroup1.add(jRadioVista);
        
        
        if (jTextField1.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Preencha o campo Descrição");
            
        } else if (jRadioVista.isSelected()) {
           
            formaPagamento.setFormaPagamento(new FormaPagamento(jTextField1.getText(), 1));
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            jTextField1.setText("");
            JOptionPane.showMessageDialog(rootPane, formaPagamento.cadastrar());
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            this.setVisible(false);

        } else if (jRadioPrazo.isSelected()) {
            formaPagamento.setFormaPagamento(new FormaPagamento(jTextField1.getText(), 0));
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            jTextField1.setText("");
            JOptionPane.showMessageDialog(rootPane, formaPagamento.cadastrar());
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            this.setVisible(false);

        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um Tipo de Pagamento");
        }

    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioPrazo;
    private javax.swing.JRadioButton jRadioVista;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void preencherFormaPagamento() {
        this.formaPagamento.buscarFormaPagamento();
        ArrayList<FormaPagamento> listaFormaPagamento = this.formaPagamento.getListFormaPagamento();
        DefaultTableModel tb;
        tb = new DefaultTableModel(new Object[][]{}, new String[]{"codigo", "descicao", "tipo"}) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        Object[] linha = new Object[3];
        for (int i = 0; i < listaFormaPagamento.size(); i++) {
            linha[0] = listaFormaPagamento.get(i).getIdformaPAgamento();
            linha[1] = listaFormaPagamento.get(i).getDescricao();

            if (listaFormaPagamento.get(i).getTipoDePagamento() == 1) {
                linha[2] = "À Vista";
            } else {
                linha[2] = "À Prazo";
            }
            tb.addRow(linha);
        }
        jTable1 = new JTable(tb);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setBorder(null);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        repaint();
    }
}
