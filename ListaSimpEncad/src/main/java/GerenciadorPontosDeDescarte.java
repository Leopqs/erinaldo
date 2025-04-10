import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class GerenciadorPontosDeDescarte {
    private ListaPontosDeDescarte lista;

    public GerenciadorPontosDeDescarte() {
        this.lista = new ListaPontosDeDescarte();
    }

    public void carregarPontosPorTipo(String tipoMaterial) {
        try (BufferedReader br = new BufferedReader(new FileReader("pontos_de_descartes.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length >= 4 && dados[2].equalsIgnoreCase(tipoMaterial)) {
                    PontoDeDescarte ponto = new PontoDeDescarte(dados[0], dados[1], dados[2], dados[3]);
                    lista.inserir(ponto);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public void exibirPontosCarregados() {
        System.out.println("\nPontos de Descarte Carregados (" + lista.getTamanho() + " encontrados):");
        lista.exibir();
    }
}