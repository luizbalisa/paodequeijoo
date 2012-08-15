/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import fachada.MovimentoCaixa;
import java.util.ArrayList;
import persistencia.ConsultaMySQLMovimentoCaixa;

/**
 *
 * @author Guil
 */
public class MovimentoDeCaixaController {
    MovimentoCaixa mC = new MovimentoCaixa();
    ArrayList<MovimentoCaixa> listaMC = new ArrayList<MovimentoCaixa>();
    
    public void inserirNoCaixa(MovimentoCaixa mCaixa){
        ConsultaMySQLMovimentoCaixa consulta = new ConsultaMySQLMovimentoCaixa();
        consulta.cadastrarItemCaixa(mCaixa);
    }

    public MovimentoCaixa getmC() {
        return mC;
    }

    public void setmC(MovimentoCaixa mV) {
        this.mC = mV;
    }
    
    public void buscarMCaixa(){
        ConsultaMySQLMovimentoCaixa consulta = new ConsultaMySQLMovimentoCaixa();
        this.listaMC =  consulta.buscarItensNoCaixa();
    }

    public ArrayList<MovimentoCaixa> getListaMC() {
        return listaMC;
    }

    public void setListaM(ArrayList<MovimentoCaixa> listaMC) {
        this.listaMC = listaMC;
    }
            
    public void getmC(int id){
        for (int i = 0; i < this.listaMC.size(); i++) {
            if(this.listaMC.get(i).getIdMovimentoCaixa() == id){
                this.mC = this.listaMC.get(i);
            }
        }
    }
    
}
