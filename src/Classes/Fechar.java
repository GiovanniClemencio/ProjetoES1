/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Luan
 */
public class Fechar {

    // Método genérico para salvar uma lista de objetos em um arquivo
    public static <T> void salvarObjetos(ArrayList<T> lista, String caminhoArquivo) {
        try {
            File arquivo = new File(caminhoArquivo);
            File pasta = arquivo.getParentFile(); // pega o diretório pai

            if (pasta != null && !pasta.exists()) {
                pasta.mkdirs(); // cria todas as pastas necessárias
                // System.out.println("Diretorio criado: " + pasta.getAbsolutePath());
            }

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
                oos.writeObject(lista);
                // System.out.println("Objetos salvos com sucesso em: " + caminhoArquivo);
            }

        } catch (IOException e) {
            // System.err.println("Erro ao salvar objetos em " + caminhoArquivo);
            e.printStackTrace();
        }
    }
}
