/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ProdutoController;
import fachada.Produto;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class JPanelGerenciarProduto extends javax.swing.JPanel {

    int idProduto;
    int telaTipo;
    JPanelMenuProdutosVenda pai;
    ProdutoController produto = new ProdutoController();
    private Component rootPane;

    /**
     * Creates new form JPanelGerenciarProduto
     */
    public JPanelGerenciarProduto(int idProduto, int tipo, JPanelMenuProdutosVenda pai) {
        initComponents();
        this.pai = pai;
        telaTipo = tipo;

        if (tipo == 1) {
            this.produto.buscarProdutos();
            jButton1.setText("Editar");
            jPanel2.setBorder(BorderFactory.createTitledBorder("Editar Produto"));
            this.produto.getProduto(idProduto);
            this.preencherDadosProduto(this.produto.getProduto());
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

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JFormattedTextField();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastrar Produto"));

        jLabel2.setText("Nome:");

        jLabel3.setText("Preço:");

        jButton5.setText("Cancelar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 206, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton1)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (telaTipo == 0) {
            if (jTextField1.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Preencha o campo Nome");
            } else if (jTextField2.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Preencha o campo Preco");
            } else {
                produto.setProduto(new Produto(jTextField1.getText(), jTextField2.getText()));
                System.out.println(jTextField2.getText() + "aki");
                this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
                jTextField1.setText("");
                jTextField2.setText("");
                JOptionPane.showMessageDialog(rootPane, produto.cadastrar());
                pai.ativarBotoes(telaTipo);
                pai.preencherProdutos();
                this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                this.setVisible(false);
            }
        } else {
            if (telaTipo == 1) {//edicao
                if (jTextField1.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Preencha o campo Nome");
                } else if (jTextField2.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Preencha o campo Preco");
                } else {
                    this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
                    editarProduto();
                    JOptionPane.showMessageDialog(rootPane, produto.editar());
                    pai.ativarBotoes(telaTipo);
                    pai.preencherProdutos();
                    this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    this.setVisible(false);
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        pai.ativarBotoes(telaTipo);
        this.setVisible(false);

    }//GEN-LAST:event_jButton5ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JFormattedTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    private void preencherDadosProduto(Produto p) {
        jTextField1.setText(p.getNome());
        jTextField2.setText(p.getPreco());
    }

    private void editarProduto() {
        produto.getProduto().setNome(jTextField1.getText());
        produto.getProduto().setPreco(jTextField2.getText());
    }
}
