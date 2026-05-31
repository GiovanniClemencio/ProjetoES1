/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Classes.Cartao;
import Classes.Conta;
import Classes.Fatura;
import Classes.Fechar;
import java.util.ArrayList;

/**
 *
 * @author Luan
 */
public class ControladorCartao {

    protected final ControladorConta ctrlConta;

    public ControladorCartao(ControladorConta controladorConta) {
        this.ctrlConta = controladorConta;
    }


    public void criarCartao(int idConta, Cartao cartao) {
        ctrlConta.buscarConta(idConta).getCartoes().add(cartao);
        Fechar.salvarObjetos(ctrlConta.getContas(), ctrlConta.getCaminhosArquivo().getArquivoConta());
    }

    public boolean removerCartao(int id) {
        Cartao cartaoParaRemover = buscarCartao(id);
        if(cartaoParaRemover != null) {
            if(cartaoParaRemover.getFaturaAtual() != null){
                return false; // Falha na remoção, cartão com fatura atual não paga
            }
            ctrlConta.buscarConta(cartaoParaRemover.getCodConta()).removerCartao(cartaoParaRemover);

            Fechar.salvarObjetos(ctrlConta.getContas(), ctrlConta.getCaminhosArquivo().getArquivoConta());
            return true; // Sucesso na remoção
        }
        return false; // Falha na remoção, cartão não encontrado
    }

    public Cartao buscarCartao(int idCartao) {
        for(Conta conta : ctrlConta.getContas()){
            for(Cartao cartao : conta.getCartoes()){
                if(cartao.getIdCartao() == idCartao){
                    return cartao;
                }
            }
        }
        return null; // Não encontrou o cartão
    }

    public void editarCartao(int idCartao, String nome, double limite, ArrayList<Fatura> faturasAntigas, Fatura faturaAtual) {
        Cartao cartao = buscarCartao(idCartao);
        if (cartao != null) {
            cartao.editarCartao(nome, limite, faturasAntigas, faturaAtual);
            Fechar.salvarObjetos(ctrlConta.getContas(), ctrlConta.getCaminhosArquivo().getArquivoConta());
        }

    }
}
