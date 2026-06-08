/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

/**
 *
 * @author Luan
 */
public class Exportar {

    public static String exportarCSV(ArrayList<Lancamento> lancamentos) {
        if (lancamentos == null || lancamentos.isEmpty()) {
            return "Data;Descrição;Tipo;Categorias;Conta Origem;Conta Destino;Valor\n";
        }

        StringBuilder csv = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        csv.append("Data;Descrição;Tipo;Categorias;Conta Origem;Conta Destino;Valor\n");

        for (Lancamento l : lancamentos) {
            String dataStr = (l.getDataLancamento() != null) ? sdf.format(l.getDataLancamento()) : "";
            String descricao = (l.getDescricao() != null) ? l.getDescricao() : "";
            String tipo = (l.getTipo() != null) ? l.getTipo() : "";

            // Se categorias for uma lista, junta elas por vírgula dentro do campo
            String categoriasStr = "";
            if (l.getCategorias() != null) {
                categoriasStr = l.getCategorias().toString().replace("[", "").replace("]", "");
            }

            String contaOrigemStr = l.getNomeContaOrigem();
            String contaDestinoStr = l.getNomeContaDestino();
            double valor = l.getValor();

            csv.append(dataStr).append(";")
                    .append(descricao).append(";")
                    .append(tipo).append(";")
                    .append(categoriasStr).append(";")
                    .append(contaOrigemStr).append(";")
                    .append(contaDestinoStr).append(";")
                    .append(String.format("%.2f", valor)).append("\n");
        }

        return csv.toString();
    }

    public static byte[] exportarPDF(ArrayList<Lancamento> lancamentos) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document documento = new Document(PageSize.A4);
        
        try {
            PdfWriter.getInstance(documento, out);
            documento.open();
            
            // Configuração das fontes
            Font fonteTitulo = new Font(Font.HELVETICA, 16, Font.BOLD);
            Font fonteCabecalho = new Font(Font.HELVETICA, 10, Font.BOLD);
            Font fonteCorpo = new Font(Font.HELVETICA, 9, Font.NORMAL);
            
            // Adiciona o Título
            Paragraph titulo = new Paragraph("Relatório de Lançamentos", fonteTitulo);
            titulo.setAlignment(Paragraph.ALIGN_CENTER);
            titulo.setSpacingAfter(20);
            documento.add(titulo);
            
            if (lancamentos == null || lancamentos.isEmpty()) {
                documento.add(new Paragraph("Nenhum lançamento encontrado.", fonteCorpo));
            } else {
                // Cria uma tabela com 5 colunas estruturadas
                PdfPTable tabela = new PdfPTable(5);
                tabela.setWidthPercentage(100);
                tabela.setWidths(new float[]{15f, 30f, 15f, 25f, 15f}); // Largura das colunas
                
                // Cabeçalho da tabela
                String[] colunas = {"Data", "Descrição", "Tipo", "Contas (Origem/Dest)", "Valor"};
                for (String nomeColuna : colunas) {
                    PdfPCell celula = new PdfPCell(new Phrase(nomeColuna, fonteCabecalho));
                    celula.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                    celula.setPadding(6);
                    tabela.addCell(celula);
                }
                
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                
                // Dados da tabela
                for (Lancamento l : lancamentos) {
                    String dataStr = (l.getDataLancamento() != null) ? sdf.format(l.getDataLancamento()) : "";
                    String descricao = (l.getDescricao() != null) ? l.getDescricao() : "";
                    String tipo = (l.getTipo() != null) ? l.getTipo() : "";
                    
                    String ori = l.getNomeContaOrigem() != null ? l.getNomeContaOrigem() : "-";
                    String dest = l.getNomeContaDestino() != null ? l.getNomeContaDestino() : "-";
                    String contas = "Ori: " + ori + "\nDest: " + dest;
                    
                    String valorStr = String.format("R$ %.2f", l.getValor());
                    
                    tabela.addCell(new PdfPCell(new Phrase(dataStr, fonteCorpo)));
                    tabela.addCell(new PdfPCell(new Phrase(descricao, fonteCorpo)));
                    tabela.addCell(new PdfPCell(new Phrase(tipo, fonteCorpo)));
                    tabela.addCell(new PdfPCell(new Phrase(contas, fonteCorpo)));
                    
                    PdfPCell celulaValor = new PdfPCell(new Phrase(valorStr, fonteCorpo));
                    celulaValor.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT); // Alinha valor à direita
                    tabela.addCell(celulaValor);
                }
                
                documento.add(tabela);
            }
            
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            documento.close(); // Fecha e consolida a estrutura binária do PDF
        }
        
        return out.toByteArray();
    }
}
