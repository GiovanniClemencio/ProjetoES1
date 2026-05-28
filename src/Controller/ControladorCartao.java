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

    ControladorConta controladorConta;

    public ControladorCartao() {
        this.controladorConta = new ControladorConta();
    }


    public void criarCartao(int idConta, Cartao cartao) {
        controladorConta.buscarConta(idConta).getCartoes().add(cartao);
        Fechar.salvarObjetos(controladorConta.getContas(), controladorConta.getCaminhosArquivo().getArquivoConta());
    }

    public boolean removerCartao(int id) {
        Cartao cartaoParaRemover = buscarCartao(id);
        if(cartaoParaRemover != null) {
            if(cartaoParaRemover.getFaturaAtual() != null){
                return false; // Falha na remoção, cartão com fatura atual não paga
            }
            controladorConta.buscarConta(cartaoParaRemover.getCodConta()).removerCartao(cartaoParaRemover);

            Fechar.salvarObjetos(controladorConta.getContas(), controladorConta.getCaminhosArquivo().getArquivoConta());
            return true; // Sucesso na remoção
        }
        return false; // Falha na remoção, cartão não encontrado
    }

    public Cartao buscarCartao(int idCartao) {
        for(Conta conta : controladorConta.getContas()){
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
            Fechar.salvarObjetos(controladorConta.getContas(), controladorConta.getCaminhosArquivo().getArquivoConta());
        }

    }
}
