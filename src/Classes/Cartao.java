/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Portu
 */
public class Cartao implements Serializable {
    private int codConta;
    private int idCartao;
    private String nome;
    private double limite;
    private ArrayList<Fatura> faturasAntigas;
    private Fatura faturaAtual;

    public Cartao(int codConta, int idCartao, String nome, double limite) {
        this.codConta = codConta;
        this.idCartao = idCartao;
        this.nome = nome;
        this.limite = limite;
        this.faturasAntigas = new ArrayList<>();
        // this.faturaAtual = new Fatura(codConta,idCartao, int idFatura, Date data, Boolean paga);
    }

    public int getCodConta() {
        return codConta;
    }

    public int getIdCartao() {
        return idCartao;
    }

    public String getNome() {
        return nome;
    }

    public double getLimite() {
        return limite;
    }

    public ArrayList<Fatura> getFaturasAntigas() {
        return faturasAntigas;
    }

    public Fatura getFaturaAtual() {
        return faturaAtual;
    }

    public void setCodConta(int codConta) {
        this.codConta = codConta;
    }

    public void setIdCartao(int idCartao) {
        this.idCartao = idCartao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public void setFaturasAntigas(ArrayList<Fatura> faturasAntigas) {
        this.faturasAntigas = faturasAntigas;
    }

    public void setFaturaAtual(Fatura faturaAtual) {
        this.faturaAtual = faturaAtual;
    }
    
    public void editarCartao(String nome, double limite, ArrayList<Fatura> faturasAntigas, Fatura faturaAtual) {
        this.nome = nome;
        this.limite = limite;
        this.faturasAntigas = faturasAntigas;
        this.faturaAtual = faturaAtual;
    }

    @Override
    public String toString() {
        return new StringBuffer("Cartao {")
                .append("Conta: ").append(codConta)
                .append(", ID cartao: ").append(idCartao)
                .append(", Nome: ").append(nome)
                .append(", Limite: ").append(limite)
                .append(", Faturas antigas: ").append(faturasAntigas)
                .append(", Fatura atual: ").append(faturaAtual)
                .append("}").toString();
    }
}
