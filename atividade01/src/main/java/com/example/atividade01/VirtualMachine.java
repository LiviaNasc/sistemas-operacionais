package com.example.atividade01;

/**
 * Representa uma Máquina Virtual (VM), um ambiente computacional completo e isolado
 * que se comporta como um computador real. O hypervisor gerencia e aloca recursos para a VM.
 */
public class VirtualMachine implements Runnable {
    private String name;
    private OperatingSystem os;
    private NetworkCard networkCard;
    private Hypervisor hypervisor; // Referência ao hypervisor
    private String message;

    /**
     * Cria uma nova Máquina Virtual com um nome específico, associada a um hypervisor.
     * Ao ser criada, a VM automaticamente "instala" um sistema operacional e uma placa de rede.
     * @param name O nome da VM (ex: "Servidor Web", "Desktop Dev").
     * @param hypervisor O hypervisor que gerencia esta VM.
     */
    public VirtualMachine(String name, Hypervisor hypervisor) {
        this.name = name;
        this.hypervisor = hypervisor; // Armazena a referência
        this.os = new OperatingSystem(name + "_OS");
        this.networkCard = new NetworkCard(this);
    }

    /**
     * Define a mensagem a ser processada pela VM.
     * @param message A mensagem.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Retorna o nome da máquina virtual.
     * @return O nome da VM.
     */
    public String getName() {
        return name;
    }

    /**
     * Retorna a placa de rede virtual associada a esta VM.
     * @return A placa de rede da VM.
     */
    public NetworkCard getNetworkCard() {
        return networkCard;
    }

    /**
     * Retorna o sistema operacional instalado nesta VM.
     * @return O sistema operacional da VM.
     */
    public OperatingSystem getOperatingSystem() {
        return os;
    }

    /**
     * Simula a geração de uma chamada de sistema.
     * A chamada é então encaminhada para o HYPERVISOR, que a direcionará para o SO correto.
     * @param call A chamada de sistema a ser processada.
     */
    public void generateSystemCall(SystemCall call) {
        // Em vez de chamar o SO diretamente, a VM  pede ao hypervisor para encaminhar a chamada.
        hypervisor.forwardSystemCall(this, call);
    }

    /**
     * Simula uma requisição de uma aplicação em modo de usuário para acessar um recurso.
     * Na vida real, isso seria um programa (ex: navegador) tentando acessar a rede.
     */
    public void printUserRequest() {
        System.out.println("[VM Usuário - " + name + "] Requisitando acesso à rede...");
    }

    @Override
    public void run() {
        System.out.println("Iniciando execução da " + name);
        for (int i = 0; i < 3; i++) {
            System.out.println("[" + name + "] Executando ciclo " + (i + 1));
            try {
                Thread.sleep(100); // Simula trabalho
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread da " + name + " interrompida.");
            }
        }
        if (message != null && !message.isEmpty()) {
            getNetworkCard().receiveData(message);
        }
        System.out.println("Finalizando execução da " + name);
    }
}