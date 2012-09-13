/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pqserver;

//import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import controle.ProdutoController;
import java.awt.Component;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import visao.JDialogQntMinima;
import visao.JFramePrincipal;

/**
 *
 * @author Rafael
 */
public class PqServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
//        Theme.loadTheme(Theme.getAvailableThemes()[2]);
        //  TinyLookAndFeel tiny = new TinyLookAndFeel();
        //   SyntheticaAluOxideLookAndFeel syntetica = new SyntheticaAluOxideLookAndFeel();
        try {
            UIManager.setLookAndFeel(new com.jtattoo.plaf.acryl.AcrylLookAndFeel());
            // UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());

        } catch (Exception exception) {
        }
        Locale l = new Locale("pt", "br");
        Locale.setDefault(l);
        JFramePrincipal principal = new JFramePrincipal();
        checarEstoqueMinimo();
        principal.setVisible(true);
    }

    public static void checarEstoqueMinimo() {
        new Thread(new Runnable() {
            ProdutoController a = new ProdutoController();
            String nome;
            ArrayList<String> aux = new ArrayList<String>();

            @Override
            public void run() {
                boolean controle = false;
                while (true) {
                    try {
                        a.buscarProdutos();
                        //Aqui implementacao, usar arraylist string para controlar quais itens estao na lista
                        if (a.getProdsQntMinima().size() > aux.size()) {
                            aux = a.getProdsQntMinima();
                            controle = true         ;
                        } else if (a.getProdsQntMinima().size() < aux.size()) {
                            aux = new ArrayList<String>();
                            aux = a.getProdsQntMinima();
                        }

                        if (controle) {
                            controle = false;
                            if (!aux.isEmpty()) {
                                JDialogQntMinima dialog = new JDialogQntMinima(null, true);
                                dialog.setVisible(true);
                            }                         //Dialog 
                        }

                        Thread.sleep(3000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PqServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }
}
