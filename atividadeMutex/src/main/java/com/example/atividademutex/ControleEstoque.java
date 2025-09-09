package com.example.atividademutex;

import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Controla o estoque de produtos do supermercado.
 * Utiliza um Mutex (ReentrantLock) para garantir que as operações de venda
 * sejam atômicas e seguras em um ambiente com múltiplas threads (caixas).
 */
public class ControleEstoque {

    private final Map<String, Produto> estoque = new HashMap<>();

    // ---- APLICAÇÃO DO MUTEX ----

    private final Lock mutex = new ReentrantLock();

    /**
     * Adiciona um produto ao estoque.
     *
     * @param produto O produto a ser adicionado.
     */
    public void adicionarProduto(Produto produto) {
        estoque.put(produto.getNome(), produto);
        System.out.println("ESTOQUE INICIAL: " + produto.getNome() + " | Quantidade: " + produto.getQuantidade());
    }

    // ---- SEÇÃO CRÍTICA ----

    /**
     * Processa a venda de um produto, garantindo acesso exclusivo ao estoque.
     *
     * @param nomeProduto O nome do produto a ser vendido.
     * @param nomeCaixa O nome do caixa que está processando a venda.
     * @return true se a venda foi bem-sucedida, false caso contrário.
     */
    public boolean processarVenda(String nomeProduto, String nomeCaixa) {
        // 1. Adquirir a trava (lock). Se estiver ocupada, a thread espera.
        mutex.lock();

        System.out.println("-> " + nomeCaixa + " tentando processar a venda de " + nomeProduto);

        try {
            Produto produto = estoque.get(nomeProduto);

            if (produto != null && produto.getQuantidade() > 0) {
                // Simula um tempo de processamento
                Thread.sleep(100);

                produto.venderUnidade();
                System.out.println("   [SUCESSO] " + nomeCaixa + " vendeu 1 " + nomeProduto + ". Restam: " + produto.getQuantidade());
                return true;
            } else {
                System.out.println("   [FALHA] " + nomeCaixa + ": " + nomeProduto + " fora de estoque.");
                return false;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        } finally {
            // 2. Liberar a trava (unlock).
            // O bloco `finally` garante que a trava será liberada mesmo que uma exceção ocorra.
            mutex.unlock();
            System.out.println("<- " + nomeCaixa + " liberou o sistema de estoque.");
        }
    }

    /**
     * Imprime o estado final do estoque.
     */
    public void imprimirEstoqueFinal() {
        System.out.println("\n--- ESTADO FINAL DO ESTOQUE ---");
        for (Produto produto : estoque.values()) {
            System.out.println("Produto: " + produto.getNome() + " | Quantidade Final: " + produto.getQuantidade());
        }
    }
}
