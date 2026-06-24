/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Luan
 */
public class Relatorio {

    private Date inicio;
    private Date fim;
    private String tipo;
    private ArrayList<Categoria> categoria;
    private ArrayList<Cartao> cartao;
    private ArrayList<Conta> conta;

    public Relatorio() {
    }

    // Filtro em cascata, cada filtro é aplicado sobre o resultado anterior
    public ArrayList<Lancamento> gerarRelatorio(ArrayList<Lancamento> lancamentosBrutos) {

        // Se ainda não tiver nenhum lançamento, retorna uma lista vazia
        if (lancamentosBrutos == null) {
            return new ArrayList<>(); // Não retorno null para evitar NullPointerException
        }

        ArrayList<Lancamento> resultado = new ArrayList<>(lancamentosBrutos); // Cria uma cópia da lista original

        // System.out.println("Inicial: " + resultado.size());

        // 1. Filtro de Conta
        if (conta != null) {
            resultado.removeIf(lancamento
                    -> conta.stream().noneMatch(c -> java.util.Objects.equals(c, lancamento.getContaOrigem()))
                    && conta.stream().noneMatch(c -> java.util.Objects.equals(c, lancamento.getContaDestino()))
            );
        }

        // System.out.println("Após conta: " + resultado.size());

        // 2. Filtro de data
        if (inicio != null || fim != null) {
            if (inicio != null && fim != null) {
                if (!inicio.after(fim)) {
                    resultado.removeIf(lancamento -> lancamento.getDataLancamento().before(inicio) || lancamento.getDataLancamento().after(fim));
                } else {
                    return new ArrayList<>();
                }
            } else if (inicio != null) {
                resultado.removeIf(lancamento -> lancamento.getDataLancamento().before(inicio));
            } else {
                resultado.removeIf(lancamento -> lancamento.getDataLancamento().after(fim));
            }
        }

        // System.out.println("Após data: " + resultado.size());

        // 3. Filtro de tipo
        if (tipo != null) {
            resultado.removeIf(lancamento -> !tipo.equalsIgnoreCase(lancamento.getTipo()));
        }

        // System.out.println("Após tipo: " + resultado.size());

        // 4. Filtro de categoria
        if (categoria != null && !categoria.isEmpty()) {
            resultado.removeIf(lancamento -> {
                if (lancamento.getCategorias() == null) {
                    return true;
                }

                for (Categoria catSelecionada : categoria) {
                    for (Categoria catLancamento : lancamento.getCategorias()) {
                        if (catSelecionada.getIdCategoria()
                                .equals(catLancamento.getIdCategoria())) {
                            return false; // encontrou uma categoria compatível
                        }
                    }
                }

                return true; // nenhuma categoria compatível encontrada
            });
        }

        //System.out.println("Após categoria: " + resultado.size());

        // 5. Filtro de cartão
        if (cartao != null && !cartao.isEmpty()) {
            resultado.removeIf(lancamento
                    -> lancamento.getIdCartao() == null
                    || cartao.stream().noneMatch(c -> java.util.Objects.equals(c.getIdCartao(), lancamento.getIdCartao()))
            );
        }

        //System.out.println("Após cartão: " + resultado.size());

        return resultado; // Retorna lista filtrada
    }

    public Relatorio(Date inicio, Date fim, String tipo, ArrayList<Categoria> categoria, ArrayList<Cartao> cartao, ArrayList<Conta> conta) {
        this.inicio = inicio;
        this.fim = fim;
        this.tipo = tipo;
        this.categoria = categoria;
        this.cartao = cartao;
        this.conta = conta;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(ArrayList<Categoria> categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Cartao> getCartao() {
        return cartao;
    }

    public void setCartao(ArrayList<Cartao> cartao) {
        this.cartao = cartao;
    }

    public ArrayList<Conta> getConta() {
        return conta;
    }

    public void setConta(ArrayList<Conta> conta) {
        this.conta = conta;
    }

}
