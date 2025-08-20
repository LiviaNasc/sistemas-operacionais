package com.example.atividade01;

/**
 * Representa o Sistema Operacional convidado (Guest OS) que roda dentro de uma máquina virtual.
 * Ele gerencia os recursos da VM e fornece serviços para as aplicações através de chamadas de sistema.
 * Exemplos reais: Windows, Linux, macOS rodando em uma VM.
 */
public class OperatingSystem {
    private String name;

    /**
     * Cria uma nova instância de um Sistema Operacional com um nome.
     * @param name O nome do SO (ex: "Windows 11", "Ubuntu 22.04").
     */
    public OperatingSystem(String name) {
        this.name = name;
    }

    /**
     * Manipula uma chamada de sistema (system call) gerada por um dispositivo ou aplicação.
     * Na vida real, este é o ponto central onde o kernel do SO atende a solicitações de baixo nível.
     * @param call A chamada de sistema a ser processada.
     */
    public void handleSystemCall(SystemCall call) {
        System.out.println("[OS Núcleo - " + name + "] Atendendo chamada: " + call.getType());

        if (SystemCall.RECEIVE_DATA.equals(call.getType())) {
            System.out.println("[OS Núcleo - " + name + "] Processando dados recebidos: " + call.getData() + "!");
        }
    }
}
