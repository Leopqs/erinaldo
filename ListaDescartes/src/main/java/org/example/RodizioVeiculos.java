package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class RodizioVeiculos {
    private static LinkedList<Veiculo> lista = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void carregarDados(int criterio, String valor) {
        lista.clear();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\ListaDescartes\\src\\rodizio_de_veiculos.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 3) {
                    String placa = dados[0].trim();
                    String dia = dados[1].trim();
                    String horario = dados[2].trim();

                    boolean atendeCriterio = false;
                    if (criterio == 1) { // Filtrar por final da placa
                        char finalPlaca = valor.charAt(0);
                        char ultimoChar = placa.charAt(placa.length() - 1);
                        if (Character.isDigit(ultimoChar)) {
                            atendeCriterio = (ultimoChar == finalPlaca);
                        }
                    } else if (criterio == 2) { // Filtrar por dia da semana
                        atendeCriterio = dia.equalsIgnoreCase(valor);
                    }

                    if (atendeCriterio) {
                        lista.add(new Veiculo(placa, dia, horario));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public static void exibirVeiculos() {
        if (lista.isEmpty()) {
            System.out.println("Nenhum veículo encontrado com os critérios especificados.");
            return;
        }

        ListIterator<Veiculo> iterator = lista.listIterator();
        int opcao;
        do {
            if (!iterator.hasNext()) {
                iterator = lista.listIterator(); // Reinicia o iterator
            }

            Veiculo atual = iterator.next();
            System.out.println("\n" + atual.toString());
            System.out.println("\n1. Próximo veículo");
            System.out.println("2. Voltar ao menu");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
        } while (opcao != 2);
    }
}
