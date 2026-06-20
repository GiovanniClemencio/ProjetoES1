/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package GUI;

import Classes.Cartao;
import Classes.Fatura;
import GUI.telas.TelaInicial;
import Controller.ControladorCartao;
import Controller.ControladorCategoria;
import Controller.ControladorConta;
import Controller.ControladorLancamento;
import Controller.ControladorRelatorio;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author Portu
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControladorConta ctrlConta = new ControladorConta();
        ControladorCartao ctrlCartao = new ControladorCartao(ctrlConta);
        ControladorLancamento ctrlLancamento = new ControladorLancamento(ctrlCartao);
        ControladorRelatorio ctrlRelatorio = new ControladorRelatorio(ctrlConta);
        ControladorCategoria ctrlCategoria = new ControladorCategoria(ctrlLancamento, ctrlRelatorio);
        
        atualizarFaturasDosCartoes(ctrlCartao);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaInicial janela = new TelaInicial(ctrlLancamento, ctrlCategoria);
                janela.setLocationRelativeTo(null); // Centraliza na tela
                janela.setVisible(true);            // Torna a janela visível
            }
        });

    }

    private static YearMonth paraYearMonth(Date data) {
        LocalDate localDate = data.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        return YearMonth.from(localDate);
    }
    
    private static Fatura criarNovaFatura(Cartao cartao, YearMonth mes) {
        Date dataFatura = Date.from(
                mes.atDay(1)
                        .atStartOfDay(ZoneId.systemDefault())
                        .toInstant()
        );

        return new Fatura(
                cartao.getCodConta(),
                cartao.getIdCartao(),
                dataFatura,
                false
        );
    }
    
    private static void atualizarFaturasDosCartoes(ControladorCartao ctrlCartao) {
        YearMonth mesAtualSistema = YearMonth.now();

        for (Cartao cartao : ctrlCartao.getCartoes()) {
            Fatura faturaAtual = cartao.getFaturaAtual();

            if (faturaAtual == null) {
                cartao.setFaturaAtual(criarNovaFatura(cartao, mesAtualSistema));
                continue;
            }

            YearMonth mesDaFatura = paraYearMonth(faturaAtual.getData());

            while (mesAtualSistema.isAfter(mesDaFatura)) {
                cartao.getFaturasAntigas().add(faturaAtual);

                mesDaFatura = mesDaFatura.plusMonths(1);
                faturaAtual = criarNovaFatura(cartao, mesDaFatura);
                cartao.setFaturaAtual(faturaAtual);
            }
        }
    }

}
