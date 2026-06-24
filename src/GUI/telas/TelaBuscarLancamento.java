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
import Controller.ControladorRelatorio;
import GUI.formularios.editarLancamento;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Portu
 */
public class TelaBuscarLancamento extends javax.swing.JFrame {

    private final ControladorConta ctrlConta;
    private final ControladorLancamento ctrlLancamento;
    private final ControladorCategoria ctrlCategoria;
    private final ControladorRelatorio ctrlRelatorio;
    private final ArrayList<Conta> contas;
    private final java.awt.Frame parent;
    private final Runnable aoFechar;

    public TelaBuscarLancamento(java.awt.Frame parent, boolean modal, ControladorLancamento ctrlLancamento, ControladorConta ctrlConta, ControladorCategoria ctrlCategoria, ControladorRelatorio ctrlRelatorio, Runnable aoFechar) {
        this.ctrlConta = ctrlConta;
        this.ctrlLancamento = ctrlLancamento;
        this.ctrlCategoria = ctrlCategoria;
        this.ctrlRelatorio = ctrlRelatorio;
        this.parent = parent;
        this.contas = new ArrayList<>(ctrlConta.getContas());
        this.aoFechar = aoFechar;

        initComponents();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                if (TelaBuscarLancamento.this.aoFechar != null) {
                    TelaBuscarLancamento.this.aoFechar.run();
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campoDescLancamento = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaResultado = new javax.swing.JTextArea();
        buttonPesquisar = new javax.swing.JButton();
        buttonAbrirLancamento = new javax.swing.JButton();
        campoLancamento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campoValorMin = new javax.swing.JFormattedTextField();
        campoValorMax = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(200, 200, 242));

        jLabel1.setText("Descrição:");

        textAreaResultado.setColumns(20);
        textAreaResultado.setRows(5);
        jScrollPane1.setViewportView(textAreaResultado);

        buttonPesquisar.setText("Buscar");
        buttonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPesquisarActionPerformed(evt);
            }
        });

        buttonAbrirLancamento.setText("Abrir");
        buttonAbrirLancamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAbrirLancamentoActionPerformed(evt);
            }
        });

        jLabel2.setText("Abrir Lancamento:");

        campoValorMin.setColumns(6);
        campoValorMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoValorMinActionPerformed(evt);
            }
        });

        campoValorMax.setColumns(6);

        jLabel3.setText("-");

        jLabel4.setText("Faixa de valor");

        jLabel5.setText("Valores positivos para Receita");

        jLabel6.setText("Valores negativos para Despesa");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addComponent(buttonAbrirLancamento))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoDescLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoValorMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoValorMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoDescLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPesquisar))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoValorMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoValorMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        labelTitulo.setText("Buscar Lançamento");
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

    private void campoValorMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoValorMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoValorMinActionPerformed

    private void buttonAbrirLancamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAbrirLancamentoActionPerformed
        Lancamento escolhido = ctrlLancamento.buscarLancamento(campoLancamento.getText());

        editarLancamento dialog = new editarLancamento(this, true, ctrlLancamento, ctrlCategoria, escolhido, () -> {
            new TelaBuscarLancamento(parent, true, ctrlLancamento, ctrlConta, ctrlCategoria, ctrlRelatorio, aoFechar).setVisible(true);
        });
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);

        dispose();
    }//GEN-LAST:event_buttonAbrirLancamentoActionPerformed

    private void buttonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPesquisarActionPerformed
        ArrayList<Lancamento> resultBusca = ctrlLancamento.buscarLancamentoDesc(campoDescLancamento.getText());

        Double valorMin = null;
        Double valorMax = null;

        try {
            if (!campoValorMin.getText().isBlank()) {
                valorMin = Double.parseDouble(campoValorMin.getText());
            }

            if (!campoValorMax.getText().isBlank()) {
                valorMax = Double.parseDouble(campoValorMax.getText());
            }

            ArrayList<Lancamento> resultFiltro = ctrlRelatorio.filtrarPorValor(resultBusca, valorMin, valorMax);

            carregarLancamentos(resultFiltro);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                this,
                "Valor inválido.",
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_buttonPesquisarActionPerformed

    private YearMonth dateParaYearMonth(Date data) {
        LocalDate dataParcial = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        YearMonth dataYearMonth = YearMonth.from(dataParcial);

        return dataYearMonth;
    }

    private void carregarLancamentos(ArrayList<Lancamento> lancamentos) {
        textAreaResultado.setText("================== Lancamentos ==================\n");

        for (int i = lancamentos.size() - 1; i >= 0; i--) {
            Lancamento lancamento = lancamentos.get(i);
            YearMonth dataLancamento = dateParaYearMonth(lancamento.getDataLancamento());

            textAreaResultado.append("-----\n");
            textAreaResultado.append(lancamento.toTextoExtrato());
            textAreaResultado.append("\n-----\n");
        }
        textAreaResultado.append("\n==================================================\n\n");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAbrirLancamento;
    private javax.swing.JButton buttonPesquisar;
    private javax.swing.JTextField campoDescLancamento;
    private javax.swing.JTextField campoLancamento;
    private javax.swing.JFormattedTextField campoValorMax;
    private javax.swing.JFormattedTextField campoValorMin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTextArea textAreaResultado;
    // End of variables declaration//GEN-END:variables
}
