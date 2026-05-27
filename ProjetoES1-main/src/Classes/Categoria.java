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
public class Categoria implements Serializable {
    private String nome;
    private Boolean padrao;
    private int qtdUsos;
    private ArrayList<Lancamento> usos;

    public Categoria(String nome, Boolean padrao, int qtdUsos) {
        this.nome = nome;
        this.padrao = padrao;
        this.qtdUsos = qtdUsos;
        this.usos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public Boolean getPadrao() {
        return padrao;
    }

    public int getQtdUsos() {
        return qtdUsos;
    }

    public ArrayList<Lancamento> getUsos() {
        return usos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPadrao(Boolean padrao) {
        this.padrao = padrao;
    }

    public void setQtdUsos(int qtdUsos) {
        this.qtdUsos = qtdUsos;
    }

    public void setUsos(ArrayList<Lancamento> usos) {
        this.usos = usos;
    }
    
    @Override
    public String toString() {
        return new StringBuffer("Categoria {")
                .append("Nome: ").append(nome)
                .append(", Padrao: ").append(padrao)
                .append(", Quantidade de usos: ").append(qtdUsos)
                .append(", Usos: ").append(usos)
                .append("}").toString();
    }
}
