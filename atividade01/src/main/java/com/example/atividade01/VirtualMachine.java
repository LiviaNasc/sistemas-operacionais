package com.example.atividade01;

public class VirtualMachine {
    private String name;
    private OperatingSystem os;
    private NetworkCard networkCard;

    public VirtualMachine(String name) {
        this.name = name;
        this.os = new OperatingSystem(name + "_OS");
        this.networkCard = new NetworkCard(this);
    }

    public String getName() {
        return name;
    }

    public NetworkCard getNetworkCard() {
        return networkCard;
    }

    // Gera a system call e encaminha para o SO
    public void generateSystemCall(SystemCall call) {
        os.handleSystemCall(call);
    }

    public void printUserRequest() {
        System.out.println("[VM Usuário - " + name + "] Requisitando acesso à rede...");
    }
}
