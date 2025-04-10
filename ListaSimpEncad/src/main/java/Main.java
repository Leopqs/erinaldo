import java.util.Scanner;

public static void main(String[] args) {
    PontoDeDescarte.GerenciadorPontosDeDescarte gerenciador = new PontoDeDescarte.GerenciadorPontosDeDescarte();
    Scanner scanner = new Scanner(System.in);

    System.out.print("Informe o tipo de material para busca (ex: Plástico, Vidro, Eletrônicos): ");
    String tipoMaterial = scanner.nextLine();

    gerenciador.carregarPontosPorTipo(tipoMaterial);
    gerenciador.exibirPontosCarregados();

    scanner.close();
}
