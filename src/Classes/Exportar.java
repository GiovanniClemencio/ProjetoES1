/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Luan
 */
public class Exportar {
    
    public static String exportarCSV(ArrayList<Lancamento> lancamentos) {
        if (lancamentos == null || lancamentos.isEmpty()) {
            return "Data;Descrição;Tipo;Categorias;Conta Origem;Conta Destino;Valor\n";
        }

        StringBuilder csv = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        csv.append("Data;Descrição;Tipo;Categorias;Conta Origem;Conta Destino;Valor\n");

        for (Lancamento l : lancamentos) {
            String dataStr = (l.getDataLancamento() != null) ? sdf.format(l.getDataLancamento()) : "";
            String descricao = (l.getDescricao() != null) ? l.getDescricao() : "";
            String tipo = (l.getTipo() != null) ? l.getTipo() : "";

            // Se categorias for uma lista, junta elas por vírgula dentro do campo
            String categoriasStr = "";
            if (l.getCategorias() != null) {
                categoriasStr = l.getCategorias().toString().replace("[", "").replace("]", "");
            }

            String contaOrigemStr = l.getNomeContaOrigem();
            String contaDestinoStr = l.getNomeContaDestino();
            double valor = l.getValor();

            csv.append(dataStr).append(";")
                    .append(descricao).append(";")
                    .append(tipo).append(";")
                    .append(categoriasStr).append(";")
                    .append(contaOrigemStr).append(";")
                    .append(contaDestinoStr).append(";")
                    .append(String.format("%.2f", valor)).append("\n");
        }

        return csv.toString();
    }
}
