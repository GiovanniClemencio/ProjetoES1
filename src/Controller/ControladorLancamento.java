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

/**
 * @author Luan
 */
public class ControladorLancamento
{
    private Configuracao caminhosArquivo = Configuracao.getInstancia();
    private ArrayList<Lancamento> lancamentos = Inicializar.carregarObjetos(caminhosArquivo.getArquivoLancamento());

    public void criarLancamento(Lancamento lancamento)
    {
        lancamentos.add(lancamento);
        Fechar.salvarObjetos(lancamentos, caminhosArquivo.getArquivoLancamento());
    }


    

}