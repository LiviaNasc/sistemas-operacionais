package com.example.atividade01;

public class Main {
    public static void main(String[] args) {
        Hypervisor hypervisor = new Hypervisor();

        VirtualMachine vm1 = new VirtualMachine("VM1");
        VirtualMachine vm2 = new VirtualMachine("VM2");

        // Adicionar ao hipervisor
        hypervisor.addVM(vm1);
        hypervisor.addVM(vm2);

        System.out.println("--------------------------------------------------");
        vm1.getNetworkCard().receiveData("Hello from network to VM1");

        System.out.println("--------------------------------------------------");
        vm2.getNetworkCard().receiveData("Ping request to VM2");
    }
}
