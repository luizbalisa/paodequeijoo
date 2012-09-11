/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.PagamentoController;
import controle.VendaController;
import fachada.Cliente;
import fachada.Pagamento;
import fachada.ProdutoVenda;
import fachada.VendaPrazo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import persistencia.ConsultasClienteMySQL;

/**
 *
 * @author Rafael
 */
public class JPanelContasReceber extends javax.swing.JPanel {

    JFramePrincipal principal;
    VendaController controle = new VendaController();
    PagamentoController pagamento = new PagamentoController();
    DecimalFormat formatador = new DecimalFormat("###0.00");
    String restante;

    /**
     * Creates new form JPanelContasReceber
     */
    public JPanelContasReceber(JFramePrincipal principal) {
        initComponents();
        this.principal = principal;
        iniciarTela();
        controle.buscaVendas();
        preencherContas(controle.getListaVenda());
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

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        jTable3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel3.setText("Contas a receber");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
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

        jTable1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Buscar: ");

        jTextField1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Nome: ");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("Itens: ");

        jTable2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Produto", "Qunatidade", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel7.setText("Nome cliente");

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel8.setText("Pagamentos realizados:");

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel9.setText("Valor total: ");

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel10.setText("VT");

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel11.setText("Valor recebido: ");

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel12.setText("VR");

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel13.setText("Valor a receber: ");

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel14.setText("VAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel14))
                                        .addGap(42, 42, 42))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void preencherContas(ArrayList<VendaPrazo> lista) {
        DefaultTableModel dt;
        dt = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Id", "Cliente"
                }) {

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        Object[] linha = new Object[2];
        ConsultasClienteMySQL c = new ConsultasClienteMySQL();
        for (int i = 0; i < lista.size(); i++) {
            linha[0] = lista.get(i).getIdVenda();
            linha[1] = c.buscarClienteId(lista.get(i).getIdCliente()).getNome();
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
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                preencherDados();
                pagamento.buscarPagamentos(controle.getVendaPrazo().getIdVenda());
                preencherPagamentos(pagamento.getListaPagamento());
                calcular();
            }
        });

        repaint();
    }

    public void limparTela() {
        jTextField1.setText("");
        iniciarTela();
        controle.buscaVendas();
        preencherContas(controle.getListaVenda());
        preencherDados();

    }

    public void preencherPag() {
        pagamento.buscarPagamentos(controle.getVendaPrazo().getIdVenda());
        preencherPagamentos(pagamento.getListaPagamento());
        calcular();
    }

    private void preencherItens(ArrayList<ProdutoVenda> lista) {
        DefaultTableModel dt;
        dt = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Data", "Produto", "Quantidade", "Valor"
                }) {

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        Object[] linha = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            linha[0] = lista.get(i).getData();
            linha[1] = lista.get(i).getProduto().getNome();
            linha[2] = lista.get(i).getQnt();
            linha[3] = formatador.format(lista.get(i).getQnt() * Double.parseDouble(lista.get(i).getValor().replace(",", ".")));
            dt.addRow(linha);
        }

        jTable2 = new JTable(dt);
        jScrollPane2.setViewportView(jTable2);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setBorder(null);
        jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        TableCellRenderer centerRenderer = new CenterRenderer();
        TableColumn column0 = jTable2.getColumnModel().getColumn(0);
        TableColumn column1 = jTable2.getColumnModel().getColumn(2);
        TableColumn column2 = jTable2.getColumnModel().getColumn(3);

        column0.setCellRenderer(centerRenderer);
        column1.setCellRenderer(centerRenderer);
        column2.setCellRenderer(centerRenderer);

        repaint();
    }

    private void preencherPagamentos(ArrayList<Pagamento> lista) {
        DefaultTableModel dt;
        dt = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Data", "Valor"
                }) {

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        Object[] linha = new Object[2];
        for (int i = 0; i < lista.size(); i++) {
            linha[0] = lista.get(i).getData();
            linha[1] = formatador.format(Double.parseDouble(lista.get(i).getValor().replace(",", ".")));
            dt.addRow(linha);
        }

        jTable3 = new JTable(dt);
        jScrollPane3.setViewportView(jTable3);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setBorder(null);
        jTable3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        TableCellRenderer centerRenderer = new CenterRenderer();
        TableColumn column0 = jTable3.getColumnModel().getColumn(0);
        TableColumn column1 = jTable3.getColumnModel().getColumn(1);
        column0.setCellRenderer(centerRenderer);
        column1.setCellRenderer(centerRenderer);

        repaint();
    }

    public void preencherDados() {
        int linha = jTable1.getSelectedRow();
        if (linha != -1) {
            int idVenda = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            controle.buscaVendaPrazo(idVenda);
            jLabel7.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
            preencherItens(controle.getVendaPrazo().getListVendaDatas());
            jLabel10.setText(formatador.format(Double.parseDouble(controle.getVendaPrazo().getValor().replace(",", "."))));
        } else {
            jLabel7.setText("");
            preencherItens(new ArrayList<ProdutoVenda>());
            jLabel10.setText("");
            preencherPagamentos(new ArrayList<Pagamento>());
        }
    }

    private void buscaDinamica() {
        jTextField1.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
                if (!jTextField1.getText().equals("")) {
                    preencherContas(controle.buscaDinamicaClientes(jTextField1.getText()));
                } else {
                    preencherContas(controle.getListaVenda());
                }
            }
        });

    }

    private void iniciarTela() {
        jLabel7.setText("");
        jLabel10.setText("");
        jLabel12.setText("");
        jLabel14.setText("");
    }

    private void calcular() {
        jLabel12.setText(String.valueOf(formatador.format(pagamento.totalPagamento())));
        restante = String.valueOf(Double.parseDouble(controle.getVendaPrazo().getValor().replace(",", ".")) - pagamento.totalPagamento());
        jLabel14.setText(formatador.format(Double.parseDouble(restante.replace(",", "."))));
    }


    class CenterRenderer extends DefaultTableCellRenderer {

        public CenterRenderer() {
            setHorizontalAlignment(CENTER);
        }
    }
}
