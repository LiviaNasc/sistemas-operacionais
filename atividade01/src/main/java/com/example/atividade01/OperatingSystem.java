package com.example.atividade01;

public class OperatingSystem {
    private String name;

    public OperatingSystem(String name) {
        this.name = name;
    }

    public void handleSystemCall(SystemCall call) {
        System.out.println("[OS Núcleo - " + name + "] Atendendo chamada: " + call.getType());

        if (SystemCall.RECEIVE_DATA.equals(call.getType())) {
            System.out.println("[OS Núcleo - " + name + "] Processando dados recebidos: " + call.getData() + "!");
        }
    }
}
