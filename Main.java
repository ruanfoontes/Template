import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Tarefa> listaTarefas = new ArrayList<>();

        int opcao = -1;
        while (opcao != 0) {
            opcao = scanner.nextInt();
            System.out.println("---MENU---");
            System.out.println("Digite uma Opção:");
            System.out.println("Opção 0 Sair");
            System.out.println("Opção 1 Adicionar Tarefa");
            System.out.println("Opção 2 Listas Tarefa");
            
        }
    }
}
