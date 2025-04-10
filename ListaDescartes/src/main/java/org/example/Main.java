import org.example.RodizioVeiculos;

import java.util.Scanner;

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("=== Sistema de Rodízio de Veículos ===");

    int opcao;
    do {
        System.out.println("\nMenu Principal:");
        System.out.println("1. Filtrar por final da placa");
        System.out.println("2. Filtrar por dia da semana");
        System.out.println("3. Sair");
        System.out.print("Escolha: ");
        opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Digite o último dígito da placa (0-9): ");
                String finalPlaca = scanner.nextLine();
                RodizioVeiculos.carregarDados(opcao, finalPlaca);
                RodizioVeiculos.exibirVeiculos();
                break;
            case 2:
                System.out.print("Digite o dia da semana (ex: Segunda): ");
                String diaSemana = scanner.nextLine();
                RodizioVeiculos.carregarDados(opcao, diaSemana);
                RodizioVeiculos.exibirVeiculos();
                break;
            case 3:
                System.out.println("Encerrando...");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    } while (opcao != 3);

    scanner.close();
}

