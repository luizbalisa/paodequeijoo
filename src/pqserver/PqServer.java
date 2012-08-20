/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pqserver;


//import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import de.muntjak.tinylookandfeel.Theme;
import de.muntjak.tinylookandfeel.TinyLookAndFeel;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.synth.SynthLookAndFeel;
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
        Theme.loadTheme(Theme.getAvailableThemes()[2]);
//        TinyLookAndFeel tiny = new TinyLookAndFeel();
//        SyntheticaAluOxideLookAndFeel syntetica = new SyntheticaAluOxideLookAndFeel();
        try {
            UIManager.setLookAndFeel(new com.jtattoo.plaf.acryl.AcrylLookAndFeel());
//            UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());

        } catch (Exception exception) {
            
        }
        JFramePrincipal principal = new JFramePrincipal();
        principal.setVisible(true);
    }
}
