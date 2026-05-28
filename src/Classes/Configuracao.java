/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Luan
 */
public class Configuracao
{
    private static Configuracao instancia = new Configuracao();
    private String arquivoConta;
    private String arquivoLancamento;
    private String arquivoCartao;

    public Configuracao()
    {
        this.arquivoConta = "./armazenamento/arquivoConta.dat";
    }

    public String getArquivoConta() { return arquivoConta; }
    public void setArquivoConta(String arquivoConta) { this.arquivoConta = arquivoConta; }

    public String getArquivoLancamento() { return arquivoLancamento; }
    public void setArquivoLancamento(String arquivoLancamento) { this.arquivoLancamento = arquivoLancamento; }

    public String getArquivoCartao() { return arquivoCartao; }
    public void setArquivoCartao(String arquivoCartao) { this.arquivoCartao = arquivoCartao; }


    public static Configuracao getInstancia() {
        return instancia;
    }
    
    @Override
    public String toString()
    {
        return new StringBuffer("\nConfiguração")
                .append("\nContas")
                .append(this.arquivoConta)
                .append("\nLançamentos")
                .append(this.arquivoLancamento)
                .append("\nCartões")
                .append(this.arquivoCartao)
                .toString();
    }
}

