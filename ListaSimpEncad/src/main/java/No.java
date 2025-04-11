class No {
    private PontoDeDescarte pontoDeDescarte;
    private No proximo;

    public No(PontoDeDescarte pontoDeDescarte) {
        this.pontoDeDescarte = pontoDeDescarte;
        this.proximo = null;
    }

    // Getters e Setters
    public PontoDeDescarte getPontoDeDescarte() {
        return pontoDeDescarte;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}