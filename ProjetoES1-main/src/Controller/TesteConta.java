package Controller;

/**
 *
 * @author Luan
 */

import Classes.Conta;

public class TesteConta
{
    public static void main(String[] args)
    {
        // PRIMEIRA EXECUÇÃO
        ControladorConta controlador1 = new ControladorConta();

        Conta conta = new Conta(1, "Luan", 1000.0);

        controlador1.criarConta(conta);




        // "Nova execução do sistema"
        ControladorConta controlador2 = new ControladorConta();

        Conta contaCarregada = controlador2.buscarConta(1);

        if (contaCarregada != null)
        {
            System.out.println("Persistência funcionando!");
            System.out.println("Conta encontrada: " 
                    + contaCarregada.getNome());
        }
        else
        {
            System.out.println("Falha na persistência!");
        }
    }
}
