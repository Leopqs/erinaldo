class ListaPontosDeDescarte {
    private No inicio;
    private int tamanho;

    public ListaPontosDeDescarte() {
        this.inicio = null;
        this.tamanho = 0;
    }

    public void inserir(PontoDeDescarte pontoDeDescarte) {
        No novoNo = new No(pontoDeDescarte);

        if (inicio == null) {
            inicio = novoNo;
        } else {
            No atual = inicio;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novoNo);
        }
        tamanho++;
    }

    public void exibir() {
        if (inicio == null) {
            System.out.println("Nenhum ponto de descarte encontrado.");
            return;
        }

        No atual = inicio;
        int contador = 1;
        while (atual != null) {
            System.out.println("Ponto " + contador + ":");
            System.out.println(atual.getPontoDeDescarte());
            atual = atual.getProximo();
            contador++;
        }
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    // Getter para o tamanho
    public int getTamanho() {
        return tamanho;
    }
}
