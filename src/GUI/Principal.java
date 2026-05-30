/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package GUI;

import Controller.ControladorCartao;
import Controller.ControladorConta;
import Controller.ControladorLancamento;

/**
 *
 * @author Portu
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            ControladorLancamento ctrlLancamento = new ControladorLancamento();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaInicial janela = new TelaInicial();
                janela.setLocationRelativeTo(null); // Centraliza na tela
                janela.setVisible(true);            // Torna a janela visível
            }
        });
        
    }
    
}
