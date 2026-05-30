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
    protected static int proxIdCartao = 0;
    
    public void setProxCodConta(int proxCodConta) {
        this.proxCodConta = proxCodConta;
    }

    public static int getProxCodConta() {
        int codAtual = proxCodConta;
        proxCodConta++;
        return codAtual;
    }

    public static int getProxIdCartao() {
        int idAtual = proxIdCartao;
        proxIdCartao++;
        return idAtual;
    }

    public void setProxIdCartao(int proxIdCartao) {
        this.proxIdCartao = proxIdCartao;
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
    
    public static void atualizarProxIdCartao(ArrayList<Cartao> cartoes) {
        int maior = -1;
        for (Cartao cartao : cartoes) {
            if (cartao.getIdCartao() > maior) {
                maior = cartao.getIdCartao();
            }
        }
        
        if(maior <= -1){
            proxIdCartao = 0;
        }else{
            proxIdCartao = maior + 1;
        }
    }
    
    @Override
    public String toString() {
        return new StringBuffer("Constantes {")
                .append("Proximo codConta: ").append(proxCodConta)
                .append(", Proximo idCartao: ").append(proxIdCartao)
                .append("}").toString();
    }
}
