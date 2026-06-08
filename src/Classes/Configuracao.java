/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Luan
 */
public class Configuracao {

    private static Configuracao instancia = new Configuracao();
    private String arquivoConta;
    private String arquivoCategoria;

    public Configuracao() {
        this.arquivoConta = "./armazenamento/arquivoConta.dat";
        this.arquivoCategoria = "./armazenamento/arquivoCategoria.dat";
    }

    public String getArquivoConta() {
        return arquivoConta;
    }

    public void setArquivoConta(String arquivoConta) {
        this.arquivoConta = arquivoConta;
    }

    public String getArquivoCategoria() {
        return arquivoCategoria;
    }

    public void setArquivoCategoria(String arquivoCategoria) {
        this.arquivoCategoria = arquivoCategoria;
    }

    public static Configuracao getInstancia() {
        return instancia;
    }

    public static void setInstancia(Configuracao instancia) {
        Configuracao.instancia = instancia;
    }

    @Override
    public String toString() {
        return new StringBuffer("\nConfiguração")
                .append("\nContas")
                .append(this.arquivoConta)
                .append("\nCategorias")
                .append(this.arquivoCategoria)
                .toString();
    }
}
