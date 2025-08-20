package com.example.atividade01;

/**
 * Abstrai uma placa de rede virtual (vNIC) associada a uma máquina virtual.
 * Na vida real, o hypervisor emula uma placa de rede física, permitindo que a VM
 * se comunique com a rede externa e outras VMs.
 */
public class NetworkCard {
    private VirtualMachine vm;

    /**
     * Cria uma nova placa de rede associada a uma VM específica.
     * @param vm A máquina virtual à qual esta placa de rede pertence.
     */
    public NetworkCard(VirtualMachine vm) {
        this.vm = vm;
    }

    /**
     * Simula o recebimento de dados da rede.
     * Este método representa o hardware recebendo um pacote e notificando o sistema.
     * Na simulação, ele gera uma chamada de sistema para que o SO da VM processe os dados.
     * @param data Os dados recebidos.
     */
    public void receiveData(String data) {
        vm.printUserRequest();
        System.out.println("[NetworkCard] Dados recebidos: " + data);

        SystemCall call = new SystemCall(SystemCall.RECEIVE_DATA, data);
        vm.generateSystemCall(call);
    }
}
