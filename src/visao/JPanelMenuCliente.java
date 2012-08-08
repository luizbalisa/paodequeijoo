/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ClienteController;
import fachada.Cliente;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.Normalizer;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rafael
 */
public class JPanelMenuCliente extends javax.swing.JPanel {

    JFramePrincipal principal;
    ClienteController cliente = new ClienteController();
    private Component rootPane;

    /**
     * Creates new form JPanelMenuCliente
     */
    public JPanelMenuCliente(JFramePrincipal principal) {
        initComponents();
        this.principal = principal;
        preencherClientes();
        buscaDinamica();
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
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel1.setText("Gerenciar Clientes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(529, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Telefone", "Local de trabalho"
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

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButton1.setText("Cadastrar Cliente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Detalhar Dados");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Editar Dados");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Remover Cliente");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setText("Buscar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        principal.gerenciarClientes(0, 0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jTable1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Selecione o cliente");
        } else {
            int linha = jTable1.getSelectedRow();
            String id = String.valueOf(jTable1.getModel().getValueAt(linha, 0));
            this.principal.gerenciarClientes(1, Integer.parseInt(id));
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (jTable1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Selecione o cliente");
        } else {
            int linha = jTable1.getSelectedRow();
            String id = jTable1.getModel().getValueAt(linha, 0).toString();
            this.principal.editarCliente(Integer.parseInt(id));
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (jTable1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Selecione o cliente");
        } else {
            int linha = jTable1.getSelectedRow();
            String id = jTable1.getModel().getValueAt(linha, 0).toString();
            cliente.getCliente(Integer.parseInt(id));
            int escolha = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja excluir o cliente " + cliente.getCliente().getNome() + " ?");
            if (escolha == 0) {
                this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
                JOptionPane.showMessageDialog(rootPane, cliente.excluirCliente());
                this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                preencherClientes();
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void preencherClientes() {
        cliente.buscarClientes();
        ArrayList<Cliente> clientes = cliente.getListaClisntes();
        DefaultTableModel dt;
        dt = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Id", "Nome", "Telefone", "Local de Trabalho"
                }) {

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        Object[] linha = new Object[4];
        for (int i = 0; i < clientes.size(); i++) {
            linha[0] = clientes.get(i).getId();
            linha[1] = clientes.get(i).getNome();
            linha[2] = clientes.get(i).getTelefoneValido();
            linha[3] = clientes.get(i).getLocalDeTrabalho();
            dt.addRow(linha);
        }

        jTable1 = new JTable(dt);
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

    private void buscaDinamica() {
        jTextField1.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {

                if (!jTextField1.getText().equals("")) {
                    ArrayList<Cliente> clientes = cliente.buscaDinamicaClientes(jTextField1.getText());
                    DefaultTableModel dt;
                    dt = new DefaultTableModel(
                            new Object[][]{},
                            new String[]{
                                "Id", "Nome", "Telefone", "Local de Trabalho"
                            }) {

                        @Override
                        public boolean isCellEditable(int row, int col) {
                            return false;
                        }
                    };
                    Object[] linha = new Object[4];
                    for (int i = 0; i < clientes.size(); i++) {
                        linha[0] = clientes.get(i).getId();
                        linha[1] = clientes.get(i).getNome();
                        linha[2] = clientes.get(i).getTelefoneValido();
                        linha[3] = clientes.get(i).getLocalDeTrabalho();
                        dt.addRow(linha);
                    }

                    jTable1 = new JTable(dt);
                    jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
                    jTable1.getColumnModel().getColumn(0).setMinWidth(0);
                    jTable1.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
                    jTable1.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
                    jScrollPane1.setViewportView(jTable1);
                    jTable1.getTableHeader().setReorderingAllowed(false);
                    jScrollPane1.setBorder(null);
                    jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    repaint();
                } else {
                    preencherClientes();
                }
            }
        });

    }
}
