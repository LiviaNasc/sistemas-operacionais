package com.example.atividademutex;

/**
 * Representa um caixa de supermercado que processa a venda de um produto.
 * Cada caixa é uma thread que tenta vender um produto específico.
 * O acesso ao estoque é controlado por um mutex para evitar condições de corrida.
 */
public class Caixa implements Runnable {
    private final String nome;
    private final ControleEstoque controleEstoque;
    private final String produtoParaVender;

    /**
     * Cria uma nova instância de Caixa.
     *
     * @param nome O nome do caixa.
     * @param controleEstoque O controle de estoque compartilhado.
     * @param produtoParaVender O nome do produto que o caixa tentará vender.
     */
    public Caixa(String nome, ControleEstoque controleEstoque, String produtoParaVender) {
        this.nome = nome;
        this.controleEstoque = controleEstoque;
        this.produtoParaVender = produtoParaVender;
    }

    /**
     * O método run é executado quando a thread do caixa é iniciada.
     * Ele tenta processar a venda de um produto.
     */
    @Override
    public void run() {
        controleEstoque.processarVenda(produtoParaVender, this.nome);
    }
}
