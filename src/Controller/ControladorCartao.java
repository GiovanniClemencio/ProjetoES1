/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Classes.Cartao;
import Classes.Configuracao;
import Classes.Fatura;
import Classes.Fechar;
import Classes.Inicializar;
import java.util.ArrayList;

/**
 *
 * @author Luan
 */
public class ControladorCartao {

    private Configuracao caminhosArquivo = Configuracao.getInstancia();
    private ArrayList<Cartao> cartoes = Inicializar.carregarObjetos(caminhosArquivo.getArquivoCartao());

    public void criarCartao(Cartao cartao) {
        cartoes.add(cartao);
        Fechar.salvarObjetos(cartoes, caminhosArquivo.getArquivoCartao());
    }

    public boolean removerCartao(int id) {
        Cartao cartaoParaRemover = buscarCartao(id);
        if (cartaoParaRemover != null) {

            cartoes.remove(cartaoParaRemover);
            Fechar.salvarObjetos(cartoes, caminhosArquivo.getArquivoCartao());

            return true; // Sucesso na remoção
        }
        return false; // Falha na remoção, cartão não encontrado
    }

    public Cartao buscarCartao(int idCartao) {
        for (Cartao cartao : cartoes) {
            if (cartao.getIdCartao() == idCartao) {
                return cartao;
            }
        }
        return null; // Não encontrou o cartão
    }

    public void editarCartao(int idCartao, String nome, double limite, ArrayList<Fatura> faturasAntigas, Fatura faturaAtual) {
        Cartao cartao = buscarCartao(idCartao);
        if (cartao != null) {
            cartao.editarCartao(nome, limite, faturasAntigas, faturaAtual);
            Fechar.salvarObjetos(cartoes, caminhosArquivo.getArquivoCartao());
        }

    }
}
