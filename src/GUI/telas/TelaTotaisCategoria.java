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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Portu
 */
public class TelaTotaisCategoria extends javax.swing.JFrame {

    private final ControladorConta ctrlConta;
    private final ControladorLancamento ctrlLancamento;
    private final ControladorCategoria ctrlCategoria;
    private final ControladorRelatorio ctrlRelatorio;
    private final ArrayList<Conta> contas;
    private final java.awt.Frame parent;
    private final Runnable aoFechar;

    public TelaTotaisCategoria(java.awt.Frame parent, ControladorLancamento ctrlLancamento, ControladorConta ctrlConta, ControladorCategoria ctrlCategoria, ControladorRelatorio ctrlRelatorio, Runnable aoFechar) {
        this.ctrlConta = ctrlConta;
        this.ctrlLancamento = ctrlLancamento;
        this.ctrlCategoria = ctrlCategoria;
        this.ctrlRelatorio = ctrlRelatorio;
        this.parent = parent;
        this.contas = new ArrayList<>(ctrlConta.getContas());
        this.aoFechar = aoFechar;

        initComponents();

        try {
            MaskFormatter mascara = new MaskFormatter("##/##/####");

            campoDataInicio.setFormatterFactory(
                    new DefaultFormatterFactory(mascara)
            );

            campoDataFim.setFormatterFactory(
                    new DefaultFormatterFactory(
                            new MaskFormatter("##/##/####")
                    )
            );

        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                if (TelaTotaisCategoria.this.aoFechar != null) {
                    TelaTotaisCategoria.this.aoFechar.run();
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaResultado = new javax.swing.JTextArea();
        buttonPesquisar = new javax.swing.JButton();
        campoDataInicio = new javax.swing.JFormattedTextField();
        campoDataFim = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(200, 200, 242));

        textAreaResultado.setColumns(20);
        textAreaResultado.setRows(5);
        jScrollPane1.setViewportView(textAreaResultado);

        buttonPesquisar.setText("Buscar");
        buttonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPesquisarActionPerformed(evt);
            }
        });

        campoDataInicio.setColumns(6);
        campoDataInicio.setText("__/__/____");

        campoDataFim.setColumns(6);
        campoDataFim.setText("__/__/____");

        jLabel3.setText("Deixe as datas em branco se quiser o histórico inteiro");

        jLabel1.setText("Inicio");

        jLabel2.setText("Fim");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(campoDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(buttonPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPesquisar)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jPanel1.setBackground(new java.awt.Color(30, 30, 150));
        jPanel1.setToolTipText("");

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(242, 242, 242));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Totais por Categoria");
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

    private void buttonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPesquisarActionPerformed
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dataInicio = null;
            Date dataFim = null;
            if (dataPreenchida(campoDataInicio)) {
                dataInicio = sdf.parse(campoDataInicio.getText());
            }

            if (dataPreenchida(campoDataFim)) {
                dataFim = sdf.parse(campoDataFim.getText());
            }

            if (dataInicio != null && dataFim != null) {
                if (dataInicio.after(dataFim)) {
                    JOptionPane.showMessageDialog(this, "Período 1: A data inicial não pode ser maior que a data final.", "Erro de Validação", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            HashMap<String, Double> totais = ctrlRelatorio.obterTotaisPorIdCategoria(dataInicio, dataFim);

            carregarTotaisCategoria(totais);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Formato de data inválido. Use DD/MM/AAAA.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonPesquisarActionPerformed

    private boolean dataPreenchida(JFormattedTextField campo) {
        String texto = campo.getText().replace("/", "").trim();
        return !texto.isEmpty();
    }

    private void carregarTotaisCategoria(HashMap<String, Double> totais) {
        textAreaResultado.setText("================== Totais por Categoria ==================\n\n");

        if (totais == null || totais.isEmpty()) {
            textAreaResultado.append("Nenhum lançamento encontrado para os filtros selecionados.\n");
        } else {
            for (java.util.Map.Entry<String, Double> entrada : totais.entrySet()) {
                String uuidCategoria = entrada.getKey();
                Double totalValue = entrada.getValue();


                Classes.Categoria cat = ctrlCategoria.buscarCategoria(uuidCategoria);

                String nomeCategoria;
                if (cat != null && cat.getNome() != null) {
                    nomeCategoria = cat.getNome();
                } else {
                    nomeCategoria = "Categoria não encontrada (" + uuidCategoria.substring(0, 8) + "...)";
                }

                String linha = String.format("%-25s : R$ %.2f\n", nomeCategoria, totalValue);

                textAreaResultado.append(linha);
            }
        }

        textAreaResultado.append("\n==================================================\n\n");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonPesquisar;
    private javax.swing.JFormattedTextField campoDataFim;
    private javax.swing.JFormattedTextField campoDataInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTextArea textAreaResultado;
    // End of variables declaration//GEN-END:variables
}
