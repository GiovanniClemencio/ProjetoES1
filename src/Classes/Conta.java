/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Portu
 */
public class Conta implements Serializable {

    private String codConta;
    private String nome;
    private double saldo;
    private ArrayList<Cartao> cartoes;
    private ArrayList<Lancamento> lancamentos;

    public Conta(String nome, double saldo) {
        this.codConta = UUID.randomUUID().toString();
        this.nome = nome;
        this.saldo = saldo;
        this.cartoes = new ArrayList<>();
        this.lancamentos = new ArrayList<>();
    }

    public String getCodConta() {
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

    public void setCodConta(String codConta) {
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

    public void adicionarCartao(Cartao cartao) {
        this.cartoes.add(cartao);
    }

    public void adicionarLancamento(Lancamento lancamento, boolean cartao) {
        double novoSaldo = this.saldo;
        
        this.lancamentos.add(lancamento);
        
        if(! cartao) novoSaldo = novoSaldo + lancamento.getValor(); // se o lancamento for para cartão, não afeta o saldo
        
        this.saldo = novoSaldo;
    }

    public void removerCartao(Cartao cartao) {
        this.cartoes.remove(cartao);
    }

    public void removerLancamento(Lancamento lancamento, boolean cartao) {
        double novoSaldo = this.saldo;

        this.lancamentos.remove(lancamento);

        if(! cartao) novoSaldo = novoSaldo - lancamento.getValor();


        this.saldo = novoSaldo;
    }

    public void editarConta(String nome, double saldo) {
        this.nome = nome;
        this.saldo = saldo;
    }

    public ArrayList<Lancamento> extrato() {
        if (lancamentos.isEmpty()) {
            return new ArrayList<>();
        }
        return lancamentos;
    }

    @Override
    public String toString() {
        return new StringBuffer("Conta {")
                .append(", Nome: ").append(nome)
                .append("Identificador: ").append(codConta)
                .append(", Saldo: ").append(saldo)
                .append("}").toString();
    }
}
