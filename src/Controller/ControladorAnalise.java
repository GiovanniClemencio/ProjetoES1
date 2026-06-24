/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Classes.Cartao;
import Classes.Categoria;
import Classes.Conta;
import Classes.Lancamento;
import Classes.Projecao;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Luan
 */
public class ControladorAnalise {

    protected final ControladorRelatorio ctrlRelatorio;

    public ControladorAnalise(ControladorRelatorio controladorRelatorio) {
        this.ctrlRelatorio = controladorRelatorio;
    }

    public double gerarProjecaoFutura(Date dataInicio, Date dataFim, int diasFuturos, ArrayList<Categoria> categoriaParaAnalise,
            ArrayList<Cartao> cartaoParaAnalise, ArrayList<Conta> contasParaAnalise) {
        if (dataInicio != null && dataFim != null && dataInicio.after(dataFim)) {
            return 0.0;
        }

        ArrayList<Lancamento> lancamentos = this.ctrlRelatorio.gerarRelatorio(dataInicio, dataFim, null, categoriaParaAnalise, cartaoParaAnalise, contasParaAnalise);

        lancamentos.removeIf(l -> "TRANSFERENCIA".equalsIgnoreCase(l.getTipo()));

        return Projecao.projetarValor(dataInicio, dataFim, diasFuturos, lancamentos);
    }

    public double compararPeriodos(Date dataInicio1, Date dataFim1, Date dataInicio2, Date dataFim2) {

        ArrayList<Lancamento> lancamentos1 = this.ctrlRelatorio.gerarRelatorio(dataInicio1, dataFim1, null, null, null, null);
        ArrayList<Lancamento> lancamentos2 = this.ctrlRelatorio.gerarRelatorio(dataInicio2, dataFim2, null, null, null, null);

        lancamentos1.removeIf(l -> "TRANSFERENCIA".equalsIgnoreCase(l.getTipo()));
        lancamentos2.removeIf(l -> "TRANSFERENCIA".equalsIgnoreCase(l.getTipo()));

        double totalPeriodo1 = 0;

        for (Lancamento l : lancamentos1) {
            totalPeriodo1 += l.getValor();
        }

        double totalPeriodo2 = 0;

        for (Lancamento l : lancamentos2) {
            totalPeriodo2 += l.getValor();
        }

        double result = totalPeriodo2 - totalPeriodo1;

        return result;
    }
}
