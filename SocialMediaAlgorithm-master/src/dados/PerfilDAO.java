package dados;

import negocio.PerfilUser;

import java.sql.SQLException;
import java.util.List;

public interface PerfilDAO {
    public void inserir(PerfilUser PerfilUser) throws SQLException;
    public void atualizar(PerfilUser PerfilUser) throws SQLException;
    public void excluir(String email) throws SQLException;
    public List<PerfilUser> listar() throws SQLException;
    public PerfilUser buscarPorEmail(String email) throws SQLException;

/*
    // Adiciona as afinidades do usuário
    user.addAfinidade("Esportes", 5);
    user.addAfinidade("Cultura Pop", 8);
    perfilDAO.addPerfilUser(user);*/
}
