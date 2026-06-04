/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Classes.Configuracao;
import Classes.Conta;
import Classes.Fechar;
import Classes.Inicializar;
import Classes.Lancamento;
import java.util.ArrayList;

/**
 *
 * @author Luan
 */
public class ControladorConta {

    private final Configuracao caminhosArquivo = Configuracao.getInstancia();
    private ArrayList<Conta> contas = Inicializar.carregarObjetos(caminhosArquivo.getArquivoConta());

    public ControladorConta() {
    }

    public void criarConta(String nome, double saldo) {
        Conta conta = new Conta(nome, saldo);
        contas.add(conta);
        Fechar.salvarObjetos(contas, caminhosArquivo.getArquivoConta());
    }

    public boolean removerConta(String id) {
        Conta contaParaRemover = buscarConta(id);
        if (contaParaRemover != null) {

            contas.remove(contaParaRemover);
            Fechar.salvarObjetos(contas, caminhosArquivo.getArquivoConta());

            return true; // Sucesso na remoção
        }
        return false; // Falha na remoção, conta não encontrada
    }

    public Conta buscarConta(String codConta) {
        for (Conta conta : contas) {
            if (conta.getCodConta().equals(codConta)) {
                return conta;
            }
        }
        return null; // Não encontrou a conta
    }

    public void editarConta(String codConta, String nome, double saldo) {
        Conta conta = buscarConta(codConta);
        if (conta != null) {
            conta.editarConta(nome, saldo);
            Fechar.salvarObjetos(contas, caminhosArquivo.getArquivoConta());
        }
    }

    public ArrayList<Lancamento> extrato() {
        ArrayList<Lancamento> todosLancamentos = new ArrayList<>();
        for (Conta conta : contas) {
            todosLancamentos.addAll(conta.extrato());
        }
        return todosLancamentos;
    }

    public Configuracao getCaminhosArquivo() {
        return caminhosArquivo;
    }

    public ArrayList<Conta> getContas() {
        return new ArrayList<>(this.contas); // Retorna uma cópia da lista para evitar modificações sem passar pelo controlador
    }

}
