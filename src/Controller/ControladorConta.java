/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;

/**
 *
 * @author Luan
 */
public class ControladorConta
{
    private Configuracao caminhosArquivo = Configuracao_EduardoGiovanniLuan.getInstancia();
    private ArrayList<Conta> contas = Inicializar.carregarObjetos(caminhosArquivo.getArquivoConta());

    public void criarConta(Conta conta)
    {
        contas.add(conta);
        Fechar.salvarObjetos(contas, caminhosArquivo.getArquivoClientes());
    }

    public boolean removerConta(int id) 
    {
        Conta contaParaRemover = buscarConta(id);
        if (contaParaRemover != null) {

            contas.remove(contaParaRemover);
            Fechar.salvarObjetos(contas, caminhosArquivo.getArquivoClientes());
            
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
}