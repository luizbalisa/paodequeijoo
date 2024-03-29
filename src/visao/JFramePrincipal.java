/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Rafael
 */
public class JFramePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JFramePrincipal
     */
    public JFramePrincipal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        JDialogLogin l = new JDialogLogin(this, rootPaneCheckingEnabled);
        l.setVisible(true);
        dinamismo();
    }

    public void menuGerenciar(int aba) {
        jPanel2.removeAll();
        jPanel2.add(new JPanelMenuGerenciarDados(this, aba));
        jPanel2.validate();
        repaint();
    }

    public void contasPagar() {
        jPanel2.removeAll();
        jPanel2.add(new JPanelContasPagar());
        jPanel2.validate();
        repaint();
    }

    public void menuRelatórios() {
        jPanel2.removeAll();
        jPanel2.add(new JPanelMenuRelatorios(this));
        jPanel2.validate();
        repaint();
    }

    public void gerenciarClientes(int tipo, int idCliente) {
        jPanel2.removeAll();
        jPanel2.add(new JPanelGerenciarCliente(this, tipo, idCliente));
        jPanel2.validate();
        repaint();
    }

    public void gerenciarFornecedores(int tipo, int idCliente) {
        jPanel2.removeAll();
        jPanel2.add(new JPanelGerenciarFornecedor(this, tipo, idCliente));
        jPanel2.validate();
        repaint();
    }

    public void editarCliente(int idCliente) {
        jPanel2.removeAll();
        jPanel2.add(new JPanelGerenciarCliente(this, 2, idCliente));
        jPanel2.validate();
        repaint();
    }

    public void contasReceber(int idCliente) {
        jPanel2.removeAll();
        jPanel2.add(new JPanelContasReceber(this));
        jPanel2.validate();
        repaint();
    }

    public void contasReceber() {
        jPanel2.removeAll();
        jPanel2.add(new JPanelContasReceber(this));
        jPanel2.validate();
        repaint();
    }

    public void comprar() {
        jPanel2.removeAll();
        jPanel2.add(new JPanelCompra(this));
        jPanel2.validate();
        repaint();
    }

    public void producao() {
        jPanel2.removeAll();
        jPanel2.add(new JPanelProducao(this));
        jPanel2.validate();
        repaint();
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
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pão de Queijo - Servidor");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagem/HomeServer.png")));
        setMinimumSize(new java.awt.Dimension(800, 600));

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jButton2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Setting-Folder-Ash-icon.png"))); // NOI18N
        jButton2.setText("<html><font color = white>Gerenciar Dados</font></html>");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusPainted(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Misc-Stats-icon.png"))); // NOI18N
        jButton3.setText("<html><font color = white>Relatórios</font></html>");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusPainted(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/payment-icon.png"))); // NOI18N
        jButton4.setText("<html><font color = white>Contas a receber</font></html>");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusPainted(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Cash-register-icon.png"))); // NOI18N
        jButton6.setText("<html><font color = white>Contas a pagar</font></html>");
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setFocusPainted(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/wallet-icon.png"))); // NOI18N
        jButton7.setText("<html><font color = white>Comprar</font></html>");
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setFocusPainted(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/options-icon.png"))); // NOI18N
        jButton8.setText("<html><font color = white>Lançar produção</font></html>");
        jButton8.setBorder(null);
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setFocusPainted(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton8)
                    .addComponent(jButton7)
                    .addComponent(jButton6)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        menuGerenciar(0);    // TODO add your handling code here:
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        menuRelatórios();        // TODO add your handling code here:
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        contasReceber();
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        contasPagar();
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        comprar();
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        producao();
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jButton8ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    private void dinamismo() {
        jButton2.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jButton2.setIcon(new ImageIcon(getClass().getResource("/imagem/Setting-Folder-Ash-icon2.png")));
                jButton2.setText("<html><font color = blue>Gerenciar Dados</font></html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jButton2.setIcon(new ImageIcon(getClass().getResource("/imagem/Setting-Folder-Ash-icon.png")));
                jButton2.setText("<html><font color = white>Gerenciar Dados</font></html>");
            }
        });


        jButton3.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jButton3.setIcon(new ImageIcon(getClass().getResource("/imagem/Misc-Stats-icon2.png")));
                jButton3.setText("<html><font color = blue>Relatórios</font></html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jButton3.setIcon(new ImageIcon(getClass().getResource("/imagem/Misc-Stats-icon.png")));
                jButton3.setText("<html><font color = white>Relatórios</font></html>");
            }
        });
        jButton4.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jButton4.setIcon(new ImageIcon(getClass().getResource("/imagem/payment-icon-1.png")));
                jButton4.setText("<html><font color = blue>Contas a receber</font></html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jButton4.setIcon(new ImageIcon(getClass().getResource("/imagem/payment-icon.png")));
                jButton4.setText("<html><font color = white>Contas a receber</font></html>");
            }
        });
        jButton6.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jButton6.setIcon(new ImageIcon(getClass().getResource("/imagem/Cash-register-icon2.png")));
                jButton6.setText("<html><font color = blue>Contas a pagar</font></html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jButton6.setIcon(new ImageIcon(getClass().getResource("/imagem/Cash-register-icon.png")));
                jButton6.setText("<html><font color = white>Contas a pagar</font></html>");
            }
        });
        jButton7.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jButton7.setIcon(new ImageIcon(getClass().getResource("/imagem/wallet-icon-1.png")));
                jButton7.setText("<html><font color = blue>Comprar</font></html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jButton7.setIcon(new ImageIcon(getClass().getResource("/imagem/wallet-icon.png")));
                jButton7.setText("<html><font color = white>Comprar</font></html>");
            }
        });
        jButton8.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jButton8.setIcon(new ImageIcon(getClass().getResource("/imagem/options-icon-1.png")));
                jButton8.setText("<html><font color = blue>Lançar Produção</font></html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jButton8.setIcon(new ImageIcon(getClass().getResource("/imagem/options-icon.png")));
                jButton8.setText("<html><font color = white>Lançar Produção</font></html>");
            }
        });
    }
}
