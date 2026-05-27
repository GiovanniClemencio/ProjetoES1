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
public class Fatura implements Serializable {
    private int codConta;
    private int idCartao;
    private int idFatura;
    private Date data;
    private Boolean paga;
    private ArrayList<Lancamento> lancamentos;

    public Fatura(int codConta, int idCartao, int idFatura, Date data, Boolean paga) {
        this.codConta = codConta;
        this.idCartao = idCartao;
        this.idFatura = idFatura;
        this.data = data;
        this.paga = paga;
        this.lancamentos = new ArrayList<>();
    }

    public int getCodConta() {
        return codConta;
    }

    public int getIdCartao() {
        return idCartao;
    }

    public int getIdFatura() {
        return idFatura;
    }

    public Date getData() {
        return data;
    }

    public Boolean getPaga() {
        return paga;
    }

    public ArrayList<Lancamento> getLancamentos() {
        return lancamentos;
    }

    public void setCodConta(int codConta) {
        this.codConta = codConta;
    }

    public void setIdCartao(int idCartao) {
        this.idCartao = idCartao;
    }

    public void setIdFatura(int idFatura) {
        this.idFatura = idFatura;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setPaga(Boolean paga) {
        this.paga = paga;
    }

    public void setLancamentos(ArrayList<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }
    
    @Override
    public String toString() {
        return new StringBuffer("Fatura {")
                .append("Conta: ").append(codConta)
                .append(", Cartao: ").append(idCartao)
                .append(", Fatura: ").append(idFatura)
                .append(", Data: ").append(data)
                .append(", Status pagamento: ").append(paga)
                .append(", Lancamentos: ").append(lancamentos)
                .append("}").toString();
    }
}
