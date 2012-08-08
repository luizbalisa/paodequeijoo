/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pqserver;

import de.muntjak.tinylookandfeel.Theme;
import de.muntjak.tinylookandfeel.TinyLookAndFeel;
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
    public static void main(String[] args) {
        Theme.loadTheme(Theme.getAvailableThemes()[2]);
        TinyLookAndFeel tiny = new TinyLookAndFeel();
        try {
            System.out.println(tiny.getDescription() + "t");
            UIManager.setLookAndFeel(tiny);

        } catch (Exception exception) {
        }
        JFramePrincipal principal = new JFramePrincipal();
        principal.setVisible(true);
    }
}
