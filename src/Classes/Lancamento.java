/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Portu
 */
public class Lancamento implements Serializable {
    private int idLancamento;
    private String tipo;
    private int contaOrigem;
    private int contaDestino;
    private Date dataMax;
    private double valor;
    private Date dataLancamento;
    private String descricao;
    private Boolean pendente;
    private ArrayList<Categoria> categorias;

    public Lancamento(int idLancamento, String tipo, int contaOrigem, int contaDestino, Date dataMax, double valor, Date dataLancamento, String descricao, Boolean pendente) {
        this.idLancamento = idLancamento;
        this.tipo = tipo;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.dataMax = dataMax;
        this.valor = valor;
        this.dataLancamento = dataLancamento;
        this.descricao = descricao;
        this.pendente = pendente;
        this.categorias = new ArrayList<>();
    }

    public int getIdLancamento() {
        return idLancamento;
    }

    public String getTipo() {
        return tipo;
    }

    public int getContaOrigem() {
        return contaOrigem;
    }

    public int getContaDestino() {
        return contaDestino;
    }

    public Date getDataMax() {
        return dataMax;
    }

    public double getValor() {
        return valor;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public Boolean getPendente() {
        return pendente;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setIdLancamento(int idLancamento) {
        this.idLancamento = idLancamento;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setContaOrigem(int contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public void setContaDestino(int contaDestino) {
        this.contaDestino = contaDestino;
    }

    public void setDataMax(Date dataMax) {
        this.dataMax = dataMax;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPendente(Boolean pendente) {
        this.pendente = pendente;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    public void editarLancamento(String tipo, int contaOrigem, int contaDestino, Date dataMax, double valor, Date dataLancamento, String descricao, Boolean pendente) {
        this.tipo = tipo;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.dataMax = dataMax;
        this.valor = valor;
        this.dataLancamento = dataLancamento;
        this.descricao = descricao;
        this.pendente = pendente;
    }

    
    @Override
    public String toString() {
        return new StringBuffer("Lancamento {")
                .append("Identificador: ").append(idLancamento)
                .append(", Tipo: ").append(tipo)
                .append(", Conta origem: ").append(contaOrigem)
                .append(", Conta destino: ").append(contaDestino)
                .append(", Data maxima de lancamento: ").append(dataMax)
                .append(", Valor: ").append(valor)
                .append(", Data do lancamento: ").append(dataLancamento)
                .append(", Descricao: ").append(descricao)
                .append(", Pendencia: ").append(pendente)
                .append(", Categorias: ").append(categorias)
                .append("}").toString();
    }
}
