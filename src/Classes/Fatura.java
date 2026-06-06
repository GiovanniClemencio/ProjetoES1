/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Portu
 */
public class Fatura implements Serializable {
    private String codConta;
    private String idCartao;
    private String idFatura;
    private Date data;
    private Boolean paga;
    private ArrayList<Lancamento> lancamentos;

    public Fatura(String codConta, String idCartao, Date data, Boolean paga) {
        this.codConta = codConta;
        this.idCartao = idCartao;
        idFatura = UUID.randomUUID().toString();
        this.data = data;
        this.paga = paga;
        this.lancamentos = new ArrayList<>();
    }

    public String getCodConta() {
        return codConta;
    }

    public String getIdCartao() {
        return idCartao;
    }

    public String getIdFatura() {
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

    public void setCodConta(String codConta) {
        this.codConta = codConta;
    }

    public void setIdCartao(String idCartao) {
        this.idCartao = idCartao;
    }

    public void setIdFatura(String idFatura) {
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
