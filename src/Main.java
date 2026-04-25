package src;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Conexão do Main com o Banco de Dados
        System.out.println("Tentando connectar ao Banco...");
        ConexaoBanco.conectar();
        System.out.println("Conexão realizada");

        //Conexão do class Main com a class Tarefa->("chamando") 
        TarefaDAO dao = new TarefaDAO();
        dao.criarTabela();

        int opcao = -1;
        while (opcao != 0) { 
            System.out.println("================================ ");
            System.out.println("       SISTEMA DE TAREFAS    ");
            System.out.println("================================");
            System.out.println("      Digite uma Opção:");
            System.out.println("    [1] Adicionar Nova Tarefa");
            System.out.println("    [2] Listar Todas as Tarefas");
            System.out.println("    [3] Remover uma Tarefa");
            System.out.println("    [0] Sair");
            System.out.println("=================================");
            opcao = scanner.nextInt();
            switch (opcao) {      //Base Para Listar Tarefas
                case 1:
                    scanner.nextLine();
                    System.out.print("Digite o Nome da Tarefa: ");
                    String nome = scanner.nextLine().trim();  //Pede e Captura o nome da Tarefa ()trim remove espaços.

                    if (nome.isEmpty()) {
                        System.out.println("Nome Vazio. tarefa não Criada");
                    } else {
                        Tarefa novaTarefa = new Tarefa(nome);
                        dao.salvarTarefa(novaTarefa.getnome());
                    }
                    break;

                    case 2:
                        //Busca os dados do Banco
                        ArrayList<Tarefa> tarefasDoBanco = dao.listarTarefas();
                        
                        System.out.println("\n----- SUAS TAREFAS -----");
                        System.out.printf("%-5s | %-20s\n", "ID", "NOME DA TAREFA");
                        System.out.println("---------------------------");

                        for (Tarefa t : tarefasDoBanco) {
                            System.out.printf("%-5s | %-20s\n", "", t.getnome());
                        }
                        System.out.println("------------------------------\n");
                        break;
    

                        case 3:
                            System.out.println("\n--- REMOVER TAREFA ---");
                             //Pergunta qual o ID
                            System.out.println("Digite o ID da tarefa que deseja excluir: ");
                             //Ler o número que o úsuario digitou 
                            int idParaDeletar = scanner.nextInt();
                             // chama o método que criei no DAO
                            dao.removerTarefa(idParaDeletar);
                            break;

            }
            
        }
        scanner.close();  //scanner.close(); Utilizado para fechar o scanner e resolver erro "is never closed"
    } 
     //método para organzar o Consoloe 
    public static void limparConsole() {
        for (int i = 0; i < 50; i++) System.out.println();
    }
}
