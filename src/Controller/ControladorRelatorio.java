/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Classes.Lancamento;
import Classes.Relatorio;
import java.util.ArrayList;

/**
 *
 * @author Luan
 */
public class ControladorRelatorio {

    private ControladorConta ctrlConta;

    public ControladorRelatorio(ControladorConta ctrlConta) {
        this.ctrlConta = ctrlConta;
    }

    public ArrayList<Lancamento> gerarRelatorio(Relatorio relatorio) {

        ArrayList<Lancamento> todosLancamentos = ctrlConta.extrato();

        return relatorio.gerarRelatorio(todosLancamentos);
    }

    public ControladorConta getCtrlConta() {
        return ctrlConta;
    }

    public void setCtrlConta(ControladorConta ctrlConta) {
        this.ctrlConta = ctrlConta;
    }
}
