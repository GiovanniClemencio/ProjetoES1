/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Classes;

import java.io.Serializable;

/**
 *
 * @author Luan
 */
public class Conta implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private int idConta;
    private String nomeConta;
    private double saldoInicial;

    public Conta(int idConta, String nomeConta, double saldoInicial) {
        this.idConta = idConta;
        this.nomeConta = nomeConta;
        this.saldoInicial = saldoInicial;
    }
    
    public int getIdConta() { return idConta; }
    public void setIdConta(int idConta) { this.idConta = idConta; }

    public String getNomeConta() { return nomeConta; }
    public void setNomeConta(String nomeConta) { this.nomeConta = nomeConta; }

    public double getSaldoInicial() { return saldoInicial; }
    public void setSaldoInicial(double saldoInicial) { this.saldoInicial = saldoInicial; }

    @Override
    public String toString() {
        return new StringBuffer("Conta {")
                .append("Identificador: ").append(idConta)
                .append(", Nome: ").append(nomeConta)
                .append(", Saldo Inicial: ").append(saldoInicial)
                .append("}").toString();
    }
}