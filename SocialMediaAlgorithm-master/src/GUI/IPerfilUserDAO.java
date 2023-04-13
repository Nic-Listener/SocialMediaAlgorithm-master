package GUI;

import negocio.User;

import java.io.IOException;
import java.util.Map;

public abstract interface IPerfilUserDAO {
    void salvar(Map<String, Integer> afinidades) throws IOException;
    Map<String, Integer> getAfinidades() throws IOException;
    void salvarPerfil(User user) throws IOException;
    User carregarPerfil() throws IOException, ClassNotFoundException;
}
