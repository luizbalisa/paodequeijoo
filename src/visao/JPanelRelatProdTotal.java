/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.HistoricoSaidaController;
import controle.ProdutoController;
import fachada.Cliente;
import fachada.HistoricoSaidaProduto;
import fachada.Produto;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author miserani
 */
public class JPanelRelatProdTotal extends javax.swing.JPanel {
    private HistoricoSaidaController historico = new HistoricoSaidaController();
    private String data;
    /**
     * Creates new form JPanelRelatProdTotal
     */
    public JPanelRelatProdTotal(String data) {
        initComponents();
        this.data = data;
        this.preencherTabela();
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

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome Produto", "Quantidade", "Valor Total"
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

    private void preencherTabela(){      
        historico.buscarHistorico();
        DefaultTableModel dt;
        dt = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Nome Produto", "Quantidade", "Valor Total"
                }) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        Object[] linha = new Object[3];
        ProdutoController p = new ProdutoController();
        ArrayList<HistoricoSaidaProduto> listaProduto = historico.getHistoricoDia(this.data);
        for (int i = 0; i < listaProduto.size(); i++) {
            p.getProduto(listaProduto.get(i).getIdProduto());
            linha[0] = p.getProduto().getNome();
            linha[1] = listaProduto.get(i).getQuantidade();
            linha[2] = valorTotal(listaProduto.get(i).getQuantidade(), listaProduto.get(i).getPreco_venda());
            dt.addRow(linha);
        }

        jTable2 = new JTable(dt);
        jTable2.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable2.getColumnModel().getColumn(0).setMinWidth(0);
        jTable2.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        jTable2.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        jScrollPane2.setViewportView(jTable2);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setBorder(null);
        jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        repaint();
    
    }
    
    private String valorTotal(int qnt,String valor){
        return String.valueOf(qnt*Double.parseDouble(valor));
    }
}
