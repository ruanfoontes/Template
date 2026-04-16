import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Tarefa> listaTarefas = new ArrayList<>();

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("---MENU---");
            System.out.println("Digite uma Opção:");
            System.out.println("Opção 1 Adicionar Tarefa");
            System.out.println("Opção 2 Listar Tarefa");
            System.out.println("Opção 0 Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Preparando para Adicionar");

            }
            
        }
    }
}
