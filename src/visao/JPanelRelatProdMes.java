/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.HistoricoSaidaProdutoController;
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
public class JPanelRelatProdMes extends javax.swing.JPanel {

    HistoricoSaidaProdutoController controle = new HistoricoSaidaProdutoController();
    int m, a;
    DecimalFormat formatador = new DecimalFormat("###0.00");

    /**
     * Creates new form JPanelRelatProdMes
     */
    public JPanelRelatProdMes(int mes, int ano) {
        initComponents();
        m = mes;
        a = ano;
        controle.buscarHistorico();
        controle.colunasHistoricoMes(mes, ano, -1);
        preencherHistorico(controle.getListaMes());
        buscaDinamica();
        jTextField1.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título 1", "Título 2", "Título 3", "Título 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/magnifier.png"))); // NOI18N
        jLabel1.setText("Buscar produto: ");

        jTextField1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jComboBox1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Produzido", "Atacado" }));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Ver: ");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Receita total:");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("jLabel5");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1)
            .add(layout.createSequentialGroup()
                .addContainerGap(725, Short.MAX_VALUE)
                .add(jLabel4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel3)
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTextField1)
                .add(18, 18, 18)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 155, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2)
                    .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jLabel4))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void preencherHistorico(ArrayList<String[]> lista) {
        DefaultTableModel dt;
        dt = new DefaultTableModel(
                new Object[][]{},
                controle.getColunasMes()) {

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        Object[] linha = new Object[controle.getColunasMes().length];
        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < linha.length; j++) {
                linha[j] = String.valueOf(lista.get(i)[j]);
            }
            linha[linha.length - 1] = formatador.format(Double.parseDouble(linha[linha.length - 1].toString().replace(",", ".")));
            dt.addRow(linha);
        }


        jTable1 = new JTable(dt);
        jScrollPane1.setViewportView(jTable1);
        jScrollPane1.setBorder(null);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        TableCellRenderer centerRenderer = new CenterRenderer();
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(linha.length - 1).setMaxWidth(100);
        jTable1.getColumnModel().getColumn(linha.length - 1).setMinWidth(100);

        TableColumn column = jTable1.getColumnModel().getColumn(linha.length - 1);
        column.setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(linha.length - 2).setMaxWidth(50);
        jTable1.getColumnModel().getColumn(linha.length - 2).setMinWidth(50);
        column = jTable1.getColumnModel().getColumn(linha.length - 2);
        column.setCellRenderer(centerRenderer);

        for (int i = 1; i < linha.length - 2; i++) {
            jTable1.getColumnModel().getColumn(i).setMaxWidth(40);
            jTable1.getColumnModel().getColumn(i).setMinWidth(40);
            column = jTable1.getColumnModel().getColumn(i);
            column.setCellRenderer(centerRenderer);
        }
        jLabel3.setText(String.valueOf(formatador.format(getReceitaTotal(lista))));

    }

    private void buscaDinamica() {
        jTextField1.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
                if (!jTextField1.getText().equals("")) {
                    preencherHistorico(controle.buscaDinamicaMes(jTextField1.getText()));
                } else {
                    preencherHistorico(controle.getListaMes());
                }
            }
        });
        jComboBox1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText("");
                controle.colunasHistoricoMes(m, a, jComboBox1.getSelectedIndex() - 1);
                preencherHistorico(controle.getListaMes());
            }
        });
    }

    public double getReceitaTotal(ArrayList<String[]> lista) {
        double soma = 0;
        for (int i = 0; i < lista.size(); i++) {
            soma += Double.parseDouble(lista.get(i)[lista.get(i).length - 1].replace(",", "."));
        }
        return soma;
    }
}

class CenterRenderer extends DefaultTableCellRenderer {

    public CenterRenderer() {
        setHorizontalAlignment(CENTER);
    }
}
