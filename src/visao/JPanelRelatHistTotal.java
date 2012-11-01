/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.HistSaidaProdutoMPController;
import controle.HistoricoSaidaProdutoController;
import controle.ProdutoController;
import controle.RelatoriosController;
import fachada.HistSaidaProdutoMP;
import fachada.HistoricoSaidaProduto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
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
public class JPanelRelatHistTotal extends javax.swing.JPanel {

    private HistSaidaProdutoMPController historico = new HistSaidaProdutoMPController();
    private String dataI;
    private String dataF;
    private int tipo;
    DecimalFormat formatador = new DecimalFormat("###0.00");

    /**
     * Creates new form JPanelRelatProdTotal
     */
    public JPanelRelatHistTotal(String dataInicio, String dataFim, int t) {
        initComponents();

        dinamismo();
        this.tipo = t;
        if (tipo == 0) {//data
            this.dataI = dataInicio;
            historico.buscarHistoricoSomadoDia(dataI);
            historico.getHistoricoDia(this.dataI, jComboBox1.getSelectedIndex());
            this.preencherTabela(historico.getListaDatas());
        } else {//periodo
            this.dataI = dataInicio;
            this.dataF = dataFim;
            historico.buscarHistoricoSomadoPeriodo(dataI, dataFim);
            historico.getHistoricoData(this.dataI, this.dataF, jComboBox1.getSelectedIndex());
            this.preencherTabela(historico.getListaDatas());
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome Produto", "Quantidade", "Receita"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jTextField1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/magnifier.png"))); // NOI18N
        jLabel1.setText("Buscar produto: ");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Ver: ");

        jComboBox1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Cozinha de salgados", "Cozinha de refeições", "Balcão" }));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("jLabel5");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Custo total: ");

        jButton1.setText("Gerar relatório");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jButton1))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        RelatoriosController r = new RelatoriosController();
        r.criarDocumento(0);
        String[] colunas = new String[]{"Nome Produto", "Destino", "Quantidade", "Custo"};
        r.relatorioSaidaEstoqueDataPeriodo(colunas, jTable2, jComboBox1.getSelectedItem().toString(), dataI, dataF, jLabel3.getText());
        r.fecharDocumento();
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void preencherTabela(ArrayList<HistSaidaProdutoMP> listaProduto) {
        DefaultTableModel dt;
        dt = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Nome Produto", "Destino", "Quantidade", "Custo"
                }) {

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        Object[] linha = new Object[4];
        ProdutoController p = new ProdutoController();
        p.buscarProdutosSaida();
        for (int i = 0; i < listaProduto.size(); i++) {
            p.getProduto(listaProduto.get(i).getIdProd());
            linha[0] = p.getProduto().getNome();
            if (listaProduto.get(i).getIdDest() == 1) {
                linha[1] = "Cozinha de salgados";
            } else if (listaProduto.get(i).getIdDest() == 2) {
                linha[1] = "Cozinha de refeições";
            } else {
                linha[1] = "Balcão";
            }
            linha[2] = listaProduto.get(i).getQnt();
            linha[3] = formatador.format(Double.parseDouble(valorTotal(listaProduto.get(i).getQnt(), listaProduto.get(i).getPreco().replaceAll(",", "."))));
            dt.addRow(linha);
        }

        jTable2 = new JTable(dt);
        jScrollPane2.setViewportView(jTable2);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setBorder(null);
        jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable2.getColumnModel().getColumn(1).setMaxWidth(200);
        jTable2.getColumnModel().getColumn(1).setMinWidth(200);
        jTable2.getColumnModel().getColumn(2).setMaxWidth(80);
        jTable2.getColumnModel().getColumn(2).setMinWidth(80);
        jTable2.getColumnModel().getColumn(3).setMaxWidth(100);
        jTable2.getColumnModel().getColumn(3).setMinWidth(100);
        TableCellRenderer centerRenderer = new CenterRenderer();
        TableColumn column0 = jTable2.getColumnModel().getColumn(2);
        TableColumn column1 = jTable2.getColumnModel().getColumn(3);
        column0.setCellRenderer(centerRenderer);
        column1.setCellRenderer(centerRenderer);


        jLabel3.setText(String.valueOf(formatador.format(getReceitaTotal(listaProduto))));


        repaint();

    }

    private void dinamismo() {
        jComboBox1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText("");
                if (tipo == 0) {//dia
                    historico.getHistoricoDia(dataI, jComboBox1.getSelectedIndex());
                    preencherTabela(historico.getListaDatas());
                } else {//periodo
                    historico.getHistoricoData(dataI, dataF, jComboBox1.getSelectedIndex());
                    preencherTabela(historico.getListaDatas());
                }
            }
        });
        jTextField1.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {

                if (!jTextField1.getText().equals("")) {
                    preencherTabela(historico.buscaDimamicaData(jTextField1.getText()));
                } else {
                    preencherTabela(historico.getListaDatas());
                }

            }
        });
    }

    private String valorTotal(int qnt, String valor) {
        return String.valueOf(qnt * Double.parseDouble(valor));
    }

    public double getReceitaTotal(ArrayList<HistSaidaProdutoMP> listaProduto) {
        double soma = 0;
        for (int i = 0; i < listaProduto.size(); i++) {
            soma += (listaProduto.get(i).getQnt() * Double.parseDouble(listaProduto.get(i).getPreco().replace(",", ".")));
        }
        return soma;
    }

    class CenterRenderer extends DefaultTableCellRenderer {

        public CenterRenderer() {
            setHorizontalAlignment(CENTER);
        }
    }
}
