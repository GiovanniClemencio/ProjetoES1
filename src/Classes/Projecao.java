/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Luan
 */
public class Projecao {

    public static double calcularMediaDiaria(Date dataInicio, Date dataFim, Conta conta) {
        // Tratando entradas nulas ou inválidas
        if (dataInicio == null || dataFim == null || conta == null || dataInicio.after(dataFim)) {
            return 0.0;
        }

        // Soma dos valores dos lançamentos no período
        double totalPeriodo = conta.getLancamentos().stream()
                .filter(l -> !l.getDataLancamento().before(dataInicio) && !l.getDataLancamento().after(dataFim))
                .mapToDouble(Lancamento::getValor)
                .sum();

        // Calculando o número de dias no período
        long diffEmMilisegundos = Math.abs(dataFim.getTime() - dataInicio.getTime());
        long totalDias = TimeUnit.DAYS.convert(diffEmMilisegundos, TimeUnit.MILLISECONDS) + 1;

        return totalPeriodo / totalDias;
    }

    public static double projetarEstimativaFutura(Date dataInicio, Date dataFim, int diasFuturos, Conta conta) {
        double mediaDiaria = calcularMediaDiaria(dataInicio, dataFim, conta);
        return mediaDiaria * diasFuturos;
    }

}
