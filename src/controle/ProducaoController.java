/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import fachada.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import persistencia.ConsultaControleProducaoMySQL;
import persistencia.ConsultaProdutoMySQL;

/**
 *
 * @author Rafael
 */
public class ProducaoController {

    private ArrayList<ControleProducao> producao = new ArrayList<ControleProducao>();
    private String data;
    DecimalFormat formatador = new DecimalFormat("###0.00");

    public ProducaoController() {
    }

    public String finalizarEntrada() {
        ConsultaProdutoMySQL cp = new ConsultaProdutoMySQL();
        ConsultaControleProducaoMySQL con = new ConsultaControleProducaoMySQL();
        for (int i = 0; i < producao.size() - 1; i++) {
            for (int j = i + 1; j < producao.size(); j++) {
                if (producao.get(i).getIdProd() == producao.get(j).getIdProd()
                        && producao.get(i).getIdDest() == producao.get(j).getIdDest()) {
                    producao.get(j).setQnt(producao.get(i).getQnt() + producao.get(j).getQnt());
                    Double preco = Double.parseDouble(producao.get(j).getValor().replace(",", ".")) + Double.parseDouble(producao.get(i).getValor().replace(",", "."));
                    producao.get(j).setValor(formatador.format(preco));
                    producao.remove(i);
                    j--;
                }
            }
        }
        for (int i = 0; i < producao.size(); i++) {
            cp.updateEntrada(producao.get(i));
            String valor = con.buscaHistoricoSaidaProdutosIguais(producao.get(i));
            if (valor.equals("n")) {
                con.insertHistoricoProducao(producao.get(i));
            } else {
                Double preco = Double.parseDouble(producao.get(i).getValor().replace(",", ".")) + Double.parseDouble(valor);
                producao.get(i).setValor(formatador.format(preco));
                con.updateHistoricoProducao(producao.get(i));
            }
        }
        producao = new ArrayList<ControleProducao>();
        return "Lançamento realizado com sucesso.";
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
