package com.example.atividademutex;

/**
 * Classe principal que simula o funcionamento de um supermercado com múltiplos caixas.
 * Demonstra o uso de Mutex para controlar o acesso concorrente a um recurso compartilhado (estoque).
 */
public class SupermercadoSimulador {

    /**
     * O ponto de entrada da simulação.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws InterruptedException Se uma thread for interrompida enquanto espera.
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Iniciando simulação do supermercado...\n");

        ControleEstoque controleEstoque = new ControleEstoque();

        // Adicionando um produto com estoque limitado
        Produto leite = new Produto("Caixa de Leite", 3);
        controleEstoque.adicionarProduto(leite);
        System.out.println("-------------------------------------\n");

        // Criando 5 caixas (threads) que tentarão vender o mesmo produto ao mesmo tempo.
        Thread caixa1 = new Thread(new Caixa("Caixa 01", controleEstoque, "Caixa de Leite"));
        Thread caixa2 = new Thread(new Caixa("Caixa 02", controleEstoque, "Caixa de Leite"));
        Thread caixa3 = new Thread(new Caixa("Caixa 03", controleEstoque, "Caixa de Leite"));
        Thread caixa4 = new Thread(new Caixa("Caixa 04", controleEstoque, "Caixa de Leite"));
        Thread caixa5 = new Thread(new Caixa("Caixa 05", controleEstoque, "Caixa de Leite"));

        // Iniciando todos os caixas simultaneamente
        caixa1.start();
        caixa2.start();
        caixa3.start();
        caixa4.start();
        caixa5.start();

        // Esperando todas as threads terminarem para ver o resultado final
        caixa1.join();
        caixa2.join();
        caixa3.join();
        caixa4.join();
        caixa5.join();

        controleEstoque.imprimirEstoqueFinal();
    }
}
