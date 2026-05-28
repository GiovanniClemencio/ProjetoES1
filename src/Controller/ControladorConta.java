/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Classes.Configuracao;
import Classes.Conta;
import Classes.Fechar;
import Classes.Inicializar;
import java.util.ArrayList;


/**
 *
 * @author Luan
 */
public class ControladorConta
{
    private Configuracao caminhosArquivo = Configuracao.getInstancia();
    private ArrayList<Conta> contas = Inicializar.carregarObjetos(caminhosArquivo.getArquivoConta());

    public void criarConta(Conta conta)
    {
        contas.add(conta);
        Fechar.salvarObjetos(contas, caminhosArquivo.getArquivoConta());
    }

    public boolean removerConta(int id) 
    {
        Conta contaParaRemover = buscarConta(id);
        if (contaParaRemover != null) {

            contas.remove(contaParaRemover);
            Fechar.salvarObjetos(contas, caminhosArquivo.getArquivoConta());
            
            return true; // Sucesso na remoção
        }
        return false; // Falha na remoção, conta não encontrada
    }

    public Conta buscarConta(int codConta)
    {
        for (Conta conta : contas)
        {
            if (conta.getCodConta() == codConta)
            {
                return conta;
            }
        }
        return null; // Não encontrou a conta
    }

    public void editarConta(int codConta, String nome, double saldo) {
        Conta conta = buscarConta(codConta);
        if (conta != null) {
            conta.editarConta(nome, saldo);
            Fechar.salvarObjetos(contas, caminhosArquivo.getArquivoConta());
        }
    }

    public void extrato(){
        for (Conta conta : contas) {
            conta.extrato();
        }
    }

    public Configuracao getCaminhosArquivo() {
        return caminhosArquivo;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }
}