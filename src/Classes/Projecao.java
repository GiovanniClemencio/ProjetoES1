/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Luan
 */
public class Projecao {

    public static double calcularMediaDiaria(Date dataInicio, Date dataFim, ArrayList<Lancamento> lancamentos) {

        // Se dataInicio for null, busca a data do lançamento mais antigo
        Date dataInicioFinal = (dataInicio == null)
                ? lancamentos.stream()
                        .map(Lancamento::getDataLancamento)
                        .min(Date::compareTo)
                        .orElse(new Date())
                : dataInicio;

        // Se dataFim for null, busca a data do lançamento mais recente
        Date dataFimFinal = (dataFim == null)
                ? lancamentos.stream()
                        .map(Lancamento::getDataLancamento)
                        .max(Date::compareTo)
                        .orElse(new Date()) // Fallback seguro
                : dataFim;

        // Soma dos valores dos lançamentos no período
        double totalPeriodo = lancamentos.stream()
                .filter(l -> !l.getDataLancamento().before(dataInicioFinal) && !l.getDataLancamento().after(dataFimFinal))
                .mapToDouble(Lancamento::getValor)
                .sum();

        // Calculando o número de dias no período
        long diffEmMilisegundos = Math.abs(dataFimFinal.getTime() - dataInicioFinal.getTime());
        long totalDias = TimeUnit.DAYS.convert(diffEmMilisegundos, TimeUnit.MILLISECONDS) + 1;

        return totalPeriodo / totalDias;
    }

    public static double projetarValor(Date dataInicio, Date dataFim, int diasFuturos, ArrayList<Lancamento> lancamentos) {
        double mediaDiaria = calcularMediaDiaria(dataInicio, dataFim, lancamentos);
        return mediaDiaria * diasFuturos;
    }

}
