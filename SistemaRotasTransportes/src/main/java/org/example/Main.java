package org.example;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaRotasTransporte lista = new ListaRotasTransporte();

        System.out.println("Filtrar rotas por:");
        System.out.println("1 - Tipo de Transporte (Ônibus, Metrô, Trem)");
        System.out.println("2 - Região (Centro, Zona Norte, etc)");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        if (opcao != 1 && opcao != 2) {
            System.out.println("Opção inválida.");
            return;
        }

        System.out.print("Digite o filtro desejado: ");
        String filtro = scanner.nextLine();

        try {
            lista.carregarRotasDeArquivo("src/rotas_de_transportes.txt", filtro, opcao == 1);
            lista.exibirEmOrdem();
            lista.exibirEmOrdemInversa();
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        scanner.close();
    }
}
