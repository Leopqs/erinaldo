package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ListaRotasTransporte {
    private No cabeca;

    public void inserirNo(int id, String nomeLinha, String tipo, String regiao) {
        No novoNo = new No(id, nomeLinha, tipo, regiao);
        if (cabeca == null) {
            cabeca = novoNo;
        } else {
            No atual = cabeca;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novoNo);
            novoNo.setAnterior(atual);
        }
    }

    public void carregarRotasDeArquivo(String nomeArquivo, String filtro, boolean filtrarPorTipo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 4) {
                    int id = Integer.parseInt(dados[0]);
                    String nomeLinha = dados[1];
                    String tipo = dados[2];
                    String regiao = dados[3];

                    if ((filtrarPorTipo && tipo.equals(filtro)) ||
                            (!filtrarPorTipo && regiao.equals(filtro))) {
                        inserirNo(id, nomeLinha, tipo, regiao);
                    }
                }
            }
        }
    }

    public void exibirEmOrdem() {
        if (cabeca == null) {
            System.out.println("Nenhuma rota encontrada.");
            return;
        }
        No atual = cabeca;
        System.out.println("\nRotas em ordem:");
        while (atual != null) {
            System.out.printf("ID: %d | Linha: %s | Tipo: %s | Região: %s\n",
                    atual.getId(), atual.getNomeLinha(), atual.getTipo(), atual.getRegiao());
            atual = atual.getProximo();
        }
    }

    public void exibirEmOrdemInversa() {
        if (cabeca == null) {
            System.out.println("Nenhuma rota encontrada.");
            return;
        }
        No atual = cabeca;
        while (atual.getProximo() != null) {
            atual = atual.getProximo();
        }
        System.out.println("\nRotas em ordem inversa:");
        while (atual != null) {
            System.out.printf("ID: %d | Linha: %s | Tipo: %s | Região: %s\n",
                    atual.getId(), atual.getNomeLinha(), atual.getTipo(), atual.getRegiao());
            atual = atual.getAnterior();
        }
    }
}
