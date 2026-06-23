/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Portu
 */
public class Cartao implements Serializable {

    private String codConta;
    private String idCartao;
    private String nome;
    private double limite;
    private ArrayList<Fatura> faturasAntigas;
    private Fatura faturaAtual;

    public Cartao(String codConta, String idCartao, String nome, double limite) {
        this.codConta = codConta;
        this.idCartao = idCartao;
        this.nome = nome;
        this.limite = limite;
        this.faturasAntigas = new ArrayList<>();
        this.faturaAtual = new Fatura(codConta, idCartao, new Date(), false);
    }

    public String getCodConta() {
        return codConta;
    }

    public String getIdCartao() {
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

    public void setCodConta(String codConta) {
        this.codConta = codConta;
    }

    public void setIdCartao(String idCartao) {
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
                .append("}").toString();
    }
}
