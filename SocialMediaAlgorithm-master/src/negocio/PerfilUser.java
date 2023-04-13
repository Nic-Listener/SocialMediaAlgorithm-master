package negocio;

import java.util.Map;

public class PerfilUser {
    private String user;
    private String pass;
    private Map<String, Integer> afinidades;

    public PerfilUser(String user, String pass, Map<String, Integer> afinidades) {
        this.user = user;
        this.pass = pass;
        this.afinidades = afinidades;
    }

    public PerfilUser(Map<String, Integer> afinidades) {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Map<String, Integer> getAfinidades() {
        return afinidades;
    }

    public void setAfinidades(Map<String, Integer> afinidades) {
        this.afinidades = afinidades;
    }

    public String getUsername() {
        return user;
    }
}
