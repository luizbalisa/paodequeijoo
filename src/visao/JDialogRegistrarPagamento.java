/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.FormaDePagamentoController;
import controle.PagamentoController;
import controle.ValidadorCampos;
import controle.VendaController;
import fachada.FormaPagamento;
import fachada.Pagamento;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Rafael
 */
public class JDialogRegistrarPagamento extends javax.swing.JDialog {

    JPanelContasReceber pai;
    PagamentoController pagamento = new PagamentoController();
    DecimalFormat formatador = new DecimalFormat("###0.00");
    ValidadorCampos validar = new ValidadorCampos();
    String anterior = "";

    /**
     * Creates new form JDialogRegistrarPagamento
     */
    public JDialogRegistrarPagamento(java.awt.Frame parent, boolean modal, JPanelContasReceber pai) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.pai = pai;
        preencherFormas();
        jTextField1.setText(formatador.format(Double.parseDouble(pai.restante.replace(",", "."))));
        jTextField1.setEditable(false);
        dinamismo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel3.setText("Receber pagamento");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jSeparator3))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Valor total");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Outro valor");

        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel1.setText("Valor: ");

        jLabel2.setText("Forma: ");

        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton1)
                                    .addComponent(jRadioButton2))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (checarMaior(Double.parseDouble(jTextField1.getText().replace(",", ".")))) {
            jRadioButton1.setSelected(true);
            JOptionPane.showMessageDialog(rootPane, "O valor pago deve ser menor ou igual ao pendente.");
            jTextField1.setEditable(false);
            jTextField1.setText(formatador.format(Double.parseDouble(pai.restante.replace(",", "."))));
        } else {
            if (jRadioButton1.isSelected() || (Double.parseDouble(pai.restante.replace(",", ".")) == Double.parseDouble(jTextField1.getText().replace(",", ".")))) {
                SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
                Date data = new Date();
                pagamento.setPagamento(new Pagamento());
                pagamento.getPagamento().setData(formatador.format(data));
                pagamento.getPagamento().setIdVenda(pai.controle.getVendaPrazo().getIdVenda());
                pagamento.getPagamento().setValor(jTextField1.getText());
                int escolha = JOptionPane.showConfirmDialog(rootPane, "Finalizar conta ?");
                if (escolha == 0) {
                    this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
                    pagamento.cadastrarPagamento(jComboBox1.getSelectedItem().toString());
                    pai.imprimir();
                    pagamento.darBaixa();
                    pai.limparTela();
                    this.dispose();
                    this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
            } else {
                SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
                Date data = new Date();
                pagamento.setPagamento(new Pagamento());
                pagamento.getPagamento().setData(formatadorData.format(data));
                pagamento.getPagamento().setIdVenda(pai.controle.getVendaPrazo().getIdVenda());
                pagamento.getPagamento().setValor(jTextField1.getText());
                int escolha = JOptionPane.showConfirmDialog(rootPane, "Registrar o pagamento de R$ " + jTextField1.getText() + " ?");
                if (escolha == 0) {
                    this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
                    JOptionPane.showMessageDialog(rootPane, pagamento.cadastrarPagamento(jComboBox1.getSelectedItem().toString()));
                    pai.imprimir();
                    pai.preencherPag();
                    this.dispose();
                    this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        if (!jTextField1.getText().equals("")) {
            if (!validar.checarReal(jTextField1.getText().replace(",", "."))) {
                jTextField1.setText("");
            } else {
                jTextField1.setText(formatador.format(Double.parseDouble(jTextField1.getText().replace(",", "."))));
                anterior = jTextField1.getText();
            }
        }
    }//GEN-LAST:event_jTextField1FocusLost

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        if (!jTextField1.getText().equals("")) {
            if (!validar.checarReal2(jTextField1.getText().replace(",", "."))) {
                jTextField1.setText(anterior);
            } else {
                anterior = jTextField1.getText();
            }
        }
    }//GEN-LAST:event_jTextField1KeyReleased
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void preencherFormas() {
        FormaDePagamentoController formaPagamento = new FormaDePagamentoController();
        formaPagamento.buscarFormaPagamento();
        ArrayList<FormaPagamento> listaFormaPagamento = formaPagamento.getListFormaPagamento();

        for (int i = 0; i < listaFormaPagamento.size(); i++) {
            if (listaFormaPagamento.get(i).getTipoDePagamento() != 0) {
                jComboBox1.addItem(listaFormaPagamento.get(i).getDescricao());
            }
        }
    }

    private void dinamismo() {
        jRadioButton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (jRadioButton2.isSelected()) {
                    jTextField1.setEditable(true);
                    jTextField1.setText("");
                }
            }
        });
        jRadioButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (jRadioButton1.isSelected()) {
                    jTextField1.setEditable(false);
                    jTextField1.setText(formatador.format(Double.parseDouble(pai.restante.replace(",", "."))));
                }
            }
        });
    }

    public boolean checarMaior(double valor) {
        if (Double.parseDouble(formatador.format(Double.parseDouble(pai.restante.replace(",", "."))).replace(",", ".")) < valor) {
            return true;
        } else {
            return false;
        }
    }
}
