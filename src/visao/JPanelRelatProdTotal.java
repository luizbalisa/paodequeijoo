/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.HistoricoSaidaController;
import controle.ProdutoController;
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
public class JPanelRelatProdTotal extends javax.swing.JPanel {

    private HistoricoSaidaController historico = new HistoricoSaidaController();
    private String dataI;
    private String dataF;
    private int tipo;
    DecimalFormat formatador = new DecimalFormat("###0.00");

    /**
     * Creates new form JPanelRelatProdTotal
     */
    public JPanelRelatProdTotal(String dataInicio, String dataFim, int t) {
        initComponents();
        historico.buscarHistoricoSomado();
        dinamismo();
        this.tipo = t;
        if (tipo == 0) {
            this.dataI = dataInicio;
            historico.getHistoricoDia(this.dataI, jComboBox1.getSelectedIndex() - 1);
            this.preencherTabela(historico.getListaDatas());
        } else {
            this.dataI = dataInicio;
            this.dataF = dataFim;
            historico.getHistoricoData(this.dataI, this.dataF, jComboBox1.getSelectedIndex() - 1);
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

        jLabel1.setText("Buscar produto: ");

        jLabel2.setText("Ver: ");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Produzido", "Atacado" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(1, 1, 1)
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE))
                .addContainerGap())
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void preencherTabela(ArrayList<HistoricoSaidaProduto> listaProduto) {
        DefaultTableModel dt;
        dt = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Nome Produto", "Quantidade", "Receita"
                }) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        Object[] linha = new Object[3];
        ProdutoController p = new ProdutoController();

        p.buscarProdutosHist();
        for (int i = 0; i < listaProduto.size(); i++) {
            p.getProduto(listaProduto.get(i).getIdProduto());
            if (p.getProduto().getCategoria() != 2) {
                linha[0] = p.getProduto().getNome();
                linha[1] = listaProduto.get(i).getQuantidade();
                linha[2] = formatador.format(Double.parseDouble(valorTotal(listaProduto.get(i).getQuantidade(), listaProduto.get(i).getPreco_venda().replaceAll(",", "."))));
                dt.addRow(linha);
            }
        }

        jTable2 = new JTable(dt);
        jScrollPane2.setViewportView(jTable2);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setBorder(null);
        jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        TableCellRenderer centerRenderer = new CenterRenderer();
        TableColumn column0 = jTable2.getColumnModel().getColumn(1);
        TableColumn column1 = jTable2.getColumnModel().getColumn(2);
        column0.setCellRenderer(centerRenderer);
        column1.setCellRenderer(centerRenderer);

        repaint();

    }

    private void preencherTabelaAtacado(ArrayList<HistoricoSaidaProduto> listaProduto) {
        DefaultTableModel dt;
        dt = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Nome Produto", "Quantidade", "Custo Total", "Receita Total", "% de Lucro"
                }) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        Object[] linha = new Object[5];
        ProdutoController p = new ProdutoController();
        p.buscarProdutosHist();
        for (int i = 0; i < listaProduto.size(); i++) {
            p.getProduto(listaProduto.get(i).getIdProduto());
            if (p.getProduto().getCategoria() != 2) {
                linha[0] = p.getProduto().getNome();
                linha[1] = listaProduto.get(i).getQuantidade();
                linha[2] = formatador.format(Double.parseDouble(custoTotalReceita(listaProduto.get(i).getQuantidade(), listaProduto.get(i).getPreco_custo().replace(",", "."))));
                linha[3] = formatador.format(Double.parseDouble(custoTotalReceita(listaProduto.get(i).getQuantidade(), listaProduto.get(i).getPreco_venda().replace(",", "."))));
                linha[4] = formatador.format(Double.parseDouble(porcentoLucro(listaProduto.get(i).getPreco_custo().replace(",", "."), listaProduto.get(i).getPreco_venda(), listaProduto.get(i).getQuantidade()).replace(",", ".")));
                dt.addRow(linha);
            }
        }

        jTable2 = new JTable(dt);
        jScrollPane2.setViewportView(jTable2);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setBorder(null);
        jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        TableCellRenderer centerRenderer = new CenterRenderer();
        TableColumn column0 = jTable2.getColumnModel().getColumn(1);
        TableColumn column1 = jTable2.getColumnModel().getColumn(2);
        TableColumn column2 = jTable2.getColumnModel().getColumn(3);
        TableColumn column3 = jTable2.getColumnModel().getColumn(4);
        column0.setCellRenderer(centerRenderer);
        column1.setCellRenderer(centerRenderer);
        column2.setCellRenderer(centerRenderer);
        column3.setCellRenderer(centerRenderer);

        repaint();
    }

    private void dinamismo() {
        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText("");
                if (tipo == 0) {
                    historico.getHistoricoDia(dataI, jComboBox1.getSelectedIndex() - 1);
                    if (jComboBox1.getSelectedIndex() == 2) {
                        preencherTabelaAtacado(historico.getListaDatas());
                    } else {
                        preencherTabela(historico.getListaDatas());
                    }
                } else {
                    if (jComboBox1.getSelectedIndex() == 2) {
                        historico.getHistoricoData(dataI, dataF, jComboBox1.getSelectedIndex() - 1);
                        preencherTabelaAtacado(historico.getListaDatas());
                    }else{
                        preencherTabela(historico.getListaDatas());
                    }
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

                if (jComboBox1.getSelectedIndex() == 2) {
                    if (!jTextField1.getText().equals("")) {
                        preencherTabelaAtacado(historico.buscaDimamicaData(jTextField1.getText()));
                    } else {
                        preencherTabelaAtacado(historico.getListaDatas());
                    }
                } else {
                    if (!jTextField1.getText().equals("")) {
                        preencherTabela(historico.buscaDimamicaData(jTextField1.getText()));
                    } else {
                        preencherTabela(historico.getListaDatas());
                    }
                }

            }
        });
    }

    private String valorTotal(int qnt, String valor) {
        return String.valueOf(qnt * Double.parseDouble(valor));
    }

    private String custoTotalReceita(int qnt, String valor) {
        return String.valueOf(qnt * Double.parseDouble(valor));
    }

    private String porcentoLucro(String valor1, String valor2, int qnt) {
        double custoQnt = Double.parseDouble(valor1.replace(",", ".")) * qnt;
        double vendQnt = Double.parseDouble(valor2.replace(",", ".")) * qnt;
        double lucroReal = (vendQnt / custoQnt);

        return String.valueOf((lucroReal -1)*100);
    }

    class CenterRenderer extends DefaultTableCellRenderer {

        public CenterRenderer() {
            setHorizontalAlignment(CENTER);
        }
    }
}
