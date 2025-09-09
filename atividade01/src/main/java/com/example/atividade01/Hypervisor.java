package com.example.atividade01;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa o Hypervisor, a camada de software que cria e gerencia as máquinas virtuais.
 * Na vida real, é o software que roda diretamente no hardware (Tipo 1) ou sobre um SO (Tipo 2),
 */
public class Hypervisor {
    private List<VirtualMachine> vms;

    /**
     * Cria uma nova instância do Hypervisor.
     */
    public Hypervisor() {
        this.vms = new ArrayList<>();
    }

    /**
     * Adiciona uma nova máquina virtual ao gerenciamento do hypervisor.
     * @param vm A máquina virtual a ser adicionada.
     */
    public void addVM(VirtualMachine vm) {
        vms.add(vm);
    }

    /**
     * Inicia a execução de todas as VMs gerenciadas por este hypervisor, cada uma em sua própria thread.
     */
    public void startAllVMs() {
        System.out.println("Hypervisor iniciando todas as VMs...");
        for (VirtualMachine vm : vms) {
            Thread vmThread = new Thread(vm);
            vmThread.start();
        }
    }

    /**
     * Retorna a lista de máquinas virtuais gerenciadas por este hypervisor.
     * @return A lista de VMs.
     */
    public List<VirtualMachine> getVMs() {
        return vms;
    }

    /**
     * Encaminha uma chamada de sistema originada em uma VM para o seu respectivo Sistema Operacional.
     * Este método centraliza a responsabilidade do hypervisor de intermediar as chamadas.
     * @param originator A VM que originou a chamada.
     * @param call A chamada de sistema a ser processada.
     */
    public void forwardSystemCall(VirtualMachine originator, SystemCall call) {
        // Encontra o sistema operacional da VM que fez a chamada e entrega a requisição
        originator.getOperatingSystem().handleSystemCall(call);
    }
}