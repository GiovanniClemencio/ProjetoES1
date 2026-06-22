/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Classes.Conta;
import Classes.Lancamento;
import Classes.Projecao;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Luan
 */
public class ControladorProjecao {

    protected final ControladorConta ctrlConta;
    protected final ControladorRelatorio ctrlRelatorio;


    public ControladorProjecao(ControladorConta controladorConta, ControladorRelatorio controladorRelatorio) {
        this.ctrlConta = controladorConta;
        this.ctrlRelatorio = controladorRelatorio;
    }
    
    public double projetarEstimativa(Date dataInicio, Date dataFim, int diasFuturos, ArrayList<Conta> contasParaAnalise) {
        if (dataInicio == null || dataFim == null || dataInicio.after(dataFim)) {
            return 0.0;
        }

        ArrayList<Lancamento> lancamentos = this.ctrlRelatorio.gerarRelatorio(dataInicio, dataFim, null, null, null, contasParaAnalise);

        lancamentos.removeIf(l -> "TRANSFERENCIA".equalsIgnoreCase(l.getTipo()));

        return Projecao.projetarValor(dataInicio, dataFim, diasFuturos, lancamentos);
    }
}
