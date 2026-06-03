/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Classes.Categoria;
import Classes.Configuracao;
import Classes.Fechar;
import Classes.Inicializar;
import java.util.ArrayList;

/**
 *
 * @author Luan
 */
public class ControladorCategoria {

    private final Configuracao caminhosArquivo = Configuracao.getInstancia();
    private ArrayList<Categoria> categorias = Inicializar.carregarObjetos(caminhosArquivo.getArquivoCategoria());

    public void criarCategoria(Categoria categoria) {
        categorias.add(categoria);
        Fechar.salvarObjetos(categorias, caminhosArquivo.getArquivoCategoria());
    }

    public boolean removerCategoria(int id) {
        Categoria categoriaParaRemover = buscarCategoria(id);
        if (categoriaParaRemover != null) {
            categorias.remove(categoriaParaRemover);
            Fechar.salvarObjetos(categorias, caminhosArquivo.getArquivoCategoria());
            return true; // Sucesso na remoção
        }
        return false; // Falha na remoção
    }

    public Categoria buscarCategoria(int idCategoria) {
        return categorias.stream().filter(c -> c.getIdCategoria() == idCategoria).findFirst().orElse(null);
    }

    public void setPadrao(int idCategoria) {
        Categoria categoria = buscarCategoria(idCategoria);

        // Verifica se a categoria existe e não é a categoria padrão atual
        if (categoria != null && !categoria.getPadrao()) {
            for (Categoria c : categorias) {
                c.setPadrao(false); // Desmarca todas as categorias como padrão
            }

            categoria.setPadrao(true); // Categoria selecionada vira a nova categoria padrão
            Fechar.salvarObjetos(categorias, caminhosArquivo.getArquivoCategoria());
        }
    }

    public boolean editarCategoria(int idCategoria, String novoNome) {
        Categoria categoria = buscarCategoria(idCategoria);
        if (categoria != null) {
            categoria.setNome(novoNome);
            Fechar.salvarObjetos(categorias, caminhosArquivo.getArquivoCategoria());
            return true; // Sucesso na edição
        }
        return false; // Falha na edição
    }

    public ArrayList<Categoria> getCategorias() {
        return new ArrayList<>(this.categorias); // Retorna uma cópia da lista para evitar modificações sem passar pelo controlador
    }

    public Configuracao getCaminhosArquivo() {
        return caminhosArquivo;
    }
}
