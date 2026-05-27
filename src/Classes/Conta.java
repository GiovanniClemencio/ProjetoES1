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
public class Conta implements Serializable {
    private int codConta;
    private String nome;
    private double saldo;
    private ArrayList<Cartao> cartoes;
    private ArrayList<Lancamento> lancamentos;

    public Conta(int codConta, String nome, double saldo) {
        this.codConta = codConta;
        this.nome = nome;
        this.saldo = saldo;
        this.cartoes = new ArrayList<>();
        this.lancamentos = new ArrayList<>();
    }

    public int getCodConta() {
        return codConta;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public ArrayList<Cartao> getCartoes() {
        return cartoes;
    }

    public ArrayList<Lancamento> getLancamentos() {
        return lancamentos;
    }

    public void setCodConta(int codConta) {
        this.codConta = codConta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setCartoes(ArrayList<Cartao> cartoes) {
        this.cartoes = cartoes;
    }

    public void setLancamentos(ArrayList<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }

    @Override
    public String toString() {
        return new StringBuffer("Conta {")
                .append("Identificador: ").append(codConta)
                .append(", Nome: ").append(nome)
                .append(", Saldo: ").append(saldo)
                .append(", Cartoes: ").append(cartoes)
                .append(", Lancamentos: ").append(lancamentos)
                .append("}").toString();
    }
}
