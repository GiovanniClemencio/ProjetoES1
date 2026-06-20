/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Classes.Cartao;
import Classes.Categoria;
import Classes.Conta;
import Classes.Fatura;
import Classes.Fechar;
import Classes.Lancamento;
import java.util.Date;

/**
 * @author Luan
 */
public class ControladorLancamento {

    protected final ControladorCartao ctrlCartao;

    public ControladorLancamento(ControladorCartao controladorCartao) {
        this.ctrlCartao = controladorCartao;
    }

    public void criarLancamento(String tipo, Conta contaOrigem, Conta contaDestino, Date dataMax, double valor, Date dataLancamento, String descricao, Boolean pendente, String idCartao) {
        Lancamento lancamento = new Lancamento(tipo, contaOrigem, contaDestino, dataMax, valor, dataLancamento, descricao, pendente, idCartao);
        Conta conta = lancamento.getContaOrigem();
        if (conta != null) {
            conta.adicionarLancamento(lancamento);
            Fechar.salvarObjetos(ctrlCartao.ctrlConta.getContas(), ctrlCartao.ctrlConta.getCaminhosArquivo().getArquivoConta());
        }
        if (!(idCartao.equalsIgnoreCase("nenhum"))) {
            Cartao cartao = ctrlCartao.buscarCartao(idCartao);

            Fatura atual = cartao.getFaturaAtual();
            atual.adicionarLancamento(lancamento);
        }
    }

    public boolean removerLancamento(String id) {
        Lancamento lancamentoParaRemover = buscarLancamento(id);
        if (lancamentoParaRemover != null) {

            lancamentoParaRemover.getContaOrigem().removerLancamento(lancamentoParaRemover);
            Fechar.salvarObjetos(ctrlCartao.ctrlConta.getContas(), ctrlCartao.ctrlConta.getCaminhosArquivo().getArquivoConta());

            return true; // Sucesso na remoção
        }
        return false; // Falha na remoção, lançamento não encontrado
    }

    public Lancamento buscarLancamento(String idLancamento) {
        for (Conta conta : ctrlCartao.ctrlConta.getContas()) {
            for (Lancamento lancamento : conta.getLancamentos()) {
                if (lancamento.getIdLancamento().equals(idLancamento)) {
                    return lancamento;
                }
            }
        }
        return null; // Não encontrou o lançamento
    }

    public void editarLancamento(String idLancamento, String tipo, Conta contaOrigem, Conta contaDestino, Date dataMax, double valor, Date dataLancamento, String descricao, Boolean pendente) {
        Lancamento lancamento = buscarLancamento(idLancamento);
        if (lancamento != null) {
            lancamento.editarLancamento(tipo, contaOrigem, contaDestino, dataMax, valor, dataLancamento, descricao, pendente);
            Fechar.salvarObjetos(ctrlCartao.ctrlConta.getContas(), ctrlCartao.ctrlConta.getCaminhosArquivo().getArquivoConta());
        }
    }

    public void addCategoriaLancamento(Lancamento lancamento, Categoria categoria) {
        if (lancamento != null) {
            lancamento.getCategorias().add(categoria);
            Fechar.salvarObjetos(ctrlCartao.ctrlConta.getContas(), ctrlCartao.ctrlConta.getCaminhosArquivo().getArquivoConta());
        }
    }

    public void removeCategoriaLancamento(Lancamento lancamento, Categoria categoria) {
        if (lancamento != null) {
            lancamento.getCategorias().remove(categoria);
            Fechar.salvarObjetos(ctrlCartao.ctrlConta.getContas(), ctrlCartao.ctrlConta.getCaminhosArquivo().getArquivoConta());
        }
    }

    public ControladorCartao getCtrlCartao() {
        return ctrlCartao;
    }

    public void criarTransferencia(String tipo, Conta contaOrigem, Conta contaDestino, Date dataMax, double valor, Date dataLancamento, String descricao, Boolean pendente, String idCartao) {
        double valorPos = Math.abs(valor);
        Lancamento lancamento1 = new Lancamento(tipo, contaOrigem, contaDestino, dataMax, valor, dataLancamento, descricao, pendente, idCartao);
        Lancamento lancamento2 = new Lancamento(tipo, contaDestino, contaOrigem, dataMax, valorPos, dataLancamento, descricao, pendente, idCartao);
        
        Conta conta = lancamento1.getContaOrigem();
        if (conta != null) {
            conta.adicionarLancamento(lancamento1);
            Fechar.salvarObjetos(ctrlCartao.ctrlConta.getContas(), ctrlCartao.ctrlConta.getCaminhosArquivo().getArquivoConta());
        }
        conta = lancamento2.getContaOrigem();
        if (conta != null) {
            conta.adicionarLancamento(lancamento2);
            Fechar.salvarObjetos(ctrlCartao.ctrlConta.getContas(), ctrlCartao.ctrlConta.getCaminhosArquivo().getArquivoConta());
        }
        
    }
}
