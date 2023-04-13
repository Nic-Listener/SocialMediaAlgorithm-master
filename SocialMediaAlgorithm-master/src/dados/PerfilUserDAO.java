package dados;

import GUI.IPerfilUserDAO;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public abstract class PerfilUserDAO {

    private static final String FILE_PATH = "perfis.dat";


    public void salvar(Map<String, Integer> afinidades) {
        try {
            FileOutputStream fileOut = new FileOutputStream(FILE_PATH);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(afinidades);
            objectOut.close();
            fileOut.close();
        } catch (IOException ex) {
            System.out.println("Erro ao salvar perfil do usuário: " + ex.getMessage());
        }
    }

    public Map<String, Integer> getAfinidades() {
        Map<String, Integer> afinidades = new HashMap<>();
        try {
            FileInputStream fileIn = new FileInputStream(FILE_PATH);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            afinidades = (Map<String, Integer>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao recuperar afinidades do usuário: " + ex.getMessage());
        }
        return afinidades;
    }

}

