/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.Serializable;
import java.util.UUID;

/**
 *
 * @author Portu
 */
public class Categoria implements Serializable {
    private String nome;
    private Boolean padrao;
    private String idCategoria;

    public Categoria(String nome, Boolean padrao) {
        this.nome = nome;
        this.padrao = padrao;
        this.idCategoria = UUID.randomUUID().toString(); // Gera um ID único para cada categoria
    }

    public String getNome() {
        return nome;
    }

    public Boolean getPadrao() {
        return padrao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPadrao(Boolean padrao) {
        this.padrao = padrao;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    @Override
    public String toString() {
        return new StringBuffer("Categoria {")
                .append("Nome: ").append(nome)
                .append(", Padrao: ").append(padrao)
                .append("}").toString();
    }
}
