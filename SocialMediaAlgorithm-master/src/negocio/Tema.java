package negocio;

import java.util.List;
import java.util.Map;

public class Tema {
    private String nome;
    private Map<String, List<String>> subtemas;

    public Tema(String nome, Map<String, List<String>> subtemas) {
        this.nome = nome;
        this.subtemas = subtemas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Map<String, List<String>> getSubtemas() {
        return subtemas;
    }

    public void setSubtemas(Map<String, List<String>> subtemas) {
        this.subtemas = subtemas;
    }
}