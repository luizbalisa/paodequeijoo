/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Desktop;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author Rafael
 */
public class RelatoriosController {

    DecimalFormat formatador = new DecimalFormat("###0.00");
    Document documento;

    public RelatoriosController() {
    }

    public void relatorioSaidaEstoqueMes(String[] colunas, JTable tabela, String destino, String data, String total) {
        Table t;
        try {
            t = new Table(1, 1);
            t.setPadding(3);
            t.setBorderColor(Color.white);
            int headerwidths2[] = {100};
            t.setWidths(headerwidths2);
            t.setWidth(100);
            Paragraph title1 = new Paragraph();
            title1.add(new Paragraph("\nRELATÓRIO DE SAÍDA DE ESTOQUE\n", FontFactory.getFont(FontFactory.TIMES, 14, Font.BOLD)));
            Cell c1 = new Cell(title1);
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setVerticalAlignment(Element.ALIGN_CENTER);
            c1.setBorderColor(Color.white);
            t.addCell(c1);
            documento.add(t);
            title1 = new Paragraph();
            String aux[] = data.split(" ");
            title1.add(new Paragraph("Referente a " + mes(Integer.parseInt(aux[0])) + "/" + aux[1] + "\nDestino: " + destino, FontFactory.getFont(FontFactory.TIMES, 14, Font.NORMAL)));
            documento.add(title1);
            ArrayList<String[]> dados = jtableParaArray(tabela);
            int[][] col = tamanhoColunas(colunas);
            if (col.length > 1) {
                int impar = colunas.length % 2;
                int headerwidths3[] = col[0];
                t = new Table(((colunas.length) / 2) + impar);
                t.setWidths(headerwidths3);
                t.setWidth(100);
                t.setPadding(3);
                t.setBorderWidth((float) 0.5);
                for (int i = 0; i < ((colunas.length) / 2) + impar; i++) {
                    title1 = new Paragraph(colunas[i], FontFactory.getFont(FontFactory.TIMES, 14, Font.BOLD));
                    c1 = new Cell(title1);
                    c1.setVerticalAlignment(Element.ALIGN_CENTER);
                    if (i != 0) {
                        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    }
                    c1.setHeader(true);
                    t.addCell(c1);
                }

                t.endHeaders();
                for (int i = 0; i < dados.size(); i++) {
                    for (int j = 0; j < ((colunas.length) / 2) + impar; j++) {
                        title1 = new Paragraph(dados.get(i)[j], FontFactory.getFont(FontFactory.TIMES, 12, Font.NORMAL));
                        c1 = new Cell(title1);
                        if (j != 0) {
                            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                        }
                        c1.setVerticalAlignment(Element.ALIGN_CENTER);
                        t.addCell(c1);
                    }
                }
                documento.add(t);
                documento.newPage();
                t = new Table(1, 1);
                t.setPadding(3);
                t.setBorderColor(Color.white);
                t.setWidths(headerwidths2);
                t.setWidth(100);
                title1 = new Paragraph();
                title1.add(new Paragraph("RELATÓRIO DE SAÍDA DE ESTOQUE\n", FontFactory.getFont(FontFactory.TIMES, 14, Font.BOLD)));
                c1 = new Cell(title1);
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                c1.setVerticalAlignment(Element.ALIGN_CENTER);
                c1.setBorderColor(Color.white);
                t.addCell(c1);
                documento.add(t);
                title1 = new Paragraph();
                title1.add(new Paragraph("Referente a " + mes(Integer.parseInt(aux[0])) + "/" + aux[1] + "\nDestino: " + destino, FontFactory.getFont(FontFactory.TIMES, 14, Font.NORMAL)));
                documento.add(title1);
                t = new Table(((colunas.length) / 2));
                int auxCol[];
                if (impar == 1) {
                    auxCol = new int[col[1].length - 1];
                    for (int i = 0; i < auxCol.length; i++) {
                        auxCol[i] = col[1][i];
                    }
                } else {
                    auxCol = col[1];
                }
                int headerwidths4[] = auxCol;
                t.setWidths(headerwidths4);
                t.setWidth(100);
                t.setPadding(3);
                t.setBorderWidth((float) 0.5);
                for (int i = ((colunas.length) / 2) + impar; i < 2 * ((colunas.length) / 2) + impar; i++) {
                    title1 = new Paragraph(colunas[i], FontFactory.getFont(FontFactory.TIMES, 14, Font.BOLD));
                    c1 = new Cell(title1);
                    c1.setVerticalAlignment(Element.ALIGN_CENTER);
                    if (i != 0) {
                        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    }
                    c1.setHeader(true);
                    t.addCell(c1);
                }

                t.endHeaders();
                for (int i = 0; i < dados.size(); i++) {
                    for (int j = ((colunas.length) / 2) + impar; j < 2 * ((colunas.length) / 2) + impar; j++) {
                        title1 = new Paragraph(dados.get(i)[j], FontFactory.getFont(FontFactory.TIMES, 12, Font.NORMAL));
                        c1 = new Cell(title1);
                        if (j != 0) {
                            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                        }
                        c1.setVerticalAlignment(Element.ALIGN_CENTER);
                        t.addCell(c1);
                    }
                }
                documento.add(t);
                title1 = new Paragraph();
                title1.add(new Paragraph("Custo total: " + total, FontFactory.getFont(FontFactory.TIMES, 14, Font.NORMAL)));
                title1.setAlignment(Element.ALIGN_RIGHT);
                documento.add(title1);
            } else {
                int headerwidths3[] = col[0];
                t = new Table(colunas.length);
                t.setWidths(headerwidths3);
                t.setWidth(100);
                t.setPadding(3);
                t.setBorderWidth((float) 0.5);
                for (int i = 0; i < colunas.length; i++) {
                    title1 = new Paragraph(colunas[i], FontFactory.getFont(FontFactory.TIMES, 14, Font.BOLD));
                    c1 = new Cell(title1);
                    c1.setVerticalAlignment(Element.ALIGN_CENTER);
                    if (i != 0) {
                        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    }
                    c1.setHeader(true);
                    t.addCell(c1);
                }

                t.endHeaders();
                for (int i = 0; i < dados.size(); i++) {
                    for (int j = 0; j < dados.get(i).length; j++) {
                        title1 = new Paragraph(dados.get(i)[j], FontFactory.getFont(FontFactory.TIMES, 12, Font.NORMAL));
                        c1 = new Cell(title1);
                        if (j != 0) {
                            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                        }
                        c1.setVerticalAlignment(Element.ALIGN_CENTER);
                        t.addCell(c1);
                    }
                }
                documento.add(t);
                title1 = new Paragraph();
                title1.add(new Paragraph("Custo total: " + total, FontFactory.getFont(FontFactory.TIMES, 14, Font.NORMAL)));
                title1.setAlignment(Element.ALIGN_RIGHT);
                documento.add(title1);
            }
        } catch (BadElementException ex) {
            Logger.getLogger(RelatoriosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(RelatoriosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void relatorioProducaoMes(String[] colunas, JTable tabela, String destino, String data, String total) {
        Table t;
        try {
            t = new Table(1, 1);
            t.setPadding(3);
            t.setBorderColor(Color.white);
            int headerwidths2[] = {100};
            t.setWidths(headerwidths2);
            t.setWidth(100);
            Paragraph title1 = new Paragraph();
            title1.add(new Paragraph("\nRELATÓRIO DE PRODUÇÃO\n", FontFactory.getFont(FontFactory.TIMES, 14, Font.BOLD)));
            Cell c1 = new Cell(title1);
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setVerticalAlignment(Element.ALIGN_CENTER);
            c1.setBorderColor(Color.white);
            t.addCell(c1);
            documento.add(t);
            title1 = new Paragraph();
            String aux[] = data.split(" ");
            title1.add(new Paragraph("Referente a " + mes(Integer.parseInt(aux[0])) + "/" + aux[1] + "\nOrigem: " + destino, FontFactory.getFont(FontFactory.TIMES, 14, Font.NORMAL)));
            documento.add(title1);
            ArrayList<String[]> dados = jtableParaArray(tabela);
            int[][] col = tamanhoColunas(colunas);
            if (col.length > 1) {
                int impar = colunas.length % 2;
                int headerwidths3[] = col[0];
                t = new Table(((colunas.length) / 2) + impar);
                t.setWidths(headerwidths3);
                t.setWidth(100);
                t.setPadding(3);
                t.setBorderWidth((float) 0.5);
                for (int i = 0; i < ((colunas.length) / 2) + impar; i++) {
                    title1 = new Paragraph(colunas[i], FontFactory.getFont(FontFactory.TIMES, 14, Font.BOLD));
                    c1 = new Cell(title1);
                    c1.setVerticalAlignment(Element.ALIGN_CENTER);
                    if (i != 0) {
                        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    }
                    c1.setHeader(true);
                    t.addCell(c1);
                }

                t.endHeaders();
                for (int i = 0; i < dados.size(); i++) {
                    for (int j = 0; j < ((colunas.length) / 2) + impar; j++) {
                        title1 = new Paragraph(dados.get(i)[j], FontFactory.getFont(FontFactory.TIMES, 12, Font.NORMAL));
                        c1 = new Cell(title1);
                        if (j != 0) {
                            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                        }
                        c1.setVerticalAlignment(Element.ALIGN_CENTER);
                        t.addCell(c1);
                    }
                }
                documento.add(t);
                documento.newPage();
                t = new Table(1, 1);
                t.setPadding(3);
                t.setBorderColor(Color.white);
                t.setWidths(headerwidths2);
                t.setWidth(100);
                title1 = new Paragraph();
                title1.add(new Paragraph("RELATÓRIO DE PRODUÇÃO\n", FontFactory.getFont(FontFactory.TIMES, 14, Font.BOLD)));
                c1 = new Cell(title1);
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                c1.setVerticalAlignment(Element.ALIGN_CENTER);
                c1.setBorderColor(Color.white);
                t.addCell(c1);
                documento.add(t);
                title1 = new Paragraph();
                title1.add(new Paragraph("Referente a " + mes(Integer.parseInt(aux[0])) + "/" + aux[1] + "\nOrigem: " + destino, FontFactory.getFont(FontFactory.TIMES, 14, Font.NORMAL)));
                documento.add(title1);
                t = new Table(((colunas.length) / 2));
                int auxCol[];
                if (impar == 1) {
                    auxCol = new int[col[1].length - 1];
                    for (int i = 0; i < auxCol.length; i++) {
                        auxCol[i] = col[1][i];
                    }
                } else {
                    auxCol = col[1];
                }
                int headerwidths4[] = auxCol;
                t.setWidths(headerwidths4);
                t.setWidth(100);
                t.setPadding(3);
                t.setBorderWidth((float) 0.5);
                for (int i = ((colunas.length) / 2) + impar; i < 2 * ((colunas.length) / 2) + impar; i++) {
                    title1 = new Paragraph(colunas[i], FontFactory.getFont(FontFactory.TIMES, 14, Font.BOLD));
                    c1 = new Cell(title1);
                    c1.setVerticalAlignment(Element.ALIGN_CENTER);
                    if (i != 0) {
                        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    }
                    c1.setHeader(true);
                    t.addCell(c1);
                }

                t.endHeaders();
                for (int i = 0; i < dados.size(); i++) {
                    for (int j = ((colunas.length) / 2) + impar; j < 2 * ((colunas.length) / 2) + impar; j++) {
                        title1 = new Paragraph(dados.get(i)[j], FontFactory.getFont(FontFactory.TIMES, 12, Font.NORMAL));
                        c1 = new Cell(title1);
                        if (j != 0) {
                            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                        }
                        c1.setVerticalAlignment(Element.ALIGN_CENTER);
                        t.addCell(c1);
                    }
                }
                documento.add(t);
                title1 = new Paragraph();
                title1.add(new Paragraph("Receita total: " + total, FontFactory.getFont(FontFactory.TIMES, 14, Font.NORMAL)));
                title1.setAlignment(Element.ALIGN_RIGHT);
                documento.add(title1);
            } else {
                int headerwidths3[] = col[0];
                t = new Table(colunas.length);
                t.setWidths(headerwidths3);
                t.setWidth(100);
                t.setPadding(3);
                t.setBorderWidth((float) 0.5);
                for (int i = 0; i < colunas.length; i++) {
                    title1 = new Paragraph(colunas[i], FontFactory.getFont(FontFactory.TIMES, 14, Font.BOLD));
                    c1 = new Cell(title1);
                    c1.setVerticalAlignment(Element.ALIGN_CENTER);
                    if (i != 0) {
                        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    }
                    c1.setHeader(true);
                    t.addCell(c1);
                }

                t.endHeaders();
                for (int i = 0; i < dados.size(); i++) {
                    for (int j = 0; j < dados.get(i).length; j++) {
                        title1 = new Paragraph(dados.get(i)[j], FontFactory.getFont(FontFactory.TIMES, 12, Font.NORMAL));
                        c1 = new Cell(title1);
                        if (j != 0) {
                            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                        }
                        c1.setVerticalAlignment(Element.ALIGN_CENTER);
                        t.addCell(c1);
                    }
                }
                documento.add(t);
                title1 = new Paragraph();
                title1.add(new Paragraph("Receita total: " + total, FontFactory.getFont(FontFactory.TIMES, 14, Font.NORMAL)));
                title1.setAlignment(Element.ALIGN_RIGHT);
                documento.add(title1);
            }
        } catch (BadElementException ex) {
            Logger.getLogger(RelatoriosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(RelatoriosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void relatorioSaidaEstoqueDataPeriodo(String[] colunas, JTable tabela, String destino, String dataI, String dataF, String total) {
        Table t;
        try {
            t = new Table(1, 1);
            t.setPadding(3);
            t.setBorderColor(Color.white);
            int headerwidths2[] = {100};
            t.setWidths(headerwidths2);
            t.setWidth(100);
            Paragraph title1 = new Paragraph();
            title1.add(new Paragraph("\nRELATÓRIO DE SAÍDA DE ESTOQUE\n", FontFactory.getFont(FontFactory.TIMES, 14, Font.BOLD)));
            Cell c1 = new Cell(title1);
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setVerticalAlignment(Element.ALIGN_CENTER);
            c1.setBorderColor(Color.white);
            t.addCell(c1);
            documento.add(t);
            title1 = new Paragraph();
            if (dataF == null || dataF.equals("")) {
                title1.add(new Paragraph("Referente a " + dataI + "\nDestino: " + destino, FontFactory.getFont(FontFactory.TIMES, 14, Font.NORMAL)));
            } else {
                title1.add(new Paragraph("Referente ao período de " + dataI + " a " + dataF + "\nDestino: " + destino, FontFactory.getFont(FontFactory.TIMES, 14, Font.NORMAL)));
            }
            documento.add(title1);
            ArrayList<String[]> dados = jtableParaArray(tabela);
            int col = colunas.length;
            int headerwidths3[] = {50, 20, 20, 10};
            if (!destino.equals("Todos")) {
                headerwidths3 = new int[3];
                headerwidths3[0] = 70;
                headerwidths3[1] = 20;
                headerwidths3[2] = 10;
                col--;
            }
            t = new Table(col);
            t.setWidths(headerwidths3);
            t.setWidth(100);
            t.setPadding(3);
            t.setBorderWidth((float) 0.5);
            for (int i = 0; i < colunas.length; i++) {
                if (i != 1 || destino.equals("Todos")) {
                    title1 = new Paragraph(colunas[i], FontFactory.getFont(FontFactory.TIMES, 14, Font.BOLD));
                    c1 = new Cell(title1);
                    c1.setVerticalAlignment(Element.ALIGN_CENTER);
                    if (i != 0) {
                        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    }
                    c1.setHeader(true);
                    t.addCell(c1);
                }
            }

            t.endHeaders();
            for (int i = 0; i < dados.size(); i++) {
                for (int j = 0; j < dados.get(i).length; j++) {
                    if (j != 1 || destino.equals("Todos")) {
                        title1 = new Paragraph(dados.get(i)[j], FontFactory.getFont(FontFactory.TIMES, 12, Font.NORMAL));
                        c1 = new Cell(title1);
                        if (j != 0) {
                            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                        }
                        c1.setVerticalAlignment(Element.ALIGN_CENTER);
                        t.addCell(c1);
                    }
                }
            }
            documento.add(t);
            title1 = new Paragraph();
            title1.add(new Paragraph("Custo total: " + total, FontFactory.getFont(FontFactory.TIMES, 14, Font.NORMAL)));
            title1.setAlignment(Element.ALIGN_RIGHT);
            documento.add(title1);
        } catch (BadElementException ex) {
            Logger.getLogger(RelatoriosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(RelatoriosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void relatorioProducaoDataPeriodo(String[] colunas, JTable tabela, String destino, String dataI, String dataF, String total) {
        Table t;
        try {
            t = new Table(1, 1);
            t.setPadding(3);
            t.setBorderColor(Color.white);
            int headerwidths2[] = {100};
            t.setWidths(headerwidths2);
            t.setWidth(100);
            Paragraph title1 = new Paragraph();
            title1.add(new Paragraph("\nRELATÓRIO DE PRODUÇÃO\n", FontFactory.getFont(FontFactory.TIMES, 14, Font.BOLD)));
            Cell c1 = new Cell(title1);
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setVerticalAlignment(Element.ALIGN_CENTER);
            c1.setBorderColor(Color.white);
            t.addCell(c1);
            documento.add(t);
            title1 = new Paragraph();
            if (dataF == null || dataF.equals("")) {
                title1.add(new Paragraph("Referente a " + dataI + "\nDestino: " + destino, FontFactory.getFont(FontFactory.TIMES, 14, Font.NORMAL)));
            } else {
                title1.add(new Paragraph("Referente ao período de " + dataI + " a " + dataF + "\nDestino: " + destino, FontFactory.getFont(FontFactory.TIMES, 14, Font.NORMAL)));
            }
            documento.add(title1);
            ArrayList<String[]> dados = jtableParaArray(tabela);
            int col = colunas.length;
            int headerwidths3[] = {50, 20, 20, 10};
            if (!destino.equals("Todos")) {
                headerwidths3 = new int[3];
                headerwidths3[0] = 70;
                headerwidths3[1] = 20;
                headerwidths3[2] = 10;
                col--;
            }
            t = new Table(col);
            t.setWidths(headerwidths3);
            t.setWidth(100);
            t.setPadding(3);
            t.setBorderWidth((float) 0.5);
            for (int i = 0; i < colunas.length; i++) {
                if (i != 1 || destino.equals("Todos")) {
                    title1 = new Paragraph(colunas[i], FontFactory.getFont(FontFactory.TIMES, 14, Font.BOLD));
                    c1 = new Cell(title1);
                    c1.setVerticalAlignment(Element.ALIGN_CENTER);
                    if (i != 0) {
                        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    }
                    c1.setHeader(true);
                    t.addCell(c1);
                }
            }

            t.endHeaders();
            for (int i = 0; i < dados.size(); i++) {
                for (int j = 0; j < dados.get(i).length; j++) {
                    if (j != 1 || destino.equals("Todos")) {
                        title1 = new Paragraph(dados.get(i)[j], FontFactory.getFont(FontFactory.TIMES, 12, Font.NORMAL));
                        c1 = new Cell(title1);
                        if (j != 0) {
                            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                        }
                        c1.setVerticalAlignment(Element.ALIGN_CENTER);
                        t.addCell(c1);
                    }
                }
            }
            documento.add(t);
            title1 = new Paragraph();
            title1.add(new Paragraph("Receita total: " + total, FontFactory.getFont(FontFactory.TIMES, 14, Font.NORMAL)));
            title1.setAlignment(Element.ALIGN_RIGHT);
            documento.add(title1);
        } catch (BadElementException ex) {
            Logger.getLogger(RelatoriosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(RelatoriosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String mes(int i) {
        if (i == 1) {
            return "Janeiro";
        } else if (i == 2) {
            return "Fevereiro";
        } else if (i == 3) {
            return "Março";
        } else if (i == 4) {
            return "Abril";
        } else if (i == 5) {
            return "Maio";
        } else if (i == 6) {
            return "Junho";
        } else if (i == 7) {
            return "Julho";
        } else if (i == 8) {
            return "Agosto";
        } else if (i == 9) {
            return "Setembro";
        } else if (i == 10) {
            return "Outubro";
        } else if (i == 11) {
            return "Novembro";
        } else {
            return "Dezembro";
        }
    }

    public int[][] tamanhoColunas(String[] colunas) {
        int qnt = colunas.length;
        if (qnt > 15) {
            int impar = qnt % 2;
            int[][] col = new int[2][((qnt) / 2) + impar];
            int tam = 80 / ((qnt) / 2);
            col[0][0] = 20;
            for (int i = 1; i < ((qnt) / 2) + impar; i++) {
                col[0][i] = tam;
            }
            tam = 100 / ((qnt) / 2);
            for (int i = 0; i < qnt - ((qnt) / 2) - impar; i++) {
                col[1][i] = tam;
            }
            return col;
        } else {
            int[][] col = new int[1][colunas.length];
            int tam = 80 / colunas.length - 1;
            col[0][0] = 20;
            for (int i = 1; i < colunas.length; i++) {
                col[0][i] = tam;
            }
            return col;
        }
    }

    public ArrayList<String[]> jtableParaArray(JTable j) {
        ArrayList<String[]> tabela = new ArrayList<String[]>();
        for (int i = 0; i < j.getRowCount(); i++) {
            String aux[] = new String[j.getColumnCount()];
            for (int k = 0; k < j.getColumnCount(); k++) {
                aux[k] = j.getValueAt(i, k).toString();
            }
            tabela.add(aux);
        }
        return tabela;
    }

    public void criarDocumento(int i, int j) {

        try {
            //----CRIANDO DOCUMENTO
            if (i == 1) {
                documento = new Document(PageSize.A4.rotate(), 28, 28, 25, 20);
            } else {
                documento = new Document(PageSize.A4, 28, 28, 25, 20);
            }
            OutputStream os;
            if (j == 0) {
                os = new FileOutputStream("Relatório.pdf");
            } else {
                os = new FileOutputStream("Relatório2.pdf");
            }
            PdfWriter.getInstance(documento, os);
            HeaderFooter footer = new HeaderFooter(new Phrase(""), new Phrase(""));
            footer.setAlignment(Element.ALIGN_CENTER);
            footer.setBorderColor(Color.white);
            documento.setFooter(footer);

            Phrase p = new Phrase();
            p.add(cabecalho());
            HeaderFooter header = new HeaderFooter(p, false);

            header.setAlignment(Element.ALIGN_CENTER);
            header.setBorderColor(Color.white);
            documento.setHeader(header);
            documento.open();
        } catch (DocumentException ex) {
            Logger.getLogger(RelatoriosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RelatoriosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RelatoriosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Table cabecalho() {
        try {
            //----CABEÇALHO
            Table t = new Table(1, 1);
            t.setPadding(3);
            t.setBorderColor(Color.white);
            int headerwidths[] = {100};
            t.setWidths(headerwidths);
            t.setWidth(100);
            Paragraph title1 = new Paragraph();
            Paragraph aux;
            title1.add(new Paragraph("Pão de Queijo", FontFactory.getFont(FontFactory.TIMES, 14, Font.BOLD)));
            aux = new Paragraph("Rua Francisco Mariano, 42 - Centro", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL));
            title1.add(aux);
            title1.setLeading(12);
            Cell c1 = new Cell(title1);
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setVerticalAlignment(Element.ALIGN_CENTER);
            c1.setBorderColor(Color.white);
            t.addCell(c1);
            return t;
            //----FIM CABEÇALHO

        } catch (DocumentException ex) {
            Logger.getLogger(RelatoriosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void fecharDocumento(int j) {
        documento.close();
        File pdf;
        if (j == 0) {
            pdf = new File("Relatório.pdf");
        } else {
            pdf = new File("Relatório2.pdf");
        }
        try {
            Desktop.getDesktop().open(pdf);
        } catch (Exception ex) {
        }
    }
}
