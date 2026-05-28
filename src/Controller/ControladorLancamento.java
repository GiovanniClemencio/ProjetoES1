/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Classes.Configuracao;
import Classes.Fechar;
import Classes.Inicializar;
import Classes.Lancamento;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Luan
 */
public class ControladorLancamento {

    private Configuracao caminhosArquivo = Configuracao.getInstancia();
    private ArrayList<Lancamento> lancamentos = Inicializar.carregarObjetos(caminhosArquivo.getArquivoLancamento());

    public void criarLancamento(Lancamento lancamento) {
        lancamentos.add(lancamento);
        Fechar.salvarObjetos(lancamentos, caminhosArquivo.getArquivoLancamento());
    }

    public boolean removerLancamento(int id) {
        Lancamento lancamentoParaRemover = buscarLancamento(id);
        if (lancamentoParaRemover != null) {

            lancamentos.remove(lancamentoParaRemover);
            Fechar.salvarObjetos(lancamentos, caminhosArquivo.getArquivoLancamento());

            return true; // Sucesso na remoção
        }
        return false; // Falha na remoção, lançamento não encontrado
    }

    public Lancamento buscarLancamento(int idLancamento) {
        for (Lancamento lancamento : lancamentos) {
            if (lancamento.getIdLancamento() == idLancamento) {
                return lancamento;
            }
        }
        return null; // Não encontrou o lançamento
    }

    public void editarLancamento(int idLancamento, String tipo, int contaOrigem, int contaDestino, Date dataMax, double valor, Date dataLancamento, String descricao, Boolean pendente) {
        Lancamento lancamento = buscarLancamento(idLancamento);
        if (lancamento != null) {
            lancamento.editarLancamento(tipo, contaOrigem, contaDestino, dataMax, valor, dataLancamento, descricao, pendente);
            Fechar.salvarObjetos(lancamentos, caminhosArquivo.getArquivoLancamento());
        }
    }

}
