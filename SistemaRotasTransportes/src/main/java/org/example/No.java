package org.example;

public class No {
    private int id;
    private String nomeLinha;
    private String tipo;
    private String regiao;
    private No anterior;
    private No proximo;

    public No(int id, String nomeLinha, String tipo, String regiao) {
        this.id = id;
        this.nomeLinha = nomeLinha;
        this.tipo = tipo;
        this.regiao = regiao;
        this.anterior = null;
        this.proximo = null;
    }

    public int getId() { return id; }
    public String getNomeLinha() { return nomeLinha; }
    public String getTipo() { return tipo; }
    public String getRegiao() { return regiao; }
    public No getAnterior() { return anterior; }
    public No getProximo() { return proximo; }
    public void setAnterior(No anterior) { this.anterior = anterior; }
    public void setProximo(No proximo) { this.proximo = proximo; }
}
