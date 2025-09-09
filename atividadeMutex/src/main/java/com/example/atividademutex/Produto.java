package com.example.atividademutex;

/**
 * Representa um produto no estoque do supermercado.
 */
public class Produto {
    private String nome;
    private int quantidade;

    /**
     * Cria uma nova instância de Produto.
     *
     * @param nome O nome do produto.
     * @param quantidade A quantidade inicial do produto em estoque.
     */
    public Produto(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    /**
     * Retorna o nome do produto.
     *
     * @return O nome do produto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna a quantidade atual do produto em estoque.
     *
     * @return A quantidade em estoque.
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Decrementa a quantidade do produto em uma unidade para simular uma venda.
     */
    public void venderUnidade() {
        if (this.quantidade > 0) {
            this.quantidade--;
        }
    }
}
