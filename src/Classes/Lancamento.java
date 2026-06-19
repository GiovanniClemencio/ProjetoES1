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
public class Lancamento implements Serializable {

    private String idLancamento;
    private String tipo;
    private Conta contaOrigem;
    private Conta contaDestino;
    private Date dataMax;
    private double valor;
    private Date dataLancamento;
    private String descricao;
    private Boolean pendente;
    private ArrayList<Categoria> categorias;
    private String idCartao;

    public Lancamento(String tipo, Conta contaOrigem, Conta contaDestino, Date dataMax, double valor, Date dataLancamento, String descricao, Boolean pendente, String idCartao) {
        this.idLancamento = UUID.randomUUID().toString();
        this.tipo = tipo;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.dataMax = dataMax;
        this.valor = valor;
        this.dataLancamento = dataLancamento;
        this.descricao = descricao;
        this.pendente = pendente;
        this.categorias = new ArrayList<>();
        this.idCartao = idCartao;
    }

    public String getIdLancamento() {
        return idLancamento;
    }

    public String getTipo() {
        return tipo;
    }

    public Conta getContaOrigem() {
        return contaOrigem;
    }

    public Conta getContaDestino() {
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

    public String getIdCartao() {
        return idCartao;
    }

    public String getNomeContaOrigem() {
        return (contaOrigem != null) ? contaOrigem.getNome() : "";
    }

    public String getNomeContaDestino() {
        return (contaDestino != null) ? contaDestino.getNome() : "";
    }

    public void setIdLancamento(String idLancamento) {
        this.idLancamento = idLancamento;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setContaOrigem(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public void setContaDestino(Conta contaDestino) {
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

    public void setIdCartao(String idCartao) {
        this.idCartao = idCartao;
    }

    public void editarLancamento(String tipo, Conta contaOrigem, Conta contaDestino, Date dataMax, double valor, Date dataLancamento, String descricao, Boolean pendente) {
        this.tipo = tipo;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.dataMax = dataMax;
        this.valor = valor;
        this.dataLancamento = dataLancamento;
        this.descricao = descricao;
        this.pendente = pendente;
    }
    
    public String toTextoExtrato() {
    String origem = contaOrigem != null ? contaOrigem.getNome() : "null";
    String destino = contaDestino != null ? contaDestino.getNome() : "null";

    return "Identificador: " + idLancamento +
           "\nTipo: " + tipo +
           "\nConta origem: " + origem +
           "\nConta destino: " + destino +
           "\nData máxima: " + dataMax +
           "\nValor: " + valor +
           "\nData do lançamento: " + dataLancamento +
           "\nDescrição: " + descricao +
           "\nPendente: " + pendente;
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
