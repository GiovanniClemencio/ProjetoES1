/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Classes.Exportar;
import Classes.Lancamento;
import Classes.Relatorio;
import java.util.ArrayList;

/**
 *
 * @author Luan
 */
public class ControladorRelatorio {

    private ControladorConta ctrlConta;

    public ControladorRelatorio(ControladorConta ctrlConta) {
        this.ctrlConta = ctrlConta;
    }

    public ArrayList<Lancamento> gerarRelatorio(Relatorio relatorio) {

        ArrayList<Lancamento> todosLancamentos = ctrlConta.extrato(); // Puxa todos os lançamentos

        return relatorio.gerarRelatorio(todosLancamentos); // Aplica os filtros e retorna um arraylist filtrado
    }

    public boolean exportarRelatorio(String caminhoArquivo, ArrayList<Lancamento> lancamentos, String formato) {
        if (formato == null || !formato.equalsIgnoreCase("csv") || !formato.equalsIgnoreCase("pdf")) {
            return false; // Formato inválido
        }

        if (formato.equalsIgnoreCase("csv")) {
            String conteudoCSV = Exportar.exportarCSV(lancamentos);
            try {
                java.nio.file.Files.write(java.nio.file.Paths.get(caminhoArquivo), conteudoCSV.getBytes());
                return true; // Exportação bem-sucedida
            } catch (java.io.IOException e) {
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
