package com.example.atividade01;

public class NetworkCard {
    private VirtualMachine vm;

    public NetworkCard(VirtualMachine vm) {
        this.vm = vm;
    }

    public void receiveData(String data) {
        vm.printUserRequest();
        System.out.println("[NetworkCard] Dados recebidos: " + data);

        SystemCall call = new SystemCall(SystemCall.RECEIVE_DATA, data);
        vm.generateSystemCall(call);
    }
}
