package dados;

import negocio.PerfilUser;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PerfilDAOImpl implements PerfilDAO {

    private static final String FILE_NAME = "perfis.bin";

    private List<PerfilUser> perfis;

    public PerfilDAOImpl() {
        carregarPerfis();
    }

    public List<PerfilUser> getPerfis() {
        return perfis;
    }

    public void salvarPerfilUser(PerfilUser perfil) {
        perfis.add(perfil);
        salvarPerfis();
    }

    public void atualizarPerfilUser(PerfilUser perfil) {
        int index = perfis.indexOf(perfil);
        perfis.set(index, perfil);
        salvarPerfis();
    }

    public void excluirPerfilUser(PerfilUser perfil) {
        perfis.remove(perfil);
        salvarPerfis();
    }

    private void salvarPerfis() {
        try {
            File file = new File(FILE_NAME);
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(perfis);
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void carregarPerfis() {
        try {
            File file = new File(FILE_NAME);
            if (file.exists()) {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                perfis = (List<PerfilUser>) in.readObject();
                in.close();
            } else {
                perfis = new ArrayList<>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void inserir(PerfilUser PerfilUser) throws SQLException {

    }

    @Override
    public void atualizar(PerfilUser PerfilUser) throws SQLException {

    }

    @Override
    public void excluir(String email) throws SQLException {

    }

    @Override
    public List<PerfilUser> listar() throws SQLException {
        return null;
    }

    @Override
    public PerfilUser buscarPorEmail(String email) throws SQLException {
        return null;
    }
}


