/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Luan
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Inicializar {
    
    private Imobiliaria_EduardoGiovanniLuan nossaImobiliaria = Imobiliaria_EduardoGiovanniLuan.getInstancia();
    private Configuracao_EduardoGiovanniLuan config = nossaImobiliaria.getConfiguracoes();

    // Método genérico para carregar uma lista de objetos de um arquivo
    @SuppressWarnings("unchecked")
    public static <T> ArrayList<T> carregarObjetos(String caminhoArquivo) {
        ArrayList<T> lista = new ArrayList<>();
        File arquivo = new File(caminhoArquivo);

        if (!arquivo.exists()) {
            // System.out.println("Arquivo nao encontrado em " + caminhoArquivo + ". Criando novo arquivo vazio.");
            return lista;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            lista = (ArrayList<T>) ois.readObject();
            // System.out.println("Objetos carregados com sucesso de: " + caminhoArquivo);
        } catch (IOException | ClassNotFoundException e) {
            // System.err.println("Erro ao carregar objetos de " + caminhoArquivo);
            e.printStackTrace();
        }

        return lista;
    }

}
