/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.telas;

import Classes.Cartao;
import Classes.Conta;
import Classes.Fatura;
import Classes.Lancamento;
import Controller.ControladorCategoria;
import Controller.ControladorConta;
import Controller.ControladorLancamento;
import GUI.formularios.editarLancamento;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Portu
 */
public class TelaExtratoConsolidado extends javax.swing.JFrame {

    private final ControladorConta ctrlConta;
    private final ControladorLancamento ctrlLancamento;
    private final ControladorCategoria ctrlCategoria;
    private final ArrayList<Conta> contas;
    private final java.awt.Frame parent;
    private YearMonth atual;
    private final Runnable aoFechar;

    public TelaExtratoConsolidado(java.awt.Frame parent, boolean modal, ControladorLancamento ctrlLancamento, ControladorConta ctrlConta, ControladorCategoria ctrlCategoria, Runnable aoFechar) {
        this.ctrlConta = ctrlConta;
        this.ctrlLancamento = ctrlLancamento;
        this.ctrlCategoria = ctrlCategoria;
        this.parent = parent;
        this.contas = new ArrayList<>(ctrlConta.getContas());
        this.aoFechar = aoFechar;

        atual = YearMonth.now();
        initComponents();

        carregarMes(atual, true);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                if (TelaExtratoConsolidado.this.aoFechar != null) {
                    TelaExtratoConsolidado.this.aoFechar.run();
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campoNomeCartao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaExtrato = new javax.swing.JTextArea();
        buttonMesAnterior = new javax.swing.JButton();
        buttonAbrirLancamento = new javax.swing.JButton();
        campoLancamento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(200, 200, 242));

        jLabel1.setText("Referente ao cartão:");

        textAreaExtrato.setColumns(20);
        textAreaExtrato.setRows(5);
        jScrollPane1.setViewportView(textAreaExtrato);

        buttonMesAnterior.setText("Carregar mês anterior");
        buttonMesAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMesAnteriorActionPerformed(evt);
            }
        });

        buttonAbrirLancamento.setText("Abrir");
        buttonAbrirLancamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAbrirLancamentoActionPerformed(evt);
            }
        });

        jLabel2.setText("Abrir Lancamento:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNomeCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonMesAnterior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonAbrirLancamento))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 23, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoNomeCartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonMesAnterior))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAbrirLancamento))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(30, 30, 150));
        jPanel1.setToolTipText("");

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(242, 242, 242));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Extrato consolidado");
        labelTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonMesAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMesAnteriorActionPerformed
        YearMonth anterior = atual.minusMonths(1);

        carregarMes(anterior, false);

        atual = anterior;
    }//GEN-LAST:event_buttonMesAnteriorActionPerformed

    private void buttonAbrirLancamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAbrirLancamentoActionPerformed
        Lancamento escolhido = ctrlLancamento.buscarLancamento(campoLancamento.getText());

        editarLancamento dialog = new editarLancamento(this, true, ctrlLancamento, ctrlCategoria, escolhido, () -> {
            new TelaExtratoConsolidado(parent, true, ctrlLancamento, ctrlConta, ctrlCategoria, aoFechar).setVisible(true);
        });
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);

        dispose();
    }//GEN-LAST:event_buttonAbrirLancamentoActionPerformed

    private void carregarFatura(Fatura fatura) {
        textAreaExtrato.append("\n");
        for (Lancamento lancamento : fatura.getLancamentos()) {
            textAreaExtrato.append("-----\n" + lancamento.toTextoExtrato() + "\n-----");
        }
        textAreaExtrato.append("\n");
    }

    private YearMonth dateParaYearMonth(Date data) {
        LocalDate dataParcial = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        YearMonth dataYearMonth = YearMonth.from(dataParcial);

        return dataYearMonth;
    }

    private void carregarMes(YearMonth atual, boolean limparTela) {
        if (limparTela) {
            textAreaExtrato.setText("");
        }

        textAreaExtrato.append("================== Lancamentos ");
        textAreaExtrato.append(atual.toString());
        textAreaExtrato.append(" ==================\n");

        for (Conta conta : contas) {
            ArrayList<Lancamento> lancamentos = new ArrayList<>(conta.getLancamentos());

            while (!lancamentos.isEmpty()) {
                Lancamento maisRecente = lancamentos.get(lancamentos.size() - 1);
                YearMonth dataLancamento = dateParaYearMonth(maisRecente.getDataLancamento());

                if (!dataLancamento.equals(atual)) {
                    break;
                }

                textAreaExtrato.append("-----\n");
                textAreaExtrato.append(maisRecente.toTextoExtrato());
                textAreaExtrato.append("\n-----\n");

                lancamentos.remove(lancamentos.size() - 1);
            }

            for (Cartao cartao : conta.getCartoes()) {
                ArrayList<Fatura> faturas = new ArrayList<>(cartao.getFaturasAntigas());
                Fatura faturaAtual = cartao.getFaturaAtual();

                if (faturaAtual == null) {
                    continue;
                }

                YearMonth dataFatura = dateParaYearMonth(faturaAtual.getData());

                while (dataFatura.isAfter(atual) && !faturas.isEmpty()) {
                    faturaAtual = faturas.remove(faturas.size() - 1);
                    dataFatura = dateParaYearMonth(faturaAtual.getData());
                }

                if (dataFatura.equals(atual)) {
                    carregarFatura(faturaAtual);
                }
            }
        }

        textAreaExtrato.append("\n==================================================\n\n");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAbrirLancamento;
    private javax.swing.JButton buttonMesAnterior;
    private javax.swing.JTextField campoLancamento;
    private javax.swing.JTextField campoNomeCartao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTextArea textAreaExtrato;
    // End of variables declaration//GEN-END:variables
}
