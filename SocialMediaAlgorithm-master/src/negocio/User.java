package negocio;

import GUI.IPerfilUserDAO;
import dados.PerfilDAOImpl;
import dados.PerfilUserDAO;

import java.util.HashMap;
import java.util.Map;

public class User extends PerfilUser {
    private String nome;
    private String user;
    private Map<String, Integer> afinidades;

    public User(String nome, String user, String pass, Map<String, Integer> afinidades) {
        super(user, pass, afinidades);
        this.nome = nome;
        this.user = user;
        this.afinidades = afinidades;
    }

    public User(String username) {
        super(username, "", new HashMap<>(15, 1));
        this.nome = "";
        this.user = username;
        this.afinidades = new HashMap<>();
        this.afinidades.put("esportes", 15);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return user;
    }

    public void setUsername(String user) {
        this.user = user;
    }

    public void addAfinidade(String tema, int valor) {
        if (afinidades.containsKey(tema)) {
            int af = afinidades.get(tema);
            afinidades.put(tema, af + valor);
        } else {
            afinidades.put(tema, valor);
        }
    }

    public Map<String, Integer> getAfinidades() {
        return afinidades;
    }

    public IPerfilUserDAO getPerfil() {
        return PerfilUserDAO;
    }
}
