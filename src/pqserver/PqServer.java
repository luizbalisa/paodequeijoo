/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pqserver;

//import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import java.awt.Component;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
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

            public void run() {
                boolean controle = true;
                while (true) {
                    try {
                        //Aqui implementacao, usar arraylist string para controlar quais itens estao na lista
                        if (controle) {
                            controle = false;
                            //Dialog 
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
