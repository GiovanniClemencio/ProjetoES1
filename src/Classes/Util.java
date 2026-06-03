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
public class Util implements Serializable {
    protected static int proxCodConta = 0;
    protected static int proxIdCategoria = 0;
    protected static int proxIdLancamento = 0;
    
    public void setProxCodConta(int proxCodConta) {
        this.proxCodConta = proxCodConta;
    }

    public static int getProxCodConta() {
        int codAtual = proxCodConta;
        proxCodConta++;
        return codAtual;
    }
    
    public static void atualizarProxCodConta(ArrayList<Conta> contas) {
        int maior = -1;
        for (Conta conta : contas) {
            if (conta.getCodConta() > maior) {
                maior = conta.getCodConta();
            }
        }
        if(maior <= -1){
            proxCodConta = 0;
        }else{
            proxCodConta = maior + 1;
        }
        
    }
    
    public void setProxIdCategoria(int proxIdCategoria) {
        this.proxIdCategoria = proxIdCategoria;
    }

    public static int getProxIdCategoria() {
        int idAtual = proxIdCategoria;
        proxIdCategoria++;
        return idAtual;
    }
    
    public static void atualizarProxIdCategoria(ArrayList<Categoria> categorias) {
        int maior = -1;
        for (Categoria categoria : categorias) {
            if (categoria.getIdCategoria() > maior) {
                maior = categoria.getIdCategoria();
            }
        }
        if(maior <= -1){
            proxIdCategoria = 0;
        }else{
            proxIdCategoria = maior + 1;
        }
        
    }
    
    public void setProxIdLancamento(int proxIdLancamento) {
        this.proxIdLancamento = proxIdLancamento;
    }

    public static int getProxIdLancamento() {
        int idAtual = proxIdLancamento;
        proxIdLancamento++;
        return idAtual;
    }
    
    public static void atualizarProxIdLancamento(ArrayList<Lancamento> lancamentos) {
        int maior = -1;
        for (Lancamento lancamento : lancamentos) {
            if (lancamento.getIdLancamento() > maior) {
                maior = lancamento.getIdLancamento();
            }
        }
        if(maior <= -1){
            proxIdLancamento = 0;
        }else{
            proxIdLancamento = maior + 1;
        }
        
    }
    
    @Override
    public String toString() {
        return new StringBuffer("Constantes {")
                .append("Proximo codConta: ").append(proxCodConta)
                .append("Proximo idCategoria: ").append(proxIdCategoria)
                .append("Proximo idLancamento: ").append(proxIdLancamento)
                .append("}").toString();
    }
}
