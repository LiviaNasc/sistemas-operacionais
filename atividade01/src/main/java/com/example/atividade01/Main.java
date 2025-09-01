package com.example.atividade01;

/**
 * Ponto de entrada da aplicação, onde a simulação é iniciada.
 */
public class Main {
    /**
     * Método principal que cria o ambiente de simulação.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        Hypervisor hypervisor = new Hypervisor();

        VirtualMachine vm1 = new VirtualMachine("VM1", hypervisor);
        vm1.setMessage("Hello from network to VM1");

        VirtualMachine vm2 = new VirtualMachine("VM2", hypervisor);
        vm2.setMessage("Ping request to VM2");

        // Adicionar ao hipervisor
        hypervisor.addVM(vm1);
        hypervisor.addVM(vm2);

        // Iniciar todas as VMs
        hypervisor.startAllVMs();
    }
}