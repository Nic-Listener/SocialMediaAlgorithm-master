package LoginSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import negocio.PerfilUser;
import negocio.User;

public class Main {
    private static Map<String, Map<String, List<String>>> imagens = new HashMap<>();
    private static List<String> combinacoes = new ArrayList<>();
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void addImagem(String tema, String subtema, int afinidade, String caminho) {
        Map<String, List<String>> subtemas = imagens.get(tema);
        if (subtemas == null) {
            subtemas = new HashMap<>();
            imagens.put(tema, subtemas);
        }
        List<String> imagensAfinidade = subtemas.get(subtema);
        if (imagensAfinidade == null) {
            imagensAfinidade = new ArrayList<>();
            subtemas.put(subtema, imagensAfinidade);
        }
        imagensAfinidade.add(caminho);
    }

    public static void main(String[] args) throws IOException {

        // Configurar tratamento de exceções
        try {
            // código que pode gerar exceções
        } catch (Exception e) {
            // código que trata a exceção
        }

        Map<String, Integer> afinidades = new HashMap<>();
        afinidades.put("Interesse1", 1);
        afinidades.put("Interesse2", 0);
        afinidades.put("Interesse3", -1);

        // Criar alguns perfis de usuário
        PerfilUser perfil1 = new PerfilUser(afinidades);
        PerfilUser perfil2 = new PerfilUser(afinidades);

        // Criar usuários com os perfis criados
        User user1 = new User("Vinicius", "vinicius", "fernandes", "");
        User user2 = new User("Nicolas", "nicolas", "assis", "");

        // Adicionar os usuários criados em uma lista
        List<User> usuarios = new ArrayList<>();
        usuarios.add(user1);
        usuarios.add(user2);

        // Pedir ao usuário que faça login
        System.out.println("Digite seu nome de usuário:");
        String nomeUsuario = scanner.nextLine();
        System.out.println("Digite sua senha:");
        String senha = scanner.nextLine();

        // Verificar se as credenciais são válidas
        User usuarioLogado = null;
        for (User usuario : usuarios) {
            if (usuario.getUsername().equals(nomeUsuario) && usuario.getPass().equals(senha)) {
                usuarioLogado = usuario;
                break;
            }
        }

        // Se as credenciais forem inválidas, exibir mensagem de erro e encerrar o programa
        if (usuarioLogado == null) {
            System.out.println("Credenciais inválidas. Tente novamente.");
            return;
        }

        // Exibir informações do perfil do usuário logado
        System.out.println("Bem-vindo, " + usuarioLogado.getUsername() + "!");
        System.out.println("Aqui estão seus interesses:");
        System.out.println(usuarioLogado.getPerfil().getAfinidades());

        // Adicionar algumas imagens de exemplo
        addImagem("Tema1", "Subtema1", 1, "Images/animais/cachorro.jpg");
        addImagem("Tema1", "Subtema2", -1, "Images/animais/capivara.jpg");
        addImagem("Tema2", "Subtema1", 1, "Images/esportes/basquete.jpg");
        addImagem("Tema2", "Subtema2", -1, "Images/esportes/futebol.jpg");

        // Criar lista de todas as possíveis combinações de tema, subtema e afinidade
        for (String tema : imagens.keySet()) {
            for (String subtema : imagens.get(tema).keySet()) {
                List<String> imagensAfinidade = imagens.get(tema).get(subtema);
                for (int i = 0; i < imagensAfinidade.size(); i++) {
                    String caminhoImagem = imagensAfinidade.get(i);
                    String combinacao = tema + "_" + subtema + "_" + i;
                    combinacoes.add(combinacao);
                }
            }
        }

        // Embaralhar lista de combinações
        Collections.shuffle(combinacoes);

        // Obter uma combinação aleatória
        String combinacaoAleatoria = combinacoes.get(random.nextInt(combinacoes.size()));
        // Separar tema, subtema e afinidade
        String[] partes = combinacaoAleatoria.split("_");
        String temaAleatorio = partes[0];
        String subtemaAleatorio = partes[1];
        int afinidadeAleatoria = Integer.parseInt(partes[2]);
        // Exibir imagem aleatória na afinidade sorteada
        List<String> imagensSelecionadas = imagens.get(temaAleatorio).get(subtemaAleatorio);
        String caminhoImagemSelecionada = imagensSelecionadas.get(afinidadeAleatoria);

        System.out.println("Imagem aleatória selecionada:");
        System.out.println(caminhoImagemSelecionada);
    }

}