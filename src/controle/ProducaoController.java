/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import fachada.ContasPagar;
import fachada.ControleProducao;
import fachada.Fornecedor;
import fachada.MovimentoCaixa;
import java.util.ArrayList;
import persistencia.ConsultaMovimentoCaixaMySQL;
import persistencia.ConsultaProdutoMySQL;

/**
 *
 * @author Rafael
 */
public class ProducaoController {

    private ArrayList<ControleProducao> producao = new ArrayList<ControleProducao>();
    private String data;

    public ProducaoController() {
    }

    public String finalizarCompra(int tipo, Fornecedor f) {
        ConsultaProdutoMySQL cp = new ConsultaProdutoMySQL();
        ConsultaMovimentoCaixaMySQL cm = new ConsultaMovimentoCaixaMySQL();
        ContasPagar contas = new ContasPagar();
        contas.setDescricao(f.getEmpresa());
        contas.setData(data);
        if (tipo == 0) {
            contas.setStatus(0);
        } else {
            contas.setStatus(1);
            MovimentoCaixa m = new MovimentoCaixa();
            m.setData(data);
            m.setDescricao("Pagamento p/ " + f.getEmpresa());
            cm.cadastrarItemCaixa(m);
        }
        contas.cadastrar();
        for (int i = 0; i < producao.size(); i++) {
//            cp.updateCompra(producao.get(i));
        }
        producao = new ArrayList<ControleProducao>();
        return "Compra finalizada com sucesso";
    }

    public void editar(ControleProducao p, ControleProducao novo) {
        for (int i = 0; i < producao.size(); i++) {
            if (p.getIdProd() == producao.get(i).getIdProd()
                    && p.getQnt() == producao.get(i).getQnt()
                    && producao.get(i).getIdDest() == p.getIdDest()) {
                producao.get(i).setIdDest(novo.getIdDest());
                producao.get(i).setQnt(novo.getQnt());
            }
        }
    }

    public ControleProducao getProduto(int id, int qnt, int origem) {
        ControleProducao p = new ControleProducao();
        for (int i = 0; i < producao.size(); i++) {
            if (producao.get(i).getIdProd() == id
                    && producao.get(i).getQnt() == qnt
                    && producao.get(i).getIdDest() == origem) {
                return producao.get(i);
            }
        }
        return p;
    }

    public void excluir(int id, int qnt, int origem) {
        for (int i = 0; i < producao.size(); i++) {
            if (producao.get(i).getIdProd() == id
                    && producao.get(i).getQnt() == qnt
                    && producao.get(i).getIdDest() == origem) {
                producao.remove(i);
            }
        }
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ArrayList<ControleProducao> getProducao() {
        return producao;
    }

    public void setProducao(ArrayList<ControleProducao> producao) {
        this.producao = producao;
    }
}
