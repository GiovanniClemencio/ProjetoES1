/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Classes.Conta;
import Classes.Fechar;
import Classes.Lancamento;
import java.util.Date;

/**
 * @author Luan
 */
public class ControladorLancamento {

    ControladorCartao controladorCartao;
    
    public ControladorLancamento() {
        this.controladorCartao = new ControladorCartao();
    }

    public void criarLancamento(Lancamento lancamento) {
        Conta conta =controladorCartao.controladorConta.buscarConta(lancamento.getContaOrigem());
        if (conta != null) {
            conta.getLancamentos().add(lancamento);
            Fechar.salvarObjetos(controladorCartao.controladorConta.getContas(), controladorCartao.controladorConta.getCaminhosArquivo().getArquivoConta());
        }
    }

    public boolean removerLancamento(int id) {
        Lancamento lancamentoParaRemover = buscarLancamento(id);
        if (lancamentoParaRemover != null) {

            controladorCartao.controladorConta.buscarConta(lancamentoParaRemover.getContaOrigem()).removerLancamento(lancamentoParaRemover);
            Fechar.salvarObjetos(controladorCartao.controladorConta.getContas(), controladorCartao.controladorConta.getCaminhosArquivo().getArquivoConta());

            return true; // Sucesso na remoção
        }
        return false; // Falha na remoção, lançamento não encontrado
    }

    public Lancamento buscarLancamento(int idLancamento) {
        for (Conta conta : controladorCartao.controladorConta.getContas()) {
            for (Lancamento lancamento : conta.getLancamentos()) {
                if (lancamento.getIdLancamento() == idLancamento) {
                    return lancamento;
                }
            }
        }
        return null; // Não encontrou o lançamento
    }

    public void editarLancamento(int idLancamento, String tipo, int contaOrigem, int contaDestino, Date dataMax, double valor, Date dataLancamento, String descricao, Boolean pendente) {
        Lancamento lancamento = buscarLancamento(idLancamento);
        if (lancamento != null) {
            lancamento.editarLancamento(tipo, contaOrigem, contaDestino, dataMax, valor, dataLancamento, descricao, pendente);
            Fechar.salvarObjetos(controladorCartao.controladorConta.getContas(), controladorCartao.controladorConta.getCaminhosArquivo().getArquivoConta());
        }
    }

}
