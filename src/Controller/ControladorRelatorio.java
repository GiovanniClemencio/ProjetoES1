/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Classes.Cartao;
import Classes.Categoria;
import Classes.Conta;
import Classes.Exportar;
import Classes.Lancamento;
import Classes.Relatorio;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Luan
 */
public class ControladorRelatorio {

    private ControladorConta ctrlConta;

    public ControladorRelatorio(ControladorConta ctrlConta) {
        this.ctrlConta = ctrlConta;
    }

    public ArrayList<Lancamento> gerarRelatorio(Date inicio, Date fim, String tipo, ArrayList<Categoria> categoria, ArrayList<Cartao> cartao, ArrayList<Conta> conta) {

        Relatorio relatorio = new Relatorio(inicio, fim, tipo, categoria, cartao, conta);

        ArrayList<Lancamento> todosLancamentos = ctrlConta.extrato(); // Puxa todos os lançamentos

        return relatorio.gerarRelatorio(todosLancamentos); // Aplica os filtros e retorna um arraylist filtrado
    }

    public boolean exportarRelatorio(ArrayList<Lancamento> lancamentos, String formato) {
        if (formato == null || (!formato.equalsIgnoreCase("csv") && !formato.equalsIgnoreCase("pdf"))) {
            return false; // Formato inválido
        }

        // Escolha do caminho para salvar o arquivo
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar Relatório");

        // Configura o filtro de arquivos e o nome padrão com base no formato escolhido
        if (formato.equalsIgnoreCase("csv")) {
            fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivos CSV (*.csv)", "csv"));
            fileChooser.setSelectedFile(new File("relatorio.csv"));
        } else if (formato.equalsIgnoreCase("pdf")) {
            fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivos PDF (*.pdf)", "pdf"));
            fileChooser.setSelectedFile(new File("relatorio.pdf"));
        }

        int retornoJanela = fileChooser.showSaveDialog(null);

        // Usuário cancelou a operação de salvar
        if (retornoJanela != JFileChooser.APPROVE_OPTION) {
            return false;
        }

        File arquivoSelecionado = fileChooser.getSelectedFile();
        String caminhoArquivo = arquivoSelecionado.getAbsolutePath();

        // Adiciona a extensão correta se o usuário não a tiver incluído
        if (formato.equalsIgnoreCase("csv") && !caminhoArquivo.toLowerCase().endsWith(".csv")) {
            caminhoArquivo += ".csv";
        } else if (formato.equalsIgnoreCase("pdf") && !caminhoArquivo.toLowerCase().endsWith(".pdf")) {
            caminhoArquivo += ".pdf";
        }

        if (formato.equalsIgnoreCase("csv")) {
            String conteudoCSV = Exportar.exportarCSV(lancamentos);
            try {
                // Converte o conteúdo CSV para bytes usando UTF-8 e adiciona o marcador BOM no início
                byte[] bytesTexto = conteudoCSV.getBytes(StandardCharsets.UTF_8);
                byte[] bom = new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF}; // Marcador BOM

                // Junta o BOM com os bytes do texto
                byte[] bytesFinais = new byte[bom.length + bytesTexto.length];
                System.arraycopy(bom, 0, bytesFinais, 0, bom.length);
                System.arraycopy(bytesTexto, 0, bytesFinais, bom.length, bytesTexto.length);

                java.nio.file.Files.write(java.nio.file.Paths.get(caminhoArquivo), bytesFinais);
                return true; // Exportação bem-sucedida
            } catch (java.io.IOException e) {
                e.printStackTrace();
                return false; // Exportação falhou
            }
        }

        // TODO: Implementar exportação para PDF
        // if(formato.equalsIgnoreCase("pdf")) {
        //     return false;
        // }
        return false; // Formato não suportado
    }

    public ControladorConta getCtrlConta() {
        return ctrlConta;
    }

    public void setCtrlConta(ControladorConta ctrlConta) {
        this.ctrlConta = ctrlConta;
    }
}
